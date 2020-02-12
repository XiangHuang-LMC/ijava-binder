//ABA_OOD_viewMessage.java: very simple object-oriented design example.
//   This class is part of the view component.

public class ABA_OOD_viewMessage
{
	private ABA_OOD_contactData data;
	private int msgNumber;
	private static final int NO_ERROR = 0;
	private static final int INVALID_NAME = 1;
	private static final int INVALID_PHONE = 2;
	private static final int CREATED_CONTACT = 4;
	private static final int DUP_CONTACT = 8;
	private static final int NOT_FOUND = 16;

	public ABA_OOD_viewMessage()
	{
		this.msgNumber = NO_ERROR;
	}

	public boolean isNoError()
	{
		boolean is = false;
		if ((msgNumber | NO_ERROR) == NO_ERROR)
			is = true;
		return is;
	}
	public boolean isInvalidName()
	{
		boolean is = false;
		if ((msgNumber & INVALID_NAME) == INVALID_NAME)
			is = true;
		return is;
	}
	public boolean isInvalidPhone()
	{
		boolean is = false;
		if ((msgNumber & INVALID_PHONE) == INVALID_PHONE)
			is = true;
		return is;
	}
	public boolean isCreatedContact()
	{
		boolean is = false;
		if ((msgNumber & CREATED_CONTACT) == CREATED_CONTACT)
			is = true;
		return is;
	}
	public boolean isDupContact()
	{
		boolean is = false;
		if ((msgNumber & DUP_CONTACT) == DUP_CONTACT)
			is = true;
		return is;
	}
	public boolean isNotFound()
	{
		boolean is = false;
		if ((msgNumber & NOT_FOUND) == NOT_FOUND)
			is = true;
		return is;
	}

	public ABA_OOD_contactData getData()
	{
		return data;
	}
	public void setData(ABA_OOD_contactData data)
	{
		this.data = data;
	}

	public void setInvalidName()
	{
		this.msgNumber = this.msgNumber + INVALID_NAME;
	}
	public void setInvalidPhone()
	{
		this.msgNumber = this.msgNumber + INVALID_PHONE;
	}
	public void setCreatedContact()
	{
		this.msgNumber = this.msgNumber + CREATED_CONTACT;
	}
	public void setDupContact()
	{
		this.msgNumber = this.msgNumber + DUP_CONTACT;
	}
	public void setNotFound()
	{
		this.msgNumber = this.msgNumber + NOT_FOUND;
	}

	public String toString()
	{
		return Integer.toString(msgNumber);
	}
}
