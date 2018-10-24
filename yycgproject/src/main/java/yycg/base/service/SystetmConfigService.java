package yycg.base.service;

import java.util.List;

import yycg.base.pojo.po.DictInfo;

public interface SystetmConfigService {
	
	/**
	 * 根据typecode查询数据
	 */
	
	List<DictInfo> findDictInfoByTypeCode(String typecode);

}
