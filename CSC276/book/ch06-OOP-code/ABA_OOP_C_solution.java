//ABA_OOP_C_solution.java: very simple object-oriented design example.
// Entry and non-persistent storage of name, no duplicate names,
// a phone number and email (better).

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeMap;

public class ABA_OOP_C_solution
{
	public static void main(String[] args)
	{
		ABA_OOP_C aba = new ABA_OOP_C();
		aba.go();
	}
}

class ABA_OOP_contactData
{
	String phone;
	String email;

	public ABA_OOP_contactData(String phone, String email)
	{
		this.phone = phone;
		this.email = email;
	}

	public String toString()
	{
		return "(" + phone + ", " + email + ")";
	}
}

class ABA_OOP_C
{
	TreeMap<String,ABA_OOP_contactData> book;
	Scanner console;

	public ABA_OOP_C()
	{
		book = new TreeMap<String,ABA_OOP_contactData>();
		console = new Scanner(System.in);
	}

	public void go()
	{
		String name, phone, email;
		name = getTextLine("Enter contact name ('exit' to quit): ");

		while (! name.equals("exit"))
		{
			phone = getTextLine("Enter phone number for " + name + ": ");
			email = getTextLine("Enter email address for " + name + ": ");
			if (! book.containsKey(name))
				book.put(name, new ABA_OOP_contactData(phone, email));
			name = getTextLine("Enter contact name ('exit' to quit): ");
		}

		displayBook();
	}

	//pre: prompt contains a message (typically instructions) to be displayed to user.
	//post: returns value entered by user as a String.
	public String getTextLine(String prompt)
	{
		System.out.print(prompt);
		String textLine = console.nextLine();
		return textLine;
	}

	public void displayBook()
	{
		System.out.println();
		System.out.println("TEST: Display contents of address book");
		System.out.println("TEST: The address book contains the following contacts");

		NavigableSet<String> keySet = book.navigableKeySet();
		Collection<ABA_OOP_contactData> valueColl = book.values();

		Iterator<String> iterKey = keySet.iterator();
		Iterator<ABA_OOP_contactData> iterValue = valueColl.iterator();
		
		while (iterKey.hasNext() && iterValue.hasNext())
			System.out.println(iterKey.next() + " " + iterValue.next());
	}
}
