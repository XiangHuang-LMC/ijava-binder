//ABA_OOD_B_viewObtainData.java: very simple object-oriented design example.
//   Meets same requirements as Chapter 10 except the design uses MVC. 
//   This class implements the view component.

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ABA_OOD_B_viewObtainData
{
	private Scanner console;
	private final String EXIT = "exit";

	public ABA_OOD_B_viewObtainData()
	{
		console = new Scanner(System.in);
	}

	//pre: Prompt contains a message (typically instructions) to be displayed to user.
	//post: Returns value entered by user as a String.
	public String textLine(String prompt)
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
			textLine = EXIT;
		}
		return textLine;
	}
}
