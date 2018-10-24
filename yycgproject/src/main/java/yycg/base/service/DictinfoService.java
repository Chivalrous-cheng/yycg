package yycg.base.service;

import java.util.List;

import yycg.base.pojo.po.DictInfo;
import yycg.base.pojo.vo.DictInfoCoustomer;
import yycg.base.pojo.vo.DictInfoVo;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.process.result.ExceptionResultInfo;

public interface DictinfoService {

	int getCount(DictInfoVo dictinfovo);

	List<DictInfoCoustomer> finddictinfor(DictInfoVo dictinfovo);

	void insertdictInfo(DictInfoVo dictinfovo) throws ExceptionResultInfo;

	DictInfoCoustomer finddictInfoById(String id);

	void updatetdictInfo(DictInfoCoustomer dictinfocoustomer) throws ExceptionResultInfo;

	void deletedictInfoById(String id);

	List<String> findtypename(String typecode);


}
