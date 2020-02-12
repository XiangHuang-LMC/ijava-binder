import java.util.Scanner;

public class demoStringCount
{
	private Scanner scan;

	public static void main(String[] args)
	{
		demoStringCount demo = new demoStringCount();
		demo.tryThis();
	}
	public demoStringCount()
	{
		scan = new Scanner(System.in);
	}
	
	private void tryThis()
	{
		int vowels = 0;
		String inputData = getTextLine();
		//char aChar = getCharacter();
		for (int idx=0; idx<inputData.length(); idx++)
		{
			if (inputData.charAt(idx) == 'a')
				vowels++;
			else if (inputData.charAt(idx) == 'e')
				vowels++;
			else if (inputData.charAt(idx) == 'i')
				vowels++;
			else if (inputData.charAt(idx) == 'o')
				vowels++;
			else if (inputData.charAt(idx) == 'u')
				vowels++;
			else if (inputData.charAt(idx) == 'y')
				vowels++;
		}
		System.out.println(vowels);
	}
	
	private String getTextLine()
	{
		System.out.print("Enter anything: ");
		String data = scan.nextLine();
		return data;
	}
	
	private char getCharacter()
	{
		char aCharacter = 0;
		while (aCharacter == 0)
		{
			System.out.print("Enter a character: ");
			String data = scan.next();
			if (data.length() >= 1)
				aCharacter = data.charAt(0);
			else
				aCharacter = 0;
		}
			
		return aCharacter;
	}
}
