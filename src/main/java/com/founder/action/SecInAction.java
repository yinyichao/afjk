package com.founder.action;

import com.founder.service.VSecInBasicService;
import common.base.BaseAction;
import common.model.VSecInBasic;
import common.util.SQLLiteUUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@RequestMapping("/secIn")
public class SecInAction extends BaseAction {

    private VSecInBasicService secInService;

    @Autowired
    public void setSecInService(VSecInBasicService secInService) {
        this.secInService = secInService;
    }

    //各区域设备运行情况
    @RequestMapping(value = "prisonInform", method = RequestMethod.GET)
    public String prisonInform(String code) {
        List<VSecInBasic> secDTOs = secInService.getPrisonInform(code);
        Map<Integer, String> semap = SQLLiteUUtil.f(secDTOs);
        //视频
        request.setAttribute("resultVidicon", semap.get(1));
        //仓讲
        request.setAttribute("warehouse", semap.get(2));
        //门禁
        request.setAttribute("access", semap.get(3));
        //电网
        request.setAttribute("grid", semap.get(4));
        //生命探测
        request.setAttribute("lifeDetection", semap.get(6));
        //手机屏蔽
        request.setAttribute("shield", semap.get(7));
        @SuppressWarnings("unchecked")
        Map<String, String> pdMap = (Map<String, String>) request.getSession().getAttribute("pdMap");
        request.setAttribute("prisonName", pdMap.get(code));
        request.setAttribute("code", code);
        return "/running/equipment";
    }
}
