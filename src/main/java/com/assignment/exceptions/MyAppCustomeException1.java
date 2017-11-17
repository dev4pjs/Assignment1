package com.assignment.exceptions;

public class MyAppCustomeException1 extends Exception {

	private int customeErrorCode;
	private String customExceptionDesc;
	
	public MyAppCustomeException1(int customeErrorCode, String customExceptionDesc) {
		super();
		this.customeErrorCode = customeErrorCode;
		this.customExceptionDesc = customExceptionDesc;
	}
	public MyAppCustomeException1() {
		super();
	}
	public int getCustomeErrorCode() {
		return customeErrorCode;
	}
	public void setCustomeErrorCode(int customeErrorCode) {
		this.customeErrorCode = customeErrorCode;
	}
	public String getCustomExceptionDesc() {
		return customExceptionDesc;
	}
	public void setCustomExceptionDesc(String customExceptionDesc) {
		this.customExceptionDesc = customExceptionDesc;
	}
	
	
}
