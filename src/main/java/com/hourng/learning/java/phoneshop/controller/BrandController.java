package com.hourng.learning.java.phoneshop.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hourng.learning.java.phoneshop.dto.BrandDTO;
import com.hourng.learning.java.phoneshop.entity.Brand;
import com.hourng.learning.java.phoneshop.mapper.BrandMapper;
import com.hourng.learning.java.phoneshop.service.BrandService;

@RestController
@RequestMapping("brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		brand=brandService.create(brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	@GetMapping("{id}") 
	public ResponseEntity<?> getOneBrand(@PathVariable ("id")Integer  brandId){
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	@PutMapping("{id}")
	public ResponseEntity<?>update(@PathVariable("id") Integer bradId,@RequestBody BrandDTO brandDTO){
		Brand brand=BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand updateBrand = brandService.update(bradId, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updateBrand));
	}
	@GetMapping() 
	public ResponseEntity<?> getBrands(){
//		List<Brand> brands = brandService.getBrands();
		List<BrandDTO> list = brandService.getBrands().stream()
			.map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))	
			.collect(Collectors.toList());
		return ResponseEntity.ok(list);
//		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
}
