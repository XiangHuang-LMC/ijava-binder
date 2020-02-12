import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class demoInputFileAndOutputFile
{
	Scanner userInput;
	Scanner inFile;
	PrintWriter outFile;

	public static void main(String[] args)
	{
		demoInputFileAndOutputFile demo = new demoInputFileAndOutputFile();
		demo.doIt();
	}

	private demoInputFileAndOutputFile()
	{
		userInput = new Scanner(System.in);

		//get name of input file from user
		System.out.print("Enter input filename: ");
		String inFileName = userInput.nextLine();
		
		userInput.close();

		openFiles(inFileName);
	}

	private void doIt()
	{
		if (inFile != null && outFile != null)
		{
			//Put each token on a separate line when writing to output file.
			while(inFile.hasNext())
			{
			   String token = inFile.next();
				outFile.println(token);
			}	
			inFile.close();
			outFile.close();
		}
	}

	private void openFiles(String inFileName)
	{
		try
		{
			//open input file
			inFile = new Scanner(new File(inFileName));
			//create output file
			outFile = new PrintWriter(new FileWriter("OUT_" + inFileName));
		}
		catch (Exception ex)
		{
			System.out.println("ERROR! Exception occured when creating file objects:");
			System.out.println(ex);

			inFile = null;
			outFile = null;
		}
	}
}
