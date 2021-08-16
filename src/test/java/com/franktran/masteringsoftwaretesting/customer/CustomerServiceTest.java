package com.franktran.masteringsoftwaretesting.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CustomerServiceTest {

  @Mock
  private CustomerRepository customerRepository;
  private CustomerService underTest;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    underTest = new CustomerService(customerRepository);
  }

  @Test
  void itShouldCreateCustomer() {
    // Given
    // When
    // Then
  }
}