

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class User extends DataHandling{
	private String uname, password;
	private String libid1, s1, libid2, s2;
	private String phno;
	private int fine;
	Scanner sc = new Scanner(System.in);
	public User() {
		
	}
	public User(String uname, String password, String phno, String libid1, String s1, String libid2, String s2, int fine)
	{
		this.uname = uname;
		this.password = password;
		this.phno = phno;
		this.libid1 = libid1;
		this.s1 = s1;
		this.libid2 = libid2;
		this.s2 = s2;
		this.fine = fine;
	}
	
	public boolean issueBook(String bid, String issueDate, String returnDate, int cardnum) {
		
		ArrayList<Book> foundbooks = Book.searchBook(bid);
		if(foundbooks.size() == 0 )
		{
			return false;
		}
		else
		{
			if(cardnum == 1)
			{
				s1 = bid;
				updateUserProfile('i',issueDate,libid1,bid);
			}
			else
			{
				s2 = bid;
				updateUserProfile('i',issueDate,libid2,bid);
			}
			updateUserDetails();
			return true;
		}
		
	}
	public void returnBook(String bid, String returnDate, int cardnum, int fine) {
		String lid;
		if(cardnum == 1)
		{
			lid = libid1;
			s1 = "0";
		}
		else
		{	
			lid = libid2;
			s2 = "0";
		}
		this.fine +=fine;
		updateUserDetails();
		updateUserProfile('r',returnDate,lid, bid);
		
	}
	public void payFine(int paidAmount) {
		
		updateUserProfile('f',getFormattedDate(), String.valueOf(paidAmount), "");
		fine -= paidAmount;
		updateUserDetails();
			
	}
	public void writeToFile() {
		try {
            // Create a FileWriter object with append=true
            FileWriter fileWriter = new FileWriter("UserDetails.txt", true);
            FileWriter fileWriter2 = new FileWriter("UserLogin.txt", true);
            // Create a BufferedWriter object to write to the file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
            // Write some data to the file
            bufferedWriter.write("\n"+uname+"/"+password+"/"+phno+"/"+libid1+"/"+s1+"/"+libid2+"/"+s2+"/"+fine+"/");
            bufferedWriter2.write("\n"+uname+"/"+password+"/");
            
            //Create a seperate file for each user
            // Create a File object
            File file = new File(uname + ".txt");

            // Create a new file
            if (file.createNewFile());
            updateUserProfile('a',getFormattedDate(),"","");
            // Close the output stream
            bufferedWriter.close();
            bufferedWriter2.close();
            
            fileWriter.close();
            fileWriter2.close();
           
            
        } catch (Exception e) {
        	System.out.println("Exception...");
            e.printStackTrace();
        }
	}
	
	public void updateUserDetails() {
		try {
			File f = new File("UserDetails.txt");
			File f1 = new File("Temp.txt");
			if(f1.createNewFile());
			Scanner iobj = new Scanner(f);
			FileWriter fw = new FileWriter("Temp.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				String[] info = splitData(data);
				if(uname.equals(info[0]) && password.equals(info[1]))
				{
					data = uname+"/"+password+"/"+phno+"/"+libid1+"/"+s1+"/"+libid2+"/"+s2+"/"+fine+"/";
					bw.write(data+"\n");
				}
				else
				{
					bw.write(data+"\n");
				}
			}
			iobj.close();
			bw.close();
			fw.close();
			if(f.delete()) {
				
			}
			else {
				System.out.println("Couldnt Delete");
			}
			File f2 = new File("UserDetails.txt");
			if(f1.renameTo(f2)) {
				
			}
			else {
				System.out.println("Couldnt rename");
			}
			
		}catch(Exception e) {
			System.out.println("ExceptionAB..."+e);
		}
	}
	public void updateUserProfile(char ch, String date, String s1, String s2) {
		try {
			FileWriter fw = new FileWriter(uname+".txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			switch(ch) {
			case 'a': 
				bw.write("a/"+date+"/"+"\n");
				break;
			case 'f':
				bw.write("f/"+s1+"/"+date+"/"+"\n");
				break;
			case 'i':
				bw.write("i/"+s1+"/"+s2+"/"+date+"/"+"\n");
				break;
			case 'r':
				bw.write("r/"+s1+"/"+s2+"/"+date+"/"+"\n");
				break;
			}
			bw.close();
			fw.close();
		}catch(Exception e) {
			System.out.println("Exception..."+e);
		}
	}
	@SuppressWarnings("finally")
	public ArrayList<ArrayList<String>> viewProfile() {
		ArrayList<ArrayList<String>> allinfo2 = new ArrayList<>();
		try {
			File f = new File(uname+".txt");
			
			Scanner iobj = new Scanner(f);
			int i = 0;
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				String[] info = splitData(data);
				ArrayList<String> curinfo = new ArrayList<>();
				if(info[0].equals("a"))
				{
					
					curinfo.add("Account Created Successfully!");
					curinfo.add(info[1]);
					allinfo2.add(curinfo);
				}
				else if(info[0].equals("f"))
				{
					
					curinfo.add("Fine Paid of Rs."+info[1]);
					curinfo.add(info[2]);
					allinfo2.add(curinfo);
				}
				else if(info[0].equals("i"))
				{
					
					curinfo.add("Book Issue - "+info[2] +" to "+info[1]);
					curinfo.add(info[3]);
					allinfo2.add(curinfo);

				}
				else
				{
					
					curinfo.add("Book Returned - "+info[2] + " from "+info[1]);
					curinfo.add(info[3]);
					allinfo2.add(curinfo);
				}
				
			}
			
			iobj.close();
		}catch(Exception e) {
			System.out.println("Exception...");
		}
		finally {
			return allinfo2;
		}
	}
	public String getuname() {
		return this.uname;
	}
	public String getpw() {
		return this.password;
	}
	public int getFine() {
		return this.fine;
	}
	public String getphno() {
		return this.phno;
	}
	public String getlib1() {
		return this.libid1;
	}
	public String getlib2() {
		return this.libid2;
	}
	public String getlibs1() {
		return this.s1;
	}
	public String getlibs2() {
		return this.s2;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	 String getFormattedDate()
	{
		LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);
        return formattedDate;
	}
	 
	
}
