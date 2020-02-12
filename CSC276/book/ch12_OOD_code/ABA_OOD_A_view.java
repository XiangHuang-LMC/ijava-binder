//ABA_OOD_A_view.java: very simple object-oriented design example.
//   Meets same requirements as Chapter 10 except the design uses MVC. 
//   This class implements the view component.

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ABA_OOD_A_view
{
	private ABA_OOD_A_controller controller;
	private Scanner console;

	public ABA_OOD_A_view(ABA_OOD_A_controller controller)
	{
		this.controller = controller;
		console = new Scanner(System.in);
	}

	public void displayBook()
	{
		System.out.println();
		System.out.println("TEST: Display contents of address book");
		System.out.println("TEST: The address book contains the following contacts");

		//Get first contact name from model.
		String name = controller.getNextName();

		//Continue to display data while there are more contact names.
		while (name != null)
		{
			String contactData = controller.getNextContactData(name);
			System.out.println(contactData);

			//Get next contact name from model.
			name = controller.getNextName();
		}
	}

	public void displayMsg(String msg)
	{
		System.out.println(msg);
	}

	//pre: prompt contains a message (typically instructions) to be displayed to user.
	//post: returns value entered by user as a String.
	public String getEmail(String name)
	{
		return getTextLine("Enter email address for " + name + ": ");
	}

	//pre: prompt contains a message (typically instructions) to be displayed to user.
	//post: returns value entered by user as a String.
	public String getName()
	{
		return getTextLine("Enter contact name ('exit' to quit): ");
	}

	//pre: prompt contains a message (typically instructions) to be displayed to user.
	//post: returns value entered by user as a String.
	public String getPhone(String name)
	{
		return getTextLine("Enter phone number for " + name + ": ");
	}

	//pre: prompt contains a message (typically instructions) to be displayed to user.
	//post: returns value entered by user as a String.
	private String getTextLine(String prompt)
	{
		System.out.print(prompt);
		String textLine;
		try
		{
			textLine = console.nextLine();
		}
		catch (NoSuchElementException ex)
		{
			//User has entered Ctrl-Z causing an end-of-file condition.
			//Force the application to exit.
			textLine = "exit";
		}
		return textLine;
	}
}
