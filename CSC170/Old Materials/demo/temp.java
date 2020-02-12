public class temp
{
	public static void main(String[] args)
	{
		temp t = new temp();
	}
	
	private temp()
	{
		double[] numbers = {1.1, 2.2, 3.3, 4.4, 9.9};
		System.out.println(numbers.length);
		for (int idx = numbers.length - 1; idx >= 0 ; idx--)
			System.out.print(numbers[idx] + " ");
		System.out.println();
	}
}
