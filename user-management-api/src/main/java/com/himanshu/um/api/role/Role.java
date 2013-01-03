package com.himanshu.um.api.role;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author himanshu
 *
 */
@XmlRootElement
public class Role {
	//private long id;
	private String roleName;
	private boolean status;

	/*public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}*/
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
