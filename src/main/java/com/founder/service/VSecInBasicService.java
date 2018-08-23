package com.founder.service;

import common.mapper.VSecInBasicMapper;
import common.model.VSecInBasic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VSecInBasicService{

	private VSecInBasicMapper vSecInBasicMapper;
	@Autowired
	public void setvSecInBasicMapper(VSecInBasicMapper vSecInBasicMapper) {
		this.vSecInBasicMapper = vSecInBasicMapper;
	}

	public List<VSecInBasic> getPrisonInform(String code) {
		return this.vSecInBasicMapper.getPrisonInform(code);		
	}
	
	
}