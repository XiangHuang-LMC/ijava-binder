//ABA_OOP_A_solution.java: very simple object-oriented design example.
// Entry and non-persistent storage of name, no duplicate names (TreeSet).

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class ABA_OOP_A_solution
{
	public static void main(String[] args)
	{
		ABA_OOP_A aba = new ABA_OOP_A();
		aba.go();
	}
}

class ABA_OOP_A
{
	TreeSet<String> book;
	Scanner console;

	public void go()
	{
		book = new TreeSet<String>();
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
