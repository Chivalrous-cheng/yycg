package yycg.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yycg.business.pojo.vo.BusinessCoustomer;
import yycg.business.pojo.vo.BusinessVo;

public interface StatisticsMapper {

	public List<BusinessCoustomer> qeuryBusinessDetail(BusinessVo businessvo);

	int findTotalItem(BusinessVo businessvo);

	public int findTotalPurchaseorders(BusinessVo businessvo);

	public List<BusinessVo> qeuryPurchaseorders(BusinessVo businessvo);

	public BusinessCoustomer findDetailByCGDId(@Param("yycgdid")String yycgdid,@Param("year")String year);

	public int getCountByGys(BusinessVo businessvo);

	public List<BusinessVo> statisticsByGys(BusinessVo businessvo);

	public int getCountByHospital(BusinessVo businessvo);

	public List<BusinessVo> statisticsByHospital(BusinessVo businessvo);

	public int getCountBymedicine(BusinessVo businessvo);

	public List<BusinessVo> statisticsBymedicine(BusinessVo businessvo);

	public BusinessCoustomer findDetailByYpbm(@Param("bm") String bm,@Param("year")String year);

}
