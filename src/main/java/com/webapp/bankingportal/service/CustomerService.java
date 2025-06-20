package com.webapp.bankingportal.service;

import java.util.List;

import com.webapp.bankingportal.dto.CustomerDTO;

public interface CustomerService {
	
    CustomerDTO createCustomer(CustomerDTO dto);
    CustomerDTO getCustomerById(Long id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO updateCustomer(Long id, CustomerDTO dto);
    void deleteCustomer(Long id);

}
