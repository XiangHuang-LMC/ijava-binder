//ABA_OOP_B_solution.java: very simple object-oriented design example.
// Entry and non-persistent storage of name, no duplicate names, a phone number.

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeMap;

public class ABA_OOP_B_solution
{
	public static void main(String[] args)
	{
		ABA_OOP_B aba = new ABA_OOP_B();
		aba.go();
	}
}

class ABA_OOP_B 
{
	TreeMap<String,String> book;
	Scanner console;

	public void go()
	{
		book = new TreeMap<String,String>();
		console = new Scanner(System.in);
		String name, phone;
		name = getName();

		while (! name.equals("exit"))
		{
			phone = getPhone(name);
			if (! book.containsKey(name))
				book.put(name, phone);
			name = getName();
		}

		displayBook();
	}

	public String getName()
	{
		System.out.print("Enter contact name ('exit' to quit): ");
		String name = console.nextLine();
		return name;
	}

	public void displayBook()
	{
		System.out.println();
		System.out.println("TEST: Display contents of address book");
		System.out.println("TEST: The address book contains the following contacts");

		NavigableSet<String> keySet = book.navigableKeySet();
		Collection<String> valueColl = book.values();

		Iterator<String> iterKey = keySet.iterator();
		Iterator<String> iterValue = valueColl.iterator();
		
		while (iterKey.hasNext() && iterValue.hasNext())
			System.out.println(iterKey.next() + " " + iterValue.next());
	}

	public String getPhone(String name)
	{
		System.out.print("Enter phone number for " + name + ": ");
		String phone = console.nextLine();
		return phone;
	}
}
