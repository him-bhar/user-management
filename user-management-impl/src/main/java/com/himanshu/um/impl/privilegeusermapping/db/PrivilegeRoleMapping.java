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

package com.himanshu.um.impl.privilegeusermapping.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.himanshu.um.impl.privileges.db.Privilege;
import com.himanshu.um.impl.role.db.Role;

@TableGenerator(name="tab", initialValue=0, allocationSize=1)
@Entity
@Table (name = "privilege_role_mapping")
public class PrivilegeRoleMapping {

	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Id
	@Column (name="id")
	private long id;

	@ManyToOne
    @JoinColumn(name="privilege_id")
	private Privilege privilege;

	@ManyToOne
    @JoinColumn(name="role_id")
	private Role role;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Privilege getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
