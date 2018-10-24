package yycg.base.dao;

import java.util.List;

import yycg.base.pojo.po.UserJD;
import yycg.base.pojo.vo.UserJdCoustomer;
import yycg.base.pojo.vo.UserJdVo;

public interface UserJdMapper {

	int findAllUserJdTotalItem();

	List<UserJdCoustomer> findUserJd(UserJdVo userjdvo);

	void insertUserJd(UserJdVo userjdvo);

	UserJD findUserJdById(String id);

	void updatetUserJd(UserJdVo userjdvo);

	void deleteUserJdById(String id);

}
