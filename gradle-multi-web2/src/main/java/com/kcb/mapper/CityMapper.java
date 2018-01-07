package com.kcb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kcb.domain.City;

@Mapper
public interface CityMapper {
	City selectCityById(@Param("id") int id);

}