package common.mapper;

import common.model.Pager;
import common.model.PlantFactory;
import common.model.PlantFactoryExt;

import java.util.List;


public interface PlantFactoryMapper {
    //查询所有厂家
    List<PlantFactory> findAllFactory();

    //查询所用厂商信息
    List<PlantFactoryExt> findAllPlantFactory(Pager<PlantFactoryExt> pager);

    //查询所有厂商的数量
    Integer getPlantFactoryCount();

    //添加厂商
    void insertFactory(PlantFactory plantFactory);

    //修改厂商回显
    PlantFactory findFactoryById(int id);

    //修改厂商
    void updateFactoryById(PlantFactory plantFactory);

    //批量删除
    void delFactory(int[] id);

    //查询调用视频所需数据
    PlantFactory findPlantFactoryData(String code);
}