package yycg.business.service;

import java.util.List;

import yycg.base.pojo.po.DictInfo;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.business.pojo.vo.BusinessCoustomer;
import yycg.business.pojo.vo.BusinessVo;

public interface StatisticsService {

	List<DictInfo> findDictInfoByTypeCode(String string);
	
	int getCount(BusinessVo businessvo) throws ExceptionResultInfo;

	List<List> qeuryBusinessDetail(BusinessVo businessvo) throws ExceptionResultInfo;

	int getPurchaseordersCount(BusinessVo businessvo) throws ExceptionResultInfo;

	List<BusinessVo> qeuryPurchaseorders(BusinessVo businessvo);

	BusinessCoustomer findDetailByCGDId(String yycgdid,String year) throws ExceptionResultInfo;

	int getCountByGys(BusinessVo businessvo) throws ExceptionResultInfo;

	List<BusinessVo> statisticsByGys(BusinessVo businessvo);

	int getCountByHospital(BusinessVo businessvo) throws ExceptionResultInfo;

	List<BusinessVo> statisticsByHospital(BusinessVo businessvo);

	int getCountBymedicine(BusinessVo businessvo) throws ExceptionResultInfo;

	List<BusinessVo> statisticsBymedicine(BusinessVo businessvo);

	BusinessCoustomer findDetailByYpbm(String bm,String year) throws ExceptionResultInfo;

	

}
