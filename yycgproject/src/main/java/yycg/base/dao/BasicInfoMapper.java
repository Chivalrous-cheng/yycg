package yycg.base.dao;

import java.util.List;

import yycg.base.pojo.po.BasicInfo;
import yycg.base.pojo.vo.BasicInfoCoustomer;
import yycg.base.pojo.vo.BasicInfoVo;

public interface BasicInfoMapper {

	int findTotalItem(BasicInfoVo basicinfovo);

	List<BasicInfoCoustomer> findAllBasicinfo(BasicInfoVo basicinfovo);

	void insertBasicinfo(BasicInfoCoustomer basicinfocoustomer);

	BasicInfo findBasicInfoByName(String name);

	void updatetBasicInfo(BasicInfoCoustomer basicinfocoustomer);

	void deleteBasicInfoById(String id);

	BasicInfoCoustomer findBasicInfoById(String id);

}
