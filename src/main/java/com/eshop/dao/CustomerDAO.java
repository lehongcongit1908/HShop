package com.eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, String>{
}