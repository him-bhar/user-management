package com.himanshu.um.api.rolepriv.mapping;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.himanshu.um.api.privileges.Privilege;
import com.himanshu.um.api.role.Role;

/**
 * @author himanshu
 *
 */
@XmlRootElement
public class RolePrivilegeMapping {
	private Role role;
	private List<Privilege> privileges;

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

}
