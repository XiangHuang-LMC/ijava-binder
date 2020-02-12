public class TempWarning02
{
	private double temperature;

	//purpose: Construct an instance of the TempWarning02 class.
	//assumptions: None.
	//inputs: None.
	//post-conditions: A TempWarning02 object now exists.
	//						 The temperature instance variable now has a value.
	public TempWarning02(double temperature)
	{
		this.temperature = temperature;
	}

	//purpose: Obtain a number from the user.
	//assumptions: User ready to enter a number.
	//inputs: instructions - tells user what number to enter.
	//post-conditions: Returns number entered by user.
	public String getWarning()
	{
		String warning = "";

		if (temperature > 90)
			warning = "It's really hot out there. Be careful!";
		else
			if (temperature > 65 && temperature < 80)
				warning = "Enjoy the pleasant temperature!";
			else
				if (temperature < 30)
					warning = "Brrrrr. Be sure to dress warmly!";

		return warning;
	}
}
