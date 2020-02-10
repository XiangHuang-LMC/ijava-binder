package chapter38;

public class GuessNumberBean {
  final static int MAX = 1000;
  private int guess; // Entered from the form by the user
  private int target = 0;
  
  public GuessNumberBean() {
    target = (int)(Math.random() * MAX + 1);
  }
  
  public int getGuess() {
    return guess;
  }

  public boolean isGuessValid() {
    return guess < MAX && guess > 0;
  }

  public void setGuess(int number) {
    this.guess = number;
  }
  
  public String getResponse() {
    if (guess < target)
      return "Too low";
    else if (guess > target)
      return "Too high";
    else 
      return "You got it!";
  }
}
