package com.founder.action;

import com.founder.service.PlantDoorService;
import common.base.BaseAction;
import common.model.*;
import common.util.JsonUtil;
import common.util.PagerParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/plantDoor")
public class PlantDoorAction extends BaseAction {

    protected PlantDoorService plantDoorService;

    @Autowired
    public void setPlantDoorService(PlantDoorService plantDoorService) {
        this.plantDoorService = plantDoorService;
    }

    //分页展示
    @RequestMapping(value = "/doorview", method = RequestMethod.GET)
    public String findDoorView(Integer pageNo, String code, String key) {
        Pager<View> pager = new Pager<>();
        pager = PagerParameter.parameter(pager, pageNo, code, key);
        int goodCount = plantDoorService.findGoodDoorCount(pager);
        pager = plantDoorService.findDoorView(pager);
        List<PlantPerimeterRegion> pList = plantPerimeterRegionService.selectByCode(code);
        request.setAttribute("organizationname", pList);
        List<PlantFactory> factorys = plantFactoryService.findAllFactory();
        request.setAttribute("factoryname", factorys);
        request.setAttribute("goodCount", goodCount);
        request.setAttribute("page", pager);
        @SuppressWarnings("unchecked")
        Map<String, String> pdMap = (Map<String, String>) request.getSession().getAttribute("pdMap");
        request.setAttribute("prisonName", pdMap.get(code));
        request.setAttribute("code", code);
        return "/running/door/doorview";
    }

    //批量删除
    @RequestMapping(value = "/delDoor", method = RequestMethod.GET)
    public String delDoor(int[] ids, String code, Integer pageNo) {
        /*for (int x : ids) {
            plantDoorService.delDoor(x);
        }*/
        plantDoorService.delDoor(ids);
        return "redirect:/plantDoor/doorview?code=" + code + "&pageNo=" + pageNo;
    }

    //添加
    @RequestMapping(value = "/insertDoor")
    public String insertDoor(PlantDoor plantDoor, String pcode) {
        plantDoorService.insertDoor(plantDoor);
        return "redirect:/plantDoor/doorview?code=" + pcode;
    }

    //修改页
    @RequestMapping(value = "/updateDoorPage", method = RequestMethod.POST)
    @ResponseBody
    public String updateDoorPage(int id) {
        PlantDoor door = plantDoorService.findAllDoorById(id);
        return JsonUtil.toJson(door);
    }

    //修改数据
    @RequestMapping(value = "/updateDoor")
    public String updateDoor(PlantDoor plantDoor, String pcode, Integer pageNo) {
        plantDoorService.updateDoor(plantDoor);
        return "redirect:/plantDoor/doorview?code=" + pcode + "&pageNo=" + pageNo;
    }
}
