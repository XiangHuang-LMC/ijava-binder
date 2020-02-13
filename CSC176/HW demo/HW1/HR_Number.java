class HR_Number
{
    public static void main(String[] args) {
        int n=2;
        while (false == isHR_number(n++));
        System.out.println("The smalls HR-number is: " + --n);
    }
    public static boolean isHR_number(int n) {
        int upper_bound = (int)(Math.pow(n, 1.0/ 3)) + 1;
        int counter = 0;
        for(int x=1;x< upper_bound;x++)
        {
            for(int y=x;y< upper_bound;y++)
            {
                if (x*x*x + y*y*y == n)
                    counter += 1;
            }
            
        }       
    return counter == 2;

    }
}