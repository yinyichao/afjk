package com.founder.action;

import com.founder.service.PlantEwireService;
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

@RequestMapping("/plantEwire")
public class PlantEwireAction extends BaseAction {

    protected PlantEwireService plantEwireService;

    @Autowired
    public void setPlantEwireService(PlantEwireService plantEwireService) {
        this.plantEwireService = plantEwireService;
    }

    //电网概览
    @RequestMapping(value = "/ewireview", method = RequestMethod.GET)
    public String findEwireView(Integer pageNo, String code, String key) {
        Pager<View> pager = new Pager<>();
        pager = PagerParameter.parameter(pager, pageNo, code, key);
        int goodCount = plantEwireService.findGoodEwireCount(pager);
        pager = plantEwireService.findEwireView(pager);
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
        return "/running/ewire/ewireview";
    }

    //批量删除
    @RequestMapping(value = "/delEwire", method = RequestMethod.GET)
    public String delEwire(int[] ids, String code, Integer pageNo) {
        plantEwireService.delEwire(ids);
        return "redirect:/plantEwire/ewireview?code=" + code + "&pageNo=" + pageNo;
    }

    //添加
    @RequestMapping(value = "/insertEwire")
    public String insertEwire(PlantEwire plantEwire, String pcode) {
        plantEwireService.insertEwire(plantEwire);
        return "redirect:/plantEwire/ewireview?code=" + pcode;
    }

    //修改页
    @RequestMapping(value = "/updateEwirePage", method = RequestMethod.POST)
    @ResponseBody
    public String updateEwirePage(int id) {
        PlantEwire ewire = plantEwireService.findAllEwireById(id);
        return JsonUtil.toJson(ewire);
    }

    //修改数据
    @RequestMapping(value = "/updateEwire")
    public String updateEwire(PlantEwire plantEwire, String pcode, Integer pageNo) {
        plantEwireService.updateEwire(plantEwire);
        return "redirect:/plantEwire/ewireview?code=" + pcode + "&pageNo=" + pageNo;
    }
}
