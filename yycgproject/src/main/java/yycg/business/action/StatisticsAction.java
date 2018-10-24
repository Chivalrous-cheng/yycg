package yycg.business.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.po.DictInfo;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.business.pojo.vo.BusinessCoustomer;
import yycg.business.pojo.vo.BusinessVo;
import yycg.business.service.StatisticsService;

@RequestMapping("/tjfx")
@Controller
public class StatisticsAction {

	@Autowired
	private StatisticsService statisticsservice;
	
	
	/**
	 * 交易明细查询
	 */
	@RequestMapping("/businessDetail.action")
	public String businessDetailQeury(Map<String,Object> map){
		//采购状态
		List<DictInfo> findDictInfoByTypeCode = statisticsservice.findDictInfoByTypeCode("011");
		map.put("groupList", findDictInfoByTypeCode);
		return "/business/tjfx/queryBusinessDetail";
	}
	
	/**
	 * 
	 * 查询分页
	 *   返回值：DataGrid.
	 * @throws ExceptionResultInfo 
	 *   
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" }) 
	@RequestMapping("/queryBusinessDetail_result.action")
	public @ResponseBody DataGridResultInfo queryDataGrid(Integer page,Integer rows,BusinessVo businessvo) throws ExceptionResultInfo{
		DataGridResultInfo resutl=new DataGridResultInfo();
		businessvo=businessvo==null?new BusinessVo():businessvo;
		//查询总记录数
		int count=statisticsservice.getCount(businessvo);
		//设置当前页，每页显示条数
		PageQuery pageQuery=new PageQuery();
		//设置条数
		pageQuery.setPageParams(count, rows, page);
		businessvo.setPageQuery(pageQuery);
		//分页查询数据
		List<List> list = statisticsservice.qeuryBusinessDetail(businessvo);
		List<BusinessVo> businessList = list.get(0);
		List<Object> footer = list.get(1);
		resutl.setRows(businessList);
		resutl.setTotal(count);
		return resutl;
		
	}
	
	/**
	 * 采购单统计查询
	 */
	@RequestMapping("/purchaseorders.action")
	public String purchaseorders(Map<String,Object> map){
		//采购状态
		List<DictInfo> findCgztByTypeCode = statisticsservice.findDictInfoByTypeCode("011");
		map.put("cgztgroupList", findCgztByTypeCode);
		//退货状态
		List<DictInfo> findBThztyTypeCode = statisticsservice.findDictInfoByTypeCode("013");
		map.put("thztgroupList", findBThztyTypeCode);
		//结算状态
		List<DictInfo> findJsztByTypeCode = statisticsservice.findDictInfoByTypeCode("015");
		map.put("jsztgroupList", findJsztByTypeCode);
		return "/business/tjfx/purchaseorders";
	}
	
	/**
	 * 
	 * 查询分页
	 *   返回值：DataGrid.
	 * @throws ExceptionResultInfo 
	 *   
	 *
	 */
	@RequestMapping("/querypurchaseorders_result.action")
	public @ResponseBody DataGridResultInfo queryPurchaseordersDataGrid(Integer page,Integer rows,BusinessVo businessvo) throws ExceptionResultInfo{
		DataGridResultInfo resutl=new DataGridResultInfo();
		businessvo=businessvo==null?new BusinessVo():businessvo;
		//查询总记录数
		int count=statisticsservice.getPurchaseordersCount(businessvo);
		//设置当前页，每页显示条数
		PageQuery pageQuery=new PageQuery();
		//设置条数
		pageQuery.setPageParams(count, rows, page);
		businessvo.setPageQuery(pageQuery);
		//分页查询数据
		List<BusinessVo> businessList = statisticsservice.qeuryPurchaseorders(businessvo);
		
		resutl.setRows(businessList);
		resutl.setTotal(count);
		return resutl;
		
	}
	
	@RequestMapping("/purchaseordersDetail.action")
	public String purchaseordersDetail(String yycgdid,String year,Model model) throws ExceptionResultInfo{
		BusinessCoustomer businesscoustomer = statisticsservice.findDetailByCGDId(yycgdid,year);
		model.addAttribute("businesscoustomer", businesscoustomer);
		return "/business/tjfx/purchaseordersDetail";
	}
	
	@RequestMapping("/supplier.action")
	public String supplier(Map<String,Object> map) throws ExceptionResultInfo{
		//采购状态
		List<DictInfo> findCgztByTypeCode = statisticsservice.findDictInfoByTypeCode("011");
		map.put("cgztgroupList", findCgztByTypeCode);
		//退货状态
		List<DictInfo> findBThztyTypeCode = statisticsservice.findDictInfoByTypeCode("013");
		map.put("thztgroupList", findBThztyTypeCode);
		//结算状态
		List<DictInfo> findJsztByTypeCode = statisticsservice.findDictInfoByTypeCode("015");
		map.put("jsztgroupList", findJsztByTypeCode);
		return "/business/tjfx/supplier";
	}
	
	@RequestMapping("/statisticsByGys_result.action")
	public @ResponseBody DataGridResultInfo statisticsByGys(Integer page,Integer rows,BusinessVo businessvo) throws ExceptionResultInfo{
		DataGridResultInfo resutl=new DataGridResultInfo();
		businessvo=businessvo==null?new BusinessVo():businessvo;
		//查询总记录数
		int count=statisticsservice.getCountByGys(businessvo);
		//设置当前页，每页显示条数
		PageQuery pageQuery=new PageQuery();
		//设置条数
		pageQuery.setPageParams(count, rows, page);
		businessvo.setPageQuery(pageQuery);
		//分页查询数据
		List<BusinessVo> businessList = statisticsservice.statisticsByGys(businessvo);
		
		resutl.setRows(businessList);
		resutl.setTotal(count);
		return resutl;
	}
	
	@RequestMapping("/hospital.action")
	public String hospital(Map<String,Object> map) throws ExceptionResultInfo{
		//采购状态
		List<DictInfo> findCgztByTypeCode = statisticsservice.findDictInfoByTypeCode("011");
		map.put("cgztgroupList", findCgztByTypeCode);
		//退货状态
		List<DictInfo> findBThztyTypeCode = statisticsservice.findDictInfoByTypeCode("013");
		map.put("thztgroupList", findBThztyTypeCode);
		//结算状态
		List<DictInfo> findJsztByTypeCode = statisticsservice.findDictInfoByTypeCode("015");
		map.put("jsztgroupList", findJsztByTypeCode);
		return "/business/tjfx/hospital";
	}
	
	@RequestMapping("/hospital_result.action")
	public @ResponseBody DataGridResultInfo hospitalresult(Integer page,Integer rows,BusinessVo businessvo) throws ExceptionResultInfo{
		DataGridResultInfo resutl=new DataGridResultInfo();
		businessvo=businessvo==null?new BusinessVo():businessvo;
		//查询总记录数
		int count=statisticsservice.getCountByHospital(businessvo);
		//设置当前页，每页显示条数
		PageQuery pageQuery=new PageQuery();
		//设置条数
		pageQuery.setPageParams(count, rows, page);
		businessvo.setPageQuery(pageQuery);
		//分页查询数据
		List<BusinessVo> businessList = statisticsservice.statisticsByHospital(businessvo);
		
		resutl.setRows(businessList);
		resutl.setTotal(count);
		return resutl;
	}
	
	@RequestMapping("/medicine.action")
	public String medicine(Map<String,Object> map) throws ExceptionResultInfo{
		//采购状态
		List<DictInfo> findCgztByTypeCode = statisticsservice.findDictInfoByTypeCode("011");
		map.put("cgztgroupList", findCgztByTypeCode);
		//退货状态
		List<DictInfo> findBThztyTypeCode = statisticsservice.findDictInfoByTypeCode("013");
		map.put("thztgroupList", findBThztyTypeCode);
		//结算状态
		List<DictInfo> findJsztByTypeCode = statisticsservice.findDictInfoByTypeCode("015");
		map.put("jsztgroupList", findJsztByTypeCode);
		return "/business/tjfx/medicine";
	}
	
	@RequestMapping("/medicine_result.action")
	public @ResponseBody DataGridResultInfo medicine_result(Integer page,Integer rows,BusinessVo businessvo) throws ExceptionResultInfo{
		DataGridResultInfo resutl=new DataGridResultInfo();
		businessvo=businessvo==null?new BusinessVo():businessvo;
		//查询总记录数
		int count=statisticsservice.getCountBymedicine(businessvo);
		//设置当前页，每页显示条数
		PageQuery pageQuery=new PageQuery();
		//设置条数
		pageQuery.setPageParams(count, rows, page);
		businessvo.setPageQuery(pageQuery);
		//分页查询数据
		List<BusinessVo> businessList = statisticsservice.statisticsBymedicine(businessvo);
		
		resutl.setRows(businessList);
		resutl.setTotal(count);
		return resutl;
	}
	
	@RequestMapping("/ypxxDetail.action")
	public String ypxxDetail(String bm,String year,Model model) throws ExceptionResultInfo{
		BusinessCoustomer businesscoustomer = statisticsservice.findDetailByYpbm(bm,year);
		model.addAttribute("businesscoustomer", businesscoustomer);
		return "/business/tjfx/medicineDetail";
	}
}
