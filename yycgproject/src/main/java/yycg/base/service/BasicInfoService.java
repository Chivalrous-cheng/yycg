package yycg.base.service;

import java.util.List;

import yycg.base.pojo.vo.BasicInfoCoustomer;
import yycg.base.pojo.vo.BasicInfoVo;
import yycg.base.process.result.ExceptionResultInfo;

public interface BasicInfoService {

	int getCount(BasicInfoVo basicinfovo);

	List<BasicInfoCoustomer> findbasicinfo(BasicInfoVo basicinfovo);

	void insertBasicinfo(BasicInfoVo basicinfovo) throws ExceptionResultInfo;

	void updatetBasicInfo(BasicInfoCoustomer basicinfocoustomer);

	void deleteBasicInfoById(String id);

	BasicInfoCoustomer findBasicInfoById(String id);

}
