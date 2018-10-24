package yycg.base.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.po.DictInfo;
import yycg.base.pojo.vo.DictInfoCoustomer;
import yycg.base.pojo.vo.DictInfoVo;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.pojo.vo.SysUserCoustomer;
import yycg.base.process.context.Config;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.DictinfoService;

@RequestMapping("/dictinfo")
@Controller
public class DictinfoAction {
	
	@Autowired
	private DictinfoService dictinfoservice;
	
	@RequestMapping("/querydictinfo.action")
	public String querydictinfo(Map<String,Object> map){
		return "/base/dictinfo/querydictinfo";
	}
	
	/**
	 * 
	 * 查询分页
	 *   返回值：DataGrid.
	 *   
	 *
	 */
	@RequestMapping("/querydictinfo_result.action")
	public @ResponseBody DataGridResultInfo queryDataGrid(Integer page,Integer rows,DictInfoVo dictinfovo){
		DataGridResultInfo resutl=new DataGridResultInfo();
		dictinfovo=dictinfovo==null?new DictInfoVo():dictinfovo;
		//查询总记录数
		int count=dictinfoservice.getCount(dictinfovo);
		//设置当前页，每页显示条数
		PageQuery pageQuery=new PageQuery();
		//设置条数
		pageQuery.setPageParams(count, rows, page);
		dictinfovo.setPageQuery(pageQuery);
		//分页查询数据
		List<DictInfoCoustomer> userList = dictinfoservice.finddictinfor(dictinfovo);
		
		resutl.setRows(userList);
		resutl.setTotal(count);
		return resutl;
		
	}
	
	
	@RequestMapping("/adddictinfo.action")
	public String adddictinfo(Model model){//为查询框的用户类型从数据库调用数据
		return "/base/dictinfo/adddictinfo";
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
	@RequestMapping("/adddictinfosubmit.action")//真正的数据库插入用户
	public @ResponseBody SubmitResultInfo adddictinfosubmit(DictInfoVo dictinfovo) throws ExceptionResultInfo{
		dictinfovo=dictinfovo==null?new DictInfoVo():dictinfovo;
		/**
		 * 调用service的方法
		 */
		dictinfoservice.insertdictInfo(dictinfovo);
			
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
	}
	
	@RequestMapping(value = "/querytypename.action",produces={"text/html;charset=UTF-8;","application/json;"})
	public @ResponseBody String querytypename (String typecode){
		List<String> list = dictinfoservice.findtypename(typecode);
		if(list.size() == 0){
			return null;
		}else{
			String typename = list.get(0);
			return typename;
		}
	}
	
	@RequestMapping("/editdictinfo.action")
	public String editdictinfo(String id,Model model){
		DictInfoCoustomer resutl=dictinfoservice.finddictInfoById(id);
		model.addAttribute("dictinfocoustomer", resutl);
		return "/base/dictinfo/editdictinfo";
	}
	
	
	@RequestMapping("/editdictinfosubmit.action")
	public @ResponseBody SubmitResultInfo editdictinfosubmit(DictInfoVo dictinfovo) throws ExceptionResultInfo{
		dictinfovo=dictinfovo==null?new DictInfoVo():dictinfovo;
		DictInfoCoustomer dictinfocoustomer = dictinfovo.getDictinfocoustomer();
		/**
		 * 调用service的方法
		 */
		dictinfoservice.updatetdictInfo(dictinfocoustomer);
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
		
	}
	
	@RequestMapping("/deletedictinfo.action")
	public @ResponseBody SubmitResultInfo deletedictinfo(String id) throws ExceptionResultInfo{
		dictinfoservice.deletedictInfoById(id);
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
	}

}
