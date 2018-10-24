package yycg.business.action;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.process.result.ExceptionResultInfo;
import yycg.business.pojo.vo.YpxxCustomer;
import yycg.business.service.SysYpxxService;
import yycg.business.service.YpmlService;

@RequestMapping("/ypml")
@Controller
public class YpmlAction {
	
//	@Autowired
//	private SysYpxxService sysypxxservice;
//	
//	@Autowired
//	private YpmlService ypmlservice;

	@RequestMapping("/exportYpxx.action")
	public String exportYpxx(Map<String, Object> map){
//		List<String> yplblist = sysypxxservice.findYplb();
//		List<String> jyztlist = sysypxxservice.findJyzt();
//		map.put("yplblist", yplblist);
//		map.put("jyztlist", jyztlist);
		return "/business/ypml/exportYpxx";
	}
	
	@RequestMapping("/exportYpxxSubmit.action")
	public @ResponseBody List<YpxxCustomer> exportYpxxSubmit() throws ExceptionResultInfo{
//		List<YpxxCustomer> ypxxList = ypmlservice.findYpxx();
		List<YpxxCustomer> ypxxList = null;
		return ypxxList;
	}
}
