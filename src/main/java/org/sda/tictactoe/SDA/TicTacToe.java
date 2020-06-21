package org.sda.tictactoe.SDA;

public class TicTacToe {

    public void play(int X, int Y) {
        if (X < 1 || X > 3) {
            throw new RuntimeException("X is outside board");
        }
        if (Y < 1 || Y > 3) {
            throw new RuntimeException("Y is outside board");
        }
        if (X == Y) {
            throw new RuntimeException("This one is taken");
        }
    }
}
