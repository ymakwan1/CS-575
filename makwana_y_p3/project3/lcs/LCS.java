package project3.lcs;


/**
 * This class implements the LCSInterface and contains the methods to find the longest common
 * subsequence between two strings.
 */
public class LCS implements LCSInterface{

    // This is the constructor for the LCS class. It takes in the two strings and initializes the
    // length of the strings and the board.
    private int [][] lcsBoard;
    private String [][] charTracker;
    private String lcsString1, lcsString2;
    private int lcsString1Length, lcsString2Length;
    
    // This is the constructor for the LCS class. It takes in the two strings and initializes the
    // length of the strings and the board.
    public LCS(String[] argsIn){
        lcsString1 = argsIn[0];
        lcsString2 = argsIn[1];

        lcsString1Length = lcsString1.length();
        lcsString2Length = lcsString2.length();

        lcsBoard = new int[lcsString1Length+1][lcsString2Length+1];
        charTracker = new String[lcsString1Length+1][lcsString2Length+1];
    }

    
    /**
     * We start at the bottom right corner of the matrix and work our way up to the top left corner. 
     * 
     * We do this by checking the value of the matrix at the current position. If the value is "D", we
     * know that the current character in both strings is the same, so we add it to the string and move
     * diagonally up and to the left. If the value is "U", we know that the current character in the
     * first string is not the same as the current character in the second string, so we move up. If
     * the value is "L", we know that the current character in the first string is not the same as the
     * current character in the second string, so we move left. 
     * 
     * We continue this process until we reach the top left corner of the matrix.
     * 
     * @return The longest common subsequence of the two strings.
     */
    @Override
    public String printSubString() {
        StringBuilder sb = new StringBuilder();
        while (lcsString1Length > 0 && lcsString2Length > 0){
            if (charTracker[lcsString1Length][lcsString2Length] == "D") {
                sb.append(lcsString1.charAt(lcsString1Length-1));
                lcsString1Length--;
                lcsString2Length--;
            } else if (charTracker[lcsString1Length][lcsString2Length] == "U") {
                lcsString1Length--;
            } else {
                lcsString2Length--;
            }
        }
        return sb.reverse().toString();
    }

    /**
     * The function returns the length of the longest common subsequence
     * 
     * @return The length of the longest common subsequence.
     */
    @Override
    public int printSubStringLength(){
        return lcsBoard[lcsString1Length][lcsString2Length];
    }
    
    /**
     * If the characters in the two strings are the same, then the length of the LCS is the length of
     * the LCS of the two strings without the last character plus one. Otherwise, the length of the LCS
     * is the maximum of the length of the LCS of the first string without the last character and the
     * length of the LCS of the second string without the last character
     */
    @Override
    public void generateSubString() {
        for (int i = 1; i <= lcsString1Length; i++) {
            for (int j = 1; j <= lcsString2Length; j++) {
                if (lcsString1.charAt(i-1) == lcsString2.charAt(j-1)) {
                    lcsBoard[i][j] = lcsBoard[i-1][j-1] + 1;
                    charTracker[i][j] = "D";
                } else if (lcsBoard[i-1][j] >= lcsBoard[i][j-1]) {
                    lcsBoard[i][j] = lcsBoard[i-1][j];
                    charTracker[i][j] = "U";
                } else {
                    lcsBoard[i][j] = lcsBoard[i][j-1];
                    charTracker[i][j] = "L";
                }
            }
        }
    }
}