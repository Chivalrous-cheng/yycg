package yycg.base.pojo.vo;

import java.io.Serializable;

public class DictInfoVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DictInfoCoustomer dictinfocoustomer;
	
	private PageQuery pageQuery;

	public DictInfoCoustomer getDictinfocoustomer() {
		return dictinfocoustomer;
	}

	public void setDictinfocoustomer(DictInfoCoustomer dictinfocoustomer) {
		this.dictinfocoustomer = dictinfocoustomer;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}
}