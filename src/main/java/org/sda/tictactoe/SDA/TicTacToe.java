package org.sda.tictactoe.SDA;

public class TicTacToe {

    private Character[][] board = {{'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}};

    private char lastPlayer = '\0';

    public String  play(int X, int Y) {
        checkAxis(X);
        checkAxis(Y);
        lastPlayer = nextPlayer();
        setBox(X, Y, lastPlayer);
        for(int i = 0; i < board.length; i++) {
            if (board[0][i] == lastPlayer && board[1][i] == lastPlayer && board[2][i] == lastPlayer) {
                return lastPlayer + " is the winner";
            }
        }

        return "No winner";
    }

    public void checkAxis(int field) {
        if (field < 1 || field > 3) {
            throw new RuntimeException("Char is outside board");
        }
    }

    public void setBox(int X, int Y, char lastPlayer) {
        if (board[X - 1][Y - 1] != '\0') {
            throw new RuntimeException("This field is already taken");
        } else {
            board[X - 1][Y - 1] = lastPlayer;
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }



}
