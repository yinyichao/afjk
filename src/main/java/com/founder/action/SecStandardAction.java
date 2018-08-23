package com.founder.action;

import com.founder.service.SecStandardService;
import common.base.BaseAction;
import common.model.PlantDict;
import common.model.SecStandard;
import common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/standard")
public class SecStandardAction extends BaseAction {

    private SecStandardService plantStandareService;

    @Autowired
    public void setPlantStandareService(SecStandardService plantStandareService) {
        this.plantStandareService = plantStandareService;
    }

    //厂商信息二级页
    @RequestMapping("/plantFactoryInfoSecond")
    public String plantFactoryInfoSecond(String code) {
        List<SecStandard> standardList = plantStandareService.plantFactoryInfoSecond(code);
        PlantDict plantDict = plantDictService.findPlantDictByCode(code);
        request.setAttribute("sList", standardList);
        request.setAttribute("plantDict", plantDict);
        return "factory/plantFactoryInfoSecond";
    }

    //厂商描述
    @RequestMapping(value = "/plantFactoryDescription", method = RequestMethod.POST)
    @ResponseBody
    public String plantFactoryDescription(Integer id) {
        SecStandard secStandard = plantStandareService.plantFactoryDescription(id);
        return JsonUtil.toJson(secStandard);
    }

}
