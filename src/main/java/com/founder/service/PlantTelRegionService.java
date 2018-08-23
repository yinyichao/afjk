package com.founder.service;

import common.mapper.PlantTelRegionMapper;
import common.model.PlantTelRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PlantTelRegionService{

    private PlantTelRegionMapper plantTelRegionMapper;
	@Autowired
	public void setPlantTelRegionMapper(PlantTelRegionMapper plantTelRegionMapper) {
		this.plantTelRegionMapper = plantTelRegionMapper;
	}

	public List<PlantTelRegion> selectByCode(String code){
		return plantTelRegionMapper.selectByCode(code);
	}
}
