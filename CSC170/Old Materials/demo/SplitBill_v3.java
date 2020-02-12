import java.util.Scanner;

public class SplitBill_v3
{
	public static void main(String [] args)
	{
		SplitBill_v3 sb = new SplitBill_v3();
		sb.computeBill();
	}

	public SplitBill_v3()
	{
	}

	private void computeBill()
	{
		Scanner scan = new Scanner(System.in);

		double bill = getBill(scan);
		int people = getPeople(scan);

		if (bill != -1 && people != -1)
			System.out.println("Each person owes $" + bill/people);

		scan.close();
	}

	private double getBill(Scanner scan)
	{
		System.out.print("Enter the total bill:");
		double bill = scan.nextDouble();
		if (bill < 0 || bill > 2000)
		{
			System.out.println("Error! Bill must be between 0 and $2000");
			bill = -1;
		}
		return bill;
	}

	private int getPeople(Scanner scan)
	{
		System.out.print("Enter the number of people in your party:");
		int people = scan.nextInt();
		if (people < 1 || people > 10)
		{
			System.out.println("Error! Party must be between 1 and 10");
			people = -1;
		}
		return people;
	}
}
