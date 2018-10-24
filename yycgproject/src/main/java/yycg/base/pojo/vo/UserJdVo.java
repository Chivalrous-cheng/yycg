package yycg.base.pojo.vo;

import java.io.Serializable;

public class UserJdVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserJdCoustomer userjdcoustomer;
	
	private PageQuery pageQuery;
	
	public UserJdCoustomer getUserjdcoustomer() {
		return userjdcoustomer;
	}

	public void setUserjdcoustomer(UserJdCoustomer userjdcoustomer) {
		this.userjdcoustomer = userjdcoustomer;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}
}
