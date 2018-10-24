package yycg.business.pojo.vo;

import java.io.Serializable;

import yycg.base.pojo.vo.PageQuery;

public class YycgdVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PageQuery pageQuery;
	
	private YycgdCoustomer yycgdcoustomer;

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

	public YycgdCoustomer getYycgdcoustomer() {
		return yycgdcoustomer;
	}

	public void setYycgdcoustomer(YycgdCoustomer yycgdcoustomer) {
		this.yycgdcoustomer = yycgdcoustomer;
	}


}
