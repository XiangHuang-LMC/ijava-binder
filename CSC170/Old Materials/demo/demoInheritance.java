public class demoInheritance
{
	public static void main(String[] args)
	{
		demoInheritance demo = new demoInheritance();
	}
	public demoInheritance()
	{
		demoInheritance_Rectangle rect1 = new demoInheritance_Rectangle(10,12);
		demoInheritance_Square square1 = new demoInheritance_Square(13);
		System.out.println(rect1);
		System.out.println(square1);
	}
}
