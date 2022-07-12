package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.bank.model.Bank;

public class BankDao {

	public int mycreation(Bank details) {
		String url="jdbc:mysql://localhost:3306/choclate";
		String user="root";
		String password="Anil@1434";
		String sql="INSERT INTO ak VALUES(?,?,?,?)";
		int status=0;
		try {

			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, details.getName());
			pstmt.setNull(2, Types.NULL);//details.getAccountNumber());
			pstmt.setString(3, details.getIFSCcode());
			pstmt.setFloat(4, details.getBalance());
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;

	}
	public ArrayList<Bank> balance (Bank balc){
		String url="jdbc:mysql://localhost:3306/choclate";
		String user="root";
		String password="Anil@1434";
		float f = balc.getAccountNumber();
		String sql="SELECT * FROM ak where AccountNumber = '"+f+"'";
		ArrayList<Bank> list=new ArrayList<Bank>();
		try {
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Bank bank=new Bank();
				bank.setName(rs.getString(1));
				bank.setAccountNumber(rs.getInt(2));
				bank.setIFSCcode(rs.getString(3));
				bank.setBalance(rs.getFloat(4));
				list.add(bank);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public int withdrawAmount(Bank b) {
		String url="jdbc:mysql://localhost:3306/choclate";
		String user="root";
		String password="Anil@1434";
		int status=0;
		String sql="update ak set balance=balance-'"+b.getBalance()+"'where AccountNumber= '"+b.getAccountNumber()+"'";
		try {
			Connection con=DriverManager.getConnection(url, user, password);
			Statement stmt=con.createStatement();
			status = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;

	}
	public int depositAmount(Bank d) {
		String url="jdbc:mysql://localhost:3306/choclate";
		String user="root";
		String password="Anil@1434";
		int status=0;
		String sql="update ak set balance=balance+'"+d.getBalance()+"'where AccountNumber= '"+d.getAccountNumber()+"'";
		try {
			Connection con=DriverManager.getConnection(url, user, password);
			Statement stmt=con.createStatement();
			status = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return status;

	}
	public int transaction(Bank t) {
		String url="jdbc:mysql://localhost:3306/choclate";
		String user="root";
		String password="Anil@1434";
		int status = 0;
		String sql = "UPDATE ak set balance=balance+'"+t.getBalance()+"' where accountNumber='"+t.getAccountNumber()+"'";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			status = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}

	public int transaction1(Bank t) {
		String url="jdbc:mysql://localhost:3306/choclate";
		String user="root";
		String password="Anil@1434";
		int status = 0;
		String sql = "UPDATE ak set balance=balance-'"+t.getBalance()+"' where accountNumber='"+t.getAccountNumber()+"'";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			status = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}

	public void presentAccount() {
		String url="jdbc:mysql://localhost:3306/choclate";
		String user="root";
		String password="Anil@1434";
		String sql="SELECT AccountNumber,Name,Balance FROM ak where Balance<100";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet re = st.executeQuery();
			while(re.next())
			{
				int accountNumber= re.getInt(1);
				String name = re.getString(2);
				int balance = re.getInt(3);
				Statement ps = con.createStatement();
				int rs = ps.executeUpdate("DELETE FROM ak WHERE balance="+balance+"");
				if(rs!=0)
				{
					System.out.println("Your Account Will Be deleted Because of ur Balance is less than 100 :/n");
					System.out.println("AccountNumber :  Name :  Balance : ");
					System.out.println(+accountNumber+" "+name+" "+balance+" ");
				}
				System.out.println("Done , It is Deleted the Account for you Have Doesn't Certain Amount In account ");
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}