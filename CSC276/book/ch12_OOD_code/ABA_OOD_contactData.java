//ABA_OOD_contactData.java: very simple object-oriented design example.
//   Meets same requirements as Chapter 10 except the design uses MVC. 
//   This class implements a container for contact data.

public class ABA_OOD_contactData
{
	private String name;
	private String phone;
	private String email;

	public ABA_OOD_contactData(String name, String phone, String email)
	{
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getName()
	{
		return name;
	}

	public String getPhone()
	{
		return phone;
	}

	public String toString()
	{
		return "(" + name + ", " + phone + ", " + email + ")";
	}
}
