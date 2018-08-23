package common.mapper;

import common.model.DiagramNodesDTO;
import common.model.PlantPerimeterRegion;

import java.util.List;



public interface PlantPerimeterRegionMapper {
    void insertRegion(PlantPerimeterRegion region);
    List<PlantPerimeterRegion> selectByCode(String code);
    String selectDiagramRoot(String code);
    List<DiagramNodesDTO> selectDiagramNodes(String code);
}