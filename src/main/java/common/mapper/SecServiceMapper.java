package common.mapper;

import common.model.SecManagement;
import common.model.SecService;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface SecServiceMapper {
	//各个监狱各设备数量
	List<SecManagement> findAllSecCount(@Param("code") String code);
	//查找个监狱的设备的详细信息
	List<SecService> findSecInfor(SecService sec);
	//id查找设备信息 
	SecService findSecById(String id);
}