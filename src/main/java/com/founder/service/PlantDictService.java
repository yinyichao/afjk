package com.founder.service;

import common.mapper.PlantDictMapper;
import common.model.PlantDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PlantDictService {

    private PlantDictMapper plantDictMapper;

    @Autowired
    public void setPlantDictMapper(PlantDictMapper plantDictMapper) {
        this.plantDictMapper = plantDictMapper;
    }

    public List<PlantDict> findPlantDictByType(int type) {
        return this.plantDictMapper.findPlantDictByType(type);
    }

    //按code类型查找设备名称
    public PlantDict findPlantDictByCode(String code) {
        return this.plantDictMapper.findPlantDictByCode(code);
    }
}
