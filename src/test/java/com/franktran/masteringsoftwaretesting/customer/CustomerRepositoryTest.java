package com.franktran.masteringsoftwaretesting.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

  @Autowired
  private CustomerRepository underTest;

  @Test
  void itShouldFindCustomerByPhoneNumber() {
    // Given
    // When
    // Then
  }
}