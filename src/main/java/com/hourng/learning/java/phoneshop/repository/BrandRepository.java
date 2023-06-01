package com.hourng.learning.java.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hourng.learning.java.phoneshop.entity.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
