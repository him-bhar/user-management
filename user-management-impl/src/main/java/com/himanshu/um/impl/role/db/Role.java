package com.himanshu.um.impl.role.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@TableGenerator(name="tab", initialValue=0, allocationSize=1)
@Entity
@Table (name = "role")
public class Role {
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Id
	private long id;
	private String roleName;
	private boolean status;
	
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

}
