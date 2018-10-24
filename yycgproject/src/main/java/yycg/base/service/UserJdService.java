package yycg.base.service;

import java.util.List;

import yycg.base.pojo.po.UserJD;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.pojo.vo.SysUserVo;
import yycg.base.pojo.vo.UserJdCoustomer;
import yycg.base.pojo.vo.UserJdVo;

public interface UserJdService {

	int getCount(UserJdVo userjdvo);

	List<UserJdCoustomer> findUserJd(UserJdVo userjdvo);
	
	void insertUserJd(UserJdVo userjdvo);

	UserJD findUserJdById(String id);

	void updatetUserJd(UserJdVo userjd);

	void deleteUserJdById(String id);


	

}
