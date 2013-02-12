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

package com.himanshu.um.impl.role.db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.himanshu.um.api.extensions.RoleInterface;
import com.himanshu.um.impl.privileges.db.Privilege;
import com.himanshu.um.impl.privilegeusermapping.db.PrivilegeRoleMapping;
import com.himanshu.um.impl.roleusermapping.db.RoleUserMapper;
import com.himanshu.um.impl.user.db.User;

@TableGenerator(name="tab", initialValue=0, allocationSize=1)
@Entity
@Table (name = "role")
public class Role implements RoleInterface {
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "role_name")
	private String roleName;
	@Column (name = "status")
	private boolean status;

	@OneToMany(mappedBy="role", cascade=CascadeType.ALL)
	private Set<RoleUserMapper> roleUserMapper = new HashSet<RoleUserMapper>();

	@OneToMany(mappedBy="role", cascade=CascadeType.ALL)
	private Set<PrivilegeRoleMapping> privilegeRoleMapper = new HashSet<PrivilegeRoleMapping>();


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public Set<RoleUserMapper> getRoleUserMapper() {
		return roleUserMapper;
	}
	public void setRoleUserMapper(Set<RoleUserMapper> roleUserMapper) {
		this.roleUserMapper = roleUserMapper;
	}

	public void addUserMapping (User u) {
		RoleUserMapper mapper = new RoleUserMapper();
		mapper.setUser(u);
		mapper.setRole(this);
		roleUserMapper.add(mapper);
	}

	public void addPrivilegeMapping(Privilege p) {
		PrivilegeRoleMapping mapping = new PrivilegeRoleMapping();
		mapping.setRole(this);
		mapping.setPrivilege(p);
		privilegeRoleMapper.add(mapping);
	}

}
