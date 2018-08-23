package com.founder.service;

import common.mapper.PlantLifeMapper;
import common.model.Pager;
import common.model.PlantLife;
import common.model.View;
import common.util.PagerParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PlantLifeService {

    private PlantLifeMapper plantLifeMapper;
    @Autowired
    public void setPlantLifeMapper(PlantLifeMapper plantLifeMapper) {
        this.plantLifeMapper = plantLifeMapper;
    }

    //生命探测概览
    public Pager<View> findLifeView(Pager<View> pager) {
        List<View> cvList = plantLifeMapper.findLifeView(pager);
        Integer totalRecord = plantLifeMapper.findAllLifeCount(pager);
        pager.setResults(cvList);
        pager.setTotalRecord(totalRecord);
        return pager;
    }

    //好的生命探测数量
    public int findGoodLifeCount(Pager<View> pager) {
        return plantLifeMapper.findAllLifeCount(PagerParameter.addStatus(pager, 0));
    }

    //删除生命探测
    @Transactional(readOnly = false)
    public void delLife(int[] id) {
        plantLifeMapper.delLife(id);
    }

    //添加生命探测
    @Transactional(readOnly = false)
    public void insertLife(PlantLife plantLife) {
        plantLifeMapper.insertLife(plantLife);
    }

    //按照id查找生命探测信息
    public PlantLife findAllLifeById(int id) {
        return plantLifeMapper.findLifeById(id);
    }

    //修改生命探测信息
    @Transactional(readOnly = false)
    public void updateLife(PlantLife plantLife) {
        plantLifeMapper.updateLife(plantLife);
    }
}
