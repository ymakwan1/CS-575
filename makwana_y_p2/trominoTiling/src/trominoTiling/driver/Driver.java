package trominoTiling.driver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import trominoTiling.utils.ExceptionHandler;
import trominoTiling.tromino.Tromino;

/**
 * It takes in the size of the board, the coordinates of the missing square, and then creates a Tromino
 * object with the appropriate parameters
 */
public class Driver{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int board_size;

        // It's asking the user to enter the size of the board. It's then converting the input to an
        // integer.
        System.out.println("Please enter size of board (0 to quit):");
        board_size = Integer.parseInt(bufferedReader.readLine());

        // It's checking if the board size is 0 or negative. If it is, then it's printing out an error
        // message and exiting the program.
        if(board_size == 0){
            System.out.println("Program exiting....");
            System.exit(1);
        } else if (board_size < 0) {
            ExceptionHandler.handleException(null, "Board size cannot be negative.");
            System.exit(1);
        }

        isPowerOfTwo(board_size);

        // It's asking the user to enter the coordinates of the missing square. It's then splitting the
        // input by a space and then converting the string to an integer.
        System.out.println("Please enter coordinates of missing square (separate by a space):");
        
        String[] iStrings = bufferedReader.readLine().split(" ");
        int x_missing = Integer.parseInt(iStrings[0]);
        int y_missing = Integer.parseInt(iStrings[1]);

        // It's checking if the coordinates are negative or if they are greater than the board size.
        if (x_missing < 0 || y_missing < 0) {
            ExceptionHandler.handleException(null, "Missing coordinates cannot be negative");
            System.exit(1);
        } else if (x_missing < 0 || x_missing >= board_size || y_missing < 0 || y_missing >= board_size) {
            ExceptionHandler.handleException(null, "Invalid coordinates entered!");
            System.exit(1);
        }

        // It's creating a new Tromino object with the appropriate parameters.
        Tromino tr = new Tromino(0, 0, board_size - y_missing - 1, x_missing,board_size);
        
    }

    /**
     * If n is not 1 and n is not a power of 2, then throw an exception
     * 
     * @param n The number to check if it's a power of 2
     */
    private static void isPowerOfTwo(int n){
        if (n == 1 || (n & (n - 1)) != 0) {
            ExceptionHandler.handleException(null, "Board size not a power of 2");
            System.exit(1);
        }
        else {
            return;
        }
    }
}