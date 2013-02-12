/*
 * Copyright 2013 Himanshu Bhardwaj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/

package com.himanshu.um.impl.db.util;

import com.himanshu.um.api.extensions.PrivilegeInterface;
import com.himanshu.um.api.extensions.RoleInterface;
import com.himanshu.um.api.extensions.UserInterface;
import com.himanshu.um.impl.privileges.db.Privilege;
import com.himanshu.um.impl.role.db.Role;
import com.himanshu.um.impl.user.db.User;

public class ApiToDbBeanUtil {
	public UserInterface convertUserApiToDb(com.himanshu.um.api.model.User user) {
		//Not yet implemented.
		return new User();
	}

	public RoleInterface convertRoleApiToDb(com.himanshu.um.api.model.Role role) {
		//Not yet implemented.
		return new Role();
	}

	public PrivilegeInterface convertPrivilegeApiToDb(com.himanshu.um.api.model.Privilege privilege) {
		//Not yet implemented.
		return new Privilege();
	}
}
