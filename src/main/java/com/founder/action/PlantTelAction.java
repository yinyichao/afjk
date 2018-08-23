package com.founder.action;

import com.founder.service.PlantTelRegionService;
import com.founder.service.PlantTelService;
import common.base.BaseAction;
import common.model.*;
import common.util.HttpUtil;
import common.util.JsonUtil;
import common.util.PagerParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/plantTel")
public class PlantTelAction extends BaseAction {

    protected PlantTelService plantTelService;

    protected PlantTelRegionService plantTelRegionService;

    @Autowired
    public void setPlantTelService(PlantTelService plantTelService) {
        this.plantTelService = plantTelService;
    }

    @Autowired
    public void setPlantTelRegionService(PlantTelRegionService plantTelRegionService) {
        this.plantTelRegionService = plantTelRegionService;
    }

    //摄像概览
    @RequestMapping(value = "/telview", method = RequestMethod.GET)
    public String findTelView(Integer pageNo, String code, String key) {
        Pager<View> pager = new Pager<>();
        pager = PagerParameter.parameter(pager, pageNo, code, key);
        int goodCount = plantTelService.findGoodTelCount(pager);
        pager = plantTelService.findTelView(pager);
        List<PlantTelRegion> pList = plantTelRegionService.selectByCode(code);
        request.setAttribute("organizationname", pList);
        List<PlantFactory> fList = plantFactoryService.findAllFactory();
        request.setAttribute("factoryname", fList);
        request.setAttribute("goodCount", goodCount);
        request.setAttribute("page", pager);
        request.setAttribute("key", key);
        @SuppressWarnings("unchecked")
        Map<String, String> pdMap = (Map<String, String>) request.getSession().getAttribute("pdMap");
        request.setAttribute("prisonName", pdMap.get(code));
        request.setAttribute("code", code);
        return "/running/tel/telview";
    }

    //批量删除
    @RequestMapping(value = "/delTel", method = RequestMethod.GET)
    public String delTel(int[] ids, String code, Integer pageNo) {
        plantTelService.delTel(ids);
        return "redirect:/plantTel/telview?code=" + code + "&pageNo=" + pageNo;
    }

    //插入数据库方法
    @RequestMapping(value = "/insertTel")
    public String insertTel(PlantTel plantTel, String pcode) {
        plantTelService.insertTel(plantTel);
        return "redirect:/plantTel/telview?code=" + pcode;
    }

    //修改数据的ajax
    @RequestMapping(value = "/updateTelPage", method = RequestMethod.POST)
    @ResponseBody
    public String updateTelPage(int id) {
        PlantTel tel = plantTelService.findAllTelById(id);
        return JsonUtil.toJson(tel);
    }

    //修改数据
    @RequestMapping(value = "/updateTel")
    public String updateTel(PlantTel plantTel, String pcode, Integer pageNo) {
        plantTelService.updateTel(plantTel);
        return "redirect:/plantTel/telview?code=" + pcode + "&pageNo=" + pageNo;
    }

    //美电拨通仓讲
    @RequestMapping(value = "/callMDBE", method = RequestMethod.GET)
    @ResponseBody
    public void callMDBE(String from, String to) {
        System.out.println("111");
        HttpUtil.getJsonByInternet("http://localhost:8080/tel/call?from=" + from
                + "&to=" + to);
    }
}
