package yycg.base.pojo.vo;

import java.io.Serializable;

public class BasicInfoVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BasicInfoCoustomer basicinfocoustomer;
	
	private PageQuery pageQuery;

	public BasicInfoCoustomer getBasicinfocoustomer() {
		return basicinfocoustomer;
	}

	public void setBasicinfocoustomer(BasicInfoCoustomer basicinfocoustomer) {
		this.basicinfocoustomer = basicinfocoustomer;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}
	
	
}
