package com.founder.service;

import common.mapper.PlantEwireMapper;
import common.model.Pager;
import common.model.PlantEwire;
import common.model.View;
import common.util.PagerParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PlantEwireService {

    private PlantEwireMapper plantEwireMapper;

    @Autowired
    public void setPlantEwireMapper(PlantEwireMapper plantEwireMapper) {
        this.plantEwireMapper = plantEwireMapper;
    }

    //电网概览
    public Pager<View> findEwireView(Pager<View> pager) {
        List<View> cvList = plantEwireMapper.findEwireView(pager);
        Integer totalRecord = plantEwireMapper.findAllEwireCount(pager);
        pager.setResults(cvList);
        pager.setTotalRecord(totalRecord);
        return pager;
    }

    //好的电网数量
    public int findGoodEwireCount(Pager<View> pager) {
        return plantEwireMapper.findAllEwireCount(PagerParameter.addStatus(pager, 0));
    }

    //删除电网
    @Transactional(readOnly = false)
    public void delEwire(int[] id) {
        plantEwireMapper.delEwire(id);
    }

    //添加电网
    @Transactional(readOnly = false)
    public void insertEwire(PlantEwire plantEwire) {
        plantEwireMapper.insertEwire(plantEwire);
    }

    //按照id查找电网信息
    public PlantEwire findAllEwireById(int id) {
        return plantEwireMapper.findEwireById(id);
    }

    //修改电网信息
    @Transactional(readOnly = false)
    public void updateEwire(PlantEwire plantEwire) {
        plantEwireMapper.updateEwire(plantEwire);
    }
}
