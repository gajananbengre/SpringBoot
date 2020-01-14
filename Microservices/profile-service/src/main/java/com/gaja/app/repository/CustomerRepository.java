package com.gaja.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import common.model.Customer;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
}