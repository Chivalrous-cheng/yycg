package yycg.base.dao;

import java.util.List;

import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.pojo.vo.SysUserVo;

public interface SysUserCoustomerMapper {
	
	List<SysUserCoustomer> findUser(SysUserVo sysuservo);
	
	int findTotalItem(SysUserVo sysuservo);

	SysUserCoustomer findUserById(String id);

}
