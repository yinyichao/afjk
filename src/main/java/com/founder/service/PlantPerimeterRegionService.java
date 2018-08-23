package com.founder.service;

import common.mapper.PlantPerimeterRegionMapper;
import common.model.DiagramNodesDTO;
import common.model.PlantPerimeterRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PlantPerimeterRegionService{

    private PlantPerimeterRegionMapper plantPerimeterRegionMapper;
	@Autowired
	public void setPlantPerimeterRegionMapper(PlantPerimeterRegionMapper plantPerimeterRegionMapper) {
		this.plantPerimeterRegionMapper = plantPerimeterRegionMapper;
	}

	@Transactional(readOnly = false)
	public void insertRegion(PlantPerimeterRegion region){
		plantPerimeterRegionMapper.insertRegion(region);
	}

	public List<PlantPerimeterRegion> selectByCode(String code){
		return plantPerimeterRegionMapper.selectByCode(code);
	}

	public String selectDiagramRoot(String code){
		return plantPerimeterRegionMapper.selectDiagramRoot(code);
	}

    public List<DiagramNodesDTO> selectDiagramNodes(String code){
		return plantPerimeterRegionMapper.selectDiagramNodes(code);
	}
}
