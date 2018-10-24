package yycg.base.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import yycg.base.pojo.po.SysUser;
import yycg.base.process.result.ExceptionResultInfo;

public class LoginInterceptor implements HandlerInterceptor  {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException{
		 String uri = request.getRequestURI();
		 //UTL:除了login.jsp是可以公开访问的，其他的URL都进行拦截控制
		 if (uri.indexOf("/login.action") >= 0) {
			 return true;
		 }else if(uri.indexOf("/loginsubmit.action") >= 0){
			 return true;
		 }
		 //获取session
		 HttpSession session = request.getSession();
		 SysUser sysuser = (SysUser) session.getAttribute("activeUser");
	//判断session中是否有用户数据，如果有，则返回true，继续向下执行
	if (sysuser != null) {
		return true;
	}
	//不符合条件的给出提示信息，并转发到登录页面
	request.setAttribute("msg", "您还没有登录，请先登录！");
//	ResultUtil.throwExcepion(ResultUtil.createInfo(Config.MESSAGE, 108));
	request.getRequestDispatcher("/login.action").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}



	
	
}

