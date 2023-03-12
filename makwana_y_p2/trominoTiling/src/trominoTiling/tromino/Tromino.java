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
        //initializeBoard(x_missing, y_missing);
        board[x_missing][y_missing]="MS";
        printTromino();
        
        tromino(x_board, y_board, x_missing, y_missing, (int)(Math.pow(2, board_size)));
        System.out.println();
        printTromino();
    }


    private void printTromino(){
        for(int i=0; i<board.length;i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }

    private void tromino(int x_boardIn, int y_boardIn, int x_missingIn, int y_missingIn, int board_sizeIn){
        int half_size = board_sizeIn / 2;
        String trominoPiece="";

        int xCoordinate = x_missingIn - x_boardIn;
        int yCoordinate =  y_missingIn - y_boardIn;
        if (board_sizeIn == 2){
            //trominoPiece = (x_missingIn-x_boardIn) < half_size ? ((y_missingIn-y_boardIn) < half_size ? "LR" : "LL") : ((y_missingIn-y_boardIn)<half_size ? "UR" : "UL");
            trominoPiece = (yCoordinate < half_size) ? ((xCoordinate < half_size) ? "LR" : "UR") : ((xCoordinate < half_size) ? "LL" : "UL");
            // if (xCoordinate < half_size) {
            //     if (yCoordinate < half_size) {
            //         trominoPiece = "LR";
            //     } else {
            //         trominoPiece = "LL";
            //     }
            // } else {
            //     if (yCoordinate < half_size) {
            //         trominoPiece = "UR";
            //     } else {
            //         trominoPiece = "UL";
            //     }
            // }
            

            for (int i = x_boardIn; i < x_boardIn + board_sizeIn; i++) {
                for (int j = y_boardIn; j < y_boardIn + board_sizeIn; j++) {
                    if (i < board.length && j < board.length && board[i][j] == null) {
                        board[i][j] = trominoPiece;
                    }
                }
            }
            // for (int i = 0; i < board_sizeIn; i++) {
            //     for (int j = 0; j < board_sizeIn; j++) {
            //         if (board[x_boardIn][y_boardIn + j] == null) {
            //             board[x_boardIn][y_boardIn + j] = trominoPiece;
            //         }
            //     }
            //     x_boardIn++;
            // }
            
            return;
        }

        int x_upper_left = x_boardIn + half_size - 1;
        int x_upper_right = x_boardIn + half_size - 1;

        int x_lower_right = x_boardIn + half_size;
        int x_lower_left = x_boardIn + half_size;

        int y_upper_left = y_boardIn + half_size-1;
        int y_upper_right = y_boardIn+half_size;

        int y_lower_left = y_boardIn + half_size - 1;
        int y_lower_right = y_boardIn + half_size;

        // if (x_missingIn - x_boardIn < half_size && y_missingIn - y_boardIn < half_size) {
        //     x_upper_left = x_missingIn;
        //     y_upper_left = y_missingIn;
        //     trominoPiece = "LR";

        //     if (board[x_upper_right][y_upper_right] == null) {
        //         board[x_upper_right][y_upper_right] = trominoPiece;
        //     }

        //     if (board[x_lower_left][y_lower_left] == null) {
        //         board[x_lower_left][y_lower_left] = trominoPiece;
        //     }

        //     if (board[x_lower_right][y_lower_right] == null) {
        //         board[x_lower_right][y_lower_right] = trominoPiece;
        //     }
            
        // } else if (x_missingIn - x_boardIn < half_size && y_missingIn - y_boardIn >= half_size) {
        //     x_upper_right = x_missingIn;
        //     y_upper_right = y_missingIn;
        //     trominoPiece = "LL";

        //     if (board[x_upper_left][y_upper_left] == null) {
        //         board[x_upper_left][y_upper_left] = trominoPiece;
        //     }

        //     if (board[x_lower_left][y_lower_left] == null) {
        //         board[x_lower_left][y_lower_left] = trominoPiece;
        //     }

        //     if (board[x_lower_right][y_lower_right] == null) {
        //         board[x_lower_right][y_lower_right] = trominoPiece;
        //     }

        // } else if (x_missingIn - x_boardIn >= half_size && y_missingIn - y_boardIn < half_size) {
        //     x_lower_left = x_missingIn;
        //     y_lower_left = y_missingIn;
        //     trominoPiece = "UR";
            
        //     if (board[x_upper_right][y_upper_right] == null) {
        //         board[x_upper_right][y_upper_right] = trominoPiece;
        //     }

        //     if (board[x_upper_left][y_upper_left] == null) {
        //         board[x_upper_left][y_upper_left] = trominoPiece;
        //     }

        //     if (board[x_lower_right][y_lower_right] == null) {
        //         board[x_lower_right][y_lower_right] = trominoPiece;
        //     }
        // }
        // else if (x_missingIn - x_boardIn >= half_size && y_missingIn - y_boardIn >= half_size) {
        //     x_lower_right = x_missingIn;
        //     y_lower_right = y_missingIn;
        //     trominoPiece = "UL";

        //     if (board[x_upper_right][y_upper_right] == null) {
        //         board[x_upper_right][y_upper_right] = trominoPiece;
        //     }

        //     if (board[x_lower_left][y_lower_left] == null) {
        //         board[x_lower_left][y_lower_left] = trominoPiece;
        //     }

        //     if (board[x_upper_left][y_upper_left] == null) {
        //         board[x_upper_left][y_upper_left] = trominoPiece;
        //     }
        // }
       // switch (true) {
            if (xCoordinate < half_size && yCoordinate < half_size){
                x_upper_left = x_missingIn;
                y_upper_left = y_missingIn;
                trominoPiece = "LR";
                if (board[x_upper_right][y_upper_right] == null) board[x_upper_right][y_upper_right] = trominoPiece;
                if (board[x_lower_left][y_lower_left] == null) board[x_lower_left][y_lower_left] = trominoPiece;
                if (board[x_lower_right][y_lower_right] == null) board[x_lower_right][y_lower_right] = trominoPiece;
            } 
            else if (xCoordinate >= half_size && yCoordinate < half_size){
                x_lower_left = x_missingIn;
                y_lower_left = y_missingIn;
                trominoPiece = "UR";
                if (board[x_upper_right][y_upper_right] == null) board[x_upper_right][y_upper_right] = trominoPiece;
                if (board[x_upper_left][y_upper_left] == null) board[x_upper_left][y_upper_left] = trominoPiece;
                if (board[x_lower_right][y_lower_right] == null) board[x_lower_right][y_lower_right] = trominoPiece;
            }
            else if (xCoordinate < half_size && yCoordinate >= half_size) {
                x_upper_right = x_missingIn;
                y_upper_right = y_missingIn;
                trominoPiece = "LL";
                if (board[x_upper_left][y_upper_left] == null) board[x_upper_left][y_upper_left] = trominoPiece;
                if (board[x_lower_left][y_lower_left] == null) board[x_lower_left][y_lower_left] = trominoPiece;
                if (board[x_lower_right][y_lower_right] == null) board[x_lower_right][y_lower_right] = trominoPiece;
            }
            else if (xCoordinate >= half_size && yCoordinate >= half_size){
                x_lower_right = x_missingIn;
                y_lower_right = y_missingIn;
                trominoPiece = "UL";
                if (board[x_upper_right][y_upper_right] == null) board[x_upper_right][y_upper_right] = trominoPiece;
                if (board[x_lower_left][y_lower_left] == null) board[x_lower_left][y_lower_left] = trominoPiece;
                if (board[x_upper_left][y_upper_left] == null) board[x_upper_left][y_upper_left] = trominoPiece;
            }
        
        tromino( x_boardIn, y_boardIn, x_upper_left, y_upper_left, half_size );
        tromino( x_boardIn, y_boardIn + half_size, x_upper_right, y_upper_right, half_size);
        tromino( x_boardIn+ half_size, y_boardIn, x_lower_left, y_lower_left, half_size );
        tromino( x_boardIn + half_size, y_boardIn + half_size, x_lower_right, y_lower_right, half_size );
    }
}