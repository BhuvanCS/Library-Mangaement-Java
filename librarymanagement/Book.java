

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Book extends DataHandling{
	private String bookname, author, id;
	public Book() {
		this.bookname = this.author = this.id = "";
	}
	public Book(String bookname, String author, String id)
	{
		this.bookname = bookname;
		this.author = author;
		this.id = id;
	}
	String getBookName() {
		return this.bookname;
	}
	String getAuthor() {
		return this.author;
	}
	String getId() {
		return this.id;
	}
	public Book getBookDetails() {
		return null;
	}
	
	public static void viewBookList() { //Same like searchbooks() but all book objects are added to ArrayList instead of searching for a key and adding
		ArrayList<Book> foundbooks = new ArrayList<>();
		DataHandling dh = new DataHandling();
		try {
			File f = new File("BookList.txt");
			if(f.createNewFile());
			Scanner iobj = new Scanner(f);
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				String[] info = dh.splitData(data);
				Book b = new Book(info[1],info[2],info[0]);
				foundbooks.add(b);
			}
			iobj.close();
			dh.printFoundBooks(foundbooks);
		}catch(Exception e) {
			System.out.println("Exception..."+e);
		}
	}
	public static ArrayList<Book> searchBook(String key) {
		key = key.toUpperCase();
		ArrayList<Book> foundbooks = new ArrayList<>();
		DataHandling dh = new DataHandling();
		try {
			File f = new File("BookList.txt");
			if(f.createNewFile());
			Scanner iobj = new Scanner(f);
			while(iobj.hasNextLine())
			{
				String data = iobj.nextLine();
				String[] info = dh.splitData(data);
				if(info[0].toUpperCase().contains(key) || info[1].toUpperCase().contains(key) || info[2].toUpperCase().contains(key))
				{
					Book b = new Book(info[1],info[2],info[0]);
					foundbooks.add(b);
				}
			}
			iobj.close();
			return foundbooks;
		}catch(Exception e) {
			System.out.println("Exception..."+e);
			return foundbooks;
		}
		
		
	}
	public static void addBook(String bid, String bname, String aname) {
		Book b = new Book(bname, aname, bid);
		b.updateBookList(1);
	}
	public static boolean delBook(String bid) {
		ArrayList<Book> foundbooks = searchBook(bid.toUpperCase());
		//Take only first object because each book has a unique BID
		if(foundbooks.size() == 0)
			return false;
		foundbooks.get(0).updateBookList(2);
		return true;
	}
	public void updateBookList(int flag) {
		//flag details: 1-Add book 2-Delete Book
		if(flag == 1)
		{
			try {
            // Create a FileWriter object with append=true
            FileWriter fileWriter = new FileWriter("BookList.txt", true);
            // Create a BufferedWriter object to write to the file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // Write some data to the file
            bufferedWriter.write("\n"+id+"/"+bookname+"/"+author+"/");
            bufferedWriter.close();
            fileWriter.close();
         
        } catch (Exception e) {
        	System.out.println("Exception...");
            e.printStackTrace();
        }
		}
		else if(flag == 2)
		{
			try {
				File f = new File("BookList.txt");
				File f1 = new File("Temp.txt");
				if(f1.createNewFile());
				Scanner iobj = new Scanner(f);
				FileWriter fw = new FileWriter("Temp.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				while(iobj.hasNextLine())
				{
					String data = iobj.nextLine();
					String[] info = splitData(data);
					if(this.id.equals(info[0]))
					{
						//skip that book
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
					System.out.println("Couldnt Delete! File Error");
				}
				File f2 = new File("BookList.txt");
				if(!(f1.renameTo(f2))) {
					System.out.println("Couldnt rename");
				}
				
			}catch(Exception e) {
				System.out.println("ExceptionAB..."+e);
			}
		}
		
	}
}
