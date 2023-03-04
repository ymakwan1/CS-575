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

        System.out.println("Please enter coordinates of missing square (separate by a space):");
        //String inputString = sc.nextLine();
        String[] iStrings = bufferedReader.readLine().split(" ");
        int x_missing = Integer.parseInt(iStrings[0]);
        int y_missing = Integer.parseInt(iStrings[1]);

        if (x_missing < 0 || y_missing < 0) {
            System.out.println("Missing coordinate cannot be negative.");
        }

        Tromino tr = new Tromino(0, 0, x_missing, y_missing, board_size);
        
        //sc.close();
    }
}