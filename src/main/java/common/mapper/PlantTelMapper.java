package common.mapper;

import common.model.Pager;
import common.model.PlantTel;
import common.model.View;

import java.util.List;


public interface PlantTelMapper {
    //查询仓讲概览
    List<View> findTelView(Pager<View> pager);

    //仓讲总数
    int findAllTelCount(Pager<View> pager);

    //删除仓讲
    void delTel(int[] id);

    //添加仓讲
    void insertTel(PlantTel plantTel);

    //按照id查找仓讲信息
    PlantTel findTelById(int id);

    //修改仓讲信息
    void updateTel(PlantTel plantTel);
}