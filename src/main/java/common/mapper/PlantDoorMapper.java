package common.mapper;

import common.model.Pager;
import common.model.PlantDoor;
import common.model.View;

import java.util.List;


public interface PlantDoorMapper {
    //查询门禁概览
    List<View> findDoorView(Pager<View> pager);

    //门禁总数
    int findAllDoorCount(Pager<View> pager);

    //删除门禁
    void delDoor(int[] id);

    //添加门禁
    void insertDoor(PlantDoor plantDoor);

    //按照id查找门禁信息
    PlantDoor findDoorById(int id);

    //修改门禁信息
    void updateDoor(PlantDoor plantDoor);
}