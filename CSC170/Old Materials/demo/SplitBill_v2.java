import java.util.Scanner;

public class SplitBill_v2
{
	public static void main(String [] args)
	{
		SplitBill_v2 sb = new SplitBill_v2();
		sb.computeBill();
	}

	public SplitBill_v2()
	{
	}

	public void computeBill()
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the total bill:");
		double bill = scan.nextDouble();

		if (bill < 0 || bill > 2000)
			System.out.println("Error! Bill must be between 0 and $2000");

		System.out.print("Enter the number of people in your party:");
		int people = scan.nextInt();

		System.out.println("Each person owes $" + bill/people);

		scan.close();
	}
}
