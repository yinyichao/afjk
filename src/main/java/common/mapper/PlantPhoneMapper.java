package common.mapper;

import common.model.Pager;
import common.model.PlantPhone;
import common.model.View;

import java.util.List;

public interface PlantPhoneMapper {
    //查询手机屏蔽概览
    List<View> findPhoneView(Pager<View> pager);

    //手机屏蔽总数
    int findAllPhoneCount(Pager<View> pager);

    //删除手机屏蔽
    void delPhone(int[] id);

    //添加手机屏蔽
    void insertPhone(PlantPhone plantPhone);

    //按照id查找手机屏蔽信息
    PlantPhone findPhoneById(int id);

    //修改手机屏蔽信息
    void updatePhone(PlantPhone plantPhone);
}
