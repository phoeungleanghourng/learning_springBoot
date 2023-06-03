package com.hourng.learning.java.phoneshop.service;

import java.util.List;

import com.hourng.learning.java.phoneshop.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id,Brand brand);
	List<Brand> getBrands();
}
