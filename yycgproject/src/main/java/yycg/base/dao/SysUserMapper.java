package yycg.base.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yycg.base.pojo.po.SysUser;
import yycg.base.pojo.po.SysUserExample;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.pojo.vo.UserGysCoustomer;

public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUserCoustomer sysusercoustomer);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

	void update(SysUserCoustomer sysusercoustomer);

	void deleteUserById(String id);
}