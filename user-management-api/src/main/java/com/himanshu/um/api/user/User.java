
package com.himanshu.um.api.user;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author himanshu
 *
 */

@XmlRootElement
public class User {
	//private long id;
	private String username;
	private String password;
	private Date createdDate;
	private Date lastModifiedDate;
	private boolean status;

	/*public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}*/
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
