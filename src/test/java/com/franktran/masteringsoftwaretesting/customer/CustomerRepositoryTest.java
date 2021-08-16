package com.franktran.masteringsoftwaretesting.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

  @Test
  void itShouldSaveCustomer() {
    // Given
    UUID id = UUID.randomUUID();
    Customer customer = new Customer(id, "Frank", "1234");

    // When
    underTest.save(customer);

    // Then
    Optional<Customer> optionalCustomer = underTest.findById(id);
    assertThat(optionalCustomer)
        .isPresent()
        .hasValueSatisfying(c -> {
//          assertThat(c.getId()).isEqualTo(id);
//          assertThat(c.getName()).isEqualTo("Frank");
//          assertThat(c.getPhoneNumber()).isEqualTo("1234");
          assertThat(c).usingRecursiveComparison().isEqualTo(customer);
        });
  }
}