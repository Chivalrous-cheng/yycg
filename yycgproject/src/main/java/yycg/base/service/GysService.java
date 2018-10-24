package yycg.base.service;

import java.util.List;

import yycg.base.pojo.po.DictInfo;
import yycg.base.pojo.po.UserGys;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.pojo.vo.SysUserVo;
import yycg.base.pojo.vo.UserGysCoustomer;
import yycg.base.pojo.vo.UserGysVo;
import yycg.base.process.result.ExceptionResultInfo;

public interface GysService {

	int getCount(UserGysVo usergysvo);

	List<UserGysCoustomer> findSysUserGys(UserGysVo usergysvo);

	void insertUser(UserGysVo usergysvo) throws ExceptionResultInfo;

	UserGysCoustomer findUserGysById(String id);

	void updatetUser(UserGys usergys);

	void deleteUserById(String id);

	
}
