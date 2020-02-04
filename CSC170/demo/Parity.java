import java.util.Scanner;

class Parity
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter an integer:");
        int num = scan.nextInt();
     	if(isOdd(num)){
		System.out.println("The number is odd.");
	}
	else{
		System.out.println("The number is even.");
	}
    }
    public static boolean isOdd(int num){
    	return num%2==1;
    }
}
