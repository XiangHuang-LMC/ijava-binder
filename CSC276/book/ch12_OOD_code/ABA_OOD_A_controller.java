//ABA_OOD_A_controller.java: very simple object-oriented design example.
//   Meets same requirements as Chapter 10 except the design uses MVC. 
//   This class implements the controller component.

import java.util.regex.PatternSyntaxException;

public class ABA_OOD_A_controller
{
	private ABA_OOD_A_model model;
	private ABA_OOD_A_view view;

	public ABA_OOD_A_controller()
	{
		model = new  ABA_OOD_A_model();
		view = new ABA_OOD_A_view(this);
	}

	//pre:  Application has been requested by a user.
	//post: User is done using the application.
	public void go()
	{
		String name, phone, email;
		name = getValidName();

		while (! name.equals("exit"))
		{
			phone = getValidPhone(name);
			email = view.getEmail(name);
			model.addContact(name, phone, email);
			name = getValidName();
		}

		view.displayBook();
	}

	//pre:  Need to obtain the next contact name from the model.
	//post: Returns the next contact name or null when the last contact name has already been provided.
	public String getNextName()
	{
		String name = model.getNextName();
		if (name != null && ! isNameValid(name))
		{
			name = "[InvalidName]";
		}
		return name;
	}

	//pre:  Need to obtain a phone number for the name specified.
	//post: Returns the phone number associated with name.
	public String getNextContactData(String name)
	{
		ABA_OOD_contactData contactData = model.getNextContactData(name);
		String data;
		if (contactData == null)
			data = null;
		else
		{
			if (! isPhoneValid(contactData.getPhone()))
				data = "(InvalidPhone)";
			else
				data = contactData.toString();
		}
		return data;
	}

	//pre:  Application needs to exit immediately.
	//post: A message is displayed and the application is terminated.
	private void endApplication(String msg)
	{
		view.displayMsg("\n" + msg + "\n");
		System.exit(0);
	}

	//pre: Need to obtain a contact name from the user.
	//post: A valid contact name is returned.
	private String getValidName()
	{
		String name = "";
		boolean okay = false;
		//Continue asking for a contact name until valid data is entered.
		do
		{
			name = view.getName();
			//Remove leading and trailing whitespace.
			name = name.trim();
			okay = isNameValid(name);
			if (! okay)
				view.displayMsg("A contact name must contain at least one letter AND " +
									 "must contain only uppercase and lowercase letters and spaces.");
		} while (! okay);
	
	    return name;
	}

	//pre: Need to obtain a phone number from the user.
	//post: A valid phone number is returned.
	private String getValidPhone(String name)
	{
		String phone = "";
		boolean okay = false;
		//Continue asking for a phone number until valid data is entered.
		do
		{
			phone = view.getPhone(name);
			//Remove leading and trailing whitespace.
			phone = phone.trim();
			//Determine if the entered phone is valid.
			okay = isPhoneValid(phone);
			if (! okay)
				view.displayMsg("A phone number must contain one or more digits.");
		} while (! okay);
	
	    return phone;
	}

	//pre: User has entered a contact name AND
	//     name value has been stripped of leading and trailing whitespace.
	//post: Return true when name is valid. Otherwise, return false.
	private boolean isNameValid(String name)
	{
		//A valid contact name may contain only spaces, uppercase letters, and lowercase letters.
		String pattern = "[ A-Za-z]+";
		boolean okay = false;
		if (name.length() > 0)
		{
			try
			{
				//Determine if the entered name is valid.
				okay = name.matches(pattern);
			}
			catch (PatternSyntaxException ex)
			{
				endApplication("Logic error using a regular expression to validate a contact name.");
			}
		}
	
		return okay;
	}

	//pre: User has entered a phone number AND
	//     phone value has been stripped of leading and trailing whitespace.
	//post: Return true when phone number is valid. Otherwise, return false.
	private boolean isPhoneValid(String phone)
	{
		//A valid getValidPhone may contain one or more digits.
		String pattern = "[0-9]+";
		boolean okay = false;
		try
		{
			//Determine if the entered phone is valid.
			okay = phone.matches(pattern);
		}
		catch (PatternSyntaxException ex)
		{
			endApplication("Logic error using a regular expression to validate a contact phone number.");
		}
	
		return okay;
	}
}
