package com.himanshu.um.api.userrole.mapping;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.himanshu.um.api.role.Role;
import com.himanshu.um.api.user.User;

/**
 * @author himanshu
 *
 */
@XmlRootElement
public class UserRoleMapping {
	private User user;
	private List<Role> roles;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
