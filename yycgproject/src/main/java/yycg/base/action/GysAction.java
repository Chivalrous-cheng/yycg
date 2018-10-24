package yycg.base.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.po.DictInfo;
import yycg.base.pojo.po.UserGys;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.pojo.vo.SysUserVo;
import yycg.base.pojo.vo.UserGysCoustomer;
import yycg.base.pojo.vo.UserGysVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.GysService;
import yycg.base.service.SysUserService;
import yycg.base.service.SystetmConfigService;

@RequestMapping("/gys")
@Controller
public class GysAction {

	@Autowired
	private GysService gysservice;
	
	@RequestMapping("/queryusergys.action")
	public String queryusergys(Map<String,Object> map){
		return "/base/gys/queryusergys";
	}
	
	/**
	 * 
	 * 查询分页
	 *   返回值：DataGrid.
	 *   
	 *
	 */
	@RequestMapping("/queryusergys_result.action")
	public @ResponseBody DataGridResultInfo queryDataGrid(Integer page,Integer rows,UserGysVo usergysvo){
		DataGridResultInfo resutl=new DataGridResultInfo();
		usergysvo=usergysvo==null?new UserGysVo():usergysvo;
		//查询总记录数
		int count=gysservice.getCount(usergysvo);
		//设置当前页，每页显示条数
		PageQuery pageQuery=new PageQuery();
		//设置条数
		pageQuery.setPageParams(count, rows, page);
		usergysvo.setPageQuery(pageQuery);
		//分页查询数据
		List<UserGysCoustomer> userList = gysservice.findSysUserGys(usergysvo);
		
		resutl.setRows(userList);
		resutl.setTotal(count);
		return resutl;
		
	}
	
	@RequestMapping("/addsysusergys.action")
	public String addsysusergys(Model model){//为查询框的用户类型从数据库调用数据
		return "/base/gys/addusergys";
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
	@RequestMapping("/addsysusergyssubmit.action")//真正的数据库插入用户
	public @ResponseBody SubmitResultInfo addsysusergyssubmit(UserGysVo usergysvo) throws ExceptionResultInfo{
		usergysvo=usergysvo==null?new UserGysVo():usergysvo;
		/**
		 * 调用service的方法
		 */
		gysservice.insertUser(usergysvo);
			
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
	}
	
	@RequestMapping("/editsysusergys.action")
	public String editsysusergys(String id,Model model){
		UserGysCoustomer resutl=gysservice.findUserGysById(id);
		model.addAttribute("userGysCustomer", resutl);
		return "/base/gys/editusergys";
	}
	
	
	@RequestMapping("/editsysusergyssubmit.action")
	public @ResponseBody SubmitResultInfo editsysusergyssubmit(UserGysVo usergysvo) throws ExceptionResultInfo{
		usergysvo=usergysvo==null?new UserGysVo():usergysvo;
		UserGys usergys = usergysvo.getUsergyscoustomer();
		/**
		 * 调用service的方法
		 */
		gysservice.updatetUser(usergys);
		
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
		
	}
	
	@RequestMapping("/deleteusergys.action")
	public @ResponseBody SubmitResultInfo deleteusergys(String id) throws ExceptionResultInfo{
		gysservice.deleteUserById(id);
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
	}
}
