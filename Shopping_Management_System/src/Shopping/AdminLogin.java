package Shopping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import java.sql.ResultSet;
import java.sql.SQLException;





public class AdminLogin {
	Scanner s=new Scanner(System.in);
	dbcon con=new dbcon();
 public void adminlogin() throws ClassNotFoundException, SQLException
 {
	//System.out.println("skjffs");
	Statement s1=(Statement) con.getConnection().createStatement();
	ResultSet rs=s1.executeQuery("select * from adminlogin");
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
	AdminLogin al=new AdminLogin();
	al.choice();
	}
	
}

public  void choice() throws ClassNotFoundException, SQLException 
{
	// TODO Auto-generated method stub
	
	System.out.println("1.Add Product\n2.Display\n3.Remove\n4.Update Product\n5.Exit \n ");
	System.out.println("Enter the choice:");
	int ch=s.nextInt();
	switch(ch)
	{
	case 1:
	
		System.out.println("Enter Product Id");
		int id=s.nextInt();
		System.out.println("Enter Product Name");
		String product=s.next();
		System.out.println("Enter Quantity");
		int qty=s.nextInt();
		System.out.println("Enter price");
		int price=s.nextInt();
		PreparedStatement st=(PreparedStatement) con.getConnection().prepareStatement("insert into  addproduct (product_id,product_name,quantity,price)values(?,?,?,?);");
		st.setInt(1,id);
		st.setString(2, product);
		st.setInt(3, qty);
		st.setInt(4, price);
		System.out.println("Product Added Sucessfully");
		st.executeUpdate();
		break;
	case 2:
		
		Statement s1=(Statement)con.getConnection().createStatement();
		ResultSet r=s1.executeQuery("Select * from addproduct");
		while(r.next())
		{
			System.out.println("#####################################");
			System.out.println("Product Id:			"+r.getInt(1)+" \n"+"Product Name:			"+r.getString(2)+" \n"+"Quantity:			"+
			r.getString(3)+"\nPrice:			"+r.getString(4));
			System.out.println("#####################################");
		}
		
		
	break;
	case 3:
		Statement s2=(Statement)con.getConnection().createStatement();
		ResultSet r2=s2.executeQuery("Select * from addproduct");
		while(r2.next())
		{
			System.out.println("Product Id:      "+r2.getInt(1)+" \n"+"Product Name:      "+r2.getString(2));
		}
		System.out.println("Enter Id");
		int idd=s.nextInt();
		PreparedStatement st1=(PreparedStatement) con.getConnection().prepareStatement("delete  from addproduct  where product_id=?;");
		st1.setInt(1,idd);
		st1.executeUpdate();
		con.getConnection().close();
		System.out.println("Product  Deleted Successfully");
		// fp=new FirstApp();
		choice();
		break;
	case 4:
	
	    int up_id;
		String up_name;
		int u_qty=0;
		int update_id;
		Statement s3=(Statement)con.getConnection().createStatement();
		ResultSet r3=s3.executeQuery("Select * from addproduct");
		while(r3.next())
		{
			System.out.println("Product Id:			"+r3.getInt(1)+" \n"+"Product Name:			"+r3.getString(2));
		
		}
		System.out.println("Choose Option");
		System.out.println("a.Update Id\nb.Update Product Name\nc.Update Product Quantity\nd.Update Price\ne.Exit Updation");
		char op=s.next().charAt(0);
		System.out.println("Enter Id");
		update_id=s.nextInt();
		
		switch(op)
		{
		case 'a':
			Statement sup1=(Statement)con.getConnection().createStatement();
			ResultSet rup1=sup1.executeQuery("Select * from addproduct ");
			//s4.setInt(1,update_id);
			while(rup1.next())
			{
				if(rup1.getInt(1)==update_id)
				{
					System.out.println("Enter New Id");
					int newid=s.nextInt();
				//int upid1=rup1.getInt(1);
				PreparedStatement stup1=(PreparedStatement) con.getConnection().prepareStatement("update addproduct set product_id=? where product_id=?");
				stup1.setInt(1, newid);
				stup1.setInt(2, update_id);
				stup1.executeUpdate();
				}
			}
			
			break;
		
		case 'b':
			Statement sup2=(Statement)con.getConnection().createStatement();
			ResultSet rup2=sup2.executeQuery("Select * from addproduct ");
			//s4.setInt(1,update_id);
			while(rup2.next())
			{
				if(rup2.getInt(1)==update_id)
				{
					System.out.println("Enter Product name");
					String p_name=s.next();
				//int upid1=rup1.getInt(1);
				PreparedStatement stup2=(PreparedStatement) con.getConnection().prepareStatement("update addproduct set product_name=? where product_id=?");
				stup2.setString(1,p_name);
				stup2.setInt(2, update_id);
				stup2.executeUpdate();
				}
			}
			
			break;
			
		case 'c':
		
		int iddd=0;
		Statement s4=(Statement)con.getConnection().createStatement();
		ResultSet r4=s4.executeQuery("Select * from addproduct ");
		//s4.setInt(1,update_id);
		while(r4.next())
		{
			System.out.println("Product Id:			"+r4.getInt(1)+" \n"+"Product Name:			"+r4.getString(2));

			if(r4.getInt(1)==update_id)
			{
			iddd=r4.getInt(1);
			 u_qty=r4.getInt(3);
			}
		}
		System.out.println("Enter New Quantity");
		int qtyy=s.nextInt();
		int q=qtyy+u_qty;
		PreparedStatement st2=(PreparedStatement) con.getConnection().prepareStatement("update addproduct set quantity=? where product_id=?;");
		st2.setInt(1, q);
		st2.setInt(2,iddd);	
		st2.executeUpdate();
		break;
		
		case 'd':
			
			Statement sup3=(Statement)con.getConnection().createStatement();
			ResultSet rup3=sup3.executeQuery("Select * from addproduct ");
			//s4.setInt(1,update_id);
			while(rup3.next())
			{
				if(rup3.getInt(1)==update_id)
				{
					System.out.println("Enter Product Price");
					int up_price=s.nextInt();
				//int upid1=rup1.getInt(1);
				PreparedStatement stup3=(PreparedStatement) con.getConnection().prepareStatement("update addproduct set price=? where product_id=?");
				stup3.setInt(1,up_price);
				stup3.setInt(2, update_id);
				stup3.executeUpdate();
				}
			}
			
			break;
			
		case 'e':
			choice();
			break;
		
	
		//break;
			default:
				break;
				
				
		}
		System.out.println("Product  Updated Successfully");
		choice();
	break;
		
		
	case 5:
		Shopping sp=new Shopping();
		sp.choices();
		break;
	default:
		break;
		
	}
	con.getConnection().close();
	//Shopping sp=new Shopping();
	//sp.choices();
	AdminLogin ad=new AdminLogin();
	ad.choice();
	
	
}
}


