import java.util.Scanner;

public class TempWarning02_main
{
	private Scanner scan;

	public static void main(String[] args)
	{
		TempWarning02_main temp_main = new TempWarning02_main();

		double temp = temp_main.getDoubleFromUser("Enter a Fahrenheit temperature: ");

		TempWarning02 tempWarning = new TempWarning02(temp);

		System.out.println(tempWarning.getWarning());
	}

	//purpose: Construct an instance of the TempWarning01_main class.
	//assumptions: None.
	//inputs: None.
	//post-conditions: A TempWarning01_main object now exists.
	//						 The scan instance variable now refers to a Scanner object.
	public TempWarning02_main()
	{
		scan = new Scanner(System.in);
	}

	//purpose: Obtain a number from the user.
	//assumptions: User ready to enter a number.
	//inputs: instructions - tells user what number to enter.
	//post-conditions: Returns number entered by user.
	private double getDoubleFromUser(String instructions)
	{
		System.out.print(instructions);
		double aDouble = scan.nextDouble();
		return aDouble;
	}
}
