package com.founder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import common.mapper.VSecInMapper;

public class VSecInService{

	private VSecInMapper vSecInMapper;
	@Autowired
	public void setvSecInMapper(VSecInMapper vSecInMapper) {
		this.vSecInMapper = vSecInMapper;
	}

	@Transactional
	public Integer [] findByType(String type){
		return vSecInMapper.findByType(type);
	}
}
