import java.util.Random;
import java.util.Scanner;

class TicTacToe {
    char[][] board;
    public TicTacToe() {
        board = new char[3][3];
        initBoard();
    }
    void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }
    void dispBoard() {
        System.out.println("\n" + "-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    void placeMark(int row, int col, char mark) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            board[row][col] = mark;
        } else {
            System.out.print("Invalid Position");
        }
    }
    boolean checkColWin() {
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                return true;
            }
        }
        return false;
    }
    boolean checkRowWin() {
        for (int i = 0; i <= 2; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
        }
        return false;
    }
    boolean checkDiagWin() {
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
            return true;
        }
        return false;
    }
    boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
abstract class Player {
    String name;
    char mark;

    abstract void makeMove(TicTacToe ticTacToe);

    boolean isValidMove(int row, int col, TicTacToe ticTacToe) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && ticTacToe.board[row][col] == ' ';
    }
}
class HumanPlayer extends Player {
    HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove(TicTacToe ticTacToe) {
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.println(name + ", enter the Row and col: ");
            row = scan.nextInt();
            col = scan.nextInt();
        } while (!isValidMove(row, col, ticTacToe));
        ticTacToe.placeMark(row, col, mark);
    }
}
class AIPlayer extends Player {
    AIPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove(TicTacToe ticTacToe) {
        int row, col;
        Random r = new Random();
        do {
            row = r.nextInt(3);
            col = r.nextInt(3);
        } while (!isValidMove(row, col, ticTacToe));
        ticTacToe.placeMark(row, col, mark);
    }
}
public class TicTacToeGame {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        HumanPlayer p1 = new HumanPlayer("Bob", 'X');
        AIPlayer p2 = new AIPlayer("TAI", 'O');
        Player cp;
        cp = p1;
        while (true) {
            System.out.println(cp.name + "'s turn");
            cp.makeMove(t);
            t.dispBoard();

            if (t.checkColWin() || t.checkRowWin() || t.checkDiagWin()) {
                System.out.println(cp.name + " has Won!");
                break;
            } else if (t.checkDraw()) {
                System.out.println("Game is a draw!");
                break;
            } else {
                cp = (cp == p1) ? p2 : p1;
            }
        }
    }
}

