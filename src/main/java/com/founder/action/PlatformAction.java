package com.founder.action;

import common.base.BaseAction;
import common.model.DiagramNodesDTO;
import common.model.PlantDict;
import common.util.JsonUtil;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 平台底层Action
 *
 * @author yins
 */
@RequestMapping("/platform")
public class PlatformAction extends BaseAction {

    @RequestMapping("/index")
    public String frame() {
        List<PlantDict> pdList = plantDictService.findPlantDictByType(1);
        Map<String, String> pdMap = new HashMap<>();
        for (PlantDict pd : pdList) {
            pdMap.put(pd.getCode(), pd.getName());
        }
        Properties pps = new Properties();
        try {
            InputStream in = PlatformAction.class.getResourceAsStream("/config.properties");
            pps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String prison = pps.getProperty("prison");
        request.getSession().setAttribute("prison_code", prison);
        request.getSession().setAttribute("plants", pdList);
        request.getSession().setAttribute("pdMap", pdMap);
        return "/frame/index";
    }

    @RequestMapping("/top")
    public String top() {
        return "/frame/top";
    }

    @RequestMapping("/main")
    public String main() {
        String code = (String) request.getSession().getAttribute("prison_code");
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
