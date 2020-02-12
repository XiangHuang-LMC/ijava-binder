public class demoInheritance_Rectangle
{
	private double side1;
	private double side2;
	protected double area;
	protected double circumference;

	public demoInheritance_Rectangle(double side1, double side2)
	{
		this.side1 = side1;
		this.side2 = side2;
		area = side1 * side2;
		circumference = side1 * 2 + side2 * 2;
	}

	public double getArea()
	{
		return area;
	}

	public double getCircumference()
	{
		return circumference;
	}

	public double getSide1()
	{
		return side1;
	}

	public double getSide2()
	{
		return side2;
	}

	public String toString()
	{
		return "rectangle: side1=" + side1 + " side2=" + side2 +
				" area=" + area + " circumference=" + circumference;
	}
}
