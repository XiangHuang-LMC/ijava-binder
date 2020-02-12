public class demoPolymorphism
{
	private Object[] objects;

	public static void main(String[] args)
	{
		demoPolymorphism demo = new demoPolymorphism();
	}

	public demoPolymorphism()
	{
		final int MAX = 3;

		objects = new Object[MAX];
		objects[0] = new demoInheritance_Rectangle(10,12);
		objects[1] = new demoInheritance_Square(13);
		objects[2] = new java.math.BigInteger("1234567890123456789012345678901234567890");

		for (int idx=0; idx < MAX; idx++)
		{
			System.out.println(objects[idx]);
			System.out.println(objects[idx].getClass());
		}
	}
}
