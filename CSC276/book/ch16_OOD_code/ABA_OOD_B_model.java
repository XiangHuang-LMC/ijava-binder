//ABA_OOD_B_model.java: very simple object-oriented design example.
//   This class implements the model component.

import java.util.Set;
import java.util.TreeMap;

public class ABA_OOD_B_model
{
	private TreeMap<String,ABA_OOD_contactData> book;

	public ABA_OOD_B_model()
	{
		book = new TreeMap<String,ABA_OOD_contactData>();
	}

	//pre:  A name and phone needs to be added to the address book.
	//post: A name and phone were added to the address book ONLY IF
	//		  the name was not already in the book.
	public boolean addContact(ABA_OOD_contactData data)
	{
		boolean added = false;
		try
		{
			if (! book.containsKey(data.getName()))
			{
				book.put(data.getName(), data);
				added = true;
			}
		}
		catch (Exception ex)
		{
			//Ignore any exceptions thrown i.e., the <name,phone> pair is not added to the book.
			//Of the two exceptions that may be thrown:
			//  ClassCastException will not occur since name is a String and book is a TreeMap<String,String>.
			//  NullPointerException occurs when name is null (which under normal operation should not occur).
		}
		return added;
	}

	//pre:  A name may already be in the address book.
	//post: Returns data associated with the request's contact name.
	//		 Returns null when request's contact name not in address book.
	public ABA_OOD_contactData getContact(ABA_OOD_contactData requestData)
	{
		ABA_OOD_contactData data = null;
		try
		{
			data = book.get(requestData.getName());
		}
		catch (Exception ex)
		{
			//Ignore any exceptions thrown i.e., the <name,phone> pair is not added to the book.
			//Of the two exceptions that may be thrown:
			//  ClassCastException will not occur since name is a String and book is a TreeMap<String,String>.
			//  NullPointerException occurs when name is null (which under normal operation should not occur).
		}
		return data;
	}

	//pre:  Address book data structure exists.
	//post: Returns set of all contact names in the address book.
	public Set<String> getContactList()
	{
		return book.keySet();
	}
}
