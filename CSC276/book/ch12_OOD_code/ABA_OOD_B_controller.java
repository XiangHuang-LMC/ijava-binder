//ABA_OOD_B_controller.java: very simple object-oriented design example.
//   Meets same requirements as Chapter 10 except the design uses MVC. 
//   This class implements the controller component.

import java.util.regex.PatternSyntaxException;

public class ABA_OOD_B_controller
{
	private ABA_OOD_B_model model;
	private ABA_OOD_B_view view;

	public ABA_OOD_B_controller()
	{
		model = new  ABA_OOD_B_model();
		view = new ABA_OOD_B_view();
	}

	//pre:  Application has been requested by a user.
	//post: User is done using the application.
	public void go()
	{
		ABA_OOD_contactData data;
		boolean nameValid, phoneValid;
		data = view.getContactData();

		while (data != null)
		{
			nameValid = isNameValid(data.getName());
			phoneValid = isPhoneValid(data.getPhone());
			if (nameValid && phoneValid)
				model.addContact(data);
			else
			{
				if (! nameValid)
					view.displayInvalidName(data.getName());
				if (! phoneValid)
					view.displayInvalidPhone(data.getPhone());
			}
			data = view.getContactData();
		}

		view.displayBook(this);
	}

	//pre:  Need to obtain a next contact data from the model.
	//post: Returns the next contact data (or null) .
	public ABA_OOD_contactData getNextContactData()
	{
		return model.getNextContactData();
	}

	//pre:  Application needs to exit immediately.
	//post: A message is displayed and the application is terminated.
	private void endApplication(String msg)
	{
		view.displayRegExError(msg);
		System.exit(0);
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
				endApplication("contact name");
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
			endApplication("phone number");
		}
	
		return okay;
	}
}
