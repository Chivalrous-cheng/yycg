package yycg.base.pojo.vo;

import java.io.Serializable;

import yycg.base.pojo.po.UserGys;



public class UserGysVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PageQuery pageQuery;
	
	private UserGysCoustomer usergyscoustomer;

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

	public UserGysCoustomer getUsergyscoustomer() {
		return usergyscoustomer;
	}

	public void setUsergyscoustomer(UserGysCoustomer usergyscoustomer) {
		this.usergyscoustomer = usergyscoustomer;
	}

	
	
	
	
}
