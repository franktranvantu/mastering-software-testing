package com.franktran.masteringsoftwaretesting.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

class CustomerServiceTest {

  @Mock
  private CustomerRepository customerRepository;
  @Captor
  private ArgumentCaptor<Customer> customerArgumentCaptor;
  private CustomerService underTest;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    underTest = new CustomerService(customerRepository);
  }

  @Test
  void itShouldCreateCustomer() {
    // Given
    String phoneNumber = "1234";
    Customer customer = new Customer(UUID.randomUUID(), "Frank", phoneNumber);
    CustomerRequest request = new CustomerRequest(customer);

    given(customerRepository.findCustomerByPhoneNumber(phoneNumber)).willReturn(Optional.empty());

    // When
    underTest.createCustomer(request);

    // Then
    then(customerRepository).should().save(customerArgumentCaptor.capture());
    Customer capturedCustomer = customerArgumentCaptor.getValue();
    assertThat(capturedCustomer).usingRecursiveComparison().isEqualTo(customer);
  }
}