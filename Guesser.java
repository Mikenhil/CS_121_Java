/*
 * Algorithm
 *
 * Needed Imports (java.util.*)
 * 
 * DECLARE CLASS Guesser
 *  DECLARE main_method()
 *    INSTANTIATE CLASS Guesser()
 *    
 *  DECLARE CONSTRUCTOR Guesser()
 *    CALL mainLoop()
 *
 *  DECLARE METHOD mainLoop()
 *    DECLARE VARIABLE boolean keepGoing Assign true
 *    WHILELOOP keepGoing Equals true
 *      SHOWMENU (0 = Exit, 1 = Human, 2 = Computer)
 *      PROMPT_INPUT_STRING selection(0-2)
 *
 *      IF selection Equals "0"
 *        SET keepGoing false
 *        PRINT "Exiting game"
 *
 *      ELSE IF selection Equals "1"
 *        CALL playerGameLoop()
 *
 *      ELSE IF selection Equals "2"
 *        CALL computerGameLoop()
 *
 *      ELSE
 *        PRINT "Invalid Input. Try again."
 *
 *  DECLARE METHOD playerGameLoop()
 *    PRINT "Human Guesser"
 *    DECLARE VARIABLE boolean keepGoing Equals true
 *    
 *    DECLARE VARIABLE RandomInt correct Equals RandomRange(1-100)
 *
 *    WHILELOOP keepGoing Equals true
 *      PROMPT_INPUT_NextInt  "Please enter a number: " -> inputInt
 *      
 *      IF inputInt > correct
 *        PRINT "Too high"
 *
 *      ELSE IF inputInt < correct
 *        PRINT "Too low"
 *
 *      Else IF inputInt == correct
 *        PRINT "Got it!"
 *        SET keepGoing false
 *
 *  DECLARE METHOD computerGameLoop()
 *    PRINT "Computer Guesser"
 *
 *
 */


import java.util.*;

public class Guesser {

  public static void main(String[] args) {

    new Guesser();
  }

  public Guesser() {
    mainLoop();
  }

  void mainLoop() {

    boolean keepGoing = true;
    while(keepGoing) {
      Scanner scanner = new Scanner(System.in);

      System.out.println("0) Exit");
      System.out.println("1) Human Guesser");
      System.out.println("2) Computer Guesser\n");

      System.out.print("Please enter 0-2: ");
      String selection = scanner.nextLine();

      if(selection.equals("0")){
        keepGoing = false;
      }
      else if(selection.equals("1"))
        playerGameLoop();
      else if(selection.equals("2"))
        computerGameLoop();
      else
        System.out.println("Invalid input. Try again.");
    }
  }

  void playerGameLoop() {
    System.out.println("Human Guesser\n");
    // w3Schools example of RandomRange(0-100)
    int correct = (int)(Math.random() * 101);
    System.out.println("Correct number: " + correct);

    int turns = 0;

    boolean keepGoing = true;
    while(keepGoing) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Please enter a number: ");
      int inputInt = scanner.nextInt();

      if(inputInt > correct)
        System.out.println(turns + ") Too high.");
      else if(inputInt < correct)
        System.out.println(turns + ") Too low.");
      else {
        System.out.println(turns + ") Got it!");
        keepGoing = false;
      }

      turns++;
    }
  }

  void computerGameLoop() {
    Scanner correctScanner = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int correct = correctScanner.nextInt();

    int turns = 0;

    boolean keepGoing = true;
    int upperbound = 100;
    int lowerbound = 0;
    int last_guess = -1;
    String last_answer = "";
    while(keepGoing) {
      int guess = 0;
      if(last_answer.equals("l")) {
        lowerbound = last_guess;
        guess = (upperbound + last_guess) / 2;
      }

      else if(last_answer.equals("h")) {
        upperbound = last_guess;
        guess = (lowerbound + last_guess) / 2;
      }

      else if(turns == 0) {
        guess = 50;
      }

      System.out.println(turns + ") I choose " + guess);

      Scanner guessScanner = new Scanner(System.in);
      last_answer = guessScanner.nextLine();
  
      if(last_answer.equals("c")) {
        keepGoing = false;
      }
      else {
        last_guess = guess;
        turns++;
      }
    }
  }
}
