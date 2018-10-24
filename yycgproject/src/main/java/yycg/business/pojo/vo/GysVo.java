package yycg.business.pojo.vo;

import java.io.Serializable;

import yycg.base.pojo.vo.PageQuery;

public class GysVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GysCoustomer gyscoustomer;
	
	private PageQuery pageQuery;

	public GysCoustomer getGyscoustomer() {
		return gyscoustomer;
	}

	public void setGyscoustomer(GysCoustomer gyscoustomer) {
		this.gyscoustomer = gyscoustomer;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}
	
	
}
