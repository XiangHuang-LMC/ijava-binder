import java.util.Scanner;

public class BMI_04_SeparateClass_NoValidation
{
	private Scanner scan;

	public static void main(String[] args)
	{
		BMI_04_SeparateClass_NoValidation anObject = new BMI_04_SeparateClass_NoValidation();

		double weight = anObject.getDoubleFromUser("Enter your weight in pounds: ");

		double height = anObject.getDoubleFromUser("Enter your height in inches: ");

		BMI_04_SeparateClass bmi = new BMI_04_SeparateClass(weight, height);

		System.out.println("Your BMI category is " + bmi.getBMICategory());
	}

	//purpose: Construct an instance of the BMI_04_SeparateClass_NoValidation class.
	//assumptions: None.
	//inputs: None.
	//post-conditions: A BMI_04_SeparateClass_NoValidation object now exists.
	//						 The scan instance variable now refers to a Scanner object.
	public BMI_04_SeparateClass_NoValidation()
	{
		scan = new Scanner(System.in);
	}

	//purpose: Obtain a number from the user.
	//assumptions: User ready to enter a number.
	//inputs: instructions - tells user what number to enter.
	//post-conditions: Returns number entered by user.
	public double getDoubleFromUser(String instructions)
	{
		System.out.print(instructions);
		double aDouble = scan.nextDouble();
		return aDouble;
	}
}
