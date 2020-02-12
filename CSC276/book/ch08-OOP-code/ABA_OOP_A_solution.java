//ABA_OOP_A_solution.java: very simple object-oriented design example.
// Validation of name and phone number, in non-persistent storage.

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeMap;

public class ABA_OOP_A_solution
{
	public static void main(String[] args)
	{
		ABA_OOP_A aba = new ABA_OOP_A();
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

class ABA_OOP_A
{
	TreeMap<String,ABA_OOP_contactData> book;
	Scanner console;

	public ABA_OOP_A()
	{
		book = new TreeMap<String,ABA_OOP_contactData>();
		console = new Scanner(System.in);
	}

	public void go()
	{
		String name, phone, email;
		name = getValidName();

		while (! name.equals("exit"))
		{
			phone = getValidPhone(name);
			email = getTextLine("Enter email address for " + name + ": ");
			if (! book.containsKey(name))
				book.put(name, new ABA_OOP_contactData(phone, email));
			name = getValidName();
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

	//pre: Need to obtain a contact name from the user.
	//post: A valid contact name is returned.
	public String getValidName()
	{
		//A valid contact name may contain only spaces, uppercase letters, and lowercase letters.
		String pattern = "[ A-Za-z]+";
		String name = "";
		String errorMsg = "";
		boolean okay = false;
		//Continue asking for a contact name until valid data is entered.
		do
		{
			name = getTextLine("Enter contact name ('exit' to quit): ");
			//Remove leading and trailing whitespace.
			name = name.trim();
			if (name.length() == 0)
			{
				//contact name must contain at least one letter.
				okay = false;
				errorMsg = "A contact name must contain at least one uppercase or lowercase letter.";
			}
			else
			{
				//Determine if the entered name is valid.
				okay = name.matches(pattern);
				errorMsg = "A contact name must contain only uppercase and lowercase letters and spaces.";
			}
			if (! okay)
				System.out.println(errorMsg);
		} while (! okay);
	
	    return name;
	}

	//pre: Need to obtain a phone number from the user.
	//post: A valid phone number is returned.
	public String getValidPhone(String name)
	{
		//A valid getValidPhone may contain one or more digits.
		String pattern = "[0-9]+";
		String phone = "";
		String errorMsg = "";
		boolean okay = false;
		//Continue asking for a phone number until valid data is entered.
		do
		{
			phone = getTextLine("Enter phone number for " + name + ": ");
			//Remove leading and trailing whitespace.
			phone = phone.trim();
			//Determine if the entered name is valid.
			okay = phone.matches(pattern);
			if (! okay)
				System.out.println("A phone number must contain one or more digits.");
		} while (! okay);
	
	    return phone;
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
