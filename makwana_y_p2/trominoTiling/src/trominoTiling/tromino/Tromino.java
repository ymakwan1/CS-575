package trominoTiling.tromino;
public class Tromino {

    String [][] board;
    int x_missing, y_missing, x_board, y_board, board_size;
    public Tromino(int x_boardIn, int y_boardIn, int x_missingIn, int y_missingIn, int board_sizeIn){
        board = new String [(int)(Math.pow(2, board_sizeIn))][(int)(Math.pow(2, board_sizeIn))];
        x_board = x_boardIn;
        y_board = y_boardIn;
        x_missing = x_missingIn;
        y_missing = y_missingIn;
        board_size = board_sizeIn;
        initializeBoard(x_missing, y_missing);
        printTromino();
        tromino(x_board, y_board, x_missing, y_missing, board_size);
        System.out.println();
        printTromino();
    }

    private void initializeBoard(int x_missingIn, int y_missingIn){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == x_missingIn && j == y_missingIn) {
                    board[i][j] = "MS";
                } else {
                    board[i][j] = "X";
                }
            }
            //System.out.println("\n");
        }
    }

    private void printTromino(){
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board.length; j++) {
        //         System.out.println(board[i][j]);
        //     }
        // }
        for (int i = board.length-1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[j][i] + " ");
            }
            System.out.println();
        }
    }

    private void tromino(int x_boardIn, int y_boardIn, int x_missingIn, int y_missingIn, int board_sizeIn){

        if(board_sizeIn == 2){
            if (x_missingIn == x_boardIn && y_missingIn == y_boardIn + 1) { //Missing square is in the top-right
                board[x_boardIn][y_boardIn] = "LL";
                board[x_boardIn][y_boardIn + 1] = "LL";
                board[x_boardIn + 1][y_boardIn] = "LL";
            }  else if (x_missingIn == x_boardIn && y_missingIn == y_boardIn) { // Missing square is in the bottom-right quadrant
                board[x_boardIn][y_boardIn] = "UL";
                board[x_boardIn+1][y_boardIn] = "UL";
                board[x_boardIn+1][y_boardIn+1] = "UL";
            }
            else if (x_missingIn == x_boardIn + 1 && y_missingIn == y_boardIn) { // Missing square is in the bottom-left quadrant
                board[x_boardIn][y_boardIn+1] = "UR";
                board[x_boardIn+1][y_boardIn] = "UR";
                board[x_boardIn+1][y_boardIn+1] = "UR";
            }
            else { // Missing square is in the top-left quadrant
                board[x_boardIn][y_boardIn] = "LR";
                board[x_boardIn][y_boardIn+1] = "LR";
                board[x_boardIn+1][y_boardIn+1] = "LR";
            }
        }
    }
}