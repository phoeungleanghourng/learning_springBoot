package com.hourng.learning.java.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.hourng.learning.java.phoneshop.dto.BrandDTO;
import com.hourng.learning.java.phoneshop.entity.Brand;

@Mapper
public interface BrandMapper {
	BrandMapper INSTANCE=Mappers.getMapper(BrandMapper.class);
	Brand toBrand(BrandDTO brandDTO);
	BrandDTO toBrandDTO(Brand entity);
}
