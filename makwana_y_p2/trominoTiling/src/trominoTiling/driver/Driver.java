package trominoTiling.driver;

import java.util.Scanner;
import trominoTiling.utils.ExceptionHandler;
public class Driver{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int board_size;
        System.out.println("Please enter size of board (0 to quit):");
        board_size = sc.nextInt();

        if(board_size == 0){
            System.out.println("Program exiting....");
            System.exit(1);
        } else if (board_size < 0) {
            ExceptionHandler.handleException(null, "Board size cannot be negative.");
        }

        System.out.println("Please enter coordinates of missing square (separate by a space):");
        String inputString = sc.next();
        String[] iStrings = inputString.split(" ");
        int x_missing = iStrings[0];
        int y_missing = iStrings[1];

        if (x_missing < 0 || y_missing < 0) {
            System.out.println("Missing coordinate cannot be negative.");
        }

        
        sc.close();
    }
}