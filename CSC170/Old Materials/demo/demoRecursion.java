public class demoRecursion
{
	public static void main(String[] args)
	{
		demoRecursion demo = new demoRecursion();
		demo.showIt(); 
	}

	private void showIt()
	{
		System.out.println("2^4 equals " + power(2, 4));	//16
		System.out.println("7^10 equals " + power(7, 10));	//282,475,249
		System.out.println();
		System.out.println("Fib(3) equals " + fib(4));		//3
		System.out.println("Fib(10) equals " + fib(10));	//55
		System.out.println("Fib(25) equals " + fib(25));	//75,025
		System.out.println("Fib(45) equals " + fib(45));	//1,134,903,170 (takes about 6 seconds!)
		System.out.println();
		System.out.println("Fib(3) equals " + fibBetter(3,1,1));		//2
		System.out.println("Fib(10) equals " + fibBetter(10,1,1));	//55
		System.out.println("Fib(25) equals " + fibBetter(25,1,1));	//75,025
		System.out.println("Fib(45) equals " + fibBetter(45,1,1));	//1,134,903,170
		System.out.println("Fib(45) equals " + fibBetter(1000000,1,1));	//1,134,903,170
	}

	//purpose: Recursively compute x^n.
	//assumptions: None.
	//inputs: x and n are integers.
	//post-conditions: returns x^n.
	public int power(int x, int n)
	{
		int answer;
		if (n > 0)
			answer = power(x,n-1)*x;
		else
			answer = 1;

		return answer;
	}

	//purpose: Recursively compute the Fibonacci(n).
	//assumptions: Fib(0)=0; Fib(1)=1; Fib(n)=Fib(n-1)+Fib(n-2) for n>1.
	//inputs: n
	//post-conditions: returns Fib(n) for any n>=0.
	public int fib(int n)
	{
		int fib_nMinus1,fib_nMinus2,fib_n;

		if (n > 1)
		{
			fib_nMinus1 = fib(n-1);
			fib_nMinus2 = fib(n-2);
			fib_n = fib_nMinus1 + fib_nMinus2;
		}
		else
			fib_n = n;

		return fib_n;
	}

	//purpose: Recursively compute the Fibonacci(n).
	//assumptions: Fib(0)=0; Fib(1)=1; Fib(n)=Fib(n-1)+Fib(n-2) for n>1.
	//inputs: n
	//			 curr - the current Fibonacci number.
	//			 prev - the previous Fibonacci number.
	//post-conditions: returns Fib(n) for any n>=0.
	public int fibBetter(int n, int curr, int prev)
	{
		int fib_n;

		if (n < 3)
			fib_n = curr;
		else
			fib_n = fibBetter(n - 1, curr + prev, curr);

		return fib_n;
	}
}
