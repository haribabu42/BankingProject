package com.Bank.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.bank.dao.BankDao;
import com.bank.model.Bank;

public class BankServiceTest {
	@Test
	public void testDepositAmount() {
		BankDao bd = new BankDao();
		Bank b = new Bank();
		b.setName("Anil");
		b.setAccountNumber((int) 1);
		b.setIFSCcode("123an456");
		b.setBalance((float) 4000);
		int status = bd.depositAmount(b);
		assertEquals(1, status);
	}

	@Test
	public void testWithdrawAmount() {

		BankDao bd1 = new BankDao();
		Bank b1 = new Bank();
		b1.setName("Shiva");
		b1.setAccountNumber((int) 2);
		b1.setIFSCcode("158sh452");
		b1.setBalance((float) 2500);
		int status = bd1.withdrawAmount(b1);
		assertEquals(1, status);

	}

}