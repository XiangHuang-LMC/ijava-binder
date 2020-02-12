//ABA_OOD_B_model.java: very simple object-oriented design example.
//   Meets same requirements as Chapter 10 except the design uses MVC. 
//   This class implements the model component.

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class ABA_OOD_B_model
{
	private TreeMap<String,ABA_OOD_contactData> book;
	private NavigableSet<String> keySet;
	private Iterator<String> iterKeySet;

	public ABA_OOD_B_model()
	{
		book = new TreeMap<String,ABA_OOD_contactData>();
		keySet = null;
	}

	//pre:  A name and phone needs to be added to the address book.
	//post: A name and phone were added to the address book ONLY IF
	//		  the name was not already in the book.
	public void addContact(ABA_OOD_contactData data)
	{
		try
		{
			if (! book.containsKey(data.getName()))
			{
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

	//pre:  Need to obtain the contact data forthe name specified.
	//post: Returns the contact data associated with name.
	public ABA_OOD_contactData getNextContactData()
	{
		ABA_OOD_contactData nextData = null;

		if (keySet == null)
		{
			keySet = book.navigableKeySet();
			iterKeySet = keySet.iterator();
		}
		if (iterKeySet.hasNext())
		{
			String nextName = iterKeySet.next();
			nextData = book.get(nextName);
		}

		return nextData;
	}
}
