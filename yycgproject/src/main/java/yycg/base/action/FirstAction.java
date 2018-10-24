package yycg.base.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.process.context.Config;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.LoginService;

@Controller
public class FirstAction {
	
	@Autowired
	private LoginService login;
	
	@RequestMapping("/first.action")
	public String first(){
		
		return "/base/first";
	}
	
	@RequestMapping("/welcome.action")
	public String welcome(){
		
		return "/base/welcome";
	}

	@RequestMapping("/login.action")
	public String login(){
		
		return "/base/login";
	}
	
	@RequestMapping("/loginsubmit.action")
	public @ResponseBody SubmitResultInfo loginsubmit(String userid,String pwd,String validateCode,HttpSession session) throws ExceptionResultInfo{
		login.login(userid,pwd,validateCode,session);
//		ServletActionContext.getResponse().sendRedirect("first.action");
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906));
		
	}
}
