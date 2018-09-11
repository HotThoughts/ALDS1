import java.util.Scanner;

class EightQueensProblem {

    static String[][] board = new String[8][8];
    static int rest;

    private static boolean isClear(int r, int c){
        if (board[r][c] == "Q") return false;

        // check the same col and same rows
        for (int i = 0; i < 8; i++) {
            if (board[r][i] == "Q" || board[i][c] == "Q")
                return false;
        }
        // check the diagonals

        return true;
    }

    private static void printBoard(){
        for (String[] line: board) {
            for (String chess: line)
                System.out.print(chess);

            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        rest = 8 - k;
        // create an empty board with dots
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                board[i][j] = ".";
        // put existing Queens on the board
        for (int i = 0; i < k; i++)
            board[sc.nextInt()][sc.nextInt()] = "Q";

        printBoard();
    }
}
