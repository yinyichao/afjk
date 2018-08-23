package com.founder.action;

import com.founder.service.PlantPhoneService;
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

@RequestMapping("/plantPhone")
public class PlantPhoneAction extends BaseAction {

    protected PlantPhoneService plantPhoneService;

    @Autowired
    public void setPlantPhoneService(PlantPhoneService plantPhoneService) {
        this.plantPhoneService = plantPhoneService;
    }

    //摄像概览
    @RequestMapping(value = "/phoneview", method = RequestMethod.GET)
    public String findPhoneView(Integer pageNo, String code, String key) {
        Pager<View> pager = new Pager<>();
        pager = PagerParameter.parameter(pager, pageNo, code, key);
        int goodCount = plantPhoneService.findGoodPhoneCount(pager);
        pager = plantPhoneService.findPhoneView(pager);
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
        return "/running/phone/phoneview";
    }

    //批量删除
    @RequestMapping(value = "/delPhone", method = RequestMethod.GET)
    public String delPhone(int[] ids, String code, Integer pageNo) {
        plantPhoneService.delPhone(ids);
        return "redirect:/plantPhone/phoneview?code=" + code + "&pageNo=" + pageNo;
    }

    //插入数据库方法
    @RequestMapping(value = "/insertPhone")
    public String insertPhone(PlantPhone plantPhone, String pcode) {
        plantPhoneService.insertPhone(plantPhone);
        return "redirect:/plantPhone/phoneview?code=" + pcode;
    }

    //修改数据的ajax
    @RequestMapping(value = "/updatePhonePage", method = RequestMethod.POST)
    @ResponseBody
    public String updatePhonePage(int id) {
        PlantPhone phone = plantPhoneService.findAllPhoneById(id);
        return JsonUtil.toJson(phone);
    }

    //修改数据
    @RequestMapping(value = "/updatePhone")
    public String updatePhone(PlantPhone plantPhone, String pcode, Integer pageNo) {
        plantPhoneService.updatePhone(plantPhone);
        return "redirect:/plantPhone/phoneview?code=" + pcode + "&pageNo=" + pageNo;
    }
}
