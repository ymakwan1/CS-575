package trominoTiling.tromino;
import trominoTiling.utils.ExceptionHandler;

/**
 * The Tromino class takes in the x and y coordinates of the missing square, the x and y coordinates of
 * the board, and the size of the board. It then creates a 2D array of Strings that represents the
 * board. It then calls the tromino method, which recursively fills in the board with the appropriate
 * tromino pieces
 */
public class Tromino {

    String [][] board;
    int x_missing, y_missing, x_board, y_board, board_size;

    /*
    * This is the constructor for the Tromino class. It takes in the x and y coordinates of the
    * missing square, the x and y coordinates of the board, and the size of the board. It then 
    * creates a 2D array of Strings that represents board. It then calls the tromino method, 
    * which recursively fills in the board with the appropriate tromino pieces
    */
    public Tromino(int x_boardIn, int y_boardIn, int x_missingIn, int y_missingIn, int board_sizeIn){
        
        x_board = x_boardIn;
        y_board = y_boardIn;
        x_missing = x_missingIn;
        y_missing = y_missingIn;
        board_size = board_sizeIn;


        board = new String [board_size][board_size];
        
        board[x_missing][y_missing]="MS";

        tromino(x_board, y_board, x_missing, y_missing, board_size);

        printTromino();
    }


    /**
     * It prints the board
     */
    private void printTromino(){
        for(int i=0; i<board.length;i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }

    /**
     * The function takes in the board size, the x and y coordinates of the board, and the x and y
     * coordinates of the missing square. It then recursively calls itself on each of the four
     * quadrants of the board, and fills in the appropriate tromino piece in each quadrant
     * 
     * @param x_boardIn The x coordinate of the board
     * @param y_boardIn The y coordinate of the top left corner of the board.
     * @param x_missingIn x coordinate of the missing square
     * @param y_missingIn The y coordinate of the missing square
     * @param board_sizeIn The size of the board.
     */
    private void tromino(int x_boardIn, int y_boardIn, int x_missingIn, int y_missingIn, int board_sizeIn){
        int half_size = board_sizeIn / 2;
        String trominoPiece="";

        /*  
        * This is the base case. If the board size is 2, then we can just fill in the board with the
        * appropriate tromino piece.
        */
        if (board_sizeIn == 2){
            trominoPiece = ((y_missingIn - y_boardIn) < half_size) ? (((x_missingIn - x_boardIn) < half_size) ? "LR" : "UR") : (((x_missingIn - x_boardIn) < half_size) ? "LL" : "UL");

            for (int i = x_boardIn; i < x_boardIn + board_sizeIn; i++) {
                for (int j = y_boardIn; j < y_boardIn + board_sizeIn; j++) {
                    if (i < board.length && j < board.length && board[i][j] == null) {
                        board[i][j] = trominoPiece;
                    }
                }
            }
            return;
        }

        // Setting the coordinates of the four corners of the board.
        int x_upper_left = x_boardIn + half_size - 1;
        int x_upper_right = x_boardIn + half_size - 1;

        int x_lower_right = x_boardIn + half_size;
        int x_lower_left = x_boardIn + half_size;

        int y_upper_left = y_boardIn + half_size-1;
        int y_upper_right = y_boardIn+half_size;

        int y_lower_left = y_boardIn + half_size - 1;
        int y_lower_right = y_boardIn + half_size;

        // This is the case where the missing square is in the upper left quadrant of the board.
        if (x_missingIn - x_boardIn < half_size && y_missingIn - y_boardIn < half_size) {
            x_upper_left = x_missingIn;
            y_upper_left = y_missingIn;
            trominoPiece = "LR";

            if (board[x_upper_right][y_upper_right] == null) board[x_upper_right][y_upper_right] = trominoPiece;
            if (board[x_lower_left][y_lower_left] == null) board[x_lower_left][y_lower_left] = trominoPiece;
            if (board[x_lower_right][y_lower_right] == null) board[x_lower_right][y_lower_right] = trominoPiece;
            
        }
        // This is the case where the missing square is in the upper right quadrant of the board.
        else if (x_missingIn - x_boardIn < half_size && y_missingIn - y_boardIn >= half_size) {
            x_upper_right = x_missingIn;
            y_upper_right = y_missingIn;
            trominoPiece = "LL";

            if (board[x_upper_left][y_upper_left] == null) board[x_upper_left][y_upper_left] = trominoPiece;
            if (board[x_lower_left][y_lower_left] == null) board[x_lower_left][y_lower_left] = trominoPiece;
            if (board[x_lower_right][y_lower_right] == null) board[x_lower_right][y_lower_right] = trominoPiece;

        } 
        // This is the case where the missing square is in the lower left quadrant of the board.
        else if (x_missingIn - x_boardIn >= half_size && y_missingIn - y_boardIn < half_size) {
            x_lower_left = x_missingIn;
            y_lower_left = y_missingIn;
            trominoPiece = "UR";
            
            if (board[x_upper_right][y_upper_right] == null) board[x_upper_right][y_upper_right] = trominoPiece;
            if (board[x_upper_left][y_upper_left] == null) board[x_upper_left][y_upper_left] = trominoPiece;
            if (board[x_lower_right][y_lower_right] == null) board[x_lower_right][y_lower_right] = trominoPiece;
        }
        // This is the case where the missing square is in the lower right quadrant of the board.
        else if (x_missingIn - x_boardIn >= half_size && y_missingIn - y_boardIn >= half_size) {
            x_lower_right = x_missingIn;
            y_lower_right = y_missingIn;
            trominoPiece = "UL";

            if (board[x_upper_right][y_upper_right] == null) board[x_upper_right][y_upper_right] = trominoPiece;
            if (board[x_lower_left][y_lower_left] == null) board[x_lower_left][y_lower_left] = trominoPiece;
            if (board[x_upper_left][y_upper_left] == null) board[x_upper_left][y_upper_left] = trominoPiece;
        }
              
        // Recursively calling the tromino method on each of the four quadrants of the board.
        tromino( x_boardIn, y_boardIn, x_upper_left, y_upper_left, half_size );
        tromino( x_boardIn, y_boardIn + half_size, x_upper_right, y_upper_right, half_size);
        tromino( x_boardIn+ half_size, y_boardIn, x_lower_left, y_lower_left, half_size );
        tromino( x_boardIn + half_size, y_boardIn + half_size, x_lower_right, y_lower_right, half_size );
    }
}