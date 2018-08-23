package com.founder.action;

import com.founder.service.SecServiceService;
import common.base.BaseAction;
import common.model.PlantDict;
import common.model.SecManagement;
import common.model.SecService;
import common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/secService")
public class SecServiceAction extends BaseAction {

    private SecServiceService secServiceService;

    @Autowired
    public void setSecServiceService(SecServiceService secServiceService) {
        this.secServiceService = secServiceService;
    }

    //各个监狱各设备数量
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String insertPage() {
        String code = (String) request.getSession().getAttribute("prison_code");
        List<SecManagement> secList = secServiceService.findAllSecCount(code);
        request.setAttribute("secList", secList);
        return "/service/serviceManagement";
    }

    //查找个监狱的设备的详细信息
    @RequestMapping(value = "/secInfor", method = RequestMethod.GET)
    public String secInfor(String code, String type) {
        SecService sec = new SecService();
        sec.setPrison(code);
        sec.setType(type);
        @SuppressWarnings("unchecked")
        Map<String, String> pdMap = (Map<String, String>) request.getSession().getAttribute("pdMap");
        request.setAttribute("prisonName", pdMap.get(code));
        List<SecService> ssList = secServiceService.findSecInfor(sec);
        request.setAttribute("ssList", ssList);
        PlantDict plantDict = plantDictService.findPlantDictByCode(type);
        request.setAttribute("plantDict", plantDict);
        return "/service/secInfor";
    }

    //id查找设备信息
    @RequestMapping(value = "/changeSec", method = RequestMethod.POST)
    @ResponseBody
    public String changeSec(String id) {
        SecService secService = secServiceService.findSecById(id);
        return JsonUtil.toJson(secService);
    }
}
