package yycg.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import yycg.base.dao.BasicInfoMapper;
import yycg.base.pojo.po.BasicInfo;
import yycg.base.pojo.vo.BasicInfoCoustomer;
import yycg.base.pojo.vo.BasicInfoVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.service.BasicInfoService;
import yycg.util.UUIDBuild;

public class BasicInfoServiceImpl implements BasicInfoService{

	@Autowired
	private BasicInfoMapper basicinfomapper;
	
	@Override
	public int getCount(BasicInfoVo basicinfovo) {
		return basicinfomapper.findTotalItem(basicinfovo);
	}

	@Override
	public List<BasicInfoCoustomer> findbasicinfo(BasicInfoVo basicinfovo) {
		return basicinfomapper.findAllBasicinfo(basicinfovo);
	}

	@Override
	public void insertBasicinfo(BasicInfoVo basicinfovo) throws ExceptionResultInfo {
		/**
		 * js校验
		 * 后台校验
		 * 配置项不能为空
		 * 配置值不能为空
		 */
		
		//配置项不为空
		BasicInfoCoustomer basicinfocoustomer =basicinfovo.getBasicinfocoustomer();
		String name =basicinfocoustomer.getName();
		if(name==null||!StringUtils.hasLength(name.trim())){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 803));
		}
		//配置项不能重复
		BasicInfo basicinfo = this.findBasicInfoByName(name);
		if(basicinfo!=null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 804));
		}
		//配置值不为空
		String value = basicinfocoustomer.getValue();
		if(value==null||!StringUtils.hasLength(value.trim())){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 805));
		}
		//补全主键
		//UUIDBuild
		basicinfocoustomer.setId(UUIDBuild.getUUID());
		
		basicinfomapper.insertBasicinfo(basicinfocoustomer);
	}

	@Override
	public void updatetBasicInfo(BasicInfoCoustomer basicinfocoustomer) {
		basicinfomapper.updatetBasicInfo(basicinfocoustomer);
	}

	@Override
	public void deleteBasicInfoById(String id) {
		basicinfomapper.deleteBasicInfoById(id);
	}

	private BasicInfo findBasicInfoByName(String name) {
		return basicinfomapper.findBasicInfoByName(name);
	}

	@Override
	public BasicInfoCoustomer findBasicInfoById(String id) {
		return basicinfomapper.findBasicInfoById(id);
	}

}
