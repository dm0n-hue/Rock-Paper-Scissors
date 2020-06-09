package rpsgame;

import java.util.*;
public class RPSGame {

    public static String genOpChoice(Random random) {
        int opNum;
        opNum = random.nextInt(3)+1;
        String opChoice = "";
        
        if (opNum==1) {
            opChoice = "Rock";
        }
        else if (opNum==2) {
            opChoice = "Paper";
        }
        else if (opNum==3) {
            opChoice = "Scissors";
        }
        return opChoice;
    }
    
    public static void showMenu() {
        System.out.println("Your options:\n1. Rock\n2. Paper\n3. Scissors");
    }
    
    public static String getUser(Scanner scanner) {
        String userChoice;
        
        System.out.println("\nWelcome to Rock-Paper-Scissors!"
                + "\nChoose one of the three choices displayed");
        userChoice = scanner.nextLine();
        
        return userChoice;
    }
    
    public static String chooseWinner(String opChoice, String userChoice) {
        String winner = "\nInvalid answer. Try again.";
        
        if (opChoice.equals("Rock") && userChoice.equalsIgnoreCase("Rock"))
            winner = "It's a tie";
        if (opChoice.equals("Scissors") && userChoice.equalsIgnoreCase("Scissors"))
            winner = "It's a tie";
        if (opChoice.equals("Paper") && userChoice.equalsIgnoreCase("Paper"))
            winner = "It's a tie";
        
        if (opChoice.equals("Rock") && userChoice.equalsIgnoreCase("Scissors"))
            winner = "The computer is the winner";
        else if (opChoice.equals("Scissors") && userChoice.equalsIgnoreCase("Rock"))
            winner = "You are the winner";
        
        if (opChoice.equals("Scissors") && userChoice.equalsIgnoreCase("Paper"))
            winner = "The computer is the winner";
        else if (opChoice.equals("Paper") && userChoice.equalsIgnoreCase("Scissors"))
            winner = "You are the winner";
        
        if (opChoice.equals("Paper") && userChoice.equalsIgnoreCase("Rock"))
            winner = "The computer is the winner";
        else if (opChoice.equals("Rock") && userChoice.equalsIgnoreCase("Paper"))
            winner = "You are the winner";
        
        return winner;
    }
    
    public static void main(String[] args) {
    
        int win, loss, tie;
        boolean playAgain = true;
        
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        String opChoice, userChoice;

        win = 0;
        loss = 0;
        tie = 0;
            
        showMenu();
            
            while (playAgain) {
                
                opChoice = genOpChoice(random);
                
                userChoice = getUser(scan);
                System.out.println("");
                
                if (chooseWinner(opChoice, userChoice).equals("The computer is the winner"))
                    loss++;
                else if (chooseWinner(opChoice, userChoice).equals("You are the winner"))
                    win++;
                else if (chooseWinner(opChoice, userChoice).equals("It's a tie"))
                    tie++;
        
                System.out.println("You chose " + userChoice
                        + "\nThe computer chose " + opChoice);
                System.out.println(chooseWinner(opChoice, userChoice) + "\n"
                + "\nWins: " + win +"\nLosses: " + loss + "\nTies: " + tie);
                
                System.out.println("");
                System.out.println("Would you like to play again? (y/n)");
                String input = scan.nextLine();
                
                if (input.equalsIgnoreCase("n")) {
                    playAgain = false;
                }
            }
        System.out.println("\nThank you for playing!");
    }
}