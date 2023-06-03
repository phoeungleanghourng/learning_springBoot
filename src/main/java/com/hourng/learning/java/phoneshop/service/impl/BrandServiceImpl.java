package com.hourng.learning.java.phoneshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.hourng.learning.java.phoneshop.entity.Brand;
import com.hourng.learning.java.phoneshop.exception.ApiException;
import com.hourng.learning.java.phoneshop.exception.ResurceNotFoundException;
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

	@Override
	public Brand getById(Integer id) {
		/*Optional<Brand> brandOptional = brandRepository.findById(id);
		if(brandOptional.isPresent()) {
			return brandOptional.get();
		}
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("Bran with id =%d not found",id));
		*/
		return brandRepository.findById(id)
				.orElseThrow( ()->new ResurceNotFoundException("Brand", id));
	}

	@Override
	public Brand update(Integer id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName());
		return brandRepository.save(brand);
	}

	@Override
	public List<Brand> getBrands() {
		return brandRepository.findAll();
		
	}
	

}
