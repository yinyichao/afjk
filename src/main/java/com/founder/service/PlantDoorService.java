package com.founder.service;

import common.mapper.PlantDoorMapper;
import common.model.Pager;
import common.model.PlantDoor;
import common.model.View;
import common.util.PagerParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PlantDoorService {

    private PlantDoorMapper plantDoorMapper;

    @Autowired
    public void setPlantDoorMapper(PlantDoorMapper plantDoorMapper) {
        this.plantDoorMapper = plantDoorMapper;
    }

    public PlantDoor findAllDoorById(int id) {
        return plantDoorMapper.findDoorById(id);
    }

    public Pager<View> findDoorView(Pager<View> pager) {
        List<View> views = plantDoorMapper.findDoorView(pager);
        Integer count = plantDoorMapper.findAllDoorCount(pager);
        pager.setResults(views);
        pager.setTotalRecord(count);
        return pager;
    }

    public int findGoodDoorCount(Pager<View> pager) {
        return plantDoorMapper.findAllDoorCount(PagerParameter.addStatus(pager, 0));
    }

    @Transactional(readOnly = false)
    public void delDoor(int[] id) {
        plantDoorMapper.delDoor(id);
    }

    @Transactional(readOnly = false)
    public void insertDoor(PlantDoor plantDoor) {
        plantDoorMapper.insertDoor(plantDoor);
    }

    @Transactional(readOnly = false)
    public void updateDoor(PlantDoor plantDoor) {
        plantDoorMapper.updateDoor(plantDoor);
    }
}
