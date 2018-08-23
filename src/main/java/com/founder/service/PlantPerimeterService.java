package com.founder.service;

import common.mapper.PlantPerimeterMapper;
import common.model.Pager;
import common.model.PlantPerimeter;
import common.model.View;
import common.util.PagerParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PlantPerimeterService {

    private PlantPerimeterMapper plantPerimeterMapper;
    @Autowired
    public void setPlantPerimeterMapper(PlantPerimeterMapper plantPerimeterMapper) {
        this.plantPerimeterMapper = plantPerimeterMapper;
    }
    //摄像机概览

    public Pager<View> findCameraView(Pager<View> pager) {
        List<View> cvList = plantPerimeterMapper.findCameraView(pager);
        Integer totalRecord = plantPerimeterMapper.findAllCameraCount(pager);
        pager.setResults(cvList);
        pager.setTotalRecord(totalRecord);
        return pager;
    }

    //好用的摄像机数量

    public int findGoodCameraCount(Pager<View> pager) {
        return plantPerimeterMapper.findAllCameraCount(PagerParameter.addStatus(pager, 0));
    }

    //删除摄像机
    @Transactional(readOnly = false)
    public void delCamera(int[] id) {
        plantPerimeterMapper.delCamera(id);
    }

    //添加摄像机
    @Transactional(readOnly = false)
    public void insertCamera(PlantPerimeter plantPerimeter) {
        plantPerimeterMapper.insertCamera(plantPerimeter);
    }

    //按照id查找摄像机信息
    public PlantPerimeter findAllCameraById(int id) {
        return plantPerimeterMapper.findCameraById(id);
    }

    //修改摄像机信息
    @Transactional(readOnly = false)
    public void updateCamera(PlantPerimeter plantPerimeter) {
        plantPerimeterMapper.updateCamera(plantPerimeter);
    }

    //通过方正编码查询海康编码
    public String findCodeByRemark(String code) {
        return plantPerimeterMapper.findCodeByRemark(code);
    }

    //通过方正编码查询海康摄像头名称
    public String findNameByRemark(String code) {
        return plantPerimeterMapper.findNameByRemark(code);
    }

    //通过方正编码查询海康摄像头ip
    public String findAddressUrlByRemark(String code) {
        return plantPerimeterMapper.findAddressUrlByRemark(code);
    }

    //通过海康编码查询海康摄像头名称
    public String findNameByCode(String code) {
        return plantPerimeterMapper.findNameByCode(code);
    }

    //通过海康编码查询海康摄像头ip
    public String findAddressUrlByCode(String code) {
        return plantPerimeterMapper.findAddressUrlByCode(code);
    }
}
