package com.bank.model;

public class Bank {
	private String Name;
	private int AccountNumber;
	private String IFSCcode;
	private float Balance;

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(String name, int accountNumber, String iFSCcode, float balance) {
		super();
		this.Name = name;
		this.AccountNumber = accountNumber;
		this.IFSCcode = iFSCcode;
		this.Balance = balance;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getIFSCcode() {
		return IFSCcode;
	}
	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}
	public float getBalance() {
		return Balance;
	}
	public void setBalance(float balance) {
		Balance = balance;
	}

}