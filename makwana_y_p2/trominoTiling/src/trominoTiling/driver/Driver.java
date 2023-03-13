package trominoTiling.driver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import trominoTiling.utils.ExceptionHandler;
import trominoTiling.tromino.Tromino;

public class Driver{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int board_size;
        System.out.println("Please enter size of board (0 to quit):");
        board_size = Integer.parseInt(bufferedReader.readLine());//sc.nextInt();

        if(board_size == 0){
            System.out.println("Program exiting....");
            System.exit(1);
        } else if (board_size < 0) {
            ExceptionHandler.handleException(null, "Board size cannot be negative.");
        }

        isPowerOfTwo(board_size);

        System.out.println("Please enter coordinates of missing square (separate by a space):");
        //String inputString = sc.nextLine();
        String[] iStrings = bufferedReader.readLine().split(" ");
        int x_missing = Integer.parseInt(iStrings[0]);
        int y_missing = Integer.parseInt(iStrings[1]);

        if (x_missing < 0 || y_missing < 0) {
            System.out.println("Missing coordinate cannot be negative.");
        }

        Tromino tr = new Tromino(0, 0, board_size - y_missing - 1, x_missing,board_size);
        
        //sc.close();
    }

    private static void isPowerOfTwo(int n){
        // if (board_sizeIn <= 0) {
        //     ExceptionHandler.handleException(null, "Board size less than 0");
        //     System.exit(1);
        // }
        // else if (!((board_sizeIn & (board_sizeIn - 1)) == 0)) {
        //     ExceptionHandler.handleException(null, "Board size is not a power of two");
        //     System.exit(1);
        // }
        // if ((n & (n - 1)) == 0 && n > 0) {
        //     return;
        // } else {
        //     // n is not a power of 2
        //     ExceptionHandler.handleException(null, "Board size is not a power of two");
        //     System.exit(1);
        // }

        if(n <= 0) {
            System.out.println("Invalid input. n must be a positive integer.");
            return;
        }
        while(n > 1) {
            if(n % 2 != 0) {
                //System.out.println("Invalid input. n must be a power of 2.");
                ExceptionHandler.handleException(null, "Board size is not a power of two");
                System.exit(1);
                return;
            }
            n = n / 2;
        }
    }
}