package com.founder.service;

import common.mapper.PlantTelMapper;
import common.model.Pager;
import common.model.PlantTel;
import common.model.View;
import common.util.PagerParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PlantTelService {

    private PlantTelMapper plantTelMapper;
    @Autowired
    public void setPlantTelMapper(PlantTelMapper plantTelMapper) {
        this.plantTelMapper = plantTelMapper;
    }

    //仓讲概览
    public Pager<View> findTelView(Pager<View> pager) {
        List<View> cvList = plantTelMapper.findTelView(pager);
        Integer totalRecord = plantTelMapper.findAllTelCount(pager);
        pager.setResults(cvList);
        pager.setTotalRecord(totalRecord);
        return pager;
    }

    //好用的仓讲数量
    public int findGoodTelCount(Pager<View> pager) {
        return plantTelMapper.findAllTelCount(PagerParameter.addStatus(pager, 0));
    }

    //删除仓讲
    @Transactional(readOnly = false)
    public void delTel(int[] id) {
        plantTelMapper.delTel(id);
    }

    //添加仓讲
    @Transactional(readOnly = false)
    public void insertTel(PlantTel plantTel) {
        plantTelMapper.insertTel(plantTel);
        ;
    }

    //按照id查找仓讲信息
    public PlantTel findAllTelById(int id) {
        return plantTelMapper.findTelById(id);
    }

    //修改仓讲信息
    @Transactional(readOnly = false)
    public void updateTel(PlantTel plantTel) {
        plantTelMapper.updateTel(plantTel);
    }
}
