//ABA_OOD_B_view.java: very simple object-oriented design example.
//   This class implements the view component.

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class ABA_OOD_B_view
{
	private ABA_OOD_B_controller controller;
	private ABA_OOD_B_viewGUI gui;

	private final String CREATE = "C";
	private final String DISPLAY = "D";
	private final String EXIT = "X";

	public ABA_OOD_B_view(ABA_OOD_B_controller controller)
	{
		this.controller = controller;
		this.gui = new ABA_OOD_B_viewGUI(this);
	}

	//purpose:
	//assumptions:
	//inputs:
	//post-conditions:
	public ABA_OOD_viewMessage addContact(ABA_OOD_contactData data)
	{
		ABA_OOD_viewRequest request = new ABA_OOD_viewRequest(ABA_OOD_viewRequest.REQUEST.CREATE, data);
		ABA_OOD_viewMessage msg = controller.processRequest(request);
		return msg;
	}

	//purpose:
	//assumptions:
	//inputs:
	//post-conditions:
	public ABA_OOD_viewMessage displayContact(ABA_OOD_contactData data)
	{
		ABA_OOD_viewRequest request = new ABA_OOD_viewRequest(ABA_OOD_viewRequest.REQUEST.DISPLAY, data);
		ABA_OOD_viewMessage msg = controller.processRequest(request);
		return msg;
	}
	
	//purpose: Exit the application.
	//assumptions: None.
	//inputs: None.
	//post-conditions: None.
	public void exitABA()
	{
		controller.exitABA();
	}

	//pre:  Address book data structure exists.
	//post: Returns set of all contact names in the address book.
	public Set<String> getContactList()
	{
		return controller.getContactList();
	}
}
