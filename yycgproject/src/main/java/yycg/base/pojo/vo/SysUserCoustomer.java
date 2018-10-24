package yycg.base.pojo.vo;
import yycg.base.pojo.po.SysUser;
/**
 * 
 * 接收返回值
 *
 */
public class SysUserCoustomer extends SysUser{
	
	private String mc;//名称
	
	private String grouptype;//用户类型

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getGrouptype() {
		return grouptype;
	}

	public void setGrouptype(String grouptype) {
		this.grouptype = grouptype;
	}

}
