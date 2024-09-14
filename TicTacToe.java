package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        //Print out an empty grid
        System.out.println("""
                ---------
                |       |
                |       |
                |       |
                ---------""");
        char[][] ticTac = new char[3][3];
        for(int i = 0; i < ticTac.length; i++){
            for(int j = 0; j < ticTac[i].length; j++){
                ticTac[i][j] = '_';
            }
        }
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Enter cells: ");
        char[] input = sc.next().toCharArray(); // Store your inputs as an array of chars

        int charCounter = 0;

        // Convert 1D to 2D array
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                ticTac[x][y] = input[charCounter++];
            }

        }*/
        printGrid(ticTac);


        // Determine the state of the game
        chooseAction(ticTac);
    }

    //A method to print the current state of the game
    static void printGrid(char[][] ticTac) {
        System.out.println("---------");
        for (int x = 0; x < 3; x++) {
            System.out.print("| ");
            for (int y = 0; y < 3; y++) {
                System.out.print(ticTac[x][y] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");


    }


    static void chooseAction(char[][] ticTac) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X'; //This is the requirement for the beginning player
        boolean gameWon = false;
        int moveCount = 0;

        while(!gameWon && moveCount < 9) {
            printGrid(ticTac);
            boolean validInput = false;

            //Input loop for current player
            while (!validInput) {
                try {
                    int row = sc.nextInt();
                    int col = sc.nextInt();

                    //Validate the coordinates
                    if (row < 1 || row > 3 || col < 1 || col > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (ticTac[row - 1][col - 1] != '_') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        ticTac[row - 1][col - 1] = currentPlayer;
                        validInput = true;
                        moveCount++;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                    sc.nextLine(); //Clear invalid input
                }

            }

            //Check if the current player has won
            char winner = winner(ticTac);
            if (winner == 'X' || winner == 'O') {
                printGrid((ticTac));
                System.out.println(winner + " wins");
                gameWon = true;
            } else if (moveCount == 9) {
                printGrid(ticTac);
                System.out.println("Draw");
                gameWon = true;
            }

            //Switch to the next player if the game is not over
            if (!gameWon) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }


    }

    //Method to determine the winner (X or O) or check if there's no winner yet
    static char winner(char[][] ticTac) {
        // Check if X or O has won
        char xWinner = winnerForChar(ticTac, 'X');
        char oWinner = winnerForChar(ticTac, 'O');

        if (xWinner == 'X') {
            return 'X'; // X wins
        } else if (oWinner == 'O') {
            return 'O'; // O wins
        }

        return ' '; // No winner
    }


    // Check if the game state is impossible (invalid state)
    static boolean isImpossible(char[][] ticTac) {
        int xCount = 0;
        int oCount = 0;

        // Count the number of X's and O's
        for (char[] chars : ticTac) {
            for (char aChar : chars) {
                if (aChar == 'X') {
                    xCount++;
                } else if (aChar == 'O') {
                    oCount++;
                }
            }
        }

        // Check if the count difference is invalid
        if (Math.abs(xCount - oCount) > 1) {
            return true; // Invalid number of X's and O's
        }

        // Check if both X and O have won (which is impossible)
        boolean xWins = winnerForChar(ticTac, 'X') == 'X';
        boolean oWins = winnerForChar(ticTac, 'O') == 'O';

        // Both X and O cannot win at the same time
        return xWins && oWins; // Valid game state
    }

    // Method to check if a specific player (X or O) has won
    static char winnerForChar(char[][] ticTac, char player) {
        for (int i = 0; i < 3; i++) {
            // Check rows for a win
            if (ticTac[i][0] == player && ticTac[i][1] == player && ticTac[i][2] == player) {
                return player;
            }
            // Check columns for a win
            if (ticTac[0][i] == player && ticTac[1][i] == player && ticTac[2][i] == player ) {
                return player;
            }
        }
        // Check diagonals for a win
        if (ticTac[0][0] == player && ticTac[1][1] == player && ticTac[2][2] == player ) {
            return player;
        }
        if (ticTac[0][2] == player && ticTac[1][1] == player && ticTac[2][0] == player) {
            return player;
        }

        return ' '; // No win for this player
    }
}
