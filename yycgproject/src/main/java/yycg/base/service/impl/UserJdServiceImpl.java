package yycg.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.dao.UserJdMapper;
import yycg.base.pojo.po.UserJD;
import yycg.base.pojo.vo.UserJdCoustomer;
import yycg.base.pojo.vo.UserJdVo;
import yycg.base.service.UserJdService;

public class UserJdServiceImpl implements UserJdService{

	@Autowired
	private UserJdMapper userjdmapper;
	
	@Override
	public int getCount(UserJdVo userjdvo) {
		// TODO Auto-generated method stub
		return userjdmapper.findAllUserJdTotalItem();
	}

	@Override
	public List<UserJdCoustomer> findUserJd(UserJdVo userjdvo) {
		// TODO Auto-generated method stub
		return userjdmapper.findUserJd(userjdvo);
	}

	@Override
	public void insertUserJd(UserJdVo userjdvo) {
		// TODO Auto-generated method stub
		userjdmapper.insertUserJd(userjdvo);
	}

	@Override
	public UserJD findUserJdById(String id) {
		// TODO Auto-generated method stub
		return userjdmapper.findUserJdById(id);
	}

	@Override
	public void updatetUserJd(UserJdVo userjdvo) {
		// TODO Auto-generated method stub
		userjdmapper.updatetUserJd(userjdvo);
	}

	@Override
	public void deleteUserJdById(String id) {
		// TODO Auto-generated method stub
		userjdmapper.deleteUserJdById(id);
	}
	
}
