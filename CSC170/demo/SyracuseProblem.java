import java.util.Scanner;

public class SyracuseProblem{
    public static void main(String[] args)
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter a positive integer");
        int n = scan.nextInt();
        threeNP1(n);
    }
    public static void threeNP1(int n)
    {
        while(true)
        {
            System.out.println("The number is now "+ n);
            if (n==1)
            {
                break;
            }
            if (n%2==0)
            {
                n=n/2;
            }
            else
            {
                n = n*3 +1;
            }
        }

    }
}