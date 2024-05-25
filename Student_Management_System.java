package Java_pop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Student_Management_System {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		String s = "Welcome to the STUDENT MANAGEMENT SYSTEM";
		String s1 = "+++ MENU +++";
		String s2 = "1. Insertion";
		String s3 = "2. Read";
		String s4 = "3. Updation";
		String s5 = "4. Deletation";
		String s6 = "5. End";
		String s7 = "+++ MENU +++";
		String s8 = "Enter Your Choice";

		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i));
			Thread.sleep(200);
		}
		System.out.println();
		for (int i = 0; i < s1.length(); i++) {
			System.out.print(s1.charAt(i));
			Thread.sleep(200);
		}
		System.out.println();

		for (int i = 0; i < s2.length(); i++) {
			System.out.print(s2.charAt(i));
			Thread.sleep(200);
		}
		System.out.println();

		for (int i = 0; i < s3.length(); i++) {
			System.out.print(s3.charAt(i));
			Thread.sleep(200);
		}
		System.out.println();
		for (int i = 0; i < s4.length(); i++) {
			System.out.print(s4.charAt(i));
			Thread.sleep(200);
		}
		System.out.println(1);
		for (int i = 0; i < s5.length(); i++) {
			System.out.print(s5.charAt(i));
			Thread.sleep(200);
		}
		System.out.println();
		for (int i = 0; i < s6.length(); i++) {
			System.out.print(s6.charAt(i));
			Thread.sleep(200);
		}
		System.out.println();

		for (int i = 0; i < s7.length(); i++) {
			System.out.print(s7.charAt(i));
			Thread.sleep(200);
		}
		System.out.println();
		int choice;
		do {
			System.out.println("Enter your Choice");
			
		 choice = sc.nextInt();
		System.out.println();

		switch (choice) {
		case 1:
			Insertion();
			break;
		case 2:
			Read();
			break;
		case 3:
			Updation();
			Read();
			break;
		case 4:
			Deletion();
			Read();
			break;
		case 5:
			System.out.println("Thank You");
			System.exit(1);
			break;
			
		}
		}while(choice!=5);
	
	}

	public static void Insertion()
	{
		Scanner sc= new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock","root","root");
			String sql="insert into STUDENT(id,name,city,email) value (?,?,?,?)";
			System.out.println("Enter your id");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your name");
			String name=sc.nextLine();
			
			System.out.println("Enter your city");
			String city=sc.nextLine();
			
			System.out.println("Enter your email id");
			String email=sc.nextLine();
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, city);
			ps.setString(4, email);
			int status=ps.executeUpdate();

			if(status==1)
			{
				System.out.println("Insertion Succesfull");
			}
			else
			{
				System.out.println("Insertion Denied ");
			}
			
			
			sc.close();
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Read()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stock","root","root");
			String sql="select * from STUDENT";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println();
				System.out.println("Student's id "+rs.getInt("id"));
				System.out.println("Student's name is "+rs.getString("name"));
				System.out.println("Student's city is "+rs.getString("city"));
				System.out.println("Student's email id is "+rs.getString("email"));
				System.out.println();
				System.out.println("++++++++++++++++++++++++++++++++++++");
			
				
			}
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void Updation()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stock","root","root");
			String sql="update STUDENT set name=?,city=? where id=?";
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your new name ");
			String name=sc.nextLine();
			System.out.println("Enter your new city");
			String city=sc.nextLine();
			System.out.println("Enter your id");
			int id=sc.nextInt();
			
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, city);
			ps.setInt(3, id);
			
			int status = ps.executeUpdate();
			if (status == 1) {
				System.out.println("Updated");
			}
			else
			{
				System.out.println("Not Updated");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Deletion()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stock","root","root");
			String sql="delete from STUDENT where id=?";
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your id which you want to delete");
			int id=sc.nextInt();
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			int status=ps.executeUpdate();
			if (status == 1) {
						System.out.println("Deleted");
			}
			else
				System.out.println("Not Deleted");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
