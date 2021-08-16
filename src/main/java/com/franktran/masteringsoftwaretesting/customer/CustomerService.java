package com.franktran.masteringsoftwaretesting.customer;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer createCustomer(CustomerRequest request) {
    String phoneNumber = request.getCustomer().getPhoneNumber();
    Optional<Customer> optionalCustomer = customerRepository.findCustomerByPhoneNumber(phoneNumber);
    if (optionalCustomer.isPresent()) {
      Customer customer = optionalCustomer.get();
      if (!customer.getName().equals(request.getCustomer().getName())) {
        throw new IllegalStateException(String.format("Phone number %s is taken", phoneNumber));
      }
    }
    return customerRepository.save(request.getCustomer());
  }

}
