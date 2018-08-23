package com.founder.service;

import common.mapper.SecServiceMapper;
import common.model.SecManagement;
import common.model.SecService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SecServiceService {

    private SecServiceMapper secServiceMapper;
    @Autowired
    public void setSecServiceMapper(SecServiceMapper secServiceMapper) {
        this.secServiceMapper = secServiceMapper;
    }

    //各个监狱各设备数量
    public List<SecManagement> findAllSecCount(String code) {
        return secServiceMapper.findAllSecCount(code);
    }

    //查找个监狱的设备的详细信息
    public List<SecService> findSecInfor(SecService sec) {
        return secServiceMapper.findSecInfor(sec);
    }

    //id查找设备信息
    public SecService findSecById(String id) {
        return secServiceMapper.findSecById(id);
    }
}
