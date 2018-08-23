package com.founder.service;

import common.mapper.PlantPhoneMapper;
import common.model.Pager;
import common.model.PlantPhone;
import common.model.View;
import common.util.PagerParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PlantPhoneService {

    private PlantPhoneMapper plantPhoneMapper;
    @Autowired
    public void setPlantPhoneMapper(PlantPhoneMapper plantPhoneMapper) {
        this.plantPhoneMapper = plantPhoneMapper;
    }

    //手机屏蔽概览
    public Pager<View> findPhoneView(Pager<View> pager) {
        List<View> cvList = plantPhoneMapper.findPhoneView(pager);
        Integer totalRecord = plantPhoneMapper.findAllPhoneCount(pager);
        pager.setResults(cvList);
        pager.setTotalRecord(totalRecord);
        return pager;
    }

    //好用的手机屏蔽数量

    public int findGoodPhoneCount(Pager<View> pager) {
        return plantPhoneMapper.findAllPhoneCount(PagerParameter.addStatus(pager, 0));
    }

    //删除手机屏蔽
    @Transactional(readOnly = false)
    public void delPhone(int[] id) {
        plantPhoneMapper.delPhone(id);
    }

    //添加手机屏蔽
    @Transactional(readOnly = false)
    public void insertPhone(PlantPhone plantPhone) {
        plantPhoneMapper.insertPhone(plantPhone);
        ;
    }

    //按照id查找手机屏蔽信息
    public PlantPhone findAllPhoneById(int id) {
        return plantPhoneMapper.findPhoneById(id);
    }

    //修改手机屏蔽信息
    @Transactional(readOnly = false)
    public void updatePhone(PlantPhone plantPhone) {
        plantPhoneMapper.updatePhone(plantPhone);
    }
}
