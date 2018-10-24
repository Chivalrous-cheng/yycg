package yycg.base.service;

import javax.servlet.http.HttpSession;

import yycg.base.process.result.ExceptionResultInfo;

public interface LoginService {

	void login(String userid, String pwd, String validateCode, HttpSession session) throws ExceptionResultInfo;


}
