public class IncorrectMethodImplementation {
  public static void main(String[] args) {
    System.out.printf("%15s%15s\n", "n", "m(n)");
    System.out.println("-------------------------------------------");
    for (int n = 1; n <= 10; n++) {
      double result = 0;
      for (int i = 1; i <= n; i++) {
        result += m(i);
      }
      System.out.printf("%15d%15.2f\n", n, result);
    }
  }

  public static double m(int n) {
    return (2 * n + 1.0) / (3 * n - 2);
  }
}
