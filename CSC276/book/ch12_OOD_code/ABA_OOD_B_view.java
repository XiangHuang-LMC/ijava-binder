//ABA_OOD_B_view.java: very simple object-oriented design example.
//   Meets same requirements as Chapter 10 except the design uses MVC. 
//   This class implements the view component.

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ABA_OOD_B_view
{
	private ABA_OOD_B_viewDisplayData display;
	private ABA_OOD_B_viewObtainData obtain;
	private final String EXIT = "exit";

	public ABA_OOD_B_view()
	{
		this.display = new ABA_OOD_B_viewDisplayData();
		this.obtain = new ABA_OOD_B_viewObtainData();
	}

	//pre: Display contents of the address book.
	//post: Address book contents have been displayed.
	public void displayBook(ABA_OOD_B_controller controller)
	{
		display.msg("");
		display.msg("TEST: Display contents of address book");
		display.msg("TEST: The address book contains the following contacts");

		//Get first contact name from model.
		ABA_OOD_contactData nextData = controller.getNextContactData();

		//Continue to display data while there are more contact names.
		while (nextData != null)
		{
			display.msg(nextData.toString());
			//Get next contact data from model.
			nextData = controller.getNextContactData();
		}
	}

	//pre: The most recent contact name entered by user is not valid.
	//post: An appropriate error message is displayed.
	public void displayInvalidName(String invalidName)
	{
		display.msg("The contact name you entered '" + invalidName + "' is not valid." +
				" A contact name must contain at least one letter AND" +
				" must contain only uppercase and lowercase letters and spaces.");
	}

	//pre: The most recent phone number entered by user is not valid.
	//post: An appropriate error message is displayed.
	public void displayInvalidPhone(String invalidPhone)
	{
		display.msg("The phone number you entered '" + invalidPhone + "' is not valid." +
				" A phone number must contain one or more digits.");
	}

	//pre: Display a message to the user.
	//post: Message has been displayed.
	public void displayRegExError(String msg)
	{
		display.msg("\nLogic error using a regular expression to validate a " + msg + ".\n");
	}

	//pre: Obtains from user all of the contact data for a single person.
	//post: Returns object containing all of the user data entered.
	public ABA_OOD_contactData getContactData()
	{
		ABA_OOD_contactData userData;
		String name, phone, email;
		
		name = obtain.textLine("Enter contact name (or 'exit' to quit): ");
		if (name.equals(EXIT))
			userData = null;
		else
		{
			phone = obtain.textLine("Enter phone number for " + name + ": ");
			email = obtain.textLine("Enter email address for " + name + ": ");
			if (phone.equals(EXIT) || email.equals(EXIT))
				//One of these values may be EXIT if user enters CTRL-Z.
				userData = null;
			else
				userData = new ABA_OOD_contactData(name, phone, email);
		}

		return userData;
	}
}
