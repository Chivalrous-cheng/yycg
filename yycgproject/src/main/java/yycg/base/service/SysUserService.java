package yycg.base.service;

import java.util.List;

import yycg.base.pojo.po.SysUser;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.pojo.vo.SysUserVo;
import yycg.base.process.result.ExceptionResultInfo;

public interface SysUserService {
	/**
	 * 查询用户
	 */

	List<SysUserCoustomer> findSysUser(SysUserVo sysuservo);

	int getCount(SysUserVo sysuservo);

	void insertUser(SysUserVo sysuservo) throws ExceptionResultInfo;
	
	
	SysUser findSysUserByUserId(String userid);

	SysUserCoustomer findSysUserById(String id);

	void updatetUser(SysUserCoustomer sysUserCoustomer) throws ExceptionResultInfo;

	void deleteUserById(String id);
	
    

}
