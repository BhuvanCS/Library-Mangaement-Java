

import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class LibraryManagement extends DataHandling {
	final String adminun = "admin";
	final String adminpw = "lib@ad123";
	Scanner sc = new Scanner(System.in);
	public void homepage() {
		System.out.println("\n=============Welcome to ABCS Library============= ");
		do
	    {
	        System.out.println("\nEnter:\n1.Admin Login\n2.Register New User\n3.Member Login\n0.Exit!\n");
	        char ch = sc.next().charAt(0);
	        switch(ch)
	        {
	            case '1':
	                //adminLogin();
	                break;
	            case '2':
	                //newUser();
	                break;
	            case '3':
	                //userLogin();
	                break;
	            case '0':
	                close();
	                break;
	            default: continue;
	        }
	    } while (true);
	}
	public boolean adminLogin(String un, String pw) {
		if(un.equals(adminun) && pw.equals(adminpw))
		{
			System.out.println("Admin Login Succesfull!!\nRedirecting to Admin Homepage\n");
			return true;
		}
		else {
			System.out.println("Admin Credentials do not match\n");
			System.out.println("Enter:\n0. To go back to homepage\nPress any character to try again");
//			char temp = sc.next().charAt(0);
//			switch(temp)
//			{
//			case '0': 
//				homepage();
//				break;
//			
//			}
			return false;
		}
	}
	public void admin() {
		System.out.println("=======Welcome Admin!=======\n");
		System.out.println("\nEnter:\n1.Issue a book to student\n2.Return a book for student\n3.To View Book List\n4.To Add Book to collection\n5.To remove Book from collection\n6.To Search Book\n7.To View User Details\n0.Log Out\nPress Any Key to Exit App\n");
		//Book b1 = new Book();
		User u;
		char ch = sc.next().charAt(0);
		switch(ch) {
		case '1':
			System.out.println("\n-------Book Issue Portal-------\n");
			u = acceptNgetObj();
			if(u == null)
				admin();
			//u.issueBook(); //done
			admin();
			break;
		case '2':
			System.out.println("\n-------Book Return Portal-------\n");
			u = acceptNgetObj();
			if(u == null)
				admin();
			//u.returnBook(); //done
			admin();
			break;
		case '3':
			Book.viewBookList(); //done
			admin();
			break;
		case '4':
			Book.addBook("","","");//done
			admin();
			break;
		case '5':
			Book.delBook(""); //done
			admin();
			break;
		case '6':
			ArrayList<Book> foundbooks = getDetailsofBook(); //ArrayList where each item is a Book Object whose search is matched
			printFoundBooks(foundbooks); // Split the ArrayList properly and print in format
			admin(); //done
			break;
		case '7':
			viewUsers(); //done
			admin();
			break;
		case '0':
			homepage(); //done
			break;
		default: 
			close(); //done
		}
	}
	public String[] newUser(String uname, String pw, String phno)  {
		Random r = new Random();
		String id1, id2;
		String[] cards = new String[2];
		
		id1 = "LIB00" + String.valueOf(r.nextInt(90) + 10) + String.valueOf(r.nextInt(90) + 10) + String.valueOf((char)(r.nextInt(26) + 65));
		id2 = "LIB01" + String.valueOf(r.nextInt(90) + 10) + String.valueOf(r.nextInt(90) + 10) + String.valueOf((char)(r.nextInt(26) + 65));
		cards[0] = id1;
		cards[1] = id2;
		User u = new User(uname,pw,phno,id1,"0",id2,"0",0);
		u.writeToFile();
		return cards;
	}
	public User userLogin(String un, String pw) {
		int flag = 0;
		//System.out.println(un+"}"+"\n"+pw+"}");
		try {
			File obj = new File("UserLogin.txt");
			if(obj.createNewFile());
			Scanner iobj = new Scanner(obj);
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				//System.out.println(data);
				for(int i = 0; i<data.length(); i++)
				{
					if(data.charAt(i) == '/')
					{
						//System.out.println(data.substring(0, i)+"}" + "\n" + data.substring(i+1, data.length()-1)+"}");
						if(un.equals(data.substring(0, i)) && pw.equals(data.substring(i+1, data.length()-1)))
							flag = 1;
						break;
					}
				}
				if(flag == 1)
					break;
			}
			iobj.close();
			if(flag == 0)
			{
				return null;
			}
			else
			{
				System.out.println("\n-----User Login Succesfull!!-----\n");
				System.out.println("Welcome "+ un);
				User user = getUserObject(un, pw);
				return user;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception...");
			return null;
		}
	}
	@SuppressWarnings("finally")
	ArrayList<User> viewUsers() {
		ArrayList<User> allusers = new ArrayList<>();
		try {
			File f = new File("UserDetails.txt");
			if(f.createNewFile());
			Scanner iobj = new Scanner(f);
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				String[] info = splitData(data);
				if(info[0] == null)
					continue;
				User u = new User(info[0],info[1],info[2],info[3],info[4],info[5],info[6],Integer.valueOf(info[7]));
				allusers.add(u);
			}
			iobj.close();
		}catch(Exception e) {
			System.out.println("Exception..."+e);
		}
		finally {
			return allusers;
		}
		
		
	}
	User acceptNgetObj() {
		String un, pw;
		System.out.println("Enter Student Username\n");
		sc.nextLine();
		un = sc.nextLine();
		System.out.println("Enter Student Password");
		pw = sc.nextLine();
		User u = getUserObject(un, pw);
		if(u.getuname() == null)
		{
			System.out.println("Entered Student credentials do not match with our database! Please retry!\n");
			return null;
		}
		else
		{
			return u;
		}
	}
	User getUserObject(String un, String pw)
	{
		String[] details = new String[8];
		try {
			File obj = new File("UserDetails.txt");
			if(obj.createNewFile());
			Scanner iobj = new Scanner(obj);
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				int curr = 0;
				int prev = 0;
				for(int i = 0; i<data.length(); i++)
				{
					if(data.charAt(i) == '/')
					{
						//System.out.println(data.substring(0, i)+"}" + "\n" + data.substring(i+1, data.length()-1)+"}");
						details[curr++] = data.substring(prev, i);
						prev = i+1;
						
					}
				}
				if(un.equals(details[0]) && pw.equals(details[1]))
					break;
				else
				{
					details = new String[8];
					details[7] = "0";
				}
			}
			iobj.close();
			User u = new User(details[0],details[1],details[2],details[3],details[4],details[5],details[6],(int)Integer.valueOf(details[7]));
			return u;
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Exception123...");
			return null;
		}
	}
	public void close() {
		System.out.println("\n-------See You Soon! Happy Reading!------\n");
		System.exit(0);
	}
	
}
