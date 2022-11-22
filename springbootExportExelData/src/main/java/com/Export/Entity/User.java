package com.Export.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String user_name;
	private String user_adress;
	private String user_email;
	private String record_1;
	private String record_2;
	private String record_3;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_adress() {
		return user_adress;
	}
	public void setUser_adress(String user_adress) {
		this.user_adress = user_adress;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getRecord_1() {
		return record_1;
	}
	public void setRecord_1(String record_1) {
		this.record_1 = record_1;
	}
	public String getRecord_2() {
		return record_2;
	}
	public void setRecord_2(String record_2) {
		this.record_2 = record_2;
	}
	public String getRecord_3() {
		return record_3;
	}
	public void setRecord_3(String record_3) {
		this.record_3 = record_3;
	}
	
	

}
