package yycg.base.dao;

import java.util.List;

import yycg.base.pojo.po.DictInfo;
import yycg.base.pojo.po.UserGys;
import yycg.base.pojo.vo.UserGysCoustomer;
import yycg.base.pojo.vo.UserGysVo;

public interface SysUserGysCoustomerMapper {

	int findTotalItem(UserGysVo usergysvo);

	List<UserGysCoustomer> findUserGys(UserGysVo usergysvo);

	List<DictInfo> selectByExample(UserGysVo usergysvo);

	void insert(UserGysCoustomer usergyscoustomer);

	UserGysCoustomer findUserGysById(String id);

	void updatetUser(UserGys usergys);

	void deleteUserById(String id);

}
