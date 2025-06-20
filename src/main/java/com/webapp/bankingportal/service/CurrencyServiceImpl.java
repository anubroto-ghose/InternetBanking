package com.webapp.bankingportal.service;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.webapp.bankingportal.entity.Currency;
import com.webapp.bankingportal.repository.CurrencyRepository;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;			

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {

	private final CurrencyRepository currencyRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository, RestTemplate restTemplate) {
        this.currencyRepository = currencyRepository;
        this.restTemplate = restTemplate;
    }

	@Value("${bank1.api.url}")
	private String bank1Url;
	@Value("${bank2.api.url}")
	private String bank2Url;
	@Value("${bank3.api.url}")
	private String bank3Url;
	@Value("${bank4.api.url}")
	private String bank4Url;
	@Value("${bank5.api.url}")
	private String bank5Url;
	@Value("${bank6.api.url}")
	private String bank6Url;
	@Value("${bank7.api.url}")
	private String bank7Url;
	@Value("${bank8.api.url}")
	private String bank8Url;
	@Value("${bank9.api.url}")
	private String bank9Url;
	@Value("${bank10.api.url}")
	private String bank10Url;

	@Override
	public Currency addOrUpdateCurrency(Currency currency) {
		Currency saved = currencyRepository.save(currency);

		// Push to third-party APIs
		try {
			bank1Update(saved);
			bank2Update(saved);
			bank3Update(saved);
			bank4Update(saved);
			bank5Update(saved);
			bank6Update(saved);
			bank7Update(saved);
			bank8Update(saved);
			bank9Update(saved);
			bank10Update(saved);

		} catch (Exception e) {
			System.err.println("Failed to notify : " + e.getMessage());
			// Add retry/queue/logging logic as needed
		}

		return saved;

	}
	
	private void bank1Update(Currency currency) {
		try {
			restTemplate.postForEntity(bank1Url, currency, String.class);
		} catch (Exception e) {
			logError("Bank1", e);
		}
	}

	private void bank2Update(Currency currency) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", "Bearer bank2-token");
			HttpEntity<Currency> request = new HttpEntity<>(currency, headers);
			restTemplate.postForEntity(bank2Url, request, String.class);
		} catch (Exception e) {
			logError("Bank2", e);
		}
	}

	private void bank3Update(Currency currency) {
		try {
			Map<String, Object> payload = new HashMap<>();
			payload.put("currencyCode", currency.getCode());
			payload.put("currencyOrigin", currency.getOrigin());
			HttpEntity<Map<String, Object>> request = new HttpEntity<>(payload);
			restTemplate.put(bank3Url, request);
		} catch (Exception e) {
			logError("Bank3", e);
		}
	}

	private void bank4Update(Currency currency) {
		try {
			URI uri = UriComponentsBuilder.fromHttpUrl(bank4Url).queryParam("code", currency.getCode())
					.queryParam("origin", currency.getOrigin()).build().toUri();
			restTemplate.getForEntity(uri, String.class);
		} catch (Exception e) {
			logError("Bank4", e);
		}
	}

	private void bank5Update(Currency currency) {
		try {
			HttpEntity<Currency> request = new HttpEntity<>(currency);
			restTemplate.exchange(bank5Url, HttpMethod.POST, request, String.class);
		} catch (Exception e) {
			logError("Bank5", e);
		}
	}

	private void bank6Update(Currency currency) {
		try {
			restTemplate.postForEntity(bank6Url + "/" + currency.getCode(), null, String.class);
		} catch (Exception e) {
			logError("Bank6", e);
		}
	}

	private void bank7Update(Currency currency) {
		try {
			MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
			formData.add("code", currency.getCode());
			formData.add("origin", currency.getOrigin());
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);
			restTemplate.postForEntity(bank7Url, request, String.class);
		} catch (Exception e) {
			logError("Bank7", e);
		}
	}

	private void bank8Update(Currency currency) {
		try {
			Map<String, Object> json = Map.of("meta", Map.of("source", "RBI"), "data", currency);
			HttpEntity<Map<String, Object>> request = new HttpEntity<>(json);
			restTemplate.postForEntity(bank8Url, request, String.class);
		} catch (Exception e) {
			logError("Bank8", e);
		}
	}

	private void bank9Update(Currency currency) {
		try {
			restTemplate.postForEntity(bank9Url, List.of(currency), String.class);
		} catch (Exception e) {
			logError("Bank9", e);
		}
	}

	private void bank10Update(Currency currency) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Client-Id", "central-rbi");
			HttpEntity<Currency> request = new HttpEntity<>(currency, headers);
			restTemplate.exchange(bank10Url, HttpMethod.PUT, request, String.class);
		} catch (Exception e) {
			logError("Bank10", e);
		}
	}

	private void logError(String bank, Exception e) {
		System.err.println("Error pushing currency to " + bank + ": " + e.getMessage());
	}

	@Override
	public List<Currency> getCurrencys() {
		// TODO Auto-generated method stub
		return currencyRepository.findAll();
	}

}
