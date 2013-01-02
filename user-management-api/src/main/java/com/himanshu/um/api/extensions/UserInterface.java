package com.himanshu.um.api.extensions;

import java.sql.Timestamp;

public interface UserInterface {
	String getUsername();
	String getPassword();
	Timestamp getLastModifiedDate();
	Timestamp getCreatedDate();
	boolean isStatus();
}
