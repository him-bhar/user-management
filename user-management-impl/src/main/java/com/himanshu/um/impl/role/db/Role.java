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

import com.himanshu.um.impl.roleusermapping.db.RoleUserMapper;
import com.himanshu.um.impl.user.db.User;

@TableGenerator(name="tab", initialValue=0, allocationSize=1)
@Entity
@Table (name = "role")
public class Role {
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

}
