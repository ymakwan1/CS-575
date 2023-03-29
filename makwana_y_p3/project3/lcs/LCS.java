package project3.lcs;

public class LCS implements LCSInterface{

    private int [][] lcsBoard;
    String lcsString1, lcsString2;
    int lcsString1Length, lcsString2Length;
    public LCS(String[] argsIn){
        lcsString1 = argsIn[0];
        lcsString2 = argsIn[1];

        lcsString1Length = lcsString1.length();
        lcsString2Length = lcsString2.length();

        lcsBoard = new int[lcsString1Length+1][lcsString2Length+1];
        generateSubString();
        System.out.print("Length of LCS : "+lcsBoard[lcsString1Length][lcsString2Length]+"\nLCS : "+printSubString());
    }

    @Override
    public String printSubString() {
        int index = lcsBoard[lcsString1Length][lcsString2Length];
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
//        for (int i = 0; i <= lcsString1Length; i++) {
//            for (int j = 0; j <= lcsString2Length; j++) {
//                System.out.print(lcsBoard[i][j]+"\t");
//            }
//            System.out.println();
//        }
    }
}
