package yycg.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.dao.UserGysMapper;
import yycg.base.pojo.po.UserGys;
import yycg.base.pojo.po.UserGysExample;
import yycg.base.pojo.po.UserGysExample.Criteria;
import yycg.base.service.UserGysService;

public class UserGysServiceImpl implements UserGysService {
	
	@Autowired
	private UserGysMapper usergysMapper;

	@Override
	public UserGys findUserGysByName(String name) {
		UserGysExample example=new UserGysExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andMcEqualTo(name);
		List<UserGys> selectByExample = usergysMapper.selectByExample(example);
	  
		return selectByExample.size()>0?selectByExample.get(0):null;
	}
	
	

}
