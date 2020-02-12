//ABA_OOP_B_solution.java: very simple object-oriented design example.
//	Entry and non-persistent storage of name (better).

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
	ArrayList<String> book;
	Scanner console;

	public void go()
	{
		book = new ArrayList<String>();
		console = new Scanner(System.in);
		String name;
		name = getName();

		while (! name.equals("exit"))
		{
			book.add(name);
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
		for (Iterator<String> iter = book.iterator(); iter.hasNext(); )
			System.out.println(iter.next());
	}
}
