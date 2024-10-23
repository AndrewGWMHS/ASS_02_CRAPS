import java.util.Queue;
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

        int money = 1000000;
        int moneySpending = 0;
        boolean moneyValid = false;

        System.out.println("If the sum is 2, 3, or 12 it is called \"craps\" or \"crapping out\" and the game is over with a loss.");
        System.out.println("If the sum is 7 or 11 it is called a \"natural\" and the game is over with a win.");
        System.out.println("For all other values, the sum becomes \"the point\" and the user makes subsequent rolls until they either roll a 7, in which case they lose, or they roll the point sum in which case they win.");
        System.out.println();


        do {
            do {
                System.out.println("You have $" + money);
                System.out.println();
                System.out.println("How much do you want to bet?");
                if (scan.hasNextInt()) {
                    moneySpending = scan.nextInt();
                    if (moneySpending >= 0 && moneySpending <= money) {
                        moneyValid = true;
                    }
                    else {
                        System.out.println("Invalid range for money");

                    }
                 }

                else {
                    System.out.println("Invalid data type");
                }
                scan.nextLine();
            } while (!moneyValid);
            diceOne = rand.nextInt(6) + 1;
            diceTwo = rand.nextInt(6) + 1;
            rollSum = diceOne + diceTwo;

            System.out.println("Roll 1: " + diceOne);
            System.out.println("Roll 2: " + diceTwo);
            System.out.println("Sum of Rolls: " + rollSum);
            System.out.println();

            if (rollSum == 2 || rollSum == 3 || rollSum == 12) {
                System.out.println("Sorry, you crapped out");
                money -= moneySpending;
                System.out.println("You lost $" + moneySpending);
            }
            else if (rollSum == 7 || rollSum == 11) {
                System.out.println("You win by a natural");
                money += moneySpending*2;
                System.out.println("You won $" + moneySpending*2);
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
                    money -= moneySpending;
                    System.out.println("You lost $" + moneySpending);
                }
                else {
                    System.out.println("You win by a point");
                    money += moneySpending*2;
                    System.out.println("You won $" + moneySpending*2);
                }
            }

            System.out.println("You have $" + money);
            do {
                System.out.println();
                System.out.println("Want to play again? [Y/N]");
                yesOrNo = scan.nextLine();
                if (yesOrNo.equalsIgnoreCase("y")) {
                    playAgain = true;
                    yesOrNoValid = true;
                    rollSumNew = 0;
                    reRollCount = 1;
                    moneySpending = 0;
                    moneyValid = false;
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