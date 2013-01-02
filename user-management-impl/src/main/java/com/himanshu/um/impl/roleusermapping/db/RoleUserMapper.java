package com.himanshu.um.impl.roleusermapping.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.himanshu.um.impl.role.db.Role;
import com.himanshu.um.impl.user.db.User;

@TableGenerator(name="tab", initialValue=0, allocationSize=1)
@Entity
@Table (name = "role_user_mapping")
public class RoleUserMapper {
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Id
	private long id;


    @ManyToOne
    @JoinColumn(name="user_id")
	private User user;

    @ManyToOne
    @JoinColumn(name="role_id")
	private Role role;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
