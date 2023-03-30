package project3.lcs;

/**
 * The LCS class takes in two strings and uses a 2D array to find the length of the longest common
 * subsequence and the longest common subsequence itself
 */
public class LCS implements LCSInterface{

    // This is the constructor for the LCS class. It takes in the two strings and initializes the
    // length of the strings and the board.
    private int [][] lcsBoard;
    private String lcsString1, lcsString2;
    private int lcsString1Length, lcsString2Length;
    
    public LCS(String[] argsIn){
        lcsString1 = argsIn[0];
        lcsString2 = argsIn[1];

        lcsString1Length = lcsString1.length();
        lcsString2Length = lcsString2.length();

        lcsBoard = new int[lcsString1Length+1][lcsString2Length+1];
    }

    /**
     * We start at the bottom right corner of the board and work our way up to the top left corner. 
     * 
     * We do this by checking if the characters at the current position are the same. If they are, we
     * add the character to the string and move diagonally up and to the left. If they are not, we move
     * up or left depending on which value is greater. 
     * 
     * We continue this process until we reach the top left corner of the board. 
     * 
     * The reason we start at the bottom right corner is because that is the position of the longest
     * common subsequence. 
     * 
     * @return The longest common subsequence of the two strings.
     */
    @Override
    public String printSubString() {
        StringBuilder sb = new StringBuilder();
        while (lcsString1Length > 0 && lcsString2Length > 0){
            if (lcsString1.charAt(lcsString1Length-1) == lcsString2.charAt(lcsString2Length-1)){
                sb.append(lcsString1.charAt(lcsString1Length-1));
                    lcsString1Length--;
                    lcsString2Length--;
            } else if (lcsBoard[lcsString1Length-1][lcsString2Length] > lcsBoard[lcsString1Length][lcsString2Length-1]){
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
     * If the characters at the current index of the two strings are the same, then the length of the
     * longest common subsequence is the length of the longest common subsequence of the two strings
     * without the current character plus one. Otherwise, the length of the longest common subsequence
     * is the maximum of the length of the longest common subsequence of the two strings without the
     * current character of the first string and the length of the longest common subsequence of the
     * two strings without the current character of the second string
     */
    @Override
    public void generateSubString() {
        for (int i = 0; i <= lcsString1Length; i++) {
            for (int j = 0; j <= lcsString2Length; j++) {
                if (i ==0 || j ==0){
                    lcsBoard[i][j] = 0;
                } else if (lcsString1.charAt(i-1) == lcsString2.charAt(j-1)) {
                    lcsBoard[i][j] = lcsBoard[i-1][j-1] + 1;
                } else {
                    lcsBoard[i][j] = Math.max(lcsBoard[i-1][j], lcsBoard[i][j-1]);
                }
            }
        }
    }
}