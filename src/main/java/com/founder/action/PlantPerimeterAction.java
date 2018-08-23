package com.founder.action;

import com.founder.service.PlantPerimeterService;
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

@RequestMapping("/plantPerimeter")
public class PlantPerimeterAction extends BaseAction {

    protected PlantPerimeterService plantPerimeterService;

    @Autowired
    public void setPlantPerimeterService(PlantPerimeterService plantPerimeterService) {
        this.plantPerimeterService = plantPerimeterService;
    }

    //摄像概览
    @RequestMapping(value = "/cameraview", method = RequestMethod.GET)
    public String findCameraView(Integer pageNo, String code, String key) {

        Pager<View> pager = new Pager<>();
        pager = PagerParameter.parameter(pager, pageNo, code, key);
        int goodCount = plantPerimeterService.findGoodCameraCount(pager);
        pager = plantPerimeterService.findCameraView(pager);
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
        request.setAttribute("key", key);
        return "/running/camera/cameraview";
    }

    //批量删除
    @RequestMapping(value = "/delCamera", method = RequestMethod.GET)
    public String delCamera(int[] ids, String code, Integer pageNo) {
        plantPerimeterService.delCamera(ids);
        return "redirect:/plantPerimeter/cameraview?code=" + code + "&pageNo=" + pageNo;
    }

    //插入数据库方法
    @RequestMapping(value = "/insertCamera")
    public String insertCamera(PlantPerimeter plantPerimeter, String pcode) {
        plantPerimeterService.insertCamera(plantPerimeter);
        return "redirect:/plantPerimeter/cameraview?code=" + pcode;
    }

    //修改数据的ajax
    @RequestMapping(value = "/updateCameraPage", method = RequestMethod.POST)
    @ResponseBody
    public String updatePage(int id) {
        PlantPerimeter camera = plantPerimeterService.findAllCameraById(id);
        return JsonUtil.toJson(camera);
    }

    //修改数据
    @RequestMapping(value = "/updateCamera")
    public String updateCamera(PlantPerimeter plantPerimeter, String pcode, Integer pageNo) {
        plantPerimeterService.updateCamera(plantPerimeter);
        return "redirect:/plantPerimeter/cameraview?code=" + pcode + "&pageNo=" + pageNo;
    }

    //厂商设备所需信息
    public void getPlantFactoryData(String code) {
        PlantFactory plantFactory = plantFactoryService.findPlantFactoryData(code);
        request.setAttribute("pfData", plantFactory);
    }

    //海康摄像头预览
    @RequestMapping(value = "/startPreview", method = RequestMethod.GET)
    public String startPreviewHK(String code, String prison, String height, String width) {
        String name = plantPerimeterService.findNameByRemark(code);
        String addressUrl = plantPerimeterService.findAddressUrlByRemark(code);
        code = plantPerimeterService.findCodeByRemark(code);
        getPlantFactoryData(prison);
        request.setAttribute("code", code);
        request.setAttribute("name", name);
        request.setAttribute("addressUrl", addressUrl);
        request.setAttribute("height", height);
        request.setAttribute("width", width);
        return "running/camera/startPreviewHK";
    }

    //海康摄像头预览
    @RequestMapping(value = "/startPreviewCode", method = RequestMethod.GET)
    public String startPreviewHKCode(String code, String prison, String height, String width) {
        String name = plantPerimeterService.findNameByCode(code);
        String addressUrl = plantPerimeterService.findAddressUrlByCode(code);
        //code = plantPerimeterService.findCodeByRemark(code);
        getPlantFactoryData(prison);
        request.setAttribute("code", code);
        request.setAttribute("name", name);
        request.setAttribute("addressUrl", addressUrl);
        request.setAttribute("height", height);
        request.setAttribute("width", width);
        return "running/camera/startPreviewHK";
    }

    //海康摄像头回放
    @RequestMapping(value = "/playBack", method = RequestMethod.GET)
    public String playBackHK(String code, String prison, String height, String width) {
        String name = plantPerimeterService.findNameByRemark(code);
        code = plantPerimeterService.findCodeByRemark(code);
        getPlantFactoryData(prison);
        request.setAttribute("code", code);
        request.setAttribute("name", name);
        request.setAttribute("height", height);
        request.setAttribute("width", width);
        return "running/camera/playBackHK";
    }

    //大华摄像头 预览
    @RequestMapping(value = "/startPreviewDH", method = RequestMethod.GET)
    public String startPreviewDH(String code) {
        getPlantFactoryData(code);
        return "running/camera/startPreviewDH";
    }

    //大华摄像头回放
    @RequestMapping(value = "/playBackDH", method = RequestMethod.GET)
    public String playBackDH(String code) {
        getPlantFactoryData(code);
        return "running/camera/playBackDH";
    }
}
