public class TTTGame {
    private static String[][] board = new String[3][3];
    private static int moveCount = 0;

    public static void getMoveCount(int m){ moveCount = m; }

    public static void getBoard(String[][] b){ board = b; }

    public static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if(board[row][col].equals(" "))
            retVal = true;
        return retVal;
    }

    public static boolean isWin(String player) {
        if(isColWin(player) || isRowWin(player) || isDiagnalWin(player)) {
            return true;
        }
        return false;
    }

    private static boolean isDiagnalWin(String player) {
        if(board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player) ) {
            return true;
        }
        if(board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player) ) {
            return true;
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for(int row=0; row < 3; row++)
        {
            if(board[row][0].equals(player) &&
                    board[row][1].equals(player) &&
                    board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for(int col=0; col < 3; col++)
        {
            if(board[0][col].equals(player) &&
                    board[1][col].equals(player) &&
                    board[2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isTie()
    {
        boolean xFlag = false;
        boolean oFlag = false;

        for(int row=0; row < 3; row++)
        {
            if(board[row][0].equals("X") ||
                    board[row][1].equals("X") ||
                    board[row][2].equals("X")) {
                xFlag = true; // there is an X in this row
            }
            if(board[row][0].equals("O") ||
                    board[row][1].equals("O") ||
                    board[row][2].equals("O")) {
                oFlag = true; // there is an O in this row
            }

            if(! (xFlag && oFlag) ) {
                return false; // No tie can still have a row win
            }

            xFlag = oFlag = false;
        }
        // Now scan the columns
        for(int col=0; col < 3; col++)
        {
            if(board[0][col].equals("X") ||
                    board[1][col].equals("X") ||
                    board[2][col].equals("X")) {
                xFlag = true; // there is an X in this col
            }
            if(board[0][col].equals("O") ||
                    board[1][col].equals("O") ||
                    board[2][col].equals("O")) {
                oFlag = true; // there is an O in this col
            }

            if(! (xFlag && oFlag) ) {
                return false; // No tie can still have a col win
            }
        }
        // Now check for the diagonals
        xFlag = oFlag = false;

        if(board[0][0].equals("X") ||
                board[1][1].equals("X") ||
                board[2][2].equals("X") ) {
            xFlag = true;
        }
        if(board[0][0].equals("O") ||
                board[1][1].equals("O") ||
                board[2][2].equals("O") ) {
            oFlag = true;
        }
        if(! (xFlag && oFlag) ) {
            return false; // No tie can still have a diag win
        }
        xFlag = oFlag = false;

        if(board[0][2].equals("X") ||
                board[1][1].equals("X") ||
                board[2][0].equals("X") ) {
            xFlag =  true;
        }
        if(board[0][2].equals("O") ||
                board[1][1].equals("O") ||
                board[2][0].equals("O") ) {
            oFlag =  true;
        }
        if(! (xFlag && oFlag) ) {
            return false; // No tie can still have a diag win
        }

        return true;
    }
}
