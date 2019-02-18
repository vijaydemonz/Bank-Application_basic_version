package p1;

import java.sql.*;

public class DAOModel 
{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	
	private int accno;
	private String password;
	private String cname;
	private int cid;
	private int balance;
	private String email;
	
	public void setAccno(int accno) 
	{
		this.accno = accno;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public void setCname(String cname) 
	{
		this.cname = cname;
	}
	public void setCid(int cid) 
	{
		this.cid = cid;
	}
	public void setBalance(int balance) 
	{
		this.balance = balance;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public int getAccno() 
	{
		return accno;
	}
	public String getPassword() 
	{
		return password;
	}
	public String getCname() 
	{
		return cname;
	}
	public int getCid() 
	{
		return cid;
	}
	public int getBalance() 
	{
		return balance;
	}
	public String getEmail() 
	{
		return email;
	}
	
	
	public DAOModel() 
	{
		DBConnector dbc=new DBConnector();
		con=dbc.giveConnection();
	}
	
	public boolean login()
	{
		try
		{
			pstmt=con.prepareStatement("SELECT * FROM JULY_PROJECT WHERE CUSTOMER_ID=? AND PASSWORD=?");
			pstmt.setInt(1, cid);
			pstmt.setString(2, password);
			res=pstmt.executeQuery();
			
			while(res.next()==true)
			{
				accno=res.getInt("ACCOUNT_NO");
				cname=res.getString("CUSTOMER_NAME");
				return true;
			}
			
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
	}
	
	public boolean checkBalance()
	{
		try
		{
			pstmt=con.prepareStatement("SELECT BALANCE FROM JULY_PROJECT WHERE ACCOUNT_NO=?");
			pstmt.setInt(1, accno);
			res=pstmt.executeQuery();
			
			while(res.next()==true)
			{
				balance=res.getInt("BALANCE");
				return true;
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
	}
	
	public boolean fundTransfer(int amt)
	{
		try
		{
			pstmt=con.prepareStatement("UPDATE JULY_PROJECT SET BALANCE=BALANCE-? WHERE ACCOUNT_NO=?");
			pstmt.setInt(1, amt);
			pstmt.setInt(2, accno);
			int num=pstmt.executeUpdate();
			
			if(num==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
}

