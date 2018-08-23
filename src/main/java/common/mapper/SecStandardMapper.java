package common.mapper;

import java.util.List;

import common.model.SecStandard;



public interface SecStandardMapper {
	//厂商信息二级页
	List<SecStandard> plantFactoryInfoSecond(String code);
	//厂商描述
	SecStandard plantFactoryDescription(Integer id);
    
}