package common.mapper;

import common.model.Pager;
import common.model.PlantPerimeter;
import common.model.View;

import java.util.List;




public interface PlantPerimeterMapper {
	//查询摄像概览
	List<View> findCameraView(Pager<View> pager);
    //摄像总数
	int findAllCameraCount(Pager<View> pager);

	//删除摄像机
	void delCamera(int[] id);
	//添加摄像机
	void insertCamera(PlantPerimeter plantPerimeter);
	//按照id查找摄像头信息
	PlantPerimeter findCameraById(int id);
	//修改摄像机信息
	void updateCamera(PlantPerimeter plantPerimeter);
	//通过方正编码查询海康编码
	String findCodeByRemark(String code);
	//通过方正编码查询海康摄像头名称
	String findNameByRemark(String code);
	//通过方正编码查询海康摄像头ip
	String findAddressUrlByRemark(String code);
	//通过海康编码查询海康摄像头名称
	String findNameByCode(String code);
	//通过海康编码查询海康摄像头ip
	String findAddressUrlByCode(String code);
}