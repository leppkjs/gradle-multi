package com.kcb.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kcb.mapper.CityMapper;

public class CityServiceImpl implements CityService {
	@Autowired
	private CityMapper cityMapper;
	
	@Override
	public String getCityName(int id) {
		return (cityMapper.selectCityById(id)).getName();
	}

}
