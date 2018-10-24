package yycg.base.dao;

import org.apache.ibatis.annotations.Param;

import yycg.base.pojo.po.SysUser;

public interface LoginMapper {

	SysUser login(@Param("userid")String userid, @Param("password")String password);

}
