import java.util.Scanner;

public class BMI_02_Methods_NoValidation
{
	private static Scanner scan;

	public static void main(String[] args)
	{
		scan = new Scanner(System.in);

		double weight = getDoubleFromUser("Enter your weight in pounds: ");

		double height = getDoubleFromUser("Enter your height in inches: ");

		double bmi = computeBMI(weight, height);

		System.out.println("Your BMI category is " + getBMICategory(bmi));
	}

	//purpose: Obtain a number from the user.
	//assumptions: User ready to enter a number.
	//inputs: instructions - tells user what number to enter.
	//post-conditions: Returns number entered by user.
	private static double getDoubleFromUser(String instructions)
	{
		System.out.print(instructions);
		double aDouble = scan.nextDouble();
		return aDouble;
	}

	//purpose: Compute the Body Mass Index (BMI).
	//assumptions: None.
	//inputs: weight - a person's weight in pounds.
	//			 height - a person's height in inches.
	//post-conditions: Returns the computed BMI value.
	private static double computeBMI(double weight, double height)
	{
		return weight / Math.pow(height,2.0) * 703;
	}

	//purpose: Determine the BMI category.
	//assumptions: None.
	//inputs: bmi - a Body Mass Index value.
	//post-conditions: Returns a BMI category.
	private static String getBMICategory(double bmi)
	{
		String category = null;

		if (bmi <= 18.5)
			category = "underweight";
		else if (bmi <= 25)
			category = "normal";
		else if (bmi <= 30)
			category = "overweight";
		else
			category = "obese";
		
		return category;
	}
}
