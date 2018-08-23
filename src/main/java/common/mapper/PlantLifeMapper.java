package common.mapper;

import common.model.Pager;
import common.model.PlantLife;
import common.model.View;

import java.util.List;

public interface PlantLifeMapper {
    //查询生命探测概览
    List<View> findLifeView(Pager<View> pager);

    //生命探测总数
    int findAllLifeCount(Pager<View> pager);

    //删除生命探测
    void delLife(int[] id);

    //添加生命探测
    void insertLife(PlantLife plantLife);

    //按照id查找生命探测信息
    PlantLife findLifeById(int id);

    //修改生命探测信息
    void updateLife(PlantLife plantLife);
}