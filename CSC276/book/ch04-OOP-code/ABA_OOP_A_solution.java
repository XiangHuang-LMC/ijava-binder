//ABA_OOP_A_solution.java: very simple object-oriented design example.
//	Entry and non-persistent storage of name.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
	public void go()
	{
		ArrayList<String> book = new ArrayList<String>();
		Scanner console = new Scanner(System.in);

		System.out.print("Enter contact name ('exit' to quit): ");
		String name = console.nextLine();

		while (! name.equals("exit"))
		{
			book.add(name);
			System.out.print("Enter contact name ('exit' to quit): ");
			name = console.nextLine();
		}

		System.out.println();
		System.out.println("TEST: Display contents of address book");
		System.out.println("TEST: The address book contains the following contacts");
		for (Iterator<String> iter = book.iterator(); iter.hasNext(); )
			System.out.println(iter.next());
	}
}
