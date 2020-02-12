public class demoInheritance_Square extends demoInheritance_Rectangle
{
	public demoInheritance_Square(double side1)
	{
		super(side1, side1);
	}

	public String toString()
	{
		return "square: side1=" + getSide1() + " side2=" + getSide2() +
				" area=" + area + " circumference=" + circumference;
	}
}
