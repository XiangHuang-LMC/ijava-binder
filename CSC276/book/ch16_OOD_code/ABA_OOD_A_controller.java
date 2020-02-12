//ABA_OOD_A_controller.java: very simple object-oriented design example.
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

	public ABA_OOD_viewMessage processRequest(ABA_OOD_viewRequest request)
	{
		ABA_OOD_viewMessage msg = null;
		if (request.isCreateContact())
		{
			msg = validateNewContact(request.getData());
			if (msg.isNoError())
			{
				if (model.addContact(request.getData()))
					msg.setCreatedContact();
				else
					msg.setDupContact();
			}
		}
		else if (request.isDisplayContact())
		{
			ABA_OOD_contactData data = model.getContact(request.getData());
			msg = new ABA_OOD_viewMessage();
			msg.setData(data);
			if (data == null)
				msg.setNotFound();
		}

		System.out.println("processRequest msg=" + msg);
		return msg;
	}
	
	//purpose: Exit the simulator.
	//assumptions: None.
	//inputs: None.
	//post-conditions: None.
	public void exitABA()
	{
		System.out.println("exitABA()");
		System.exit(0);
	}

	//pre:  Application needs to exit immediately.
	//post: A message is displayed and the application is terminated.
	private void endApplication(String msg)
	{
//		view.displayRegExError(msg);
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

	//pre: Need to validate new contact data.
	//post: Either adds new contact data to address book OR displays error message(s).
	private ABA_OOD_viewMessage validateNewContact(ABA_OOD_contactData data)
	{
		boolean nameValid, phoneValid;
		ABA_OOD_viewMessage msg;

		msg = new ABA_OOD_viewMessage();
		nameValid = isNameValid(data.getName());
		phoneValid = isPhoneValid(data.getPhone());

		if (! nameValid)
			msg.setInvalidName();
		if (! phoneValid)
			msg.setInvalidPhone();

		return msg;
	}
}
