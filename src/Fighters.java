import java.util.Scanner;
import java.util.Random;

public class Fighters {

    public static void main(String[] args) {

        int white = 100;
        int black = 100;
        int player = 100;
        boolean goodname = false;
        boolean goodmove = false;
        boolean playerTurn = true; // player always goes first
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Black VS White");

        do {
            System.out.println("Choose Your Character: Black / White");
            String inputChar = scan.next();

            if (inputChar.equalsIgnoreCase("white")) {
                player = white;
                goodname = true;
                System.out.println("");
                System.out.println("You are now " + inputChar);
            } else if (inputChar.equalsIgnoreCase("black")) {
                player = black;
                goodname = true;
                System.out.println("");
                System.out.println("You are now " + inputChar);
            } else {
                goodname = false;
                System.out.println("You cannot be that character!");
            }

        } while (goodname == false);

        int turnCount = 1;
        while (white > 0 && black > 0) { // keep playing until one of the players reaches 0 health
            System.out.println("Turn " + turnCount + ":");
            turnCount++;

            if (playerTurn) {
                do {
                    System.out.println("Choose Your Move: Punch / Kick");
                    String[] moves = {"punch", "kick"};
                    String inputMove = scan.next();

                    if (inputMove.equalsIgnoreCase(moves[0])) {
                        if (player == white) {
                            int randomdmg = random.nextInt(70) + 1;
                            black = black - randomdmg;
                            System.out.println("");
                            System.out.println("You punched Black for " + randomdmg + " damage!");
                            System.out.println("Opponent has " + black + " health remaining.");
                            System.out.println("");
                            goodmove = true;

                        } else if (player == black) {
                            int randompunchdmg = random.nextInt(70) + 1;
                            white = white - randompunchdmg;
                            System.out.println("");
                            System.out.println("You punched White for " + randompunchdmg + " damage!");
                            System.out.println("Opponent has " + white + " health remaining.");
                            System.out.println("");
                            goodmove = true;
                        }

                    } else if (inputMove.equalsIgnoreCase(moves[1])) {
                        if (player == white) {
                            int randomkickdmg = random.nextInt(40) + 1;
                            black = black - randomkickdmg;
                            System.out.println("");
                            System.out.println("You kicked Black for " + randomkickdmg + " damage!");
                            System.out.println("Opponent has " + black + " health remaining.");
                            System.out.println("");
                            goodmove = true;

                        } else if (player == black) {
                            int randomkickdmg = random.nextInt(40) + 1;
                            white = white - randomkickdmg;
                            System.out.println("");
                            System.out.println("You kicked White for " + randomkickdmg + " damage!");
                            System.out.println("Opponent has " + white + " health remaining.");
                            System.out.println("");
                            goodmove = true;
                        }

                    } else {
                        System.out.println("That's not a move!");
                        goodmove = false;
                    }

                } while (goodmove == false);
                

            }
        }
        
        scan.close();
        
    }
}