//ABA_OOD_A_model.java: very simple object-oriented design example.
//   Meets same requirements as Chapter 10 except the design uses MVC. 
//   This class implements the model component.

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class ABA_OOD_A_model
{
	private TreeMap<String,ABA_OOD_contactData> book;
	private NavigableSet<String> keySet;
	private Iterator<String> iterKeySet;

	public ABA_OOD_A_model()
	{
		book = new TreeMap<String,ABA_OOD_contactData>();
		keySet = null;
	}

	//pre:  A name and phone needs to be added to the address book.
	//post: A name and phone were added to the address book ONLY IF
	//		  the name was not already in the book.
	public void addContact(String name, String phone, String email)
	{
		try
		{
			if (! book.containsKey(name))
			{
				ABA_OOD_contactData data = new ABA_OOD_contactData(name, phone, email);
				book.put(data.getName(), data);
			}
		}
		catch (Exception ex)
		{
			//Ignore any exceptions thrown i.e., the <name,phone> pair is not added to the book.
			//Of the two exceptions that may be thrown:
			//  ClassCastException will not occur since name is a String and book is a TreeMap<String,String>.
			//  NullPointerException occurs when name is null (which under normal operation should not occur).
		}
	}

	//pre:  Need to obtain the next contact name from the model.
	//post: Returns the next contact name or null when the last contact name has already been provided.
	public String getNextName()
	{
		String name = null;
		if (keySet == null)
		{
			keySet = book.navigableKeySet();
			iterKeySet = keySet.iterator();
		}
		if (iterKeySet.hasNext())
			name = iterKeySet.next();

		return name;
	}

	//pre:  Need to obtain the contact data forthe name specified.
	//post: Returns the contact data associated with name.
	public ABA_OOD_contactData getNextContactData(String name)
	{
		return book.get(name);
	}
}
