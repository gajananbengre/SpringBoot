package com.gaja.app.service;

import java.util.List;

import common.model.Customer;

public interface CustomerService {


    Customer save(Customer customer);

    Customer fetchById(int profileId);

    List<Customer> fetchAllProfiles();
}