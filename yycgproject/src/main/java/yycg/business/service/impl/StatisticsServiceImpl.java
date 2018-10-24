package yycg.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.dao.DictInfoMapper;
import yycg.base.pojo.po.DictInfo;
import yycg.base.pojo.po.DictInfoExample;
import yycg.base.pojo.po.DictInfoExample.Criteria;
import yycg.base.process.context.Config;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.business.dao.StatisticsMapper;
import yycg.business.pojo.vo.BusinessCoustomer;
import yycg.business.pojo.vo.BusinessVo;
import yycg.business.service.StatisticsService;

public class StatisticsServiceImpl implements StatisticsService{

	@Autowired
	private StatisticsMapper statisticsmapper;
	
	@Autowired
	private DictInfoMapper mapper;
	
	@Override
	public List<DictInfo> findDictInfoByTypeCode(String typecode) {
		DictInfoExample example=new DictInfoExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTypecodeEqualTo(typecode);
		List<DictInfo> selectByExample = mapper.selectByExample(example);
		return selectByExample;
	}
	
	/**
	 * 交易明细查询
	 */
	@Override
	public int getCount(BusinessVo businessvo) throws ExceptionResultInfo {
		BusinessCoustomer businesscoustomer = businessvo.getBusinesscoustomer();
		if(businesscoustomer != null){
			String year = businesscoustomer.getYear();
			if(year != null && !"".equals(year) ){
				if ("2014".equals(year)){
					businesscoustomer.setYear("YYBUSINESS2014");
					return statisticsmapper.findTotalItem(businessvo);
				}
				if("2015".equals(year)){
					businesscoustomer.setYear("YYBUSINESS2015");
					return statisticsmapper.findTotalItem(businessvo);
				}
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 701));
			}
		}
		return statisticsmapper.findTotalItem(businessvo);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<List> qeuryBusinessDetail(BusinessVo businessvo) throws ExceptionResultInfo {
		List<BusinessCoustomer> businessdetail = statisticsmapper.qeuryBusinessDetail(businessvo);
		List<Object> footer = new ArrayList<Object>();
		int sumCgl = 0,sumJsl = 0,sumThl = 0;
		float sumCgje = 0,sumRkl = 0,sumRkje = 0,sumThje = 0,sumJsje = 0;
		for(BusinessCoustomer businessvo0 : businessdetail){
			sumCgl += businessvo0.getCgl();
			sumCgje += businessvo0.getCgje();
			sumRkl += businessvo0.getRkl();
			sumRkje += businessvo0.getRkje();
			sumThl += Integer.parseInt(businessvo0.getThl());
			sumThje += businessvo0.getThje();
			sumJsl += businessvo0.getJsl();
			sumJsje += businessvo0.getJsje();
		}
		footer.add(sumCgl);
		footer.add(sumCgje);
		footer.add(sumRkl);
		footer.add(sumRkje);
		footer.add(sumThl);
		footer.add(sumThje);
		footer.add(sumJsl);
		footer.add(sumJsje);
		List<List> list = new ArrayList<List>();
		list.add(businessdetail);
		list.add(footer);
		return list;
		
	}

	/**
	 * 采购单统计查询
	 */
	@Override
	public int getPurchaseordersCount(BusinessVo businessvo) throws ExceptionResultInfo {
		BusinessCoustomer businesscoustomer = businessvo.getBusinesscoustomer();
		if(businesscoustomer != null){
			String year = businesscoustomer.getYear();
			if(year != null && !"".equals(year) ){
				if ("2014".equals(year)){
					businesscoustomer.setYear("YYBUSINESS2014");
					return statisticsmapper.findTotalPurchaseorders(businessvo);
				}
				if("2015".equals(year)){
					businesscoustomer.setYear("YYBUSINESS2015");
					return statisticsmapper.findTotalPurchaseorders(businessvo);
				}
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 701));
			}
		}
		return statisticsmapper.findTotalPurchaseorders(businessvo);
	}

	@Override
	public List<BusinessVo> qeuryPurchaseorders(BusinessVo businessvo) {
		return statisticsmapper.qeuryPurchaseorders(businessvo);
	}

	@Override
	public BusinessCoustomer findDetailByCGDId(String yycgdid,String year) throws ExceptionResultInfo {
		if(year != null && !"".equals(year) ){
			if ("2014".equals(year)){
				year = "YYBUSINESS2014";
				return statisticsmapper.findDetailByCGDId(yycgdid,year);
			}
			if("2015".equals(year)){
				year = "YYBUSINESS2015";
				return statisticsmapper.findDetailByCGDId(yycgdid,year);
			}
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 701));
		}
		return statisticsmapper.findDetailByCGDId(yycgdid,year);
	}

	@Override
	public int getCountByGys(BusinessVo businessvo) throws ExceptionResultInfo {
		BusinessCoustomer businesscoustomer = businessvo.getBusinesscoustomer();
		if(businesscoustomer != null){
			String year = businesscoustomer.getYear();
			if(year != null && !"".equals(year) ){
				if ("2014".equals(year)){
					businesscoustomer.setYear("YYBUSINESS2014");
					return statisticsmapper.getCountByGys(businessvo);
				}
				if("2015".equals(year)){
					businesscoustomer.setYear("YYBUSINESS2015");
					return statisticsmapper.getCountByGys(businessvo);
				}
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 701));
			}
		}
		return statisticsmapper.getCountByGys(businessvo);
	}

	@Override
	public List<BusinessVo> statisticsByGys(BusinessVo businessvo) {
		return statisticsmapper.statisticsByGys(businessvo);
	}

	@Override
	public int getCountByHospital(BusinessVo businessvo) throws ExceptionResultInfo {
		BusinessCoustomer businesscoustomer = businessvo.getBusinesscoustomer();
		if(businesscoustomer != null){
			String year = businesscoustomer.getYear();
			if(year != null && !"".equals(year) ){
				if ("2014".equals(year)){
					businesscoustomer.setYear("YYBUSINESS2014");
					return statisticsmapper.getCountByHospital(businessvo);
				}
				if("2015".equals(year)){
					businesscoustomer.setYear("YYBUSINESS2015");
					return statisticsmapper.getCountByHospital(businessvo);
				}
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 701));
			}
		}
		return statisticsmapper.getCountByHospital(businessvo);
	}

	@Override
	public List<BusinessVo> statisticsByHospital(BusinessVo businessvo) {
		return statisticsmapper.statisticsByHospital(businessvo);
	}

	@Override
	public int getCountBymedicine(BusinessVo businessvo) throws ExceptionResultInfo {
		BusinessCoustomer businesscoustomer = businessvo.getBusinesscoustomer();
		if(businesscoustomer != null){
			String year = businesscoustomer.getYear();
			if(year != null && !"".equals(year) ){
				if ("2014".equals(year)){
					businesscoustomer.setYear("YYBUSINESS2014");
					return statisticsmapper.getCountBymedicine(businessvo);
				}
				if("2015".equals(year)){
					businesscoustomer.setYear("YYBUSINESS2015");
					return statisticsmapper.getCountBymedicine(businessvo);
				}
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 701));
			}
		}
		return statisticsmapper.getCountBymedicine(businessvo);
	}
	
	@Override
	public List<BusinessVo> statisticsBymedicine(BusinessVo businessvo) {
		return statisticsmapper.statisticsBymedicine(businessvo);
	}
	
	@Override
	public BusinessCoustomer findDetailByYpbm(String bm,String year) throws ExceptionResultInfo {
		if(year != null && !"".equals(year) ){
			if ("2014".equals(year)){
				year = "YYBUSINESS2014";
				return statisticsmapper.findDetailByYpbm(bm,year);
			}
			if("2015".equals(year)){
				year = "YYBUSINESS2015";
				return statisticsmapper.findDetailByYpbm(bm,year);
			}
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 701));
		}
		return statisticsmapper.findDetailByYpbm(bm,year);
	}


}
