package com.codegym.demo.repository;

import com.codegym.demo.model.Customer;
import com.codegym.demo.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
