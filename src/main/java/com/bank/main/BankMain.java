package com.bank.main;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.dao.BankDao;
import com.bank.model.Bank;
import com.bank.service.BankService;

public class BankMain {
	private static final Logger log=LogManager.getLogger(BankMain.class);
	private Object balance;
	public void login() {

		Scanner s=new Scanner(System.in);
		System.out.println(" = > Enter a Name : ");
		String CustomerName=s.nextLine();
		//System.out.println(" => Enter The AccountNumber : ");
		//int AccountNumber=s.nextInt();
		System.out.println(" => Enter The IFSC code : ");
		String ifsccode=s.next();
		System.out.println(" => Enter a Balance : ");
		float balance=s.nextFloat();
		
		Bank b = new Bank();
		b.setName(CustomerName);
		//b.setAccountNumber(AccountNumber);
		b.setIFSCcode(ifsccode);
		b.setBalance(balance);
		BankService bs = new BankService();
		int result = bs.myAccount(b);
		if(result!=0)
		{
			System.out.println("Successfully Create an Account ");

			System.out.println("   ^ _ ^   ");
		}
		else
		{
			System.out.println("Failed To Create an Account ");

			System.out.println("   @ _ @   ");
		}
		s.close();
	}

	public void checkBalance()
	{
		log.info("Checking acount balance");
		
		Scanner s = new Scanner(System.in);

		System.out.println("----------------------------");
		System.out.println("Enter The AccountNumber : ");
		System.out.println("----------------------------");
		
		int AccountNumber = s.nextInt();
		Bank b2 = new Bank();
		b2.setAccountNumber(AccountNumber);
		BankService bs1 = new BankService();
		ArrayList<Bank> alist = bs1.balanceCheck(b2);
		
		//System.out.println("CustomerName AccountNumber Balance");
		//System.out.println("**********************************");
		//alist.forEach((n)->System.out.println(n.toString()));
		
		for(Bank n:alist)
		{
			//System.out.println(n.getBalance()+" "+n.getName()+" "+n.getIFSCcode());
			System.out.println("Name :  AccountNumber :  Balance : ");
			System.out.println(n.getName()+" "+n.getAccountNumber()+" "+n.getBalance());
			
		}
		s.close();
	}

	public void withdraw()
	{
		Scanner s = new Scanner(System.in);

		System.out.println("----------------------------");
		System.out.println("Enter The AccountNumber : ");
		System.out.println("----------------------------");
		
		int AccountNumber=s.nextInt();
		
		System.out.println("----------------------------");
		System.out.println("Enter withdraw Money : ");
		System.out.println("----------------------------");
		
		int amount = s.nextInt();
		Bank b3 = new Bank();
		b3.setBalance(amount);
		b3.setAccountNumber(AccountNumber);
		BankService bs3 = new BankService();
		int result1 = bs3.withdraw(b3);
		if(result1 !=0 )
		{
			System.out.println("Withdraw Successfull");

			System.out.println("   ^ _ ^   ");
		}
		else
		{
			System.out.println("withdraw failed ");

			System.out.println("   @ _ @   ");
		}
		s.close();
	}

	public void deposit()
	{
		Scanner s = new Scanner(System.in);

		System.out.println("----------------------------");
		System.out.println("Enter the AccountNumber : ");
		System.out.println("----------------------------");
		
		int AccountNumber = s.nextInt();//2
		
		System.out.println("----------------------------");
		System.out.println("Enter Deposit Money : ");
		System.out.println("----------------------------");
		
		int amount1 = s.nextInt();
		Bank b4 = new Bank();
		b4.setBalance(amount1);
		b4.setAccountNumber(AccountNumber);//2
		BankService bs4 = new BankService();
		int result2 = bs4.deposit(b4);
		if(result2 !=0 )
		{
			System.out.println("Money Deposited successfully ");

			System.out.println("  ^ _ ^  ");
		}
		else
		{
			System.out.println("Failed to depositing Money");

			System.out.println(" .. @ _ @ .. ");
		}
		s.close();

	}
	public void present()
	{
		BankDao d = new BankDao();
		d.presentAccount();
	}
	public void viewDetails()
	{
		checkBalance();
	}
	public static void main(String[] args)
	{
		BankMain bm = new BankMain();
		Scanner s = new Scanner(System.in);    

		System.out.println("<~~~~~~~~~~~~~~~~~~~~~~~~~>\n");
		System.out.println(" *** HELLO! WELCOME *** \n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(" --- Login Account --- ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("1.Customer Account Login ");                                            
		System.out.println("2.Employee Account Login ");
		
		System.out.println("********************");
		System.out.println("Select the option : ");
		System.out.println("********************");
		int option = s.nextInt();
		switch(option)
		{
		case 1:
			System.out.println("....................");
			System.out.println("Select The option : ");
			System.out.println("....................");
			
			System.out.println("1.Create new Account\n  ");
			System.out.println("2.Check Balance \n  ");
			System.out.println("3.WithDraw \n  ");
			System.out.println("4.Deposit \n  ");
			System.out.println("5.transaction  ");
			
			System.out.println("....................");
			System.out.println("Select The option : ");
			System.out.println("....................");
			
			int Option = s.nextInt();
			switch(Option)
			{
			case 1:
				bm.login();
				break;
			case 2:
				bm.checkBalance();
				break;
			case 3:
				bm.withdraw();
				break;
			case 4:
				bm.deposit();
			case 5:
				bm.transaction();
				break;
			default:
				System.out.println("Select the Correct option");
				break;
			}
			break;
		case 2 :
			int id = 1434 ;
			String passwrd = "Anil@1434";
			System.out.println("------------------");
			System.out.println("Enter ID number:");
			System.out.println("------------------");
			int employeeId = s.nextInt();
			System.out.println("--------------------");
			System.out.println("Enter the password:");
			System.out.println("---------------------");
			s.nextLine();
			String paswrd = s.nextLine();
			if(id == employeeId && passwrd.equals(paswrd))
			{
				System.out.println("--------------------");
				System.out.println(" select the option :");
				System.out.println("--------------------");
				
				System.out.println("............................");
				System.out.println("1.present customer accounts : ");
				System.out.println("............................");
				
				System.out.println("\n");
				
				System.out.println("***************************");
				System.out.println("2.Customer bank Deatails : ");
				System.out.println("***************************");
				int opt = s.nextInt();
				switch(opt)
				{
				case 1:
					bm.present();
					break;
				case 2:
					bm.viewDetails();
					break;
				}
			}
			else
			{
				System.out.println("Give the correct options");
			}
			break;
		default:
			System.out.println("select the Correct option");
			break;
		}
		s.close();
	}
	private void transaction() {
		Scanner s = new Scanner(System.in);

		System.out.println("****************************");
		System.out.println("Enter the FROM AccountNumber:");
		System.out.println("*****************************");
		
		int AccountNumber=s.nextInt();
		
		System.out.println("************************");
		System.out.println("Enter the To AccountNumber:");
		System.out.println("************************");
		
		int AccountNumber1=s.nextInt();
		
		System.out.println("*****************************");
		System.out.println("Enter transaction Money:");
		System.out.println("*****************************");
		int amount3 = s.nextInt();
		Bank b4 = new Bank();
		b4.setBalance(amount3);
		b4.setAccountNumber(AccountNumber);
		b4.setAccountNumber(AccountNumber1);
		AccountNumber1=AccountNumber;
		BankService bs4 = new BankService();
		int result2 = bs4.transaction(b4);
		if(result2!=0)
		{
			System.out.println("Successfully Transaction the Money");

			System.out.println("   ^ _ ^   ");
		}
		else
		{
			System.out.println("Transaction is Failed");

			System.out.println("   @ _ @   ");
		}
		s.close();
	}
}