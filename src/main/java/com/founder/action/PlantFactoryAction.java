package com.founder.action;


import common.base.BaseAction;
import common.model.Pager;
import common.model.PlantDict;
import common.model.PlantFactory;
import common.model.PlantFactoryExt;
import common.util.JsonUtil;
import common.util.PagerParameter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/factory")
public class PlantFactoryAction extends BaseAction {

    //查询所有厂商
    @RequestMapping(value = "toPlantFactory", method = RequestMethod.GET)
    public String toPlantFactory(Integer pageNo) {
        Pager<PlantFactoryExt> pager = new Pager<>();
        pager = PagerParameter.parameter(pager, pageNo);
        pager = plantFactoryService.findAllPlantFactory(pager);
        request.setAttribute("page", pager);
        //所有监狱
        List<PlantDict> prisons = plantDictService.findPlantDictByType(1);
        //所有设备类型
        List<PlantDict> types = plantDictService.findPlantDictByType(3);
        request.setAttribute("prison", prisons);
        request.setAttribute("type", types);
        return "/factory/plantFactory";
    }

    //添加厂商
    @RequestMapping(value = "insertFactory")
    public String insertFactory(PlantFactory plantFactory) {
        plantFactoryService.insertFactory(plantFactory);
        return "redirect:/factory/toPlantFactory";
    }

    //批量删除
    @RequestMapping(value = "/delFactory", method = RequestMethod.GET)
    public String delFactory(int[] ids, Integer pageNo) {
        plantFactoryService.delFactory(ids);
        return "redirect:/factory/toPlantFactory?pageNo=" + pageNo;
    }

    //修改数据的回显
    @RequestMapping(value = "/updateFactoryView", method = RequestMethod.POST)
    @ResponseBody
    public String updateFactoryView(int id) {
        PlantFactory factory = plantFactoryService.findFactoryById(id);
        return JsonUtil.toJson(factory);
    }

    //修改数据
    @RequestMapping(value = "/updateFactory")
    public String updateFactory(PlantFactory plantFactory, Integer pageNo) {
        plantFactoryService.updateFactoryById(plantFactory);
        return "redirect:/factory/toPlantFactory?pageNo=" + pageNo;
    }

    //厂商信息一级页
    @RequestMapping(value = "toPlantFactoryInfo", method = RequestMethod.GET)
    public String toPlantFactoryInfo() {
        //所有设备类型
        List<PlantDict> types = plantDictService.findPlantDictByType(3);
        request.setAttribute("type", types);
        return "/factory/plantFactoryInfo";
    }
}
