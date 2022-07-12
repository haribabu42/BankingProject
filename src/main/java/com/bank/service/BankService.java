package com.bank.service;

import java.util.ArrayList;

import com.bank.dao.BankDao;
import com.bank.model.Bank;

public class BankService {

	public int myAccount(Bank bank) {

		BankDao bd = new BankDao();
		int result = bd.mycreation(bank);
		return result;

	}

	public ArrayList<Bank> balanceCheck(Bank bank){
		BankDao bd1 = new BankDao();
		ArrayList<Bank> n1 =bd1.balance(bank);
		return n1;
	}
	public int withdraw(Bank bank) {
		BankDao bd2 = new BankDao();
		int result1 = bd2.withdrawAmount(bank);
		return result1;

	}
	public int deposit(Bank bank) {
		BankDao bd3 = new BankDao();
		int result2 = bd3.depositAmount(bank);
		return result2;

	}
	public int transaction(Bank bank) {
		BankDao bd4 = new BankDao();
		int result3 = bd4.transaction(bank);
		return result3;

	}


}