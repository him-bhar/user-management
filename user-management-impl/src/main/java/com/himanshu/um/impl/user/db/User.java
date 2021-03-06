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

package com.himanshu.um.impl.user.db;

import java.sql.Timestamp;
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

import com.himanshu.um.api.extensions.UserInterface;
import com.himanshu.um.impl.role.db.Role;
import com.himanshu.um.impl.roleusermapping.db.RoleUserMapper;

/**
 * @author himanshu
 *
 */
@TableGenerator(name="tab", initialValue=0, allocationSize=1)
@Entity
@Table (name = "user")
public class User implements UserInterface {
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Id
	@Column (name="id")
	private long id;

	@Column (name = "username")
	private String username;
	@Column (name = "password")
	private String password;
	@Column (name = "created_date")
	private Timestamp createdDate;
	@Column (name = "last_modified_date")
	private Timestamp lastModifiedDate;
	@Column (name = "status")
	private boolean status;


	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private Set<RoleUserMapper> roleUserMapping = new HashSet<RoleUserMapper>();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public Set<RoleUserMapper> getRoleUserMapping() {
		return roleUserMapping;
	}


	public void setRoleUserMapping(Set<RoleUserMapper> roleUserMapping) {
		this.roleUserMapping = roleUserMapping;
	}

	public void addRoleMapping (Role r) {
		RoleUserMapper mapper = new RoleUserMapper();
		mapper.setUser(this);
		mapper.setRole(r);
		roleUserMapping.add(mapper);
	}
}