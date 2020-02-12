//ABA_OOD_viewRequest.java: very simple object-oriented design example.
//   This class is part of the view component.

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ABA_OOD_viewRequest
{
	public static enum REQUEST {CREATE, DISPLAY, UNKNOWN};
	private REQUEST request;
	private ABA_OOD_contactData data;

	public ABA_OOD_viewRequest(REQUEST request, ABA_OOD_contactData data)
	{
		this.request = request;
		this.data = data;

	}

	//pre: 
	//post: 
	public ABA_OOD_contactData getData()
	{
		return data;
	}

	//pre: 
	//post: 
	public boolean isCreateContact()
	{
		boolean isCreate = false;

		if (request == REQUEST.CREATE)
			isCreate = true;

		return isCreate;
	}

	//pre: 
	//post: 
	public boolean isDisplayContact()
	{
		boolean isDisplay = false;

		if (request == REQUEST.DISPLAY)
			isDisplay = true;

		return isDisplay;
	}
}
