package com.hourng.learning.java.phoneshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hourng.learning.java.phoneshop.entity.Brand;
import com.hourng.learning.java.phoneshop.repository.BrandRepository;
import com.hourng.learning.java.phoneshop.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand create(Brand brand) {
		
		return brandRepository.save(brand);
	}
	

}
