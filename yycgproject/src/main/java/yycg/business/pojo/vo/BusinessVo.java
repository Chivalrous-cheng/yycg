package yycg.business.pojo.vo;

import java.io.Serializable;

import yycg.base.pojo.vo.PageQuery;
import yycg.business.pojo.po.Ypxx;

public class BusinessVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PageQuery pageQuery;
	
	private BusinessCoustomer businesscoustomer;
	
	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

	public BusinessCoustomer getBusinesscoustomer() {
		return businesscoustomer;
	}

	public void setBusinesscoustomer(BusinessCoustomer businesscoustomer) {
		this.businesscoustomer = businesscoustomer;
	}

	
}
