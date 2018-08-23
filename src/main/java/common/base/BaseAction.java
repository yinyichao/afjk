package common.base;

import com.founder.service.PlantDictService;
import com.founder.service.PlantFactoryService;
import com.founder.service.PlantPerimeterRegionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action Base
 *
 * @author yins
 */
public class BaseAction {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Autowired
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }


    protected PlantPerimeterRegionService plantPerimeterRegionService;

    protected PlantFactoryService plantFactoryService;


    protected PlantDictService plantDictService;

    @Autowired
    public void setPlantPerimeterRegionService(PlantPerimeterRegionService plantPerimeterRegionService) {
        this.plantPerimeterRegionService = plantPerimeterRegionService;
    }

    @Autowired
    public void setPlantFactoryService(PlantFactoryService plantFactoryService) {
        this.plantFactoryService = plantFactoryService;
    }

    @Autowired
    public void setPlantDictService(PlantDictService plantDictService) {
        this.plantDictService = plantDictService;
    }
}
