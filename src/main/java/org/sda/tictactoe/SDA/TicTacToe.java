package org.sda.tictactoe.SDA;

public class TicTacToe {

    private Character[][] board = {{'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}};

    private char lastPlayer = '\0';

    public void play(int X, int Y) {
        checkAxis(X);
        checkAxis(Y);
        setBox(X, Y);
        lastPlayer = nextPlayer();
    }

    public void checkAxis(int field) {
        if (field < 1 || field > 3) {
            throw new RuntimeException("Char is outside board");
        }
    }

    public void setBox(int X, int Y) {
        if (board[X - 1][Y - 1] != '\0') {
            throw new RuntimeException("This field is already taken");
        } else {
            board[X - 1][Y - 1] = 'X';
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}
