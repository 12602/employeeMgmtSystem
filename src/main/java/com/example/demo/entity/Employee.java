package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity(name="emp")
@Table(name="emp")
public class Employee {
	@Override
	public String toString() {
		return "AddEmp [id=" + id + ", name=" + name  + ", address=" + address + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Id
	@GeneratedValue(generator ="emp_seq")
	@SequenceGenerator(name="id",sequenceName ="emp_seq",initialValue=1,allocationSize=1)
	private int id;
	private String name;

	private String address;
	private String email;
	private String phone;
}
