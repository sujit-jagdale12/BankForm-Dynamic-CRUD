package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Bank;

public class BankDao {

	public static int insert(Bank b) {
		int a=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","root");
			PreparedStatement statement=con.prepareStatement("insert into account(acc_no,name,address,ifsc)value(?,?,?,?);");
			statement.setInt(1, b.getAcc_no());
			statement.setString(2, b.getName());
			statement.setString(3, b.getAddress());
			statement.setInt(4, b.getIfsc());
			
			a=statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	public static List<Bank> getAccounts(){
		List<Bank> account=new ArrayList<Bank>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","root");
			PreparedStatement statement=con.prepareStatement("select *from account;");
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Bank b=new Bank();
				b.setId(rs.getInt(1));
				b.setAcc_no(rs.getInt(2));
				b.setName(rs.getString(3));
				b.setAddress(rs.getString(4));
				b.setIfsc(rs.getInt(5));
				
				account.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	public static boolean delete(int id) {
		boolean ans=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","root");
			PreparedStatement statement=con.prepareStatement("delete from account where id=?;");
			statement.setInt(1, id);
			
			ans=statement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}
	public static Bank getAccountId(int id) {
		Bank bank=new Bank();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","root");
			PreparedStatement statement=con.prepareStatement("select *from account where id=?;");
			statement.setInt(1, id);
			
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				bank.setId(rs.getInt(1));
				bank.setAcc_no(rs.getInt(2));
				bank.setName(rs.getString(3));
				bank.setAddress(rs.getString(4));
				bank.setIfsc(rs.getInt(5));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bank;
	}
	public static int updateAccount(Bank b) {
		int a=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","root");
			PreparedStatement statement=con.prepareStatement("update account set acc_no=?,name=?,address=?,ifsc=? where id=?;");
			statement.setInt(1, b.getAcc_no());
			statement.setString(2, b.getName());
			statement.setString(3, b.getAddress());
			statement.setInt(4, b.getIfsc());
			statement.setInt(5, b.getId());
			
			a=statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}
