import java.util.Scanner;

public class SplitBill_v2Better
{
	public static void main(String [] args)
	{
		SplitBill_v2Better sb = new SplitBill_v2Better();
		sb.computeBill();
	}

	public SplitBill_v2Better()
	{
	}

	private void computeBill()
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the total bill:");
		double bill = scan.nextDouble();

		if (bill < 0 || bill > 2000)
			System.out.println("Error! Bill must be between 0 and $2000");
		else
		{
			System.out.print("Enter the number of people in your party:");
			int people = scan.nextInt();

			System.out.println("Each person owes $" + bill/people);
		}

		scan.close();
	}
}
