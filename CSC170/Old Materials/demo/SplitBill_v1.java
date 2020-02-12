import java.util.Scanner;

public class SplitBill_v1
{
	public static void main(String [] args)
	{
		SplitBill_v1 sb = new SplitBill_v1();
		sb.computeBill();
	}

	public SplitBill_v1()
	{
	}

	public void computeBill()
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the total bill:");
		double bill = scan.nextDouble();

		System.out.print("Enter the number of people in your party:");
		int people = scan.nextInt();

		System.out.println("Each person owes $" + bill/people);

		scan.close();
	}
}
