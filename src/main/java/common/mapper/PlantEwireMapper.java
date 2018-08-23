package common.mapper;

import common.model.Pager;
import common.model.PlantEwire;
import common.model.View;

import java.util.List;

public interface PlantEwireMapper {
    //查询电网概览
    List<View> findEwireView(Pager<View> pager);

    //电网总数
    int findAllEwireCount(Pager<View> pager);

    //删除电网
    void delEwire(int[] id);

    //添加电网
    void insertEwire(PlantEwire plantEwire);

    //按照id查找电网信息
    PlantEwire findEwireById(int id);

    //修改电网信息
    void updateEwire(PlantEwire plantEwire);
}