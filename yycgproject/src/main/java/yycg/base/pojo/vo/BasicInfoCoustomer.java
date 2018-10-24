package yycg.base.pojo.vo;

import yycg.base.pojo.po.BasicInfo;

public class BasicInfoCoustomer extends BasicInfo{

	private String isalive;


	public String getIsalive() {
		return isalive;
	}

	public void setIsalive(String isalive) {
		
		//isalive取值为"0","1"时为从数据库取返回给页面. isalive取值为"是","否"时为从 页面 取更新回 数据库
		if("1".equals(isalive)){
			this.isalive = "是";
		}else if("0".equals(isalive)){
			this.isalive = "否";
		}else if("是".equals(isalive)){
			this.isalive = "1";
		}else if("否".equals(isalive)){
			this.isalive = "0";
		}
	}
	
}
