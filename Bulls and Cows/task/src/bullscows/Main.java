// Java program for the "Bulls and Cows" secret code guessing game

/**
 * The program asks the player to enter length and number of alphanumeric characters.
 * The player is supposed to guess the code.
 * If the guessed character is anywhere in the secret code, its termed as a 'cow'
 * and if the character is in the secret code and has a same place value, it is termed as a 'bull'!
 * The program catches all the exceptions and doesnt through any error!
 * Sounds interesting, is'nt it?..Give it a try....
 * ************************************************************************************************
 * @author: Siddhesh Sule, Radolfzell, Germany.
 *
 * * */

package bullscows;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
        public static String playerInput;
        private static Integer codeLength;
        private static Integer charLength;
        private static Integer turnCount;
        public static Boolean isGameOn;
        private static String secretCode;
        private static Integer countBulls;
        private static Integer countCows;
        private static Boolean isCodeLengthRight;
        private static String alphaNumeric = "0123456789abcdefghijklmnopqrstuvwxyz";

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            isCodeLengthRight = true;

            while (isCodeLengthRight) {
                System.out.println("Please, enter the secret code's length:");
                try {
                    codeLength = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter valid input.");
                    System.exit(0);
                }
                if (codeLength > 0 && codeLength <= 36) {
                    System.out.println("Input the number of possible symbols in the code:");
                    charLength = scanner.nextInt();
                    if (codeLength > charLength || charLength > 36) {
                        System.out.println("Error: it's not possible to generate a code with a length of " +
                                codeLength + " with "+ charLength +
                                " unique symbols.");
                        System.exit(0);
                    } else {
                        secretCode = generateCode();
                        isCodeLengthRight = false;
                    }
                } else if (codeLength > 36) {
                    System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                    System.exit(0);
                } else if (codeLength < 0) {
                    System.out.println("Error: Length of secret code cannot be zero! ");
                    System.exit(0);

                } else {
                    System.out.println("Error: " + codeLength + " isn't a valid number.");
                    System.exit(0);
                }
            }
            secretCodeMessage();
            System.out.println("Okay, let's start a game!");
            isGameOn = true;
            turnCount = 1;
            while (isGameOn) {
                System.out.println("Turn " + turnCount + ":");
                playerInput = scanner.next();
                countBulls = countBulls();
                countCows = countCows();
                turnCount++;
                displayGrade();
           }
    }
    /** This method uses the counts of bull and cows and displays the grade.
     * @param: No parameters
     * @return: Does'nt return anything. Its prints the grading only.
     * */
    private static void displayGrade() {
        if (countBulls == codeLength) {
            System.out.println("Grade: " + countBulls + " bulls");
            System.out.println("Congratulations! You guessed the secret code.");
            isGameOn = false;
        } else if(countBulls > 1 && countCows == 0) {
            System.out.println("Grade: " + countBulls + " bulls");
        } else if (countBulls > 1 && countCows == 1) {
            System.out.println("Grade: " + countBulls + " bulls and " + countCows + " cow");
        } else if (countBulls == 1 && countCows == 1) {
            System.out.println("Grade: " + countBulls + " bull and " + countCows + " cow");
        } else if (countBulls == 1 && countCows > 1) {
            System.out.println("Grade: " + countBulls + " bull and " + countCows + " cows");
        } else if (countCows > 1 && countBulls == 0) {
            System.out.println("Grade: " + countCows + " cows");
        } else {
            System.out.println("None.");
        }
    }

    /** This method counts the number of cows.
     * @param: No parameters
     * @return: Returns the integer count of cows.
     * */
    private static Integer countCows() {
        Integer count = 0;
        for (int i = 0; i < secretCode.length(); ++i) {
            for (int j = 0; j < secretCode.length(); ++j) {
                if (secretCode.charAt(j) == playerInput.charAt(i)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    /** This method counts the number of bulls.
     * @param: No parameters
     * @return: Returns the integer count of bulls.
     * */
    private static Integer countBulls() {
            Integer count = 0;
            for (int i = 0; i < secretCode.length(); ++i) {
                if(playerInput.charAt(i) == secretCode.charAt(i)) {
                    count += 1;
                }
            }
            return count;
    }

    /** This method generates the secret code.
     * @param: No parameters
     * @return: Returns the String of Secret Code.
     * */
    private static String generateCode() {
        //long randomNum = System.nanoTime();
        Random random = new Random();
        long randomNum = random.nextLong();
        String[] alphaNumericSet = String.valueOf(randomNum).split("");
        StringBuilder number = new StringBuilder();
        for (int i = alphaNumericSet.length - 1; i > 0; --i) {
                if(!(number.toString().contains(alphaNumericSet[i]))) {
                    number.append(alphaNumericSet[i]);
                }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < codeLength; i++) {
            result.append(number.charAt(i));
        }
        try{
            if(result.length() == 0) {
                return generateCode();
            } else {
                return result.toString();
            }
        } catch (StackOverflowError e) {
            return ("Error: Stack Over Flow due to recursive generate code.");
        }
    }

    /** This method prints a customized secret code message.
     * @param: No parameters
     * @return: Doesnt return anything. Its prints the secret code message.
     * */
    private static void secretCodeMessage() {
        String asterics = "";
        char upperAlpha = ' ';
        for (int i = 0; i < codeLength; ++i) {
            asterics += "*";
        }
        upperAlpha = alphaNumeric.charAt(charLength - 1);
        System.out.println("The secret is prepared: " + asterics + " (0-9, a-" + upperAlpha +").");

    }

}