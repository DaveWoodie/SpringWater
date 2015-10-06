package com.netbuilder.entities;

public class User {
	
	private int iDnum;
	private String pWd;
	private String forName;
	private String surName;
	private String email;
	private boolean isEmp;
	
	public User(String pwd, String fore, String surn, String ema, boolean emp) {
		
		pWd = pwd;
		forName = fore;
		surName = surn;
		email = ema;
		isEmp = emp;		
	}
	
	public void setPwd(String p) {
	}
}
