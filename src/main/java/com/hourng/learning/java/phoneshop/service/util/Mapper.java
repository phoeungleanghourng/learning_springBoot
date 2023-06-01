package com.hourng.learning.java.phoneshop.service.util;

import com.hourng.learning.java.phoneshop.dto.BrandDTO;
import com.hourng.learning.java.phoneshop.entity.Brand;

public class Mapper {
	public static Brand toBrand(BrandDTO dto) {
		Brand brand=new Brand();
		brand.setId(dto.getId());
		brand.setName(dto.getName());
		return brand;
	}
}
