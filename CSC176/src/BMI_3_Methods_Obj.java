import java.util.Scanner;

public class BMI_3_Methods_Obj
{
	Scanner scan;

	public static void main(String[] args)
	{
		BMI_3_Methods_Obj bmi = new BMI_3_Methods_Obj();
		bmi.go();
	}

	//purpose: Need to construct a BMI_Function_Obj object.
	//assumptions: None.
	//inputs: None.
	//post-conditions: A BMI_Function_Obj object has been created.
	private BMI_3_Methods_Obj()
	{
		scan = new Scanner(System.in);
	}

	//purpose: Execute this BMI program.
	//assumptions: User ready to enter weight and height.
	//inputs: None.
	//post-conditions: Displays the BMI category corresponding to inputs.
	private void go()
	{
		double weight = getNumber("Enter your weight in pounds: ");
		while (! isInputValid(weight, 0, 1000))
		{
			System.out.println("Weight must be a number in range (0,1000]");
			weight = getNumber("Re-enter your weight in pounds: ");
		}

		double height = getNumber("Enter your height in inches: ");
		while (! isInputValid(height, 0, 100))
		{
			System.out.println("Height must be a number in range (0, 100]");
			height = getNumber("Re-enter your height in inches: ");
		}

		String result = getBMICategory(weight, height);
		System.out.println(" Your BMI category is " + result);
	}

	//purpose: Obtain a number from the user.
	//assumptions: User ready to enter a number.
	//inputs: prompt - text displayed to user before user enters a number.
	//post-conditions: Returns number entered by user.
	private double getNumber(String prompt)
	{
		double num = -1;
		try
		{
			System.out.print(prompt);
			num = scan.nextDouble();
		}
		catch (Exception ex)
		{
			scan.nextLine();	//skip past the data entered by user.
		}
		return num;
	}

	//purpose: Validate a number entered by user.
	//assumptions: user input needs to be validated to be inside range  (min, max].
	//inputs: userInput - number entered by user.
	//			min - userInput must be > min.
	//			max - userInput must be <= max.
	//post-conditions: Returns true when min < userInput <= max. Otherwise, returns false.
	private boolean isInputValid(double   userInput, double min, double max)
	{
		if (userInput > min && userInput <= max)
			return true;
		else
			return false;
	}

	//purpose: Return BMI category given a weight and height.
	//assumptions: weight and height are valid values.
	//inputs: weight - weight of person in pounds.
	//			height - height of person in inches.
	//post-conditions: Returns category that the BMI value corresponds to.
	private String getBMICategory(double weight, double height)
	{
		double bmi = weight / Math.pow(height,2.0) * 703;
		String result = null;
		if (bmi <= 18.5)
			result = "underweight";
		else if (bmi <= 25)
			result = "normal";
		else if (bmi <= 30)
			result = "overweight";
		else
			result = "obese";
		return result;
	}
}
