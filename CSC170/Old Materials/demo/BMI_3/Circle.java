import java.util.Scanner;

public class Circle
{
	
	public static void main(String[] args)
	{
		
		System.out.println("Enter the radius: ");

		Scanner scan = new Scanner(System.in);
		int radius = scan.nextInt();

		System.out.println("The radius: "+ radius);
	}
}
