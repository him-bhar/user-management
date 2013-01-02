package com.himanshu.um.impl.db.util;

import com.himanshu.um.api.extensions.PrivilegeInterface;
import com.himanshu.um.api.extensions.RoleInterface;
import com.himanshu.um.api.extensions.UserInterface;
import com.himanshu.um.impl.privileges.db.Privilege;
import com.himanshu.um.impl.role.db.Role;
import com.himanshu.um.impl.user.db.User;

public class ApiToDbBeanUtil {
	public UserInterface convertUserApiToDb(com.himanshu.um.api.user.User user) {
		//NOOP
		return new User();
	}

	public RoleInterface convertRoleApiToDb(com.himanshu.um.api.role.Role role) {
		//NOOP
		return new Role();
	}

	public PrivilegeInterface convertPrivilegeApiToDb(com.himanshu.um.api.privileges.Privilege privilege) {
		//NOOP
		return new Privilege();
	}
}
