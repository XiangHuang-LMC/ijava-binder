import java.util.Scanner;

class AssignmentOne{
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        double diameter= getNextDouble("Enter the diameter", scan);
        System.out.println("The area of the circle is:"+ circleArea(diameter)); 
    }
    public static double getNextDouble(String msg, Scanner scan)
    {
        System.out.println(msg);
        return scan.nextDouble();
    }
    public static double circleArea(double diameter) {
        return Math.PI*diameter*diameter/4;
    }
    public static double squareArea() {
        
    }
    
}