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

package com.himanshu.um.impl.privileges.db;

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

import com.himanshu.um.api.extensions.PrivilegeInterface;
import com.himanshu.um.impl.privilegeusermapping.db.PrivilegeRoleMapping;
import com.himanshu.um.impl.role.db.Role;

@TableGenerator(name="tab", initialValue=0, allocationSize=1)
@Entity
@Table (name = "privilege")
public class Privilege implements PrivilegeInterface {
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Id
	@Column (name="id")
	private long id;

	@Column (name="privilege_name")
	private String privilegeName;

	@Column (name="status")
	private boolean status;

	@OneToMany(mappedBy="privilege", cascade=CascadeType.ALL)
	private Set<PrivilegeRoleMapping> privRoleSet = new HashSet<PrivilegeRoleMapping>();

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	public void addRoleMapping(Role r) {
		PrivilegeRoleMapping mapping = new PrivilegeRoleMapping();
		mapping.setPrivilege(this);
		mapping.setRole(r);
		privRoleSet.add(mapping);
	}

}
