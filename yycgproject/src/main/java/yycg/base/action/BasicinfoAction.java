package yycg.base.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.vo.BasicInfoCoustomer;
import yycg.base.pojo.vo.BasicInfoVo;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.pojo.vo.SysUserVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.BasicInfoService;

@RequestMapping("/basicinfo")
@Controller
public class BasicinfoAction {
	
	@Autowired
	private BasicInfoService basicinfovoservice;
	
	@RequestMapping("/querybasicinfo.action")
	public String querybasicinfo(Model model){
		return "/base/basicinfo/querybasicinfo";
	}
	
	@RequestMapping("/querybasicinfo_result.action")
	public @ResponseBody DataGridResultInfo queryDataGrid(Integer page,Integer rows,BasicInfoVo basicinfovo){
		DataGridResultInfo resutl=new DataGridResultInfo();
		basicinfovo=basicinfovo!=null?basicinfovo:new BasicInfoVo();
		//查询总记录数
		int count=basicinfovoservice.getCount(basicinfovo);
		//设置当前页，每页显示条数
		PageQuery pageQuery=new PageQuery();
		//设置条数
		pageQuery.setPageParams(count, rows, page);
		basicinfovo.setPageQuery(pageQuery);
		//分页查询数据
		List<BasicInfoCoustomer> userList = basicinfovoservice.findbasicinfo(basicinfovo);
		
		resutl.setRows(userList);
		resutl.setTotal(count);
		
		
		return resutl;
		
	}
	
	
	@RequestMapping("/addbasicinfo.action")
	public String addbasicinfo(Model model){//为查询框的用户类型从数据库调用数据
		return "/base/basicinfo/addbasicinfo";
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
	@RequestMapping("/addbasicinfosubmit.action")//真正的数据库插入用户
	public @ResponseBody SubmitResultInfo addbasicinfosubmit(BasicInfoVo basicinfovo) throws ExceptionResultInfo{
		basicinfovo=basicinfovo==null?new BasicInfoVo():basicinfovo;
		
		basicinfovoservice.insertBasicinfo(basicinfovo);
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
	}
	
	@RequestMapping("/editbasicinfo.action")
	public String editbasicinfo(String id,Model model){
		BasicInfoCoustomer resutl=basicinfovoservice.findBasicInfoById(id);
		model.addAttribute("basicinfocoustomer", resutl);
		return "/base/basicinfo/editbasicinfo";
	}
	
	
	@RequestMapping("/editbasicinfosubmit.action")
	public @ResponseBody SubmitResultInfo editbasicinfosubmit(BasicInfoVo basicinfovo) throws ExceptionResultInfo{
		basicinfovo=basicinfovo==null?new BasicInfoVo():basicinfovo;
		BasicInfoCoustomer basicinfocoustomer = basicinfovo.getBasicinfocoustomer();
		/**
		 * 调用service的方法
		 */
		basicinfovoservice.updatetBasicInfo(basicinfocoustomer);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
		
	}
	
	@RequestMapping("/deletebasicinfo.action")
	public @ResponseBody SubmitResultInfo deletebasicinfo(String id) throws ExceptionResultInfo{
		
		basicinfovoservice.deleteBasicInfoById(id);
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
	}
}
