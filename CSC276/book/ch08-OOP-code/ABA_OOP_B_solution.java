//ABA_OOP_A_solution.java: very simple object-oriented design example.
// A more secure ABA since it includes:
// - Input validation of name and phone number before put into non-persistent storage.
// - Output validation of name and phone number before displayed to user.
// - Exception handling and fail-safe defaults.

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.regex.PatternSyntaxException;
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

class ABA_OOP_contactData
{
	public String phone;
	public String email;

	public ABA_OOP_contactData(String phone, String email)
	{
		this.phone = phone;
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public String toString()
	{
		return "(" + phone + ", " + email + ")";
	}
}

class ABA_OOP_B
{
	public TreeMap<String,ABA_OOP_contactData> book;
	public Scanner console;

	//A valid contact name may contain only spaces, uppercase letters, and lowercase letters.
	public final String NAME_PATTERN = "[ A-Za-z]+";
	//A valid getValidPhone contains one or more digits.
	public final String PHONE_PATTERN = "[0-9]+";

	public ABA_OOP_B()
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
			try
			{
				if (! book.containsKey(name))
					book.put(name, new ABA_OOP_contactData(phone, email));
			}
			catch (Exception ex)
			{
				//Ignore any exceptions thrown i.e., the <name,ABA_OOP_contactData> pair is not added to the book.
				//Of the two exceptions that may be thrown:
				//  ClassCastException will not occur since name is a String and book is a TreeMap<String,ABA_OOP_contactData>.
				//  NullPointerException occurs when name is null (which under normal operation should not occur).
			}
			name = getValidName();
		}

		displayBook();
	}

	//pre: prompt contains a message (typically instructions) to be displayed to user.
	//post: returns value entered by user as a String.
	public String getTextLine(String prompt)
	{
		System.out.print(prompt);
		String textLine;
		try
		{
			textLine = console.nextLine();
		}
		catch (Exception ex)
		{
			textLine = "";
			//Entering Ctrl-Z causes a NoSuchElementException
			System.out.println("\nConsole input has been terminated, ending application.\n");
			endApplication();
		}
		return textLine;
	}

	//pre: Need to obtain a contact name from the user.
	//post: A valid contact name is returned.
	public String getValidName()
	{
		String name = "";
		boolean okay = false;
		//Continue asking for a contact name until valid data is entered.
		do
		{
			name = getTextLine("Enter contact name ('exit' to quit): ");
			//Remove leading and trailing whitespace.
			name = name.trim();
			okay = isValid(name, NAME_PATTERN);
			if (! okay)
				System.out.println("A contact name must contain only uppercase and lowercase letters and spaces.");
		} while (! okay);
	
	    return name;
	}

	//pre: Need to obtain a phone number from the user.
	//post: A valid phone number is returned.
	public String getValidPhone(String name)
	{
		String phone = "";
		boolean okay = false;
		//Continue asking for a phone number until valid data is entered.
		do
		{
			phone = getTextLine("Enter phone number for " + name + ": ");
			//Remove leading and trailing whitespace.
			phone = phone.trim();
			//Determine if the entered phone is valid.
			okay = isValid(phone, PHONE_PATTERN);
			if (! okay)
				System.out.println("A phone number must contain one or more digits.");
		} while (! okay);
	
	    return phone;
	}

	//pre: User has entered a data value that can be validated using a regular expression.
	//post: Return true when name is valid. Otherwise, return false.
	public boolean isValid(String data, String pattern)
	{
		boolean okay = false;
		if (data.length() > 0)
		{
			try
			{
				//Determine if the entered name is valid.
				okay = data.matches(pattern);
			}
			catch (PatternSyntaxException ex)
			{
				System.out.println("\nLogic error in pattern matching, ending application.\n");
				endApplication();
			}
		}
	
		return okay;
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

		String name, phone, data;
		while (iterKey.hasNext() && iterValue.hasNext())
		{
			try
			{
				name = iterKey.next();
				ABA_OOP_contactData contactData = iterValue.next();
				data = contactData.toString();
				phone = contactData.getPhone();
				if (! isValid(name, NAME_PATTERN) ||
					! isValid(phone, PHONE_PATTERN))
				{
					name = "[InvalidName]";
					data = "[InvalidContactData]";
				}
			}
			catch (Exception ex)
			{
				name = "[InvalidName]";
				data = "[InvalidContactData]";
			}
			System.out.println(name + " " + data);
		}
	}

	public void endApplication()
	{
		System.exit(0);
	}
}
