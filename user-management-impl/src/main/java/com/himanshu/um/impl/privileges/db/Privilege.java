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
