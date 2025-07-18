/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3959
 * Epic: BANK-3931
 * Generated on: 2025-07-18 17:23:40
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmailNotificationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() {
        // Clean up resources if necessary
    }

    @Test
    public void testEmailNotificationSentToApprover() throws Exception {
        // Given
        String approverEmail = "approver@example.com";
        doNothing().when(mailSender).send(any(SimpleMailMessage.class));

        // When
        mockMvc.perform(MockMvcRequestBuilders.post("/api/approval/submit")
                .param("entryId", "12345")
                .param("approverEmail", approverEmail))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Then
        verify(mailSender).send(any(SimpleMailMessage.class));
    }
}