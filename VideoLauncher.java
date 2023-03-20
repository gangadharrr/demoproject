import java.util.*;
import java.lang.*;
import java.io.*;
class Video
{
	private String videoName;
	private boolean checkout=false;
	int rating=-1;
	Video(String name)
	{
		videoName=name;
	}
	String getName()
	{
		return videoName;
	}
	void doCheckout()
	{
		checkout=true;
	}
	void doReturn()
	{
		checkout=false;
	}
	void receiveRating(int rating)
	{
		this.rating=rating;
	}
	int getRating()
	{
		return rating;
	}
	boolean getCheckout()
	{
		return checkout;
	}
}
class VideoStore
{
	private HashMap<String,Video> store= new HashMap<String,Video>();
	void addVideo(String name)
	{
		store.put(name,new Video(name));
	}
	void doCheckout(String name)
	{
		try{
		Video temp=store.get(name);
		temp.doCheckout();
		}
		catch(Exception e)
		{
			System.out.println("Movie Not Found in Database\n"+e);
		}
	}
	void doReturn(String name)
	{
		try{
		store.get(name).doReturn();
		}
		catch(Exception e)
		{
			System.out.println("Movie Not Found in Database\n"+e);
		}
	}
	void receiveRating(String name, int rating)
	{
		try{
		store.get(name).receiveRating(rating);
		}
		catch(Exception e)
		{
			System.out.println("Movie Not Found in Database\n"+e);
		}
	}
	void listInventory()
	{
		System.out.println("------------------------------------------------------------");
		System.out.println("|    "+"Movie Name"+"    |    "+"CheckOut"+"    |    "+"Rating"+"    |");
		System.out.println("=================================");
		for(Map.Entry m : store.entrySet()){
			Video temp=store.get(m.getKey());
			System.out.println("------------------------------------------------------------");
			System.out.println("|"+String.format("%" + 9 + "s", temp.getName())+String.format("%-" + 9 + "s","")+"|"+String.format("%" + 9 + "s", temp.getCheckout())+String.format("%-" + 9 + "s", "")+"|"+String.format("%" + 9 + "s", temp.getRating())+String.format("%-" + 9 + "s", "")+"|");    
		} 
		System.out.println("------------------------------------------------------------");
	}
}
public class VideoLauncher
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		VideoStore VS=new VideoStore();
		
		while(true){
			System.out.println("MAIN MENU\n=========\n1. Add Videos :\n2. Check Out Video :\n3. Return Video :\n4. Recevie Rating :\n5. List Inventory :\n6. Exit :\nEnter Your Choice (1..6):");
			int choice=sc.nextInt();
			if(choice==1)
			{
				System.out.print("Enter Name:");
				String name=sc.next();
				VS.addVideo(name);
			}
			else if(choice==2)
			{
				System.out.print("Enter Name:");
				String name=sc.next();
				VS.doCheckout(name);
			}
			else if(choice==3)
			{
				System.out.print("Enter Name:");
				String name=sc.next();
				VS.doReturn(name);
			}
			else if(choice==4)
			{
				System.out.print("Enter name:");
				String name=sc.next();
				System.out.print("Enter Rating:");
				int rate=sc.nextInt();
				VS.receiveRating(name,rate);
			}
			else if(choice==5)
			{
				VS.listInventory();
			}
			else if(choice==6)
			{
				break;
			}
		}
	}
}