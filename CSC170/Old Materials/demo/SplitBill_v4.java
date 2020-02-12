import java.util.Scanner;

public class SplitBill_v4
{
	public static void main(String [] args)
	{
		SplitBill_v4 sb = new SplitBill_v4();
		sb.computeBill();
	}

	public SplitBill_v4()
	{
	}

	private void computeBill()
	{
		Scanner scan = new Scanner(System.in);

		double bill = getBill(scan);
		double people = getPeople(scan);

		if (bill!= -1 && people != -1)
			System.out.println("Each person owes $" + bill/people);

		scan.close();
	}

	private double getBill(Scanner scan)
	{
		double bill;
		System.out.print("Enter the total bill:");
		if(scan.hasNextDouble())
			bill = scan.nextDouble();
		else
		{
			scan.next(); //skip over incorrect input
			bill = -1;
		}

		if (bill < 0 || bill > 2000)
		{
			System.out.println("Error! Bill must be a number between 0 and $2000");
			bill = -1;
		}
		return bill;
	}

	private double getPeople(Scanner scan)
	{
		int people;
		System.out.print("Enter the number of people in your party:");
		if(scan.hasNextInt())
			people = scan.nextInt();
		else
		{
			scan.next(); //skip over incorrect input
			people = -1;
		}

		if (people < 1 || people > 10)
		{
			System.out.println("Error! Party must be an integer between 1 and 10");
			people = -1;
		}
		return people;
	}
}
