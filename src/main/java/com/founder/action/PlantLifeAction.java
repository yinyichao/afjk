package com.founder.action;

import com.founder.service.PlantLifeService;
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

@RequestMapping("/plantLife")
public class PlantLifeAction extends BaseAction {

    protected PlantLifeService plantLifeService;

    @Autowired
    public void setPlantLifeService(PlantLifeService plantLifeService) {
        this.plantLifeService = plantLifeService;
    }

    //摄像概览
    @RequestMapping(value = "/lifeview", method = RequestMethod.GET)
    public String findLifeView(Integer pageNo, String code, String key) {

        Pager<View> pager = new Pager<>();
        pager = PagerParameter.parameter(pager, pageNo, code, key);
        int goodCount = plantLifeService.findGoodLifeCount(pager);
        pager = plantLifeService.findLifeView(pager);
        List<PlantPerimeterRegion> pList = plantPerimeterRegionService.selectByCode(code);
        request.setAttribute("organizationname", pList);
        List<PlantFactory> fList = plantFactoryService.findAllFactory();
        request.setAttribute("factoryname", fList);
        request.setAttribute("goodCount", goodCount);
        request.setAttribute("page", pager);
        @SuppressWarnings("unchecked")
        Map<String, String> pdMap = (Map<String, String>) request.getSession().getAttribute("pdMap");
        request.setAttribute("prisonName", pdMap.get(code));
        request.setAttribute("code", code);
        return "/running/life/lifeview";
    }

    //批量删除
    @RequestMapping(value = "/delLife", method = RequestMethod.GET)
    public String delLife(int[] ids, String code, Integer pageNo) {
        plantLifeService.delLife(ids);
        return "redirect:/plantLife/lifeview?code=" + code + "&pageNo=" + pageNo;
    }

    //插入数据库方法
    @RequestMapping(value = "/insertLife")
    public String insertCamera(PlantLife plantLife, String pcode) {
        plantLifeService.insertLife(plantLife);
        return "redirect:/plantLife/lifeview?code=" + pcode;
    }

    //修改数据的ajax
    @RequestMapping(value = "/updateLifePage", method = RequestMethod.POST)
    @ResponseBody
    public String updatePage(int id) {
        PlantLife life = plantLifeService.findAllLifeById(id);
        return JsonUtil.toJson(life);
    }

    //修改数据
    @RequestMapping(value = "/updateLife")
    public String updateCamera(PlantLife plantLife, String pcode, Integer pageNo) {
        plantLifeService.updateLife(plantLife);
        return "redirect:/plantLife/lifeview?code=" + pcode + "&pageNo=" + pageNo;
    }
}
