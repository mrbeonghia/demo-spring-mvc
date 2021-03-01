package com.codegym.demo.repository;

import com.codegym.demo.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepository extends CrudRepository<Province,Long> {
}
