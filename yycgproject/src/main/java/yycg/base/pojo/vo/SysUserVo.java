package yycg.base.pojo.vo;

import java.io.Serializable;

/**
 * 
 * 封装查询条件
 * @author Administrator
 *
 */
public class SysUserVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SysUserCoustomer getSysusercoustomer() {
		return sysusercoustomer;
	}

	public void setSysusercoustomer(SysUserCoustomer sysusercoustomer) {
		this.sysusercoustomer = sysusercoustomer;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

	private SysUserCoustomer sysusercoustomer;
	
	private PageQuery pageQuery;
	
	

}
