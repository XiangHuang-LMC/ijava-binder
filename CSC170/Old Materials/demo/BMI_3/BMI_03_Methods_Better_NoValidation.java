import java.util.Scanner;

public class BMI_03_Methods_Better_NoValidation
{
	private Scanner scan;

	public static void main(String[] args)
	{
		BMI_03_Methods_Better_NoValidation anObject;
		double weight;
		double height;
		double bmi;

		anObject = new BMI_03_Methods_Better_NoValidation();
		weight = anObject.getDoubleFromUser("Enter your weight in pounds: ");
		height = anObject.getDoubleFromUser("Enter your height in inches: ");
		bmi = anObject.computeBMI(weight, height);

		System.out.println("Your BMI category is\n" + anObject.getBMICategory(bmi));
	}

	//purpose: Construct an instance of the BMI_03_Methods_Better_NoValidation class.
	//assumptions: None.
	//inputs: None.
	//post-conditions: A BMI_03_Methods_Better_NoValidation object now exists.
	//						 The scan instance variable now refers to a Scanner object.
	public BMI_03_Methods_Better_NoValidation()
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

	//purpose: Compute the Body Mass Index (BMI).
	//assumptions: None.
	//inputs: weight - a person's weight in pounds.
	//			 height - a person's height in inches.
	//post-conditions: Returns the computed BMI value.
	private double computeBMI(double weight, double height)
	{
		final double FACTOR = 703;
		return weight / Math.pow(height,2.0) * FACTOR;
	}

	//purpose: Determine the BMI cagegory.
	//assumptions: None.
	//inputs: bmi - a Body Mass Index value.
	//post-conditions: Returns a BMI category.
	private String getBMICategory(double bmi)
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
