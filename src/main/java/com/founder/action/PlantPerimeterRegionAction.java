package com.founder.action;

import common.base.BaseAction;
import common.model.DiagramNodesDTO;
import common.model.PlantPerimeterRegion;
import common.util.JsonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/region")
public class PlantPerimeterRegionAction extends BaseAction {

    @RequestMapping(value = "/insertPage", method = RequestMethod.GET)
    public String insertPage() {
        return "/region/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insert(PlantPerimeterRegion region) {
        plantPerimeterRegionService.insertRegion(region);
        return region.getId();
    }

    @RequestMapping(value = "/selectByCode", method = RequestMethod.GET)
    @ResponseBody
    public String selectByCode(String code) {
        return JsonUtil.toJson(plantPerimeterRegionService.selectByCode(code));
    }

    //区域设备分布
    @RequestMapping(value = "/findAllEquipment", method = RequestMethod.GET)
    public String findAllEquipment(String code) {
        String name = plantPerimeterRegionService.selectDiagramRoot(code);
        List<DiagramNodesDTO> nodes = plantPerimeterRegionService.selectDiagramNodes(code);
        @SuppressWarnings("unchecked")
        Map<String, String> pdMap = (Map<String, String>) request.getSession().getAttribute("pdMap");
        request.setAttribute("prisonName", pdMap.get(code));
        request.setAttribute("name", name);
        request.setAttribute("nodes", JsonUtil.toJson(nodes));
        return "/region/equipment";
    }
}
