package com.franktran.masteringsoftwaretesting.customer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

  @PostMapping
  public Customer createCustomer(@RequestBody @Valid CustomerRequest request) {
    return null;
  }

}
