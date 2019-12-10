package Shopping;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;



public class Shopping {
	Scanner s=new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		// TODO Auto-generated method stub

	
	Shopping sp=new Shopping();
	sp.choices();
	}


	public void choices() throws ClassNotFoundException,SQLException
	{
	System.out.println("Enter the Choice:");
	System.out.println("1.Admin Login\n2.Agent Login\n3.Exit");
	
	int op=s.nextInt();
	switch(op)
	{
	case 1:
		 AdminLogin admin=new AdminLogin();
		  admin.adminlogin();
		
	break;
	case 2:
		AgentLogin agent=new AgentLogin();
		agent.agentLogin();
		 
	break;
	case 3:
		System.out.println("Process Completed");
		System.exit(0);
		break;
	
	}
	}
}
