package com.founder.service;

import common.mapper.SecStandardMapper;
import common.model.SecStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class SecStandardService {
	//厂商信息二级页

	private SecStandardMapper secStandardMapper;
	@Autowired
	public void setSecStandardMapper(SecStandardMapper secStandardMapper) {
		this.secStandardMapper = secStandardMapper;
	}

	public List<SecStandard> plantFactoryInfoSecond(String code){
		return secStandardMapper.plantFactoryInfoSecond(code);
	}
	//厂商描述
	public SecStandard plantFactoryDescription(Integer id) {
		return secStandardMapper.plantFactoryDescription(id);
	};
}
