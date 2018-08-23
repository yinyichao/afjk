package common.mapper;

import common.model.PlantDict;

import java.util.List;


public interface PlantDictMapper {
    List<PlantDict> findPlantDictByType(int type);

    //按code类型查找设备名称
    PlantDict findPlantDictByCode(String code);
}