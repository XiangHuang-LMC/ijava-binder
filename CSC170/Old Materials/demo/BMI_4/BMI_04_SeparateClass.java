import java.util.Scanner;

public class BMI_04_SeparateClass
{
	private double bmi;

	//purpose: Need to construct a BMI_04_SeparateClass object.
	//assumptions: None.
	//inputs: None.
	//post-conditions: A BMI_04_SeparateClass object now exists.
	//						 The bmi instance variable now contains a computed value.
	public BMI_04_SeparateClass(double weight, double height)
	{
		bmi = weight / Math.pow(height,2.0) * 703;
	}

	//purpose: Determine the BMI cagegory.
	//assumptions: None.
	//inputs: bmi - a Body Mass Index value.
	//post-conditions: Returns a BMI category.
	public String getBMICategory()
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
