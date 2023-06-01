package com.hourng.learning.java.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hourng.learning.java.phoneshop.dto.BrandDTO;
import com.hourng.learning.java.phoneshop.entity.Brand;
import com.hourng.learning.java.phoneshop.service.BrandService;
import com.hourng.learning.java.phoneshop.service.util.Mapper;

@RestController
@RequestMapping("brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = Mapper.toBrand(brandDTO);
		brand=brandService.create(brand);
		return ResponseEntity.ok(brand);
	}
}
