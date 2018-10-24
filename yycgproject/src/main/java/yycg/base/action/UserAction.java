package yycg.base.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.po.DictInfo;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.pojo.vo.SysUserVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.SysUserService;
import yycg.base.service.SystetmConfigService;
@RequestMapping("/user")
@Controller
public class UserAction {
	
	@Autowired
	private SysUserService sysuserservice;
	
	@Autowired
	private SystetmConfigService systetmconfigservice;
	
	/**
	 * 用户查询
	 */
	@RequestMapping("/queryuser.action")
	public String queryuser(Map<String,Object> map){
		List<DictInfo> findDictInfoByTypeCode = systetmconfigservice.findDictInfoByTypeCode("s01");
		map.put("groupList", findDictInfoByTypeCode);
		return "/base/user/queryuser";
	}
	
	/**
	 * 
	 * 查询分页
	 *   返回值：DataGrid.
	 *   
	 *
	 */
	@RequestMapping("/queryuser_result.action")
	public @ResponseBody DataGridResultInfo queryDataGrid(Integer page,Integer rows,SysUserVo sysuservo){
		DataGridResultInfo resutl=new DataGridResultInfo();
		sysuservo=sysuservo==null?new SysUserVo():sysuservo;
		//查询总记录数
		int count=sysuserservice.getCount(sysuservo);
		//设置当前页，每页显示条数
		PageQuery pageQuery=new PageQuery();
		//设置条数
		pageQuery.setPageParams(count, rows, page);
		sysuservo.setPageQuery(pageQuery);
		//分页查询数据
		List<SysUserCoustomer> userList = sysuserservice.findSysUser(sysuservo);
		
		resutl.setRows(userList);
		resutl.setTotal(count);
		return resutl;
		
	}
	
	
	@RequestMapping("/addsysuser.action")
	public String addsysuser(Model model){//为查询框的用户类型从数据库调用数据
		List<DictInfo> findDictInfoByTypeCode = systetmconfigservice.findDictInfoByTypeCode("s01");
		model.addAttribute("groupList", findDictInfoByTypeCode);
		return "/base/user/addsysuser";
	}
	
	
	/**
	 * 添加
	 * 
	 * 异步提交，响应的返回值Sub
	 * @throws ExceptionResultInfo 
	 * 
	 * 
	 * 
	 */
	@RequestMapping("/addsysusersubmit.action")//真正的数据库插入用户
	public @ResponseBody SubmitResultInfo addsysusersubmit(SysUserVo sysuservo) throws ExceptionResultInfo{
		sysuservo=sysuservo==null?new SysUserVo():sysuservo;
		/**
		 * 调用service的方法
		 */
		sysuserservice.insertUser(sysuservo);
			
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
	}
	
	@RequestMapping("/editsysuser.action")
	public String EditSYSUser(String id,Model model){
		SysUserCoustomer resutl=sysuserservice.findSysUserById(id);
		model.addAttribute("sysuserCustomer", resutl);
		return "/base/user/editsysuser";
	}
	
	
	@RequestMapping("/editsysusersubmit.action")
	public @ResponseBody SubmitResultInfo editsysusersubmit(SysUserVo sysuservo) throws ExceptionResultInfo{
		sysuservo=sysuservo==null?new SysUserVo():sysuservo;
		SysUserCoustomer sysuserCustom = sysuservo.getSysusercoustomer();
		/**
		 * 调用service的方法
		 */
		sysuserservice.updatetUser(sysuserCustom);
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
		
	}
	
	@RequestMapping("/deletesysuser.action")
	public @ResponseBody SubmitResultInfo deletesysuser(String id) throws ExceptionResultInfo{
		sysuserservice.deleteUserById(id);
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
