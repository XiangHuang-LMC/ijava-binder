package debug_demo;
public class HR_Number{
  public static void main(String[] args) {
    int n=2;
    while ( isHRNumber(n)== false)
    {
        n++;
    }
    
    System.out.println("The smallest numbers that can be written into two cubes is "+ n +".");
  }

  public static boolean isHRNumber(int n)
  {
      int upper_bound = (int)Math.round(Math.pow(n, 1.0/3))+1;
      int counter =0;
      for (int x=1; x<= upper_bound; x++)
      {
          for (int y=x; y<=upper_bound; y++)//change this to x++ and see what happen.
          {
              if (x*x*x + y*y*y ==n)
              {
                  counter +=1;
              }
          }
      }
      return counter == 2;
  }
}