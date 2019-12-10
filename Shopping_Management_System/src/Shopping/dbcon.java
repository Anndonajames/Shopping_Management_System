package Shopping;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
public class dbcon {

		// TODO Auto-generated method stub
		
		
		public Connection getConnection()
				throws ClassNotFoundException, SQLException 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","");
					if(con!=null)
					{
						//System.out.println("jdfsjfs");
						return con;
					}
					else
						//System.out.println("jdfsjfs");
						return null;
		}
		}
		
