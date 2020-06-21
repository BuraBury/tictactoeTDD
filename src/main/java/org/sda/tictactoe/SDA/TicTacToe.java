package org.sda.tictactoe.SDA;

public class TicTacToe {

    private final Character[][] board =

                    {{'\0', '\0', '\0'},
                    {'\0', '\0', '\0'},
                    {'\0', '\0', '\0'}};


    private char lastPlayer = '\0';


    public static void printBoard() {

        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.print('_' + " ");
            }
        }
    }

    public String play(int X, int Y) {
        printBoard();
        checkAxis(X);
        checkAxis(Y);
        lastPlayer = nextPlayer();
        setBox(X, Y, lastPlayer);

        if (checkHorrizontal()) return lastPlayer + " is the winner";

        if (CheckVertical()) return lastPlayer + " is the winner";

        if (checkFirstDiagonal()) return lastPlayer + " is the winner";

        if (checkSecondDiagonal()) return lastPlayer + " is the winner";

        return "No winner";
    }

    public boolean CheckVertical() {
        int i = 0;
        while (i < board.length) {
            if (
                    board[i][0] == lastPlayer
                    && board[i][1] == lastPlayer
                    && board[i][2] == lastPlayer
            ){
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean checkHorrizontal() {
        for (int i = 0; i < board.length; i++) {
            if (
                    board[0][i] == lastPlayer
                    && board[1][i] == lastPlayer
                    && board[2][i] == lastPlayer
            ){
                return true;
            }
        }
        return false;
    }

    public boolean checkFirstDiagonal() {
        return
                board[0][0] == lastPlayer
                && board[1][1] == lastPlayer
                && board[2][2] == lastPlayer;
    }

    public boolean checkSecondDiagonal() {
        return
                board[2][0] == lastPlayer
                && board[1][1] == lastPlayer
                && board[0][2] == lastPlayer;
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
