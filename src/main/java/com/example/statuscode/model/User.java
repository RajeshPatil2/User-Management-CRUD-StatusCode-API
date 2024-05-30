package com.example.statuscode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	private int uid;
	private String uname;
	private float ufee;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public float getUfee() {
		return ufee;
	}

	public void setUfee(float ufee) {
		this.ufee = ufee;
	}

}