package com.bean;

public class Bank {

	private int id;
	private int acc_no;
	private String name;
	private String address;
	private int ifsc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
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

	public int getIfsc() {
		return ifsc;
	}

	public void setIfsc(int ifsc) {
		this.ifsc = ifsc;
	}

	public Bank(int id, int acc_no, String name, String address, int ifsc) {
		super();
		this.id = id;
		this.acc_no = acc_no;
		this.name = name;
		this.address = address;
		this.ifsc = ifsc;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

}
