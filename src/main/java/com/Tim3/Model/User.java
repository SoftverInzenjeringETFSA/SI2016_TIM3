package com.Tim3.Model;

public class User {
	
	int uid;
	String name;
	String lastName;
	String eMail;
	String password;
	boolean reported;
	boolean removed;
	boolean role;
	
	public User(String name, String lastName, String eMail, String password, boolean reported, boolean removed,
			boolean role) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
		this.reported = reported;
		this.removed = removed;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isReported() {
		return reported;
	}

	public void setReported(boolean reported) {
		this.reported = reported;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}
	
	
}
