package Shopping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


import Shopping.dbcon;
public class AgentLogin {
	Scanner s=new Scanner(System.in);
	dbcon con=new dbcon();

	public void agentLogin()throws ClassNotFoundException,SQLException
	{
		
		//Create statement
		Statement s1=(Statement) con.getConnection().createStatement();
		ResultSet rs=s1.executeQuery("select * from agentlogin");
		System.out.println("Enter Username:");
		String name=s.next();
		System.out.println("Enter Password");
		String pwd=s.next();
		int flag=0;
		while(rs.next())
		{
			String name1=rs.getString(1);
			String pass1=rs.getString(2);
			if(name1.equals(name) && pass1.equals(pwd))
			{
				System.out.println("Sucessfully Verified");
				flag=1;
				
			}
			else
				System.out.println("Unauthorized Login Request");
			
		}
		if(flag==1)
		{
		
		AgentLogin agl=new AgentLogin();
		agl.agentchoice();
		}
	}

	public  void agentchoice() throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
	
		System.out.println("1.BuySell \n2.View Product\n3.Logout \n ");
		System.out.println("Enter the choice:");
		int ch=s.nextInt();
		switch(ch)
		{
		case 1:
		
			System.out.println("Enter Product Id");
			int id=s.nextInt();
			System.out.println("Enter Quantity");
			int qty=s.nextInt();
			Statement sq=(Statement)con.getConnection().createStatement();
			ResultSet rq=sq.executeQuery("Select * from addproduct");
			int price=0,total=0,newqty=0;
			while(rq.next())
			{ 
				if(rq.getInt(1)==id)
				{
					if(qty<=rq.getInt(3))
					{
				price=rq.getInt(4);
				total=price*qty;
				System.out.println("Cost is "+total);
				System.out.println("Enter 1 to confirm purchase");
				int num=s.nextInt();
				if(num==1)
				{
				newqty=rq.getInt(3)-qty;
				System.out.println("Thanks for your purchase");
				PreparedStatement stt=(PreparedStatement) con.getConnection().prepareStatement("update addproduct set quantity=? where product_id=?;");
				
				stt.setInt(1,newqty);
				stt.setInt(2,id);

				stt.executeUpdate();
					}
					}
					else
						System.out.println("Out Of Stock");
				}
			}
		
		//	System.out.println("Pr");
		//	sq.executeUpdate();
			agentchoice();
			break;
		case 2:
			
			Statement s1=(Statement)con.getConnection().createStatement();
			ResultSet r=s1.executeQuery("Select * from addproduct");
			while(r.next())
			{
				System.out.println("------List of Products -------");
				System.out.println("Product Id:      "+r.getInt(1)+" \n"+"Product Name:      "+r.getString(2)+" \n"+"Quantity:      "+
				r.getString(3)+"\nPrice:      "+r.getString(4));
				System.out.println("------------------------------");
			}
			agentchoice();
			
			
		break;
		
			
		case 3:
			Shopping sp=new Shopping();
			sp.choices();
			break;
		default:
			break;	
		
				
	}
	}
}
	
	
	
	
	
	
	

