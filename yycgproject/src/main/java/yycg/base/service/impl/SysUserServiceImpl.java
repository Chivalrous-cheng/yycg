package yycg.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import yycg.base.dao.SysUserCoustomerMapper;
import yycg.base.dao.SysUserMapper;
import yycg.base.dao.UserGysMapper;
import yycg.base.pojo.po.SysUser;
import yycg.base.pojo.po.SysUserExample;
import yycg.base.pojo.po.UserGys;
import yycg.base.pojo.po.UserGysExample;
import yycg.base.pojo.po.SysUserExample.Criteria;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.pojo.vo.SysUserVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.service.SysUserService;
import yycg.util.MD5;
import yycg.util.UUIDBuild;

public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserCoustomerMapper sysusercoustomermapper;
	
	@Autowired
	private SysUserMapper sysusermapper;
	
	@Autowired
	private UserGysMapper mapper;

	
	


	@Override
	public List<SysUserCoustomer> findSysUser(SysUserVo sysuservo) {
		// TODO Auto-generated method stub
		return sysusercoustomermapper.findUser(sysuservo);
	}


	@Override
	public int getCount(SysUserVo sysuservo) {
		// TODO Auto-generated method stub
		return sysusercoustomermapper.findTotalItem(sysuservo);
	}

   /**
    * 添加的方法
    *  判断前置条件
    *        失败： 抛出异常 
    *  自定义异常 ExceptionResultInfo
 * @throws ExceptionResultInfo 
    */
	@Override
	public void insertUser(SysUserVo sysuservo) throws ExceptionResultInfo {
		/**
		 * js校验
		 * 后台校验
		 * 
		 * 用户账号不能空
		 *  用户账号不能重复
		 *  用户单位名称必须存在
		 */
		
		//用户账号不能空
		SysUserCoustomer sysusercoustomer = sysuservo.getSysusercoustomer();
		String userid =sysusercoustomer .getUserid();
		if(userid==null||!StringUtils.hasLength(userid.trim())){
//			ResultInfo info=new ResultInfo(ResultInfo.TYPE_RESULT_FAIL , 115, ResourcesUtil.getValue("", "115"));
//			throw new ExceptionResultInfo(info);
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 115));
		}
		//用户账号不能重复
		SysUser sysUser=this.findSysUserByUserId(userid);
		if(sysUser!=null){
//			ResultInfo info=new ResultInfo(ResultInfo.TYPE_RESULT_FAIL , 100, "用户账号不能重复");
//			throw new ExceptionResultInfo(info);
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 208));
		}
		//用户单位名称必须存在
		//根据单位名称查询单位
		String groupid = sysusercoustomer.getGroupid();
		if(!StringUtils.hasLength(groupid.trim())){
//			ResultInfo info=new ResultInfo(ResultInfo.TYPE_RESULT_FAIL , 100, "请选择用户类型");
//			throw new ExceptionResultInfo(info);
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 218));
		}
		UserGys usergys=null;
		if("4".equals(groupid)){
			//查询供应商
			String mc = sysusercoustomer.getMc();
			usergys= this.findUserGysByName(mc);
			if(usergys==null){
//				ResultInfo info=new ResultInfo(ResultInfo.TYPE_RESULT_FAIL , 100, "用单位名称错误户");
//				throw new ExceptionResultInfo(info);
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 217));
			}
		}
		//添加
		/**
		 * 
		 * 
		 */
		//补全用户的单位id
		sysusercoustomer.setSysid(usergys.getId());
		//密码加密
		//暂时使用工具类加密
		  //shiro 的加密方式  
		sysusercoustomer.setPwd(new MD5().getMD5ofStr(sysusercoustomer.getPwd()));
		//补全主键
		//UUIDBuild
		sysusercoustomer.setId(UUIDBuild.getUUID());
		sysusermapper.insert(sysusercoustomer);
//		ResultInfo info=new ResultInfo(ResultInfo.TYPE_RESULT_SUCCESS , 100, "添加成功");
//		throw new ExceptionResultInfo(info);
	}
	
	/**
	    * 修改的方法
	    *  判断前置条件
	    *        失败： 抛出异常 
	    *  自定义异常 ExceptionResultInfo
	 * @throws ExceptionResultInfo 
	    */
	@Override
	public void updatetUser(SysUserCoustomer sysusercoustomer) throws ExceptionResultInfo {
		/**
		 * js校验
		 * 后台校验
		 * 
		 * 用户账号不能空
		 *  用户账号不能不存在
		 */
		//用户账号不能空
		String userid =sysusercoustomer .getUserid();
		if(userid==null||!StringUtils.hasLength(userid.trim())){
//			ResultInfo info=new ResultInfo(ResultInfo.TYPE_RESULT_FAIL , 115, ResourcesUtil.getValue("", "115"));
//			throw new ExceptionResultInfo(info);
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 115));
		}
		//用户账号不存在
		SysUser sysUser=this.findSysUserByUserId(userid);
		if(sysUser==null){
//			ResultInfo info=new ResultInfo(ResultInfo.TYPE_RESULT_FAIL , 100, "用户账号不能重复");
//			throw new ExceptionResultInfo(info);
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 208));
		}
		//用户单位名称必须存在
		//根据单位名称查询单位
		String groupid = sysusercoustomer.getGroupid();
		if(!StringUtils.hasLength(groupid.trim())){
//			ResultInfo info=new ResultInfo(ResultInfo.TYPE_RESULT_FAIL , 100, "请选择用户类型");
//			throw new ExceptionResultInfo(info);
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 218));
		}
		UserGys usergys=null;
		if("4".equals(groupid)){
			//查询供应商
			String mc = sysusercoustomer.getMc();
			usergys= this.findUserGysByName(mc);
			if(usergys==null){
//				ResultInfo info=new ResultInfo(ResultInfo.TYPE_RESULT_FAIL , 100, "用单位名称错误户");
//				throw new ExceptionResultInfo(info);
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 217));
			}
		}
		if(!"0".equals(groupid))
		//补全用户的单位id
		sysusercoustomer.setSysid(usergys.getId());
		
		//修改
		//是否修改密码
		String pwd = sysusercoustomer.getPwd();
		if(pwd != null && !"".equals(pwd)){
			//密码加密
			//暂时使用工具类加密
			  //shiro 的加密方式  
			sysusercoustomer.setPwd(new MD5().getMD5ofStr(sysusercoustomer.getPwd()));
		}
		sysusermapper.update(sysusercoustomer);
//		ResultInfo info=new ResultInfo(ResultInfo.TYPE_RESULT_SUCCESS , 100, "添加成功");
//		throw new ExceptionResultInfo(info);
	
		
	}
	
	
	
	public SysUser findSysUserByUserId(String userid){
		SysUserExample example=new SysUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUseridEqualTo(userid);
		List<SysUser> selectByExample = sysusermapper.selectByExample(example);
		if(selectByExample.size()>0){
			return selectByExample.get(0);
		}
		return null;
	}
	
	
	public UserGys findUserGysByName(String name) {
		UserGysExample example=new UserGysExample();
		yycg.base.pojo.po.UserGysExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andMcEqualTo(name);
		List<UserGys> selectByExample = mapper.selectByExample(example);
		return selectByExample.size()>0?selectByExample.get(0):null;
	}


	@Override
	public SysUserCoustomer findSysUserById(String id) {
		return sysusercoustomermapper.findUserById(id);
	}


	@Override
	public void deleteUserById(String id) {
		sysusermapper.deleteUserById(id);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
