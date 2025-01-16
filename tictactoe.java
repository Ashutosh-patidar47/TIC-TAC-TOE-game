import java.util.Scanner;

public class tictactoe {
    public static void main(String args[]) {
        char[][] board = new char[3][3];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                board[r][c] = ' ';
            }
        }
        char player = 'X';
        boolean gameover = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameover) {
            PrintBoard(board);
            System.out.print("\n\nplayer " + player + " enter: ");
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            if (board[r][c] == ' ') {
                board[r][c] = player;// place element
                gameover = haveWon(board, player);
                if (gameover) {
                    System.out.println("player " + player + " has Won ");
                } else {
                    if (player == 'X') {
                        player = 'O';
                    } else
                        player = 'X';
                }

            } else {
                System.out.println("Invalid move. try again");
            }
        }
        scanner.close();
    }

    public static boolean haveWon(char[][] board, char player) {
        // check for rows
        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == player && board[r][1] == player && board[r][2] == player) {
                return true;
            }
        }

        // check for columns
        for (int c = 0; c < board.length; c++) {
            if (board[c][0] == player && board[c][1] == player && board[c][2] == player)
                return true;
        }

        // check for diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void PrintBoard(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                System.out.print(board[r][c] + " | ");
            }
            System.out.println();
        }
    }
}
