package yycg.base.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.dao.LoginMapper;
import yycg.base.pojo.po.SysUser;
import yycg.base.process.context.Config;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.service.LoginService;
import yycg.util.MD5;

public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper loginmapper;

	@Override
	public void login(String userid, String pwd, String validateCode, HttpSession session) throws ExceptionResultInfo{
			/**
			 * 判断用户名是否为空
			 * 判断密码是否为空
			 * 判断验证码是否为空
			 * 判断验证码是否一致
			 * 判断用户是否与数据库匹配
			 */
			
			if(userid!=null && !"".equals(userid) ){
				if(!"".equals(pwd) && pwd!=null){
					if(validateCode!=null && !"".equals(validateCode)){
						//验证码
						String validate = session.getAttribute("validateCode").toString();
						if(validateCode.equals(validate)){
							pwd = new MD5().getMD5ofStr(pwd);
							SysUser activeUser = loginmapper.login(userid,pwd);
							if(activeUser!=null){
								session.setAttribute("activeUser", activeUser);
							}else{
								ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 114));//用户名或密码错误
							}
						}else{
							ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 113));//验证码错误
						}
					}else{
						ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 112));//请输入验证码
					}
					
				}else{
					ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 111));//密码为空
				}
			}else{
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 110));//用户账号为空
			}
	}
	
	

}
