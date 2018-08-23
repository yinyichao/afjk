package common.mapper;

import common.model.PlantTelRegion;

import java.util.List;



public interface PlantTelRegionMapper {
    List<PlantTelRegion> selectByCode(String code);
}