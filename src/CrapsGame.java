import java.util.Scanner;
import java.util.Random;
public class CrapsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int diceOne;
        int diceTwo;
        int rollSum;
        int rollSumNew = 0;
        int reRollCount = 1;
        String yesOrNo;
        boolean yesOrNoValid = false;
        boolean playAgain = false;

        System.out.println("If the sum is 2, 3, or 12 it is called \"craps\" or \"crapping out\" and the game is over with a loss.");
        System.out.println("If the sum is 7 or 11 it is called a \"natural\" and the game is over with a win.");
        System.out.println("For all other values, the sum becomes \"the point\" and the user makes subsequent rolls until they either roll a 7, in which case they lose, or they roll the point sum in which case they win.");
        System.out.println();

        do {
            diceOne = rand.nextInt(6) + 1;
            diceTwo = rand.nextInt(6) + 1;
            rollSum = diceOne + diceTwo;

            System.out.println("Roll 1: " + diceOne);
            System.out.println("Roll 2: " + diceTwo);
            System.out.println("Sum of Rolls: " + rollSum);
            System.out.println();

            if (rollSum == 2 || rollSum == 3 || rollSum == 12) {
                System.out.println("Sorry, you crapped out");
            }
            else if (rollSum == 7 || rollSum == 11) {
                System.out.println("You win by a natural");
            }
            else {

                while(rollSumNew != 7 && rollSumNew != rollSum) {
                    diceOne = rand.nextInt(6) + 1;
                    diceTwo = rand.nextInt(6) + 1;
                    rollSumNew = diceOne + diceTwo;
                    System.out.println("Re-roll " + reRollCount + ", you must get a " + rollSum + " to win, and a 7 to lose");
                    System.out.println("Roll 1: " + diceOne);
                    System.out.println("Roll 2: " + diceTwo);
                    System.out.println("Sum: " + rollSumNew);
                    System.out.println();
                    reRollCount++;
                }

                if (rollSumNew == 7) {
                    System.out.println("Sorry, you crapped out");
                }
                else {
                    System.out.println("You win by a point");
                }
            }

            do {
                System.out.println();
                System.out.println("Want to play again? [Y/N]");
                yesOrNo = scan.nextLine();
                if (yesOrNo.equalsIgnoreCase("y")) {
                    playAgain = true;
                    yesOrNoValid = true;
                    rollSumNew = 0;
                    reRollCount = 1;
                } else if (yesOrNo.equalsIgnoreCase("n")) {
                    playAgain = false;
                    yesOrNoValid = true;
                    System.out.println("Game Ended");
                } else {
                    playAgain = false;
                    yesOrNoValid = false;
                    System.out.println("Invalid Input");
                }
            } while(!yesOrNoValid);
        } while (playAgain);
    }
}