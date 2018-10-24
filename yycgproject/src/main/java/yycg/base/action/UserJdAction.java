package yycg.base.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.po.DictInfo;
import yycg.base.pojo.po.UserJD;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.pojo.vo.UserJdCoustomer;
import yycg.base.pojo.vo.UserJdVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.SysUserService;
import yycg.base.service.SystetmConfigService;
import yycg.base.service.UserJdService;

@RequestMapping("/userjd")
@Controller
public class UserJdAction {
	
	@Autowired
	private UserJdService userjdservice;
	
	/**
	 * 用户查询
	 */
	@RequestMapping("/queryuserjd.action")
	public String queryuserjd(Map<String,Object> map){
		return "/base/userjd/userjdresult";
	}
	
	/**
	 * 
	 * 查询分页
	 *   返回值：DataGrid.
	 *   
	 *
	 */
	@RequestMapping("/queryuserjd_result.action")
	public @ResponseBody DataGridResultInfo queryDataGrid(Integer page,Integer rows,UserJdVo userjdvo){
		DataGridResultInfo resutl=new DataGridResultInfo();
		userjdvo=userjdvo!=null?userjdvo:new UserJdVo();
		//查询总记录数
		int count=userjdservice.getCount(userjdvo);
		//设置当前页，每页显示条数
		PageQuery pageQuery=new PageQuery();
		//设置条数
		pageQuery.setPageParams(count, rows, page);
		userjdvo.setPageQuery(pageQuery);
		//分页查询数据
		List<UserJdCoustomer> userList = userjdservice.findUserJd(userjdvo);
		
		resutl.setRows(userList);
		resutl.setTotal(count);
		return resutl;
		
	}
	
	
	@RequestMapping("/adduserjd.action")
	public String adduserjd(Model model){//为查询框的用户类型从数据库调用数据
		return "/base/userjd/adduserjd";
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
	@RequestMapping("/adduserjdsubmit.action")//真正的数据库插入用户
	public @ResponseBody SubmitResultInfo adduserjdsubmit(UserJdVo userjdvo) throws ExceptionResultInfo{
		userjdvo=userjdvo==null?new UserJdVo():userjdvo;
		/**
		 * 调用service的方法
		 */
		userjdservice.insertUserJd(userjdvo);
			
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
	}
	
	@RequestMapping("/edituserjd.action")
	public String edituserjd(String id,Model model){
		UserJD resutl=userjdservice.findUserJdById(id);
		model.addAttribute("sysuserCustomer", resutl);
		return "/base/userjd/edituserjd";
	}
	
	
	@RequestMapping("/edituserjdsubmit.action")
	public @ResponseBody SubmitResultInfo edituserjdsubmit(UserJdVo userjd) throws ExceptionResultInfo{
		userjd=userjd==null?new UserJdVo():userjd;
		/**
		 * 调用service的方法
		 */
		userjdservice.updatetUserJd(userjd);
		
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
		
	}
	
	@RequestMapping("/deleteuserjd.action")
	
	public @ResponseBody SubmitResultInfo deleteuserjd(String id) throws ExceptionResultInfo{
		userjdservice.deleteUserJdById(id);
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
	}
	

}
