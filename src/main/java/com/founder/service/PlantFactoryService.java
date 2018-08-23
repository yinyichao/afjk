package com.founder.service;

import common.mapper.PlantFactoryMapper;
import common.model.Pager;
import common.model.PlantFactory;
import common.model.PlantFactoryExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PlantFactoryService {

    private PlantFactoryMapper plantFactoryMapper;
    @Autowired
    public void setPlantFactoryMapper(PlantFactoryMapper plantFactoryMapper) {
        this.plantFactoryMapper = plantFactoryMapper;
    }

    //所有厂家集合
    public List<PlantFactory> findAllFactory() {
        return plantFactoryMapper.findAllFactory();
    }

    //查询所有厂商集合
    public Pager<PlantFactoryExt> findAllPlantFactory(Pager<PlantFactoryExt> pager) {
        List<PlantFactoryExt> pfList = plantFactoryMapper.findAllPlantFactory(pager);
        Integer totalRecord = plantFactoryMapper.getPlantFactoryCount();
        pager.setResults(pfList);
        pager.setTotalRecord(totalRecord);
        return pager;
    }

    //添加厂商
    @Transactional(readOnly = false)
    public void insertFactory(PlantFactory plantFactory) {
        plantFactoryMapper.insertFactory(plantFactory);
    }

    //修改厂商回显
    public PlantFactory findFactoryById(int id) {
        return plantFactoryMapper.findFactoryById(id);
    }

    //修改厂商
    @Transactional(readOnly = false)
    public void updateFactoryById(PlantFactory plantFactory) {
        plantFactoryMapper.updateFactoryById(plantFactory);
    }

    //批量删除
    @Transactional(readOnly = false)
    public void delFactory(int[] id) {
        plantFactoryMapper.delFactory(id);

    }

    //查询调用视频所需数据
    public PlantFactory findPlantFactoryData(String code) {
        return plantFactoryMapper.findPlantFactoryData(code);

    }
}
