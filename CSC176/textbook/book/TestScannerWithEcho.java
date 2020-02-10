import java.util.Scanner; // Scanner is in java.util

public class TestScannerWithEcho {
  public static void main(String args[]) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter an integer
    System.out.print("Enter an integer (does not echo): ");
    int intValue = input.nextInt();
    System.out.println("You entered the integer " + intValue);

    // Prompt the user to enter a double value
    System.out.print("Enter a double value: ");
    double doubleValue = input.nextDouble();
    System.out.println("You entered the double value "
      + doubleValue);

    // Prompt the user to enter a string
    System.out.print("Enter a string (whole line): ");
    String line = input.nextLine();
    System.out.println("You entered the string " + line);

    // Prompt the user to enter a float
    System.out.print("Enter a float: ");
    float f = input.nextFloat();
    System.out.println("You entered the float " + f);

    // Prompt the user to enter a byte
    System.out.print("Enter a short: ");
    byte b = input.nextByte();
    System.out.println("You entered the short " + b);

    // Prompt the user to enter a short
    System.out.print("Enter a short: ");
    short n = input.nextShort();
    System.out.println("You entered the short " + n);

    // Prompt the user to enter a string
    System.out.print("Enter a string without space: ");
    String string = input.next();
    System.out.println("You entered the string " + string);
  }
}
