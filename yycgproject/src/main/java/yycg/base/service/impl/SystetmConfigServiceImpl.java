package yycg.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.dao.DictInfoMapper;
import yycg.base.pojo.po.DictInfo;
import yycg.base.pojo.po.DictInfoExample;
import yycg.base.pojo.po.DictInfoExample.Criteria;
import yycg.base.service.SystetmConfigService;

public class SystetmConfigServiceImpl implements SystetmConfigService{
	
	@Autowired
	private DictInfoMapper mapper;
/**
 * typecode:数据字典表的typcode.
 * 
 */
	@Override
	public List<DictInfo> findDictInfoByTypeCode(String typecode) {
		DictInfoExample example=new DictInfoExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTypecodeEqualTo(typecode);
		List<DictInfo> selectByExample = mapper.selectByExample(example);
		return selectByExample;
	}

}
