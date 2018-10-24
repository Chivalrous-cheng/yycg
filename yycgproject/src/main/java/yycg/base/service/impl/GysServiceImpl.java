package yycg.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import yycg.base.dao.SysUserGysCoustomerMapper;
import yycg.base.dao.UserGysMapper;
import yycg.base.pojo.po.UserGys;
import yycg.base.pojo.po.UserGysExample;
import yycg.base.pojo.po.UserGysExample.Criteria;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.pojo.vo.UserGysCoustomer;
import yycg.base.pojo.vo.UserGysVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.service.GysService;
import yycg.util.UUIDBuild;

public class GysServiceImpl implements GysService{

	
	@Autowired
	private SysUserGysCoustomerMapper sysusergyscoustomermapper;
	
	@Autowired
	private UserGysMapper gysmapper;
	
	@Override
	public int getCount(UserGysVo usergysvo) {
		return sysusergyscoustomermapper.findTotalItem(usergysvo);
	}


	@Override
	public List<UserGysCoustomer> findSysUserGys(UserGysVo usergysvo) {
		return sysusergyscoustomermapper.findUserGys(usergysvo);
	}

	@Override
	public void insertUser(UserGysVo usergysvo) throws ExceptionResultInfo {
		/**
		 * js校验
		 * 后台校验
		 * 
		 * 用户账号不能空
		 *  用户账号不能重复
		 */
		
		//企业名称不能空
		UserGysCoustomer usergyscoustomer = usergysvo.getUsergyscoustomer();
		String mc =usergyscoustomer.getMc();
		if(mc==null||!StringUtils.hasLength(mc.trim())){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 116));
		}
		//企业名称不能重复
		UserGys usergys =this.findUserGysByMc(mc);
		if(usergys!=null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 219));
		}
		//添加
		/**
		 * 
		 * 
		 */
		//补全主键
		//UUIDBuild
		usergyscoustomer.setId(UUIDBuild.getUUID());
		sysusergyscoustomermapper.insert(usergyscoustomer);
	}
	
	public UserGys findUserGysByMc(String mc){
		UserGysExample example=new UserGysExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andMcEqualTo(mc);
		List<UserGys> selectByExample = gysmapper.selectByExample(example);
		if(selectByExample.size()>0){
			return selectByExample.get(0);
		}
		return null;
	}
	

	@Override
	public UserGysCoustomer findUserGysById(String id) {
		// TODO Auto-generated method stub
		return sysusergyscoustomermapper.findUserGysById(id);
	}


	@Override
	public void updatetUser(UserGys usergys) {
		sysusergyscoustomermapper.updatetUser(usergys);
	}


	@Override
	public void deleteUserById(String id) {
		sysusergyscoustomermapper.deleteUserById(id);
	}

}
