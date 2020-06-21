package org.sda.tictactoe.SDA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe ticTacToe;

    @BeforeEach
    public void SetUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXIsOutside() {
        TicTacToe ticTacToe = new TicTacToe();
        assertThatThrownBy(() -> ticTacToe.play(5, 3))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void whenYIsOutside() {
        TicTacToe ticTacToe = new TicTacToe();
        assertThatThrownBy(() -> ticTacToe.play(5, 3))
                .isInstanceOf(RuntimeException.class);
    }
    @Test
    public void whenItsTaken() {
        TicTacToe ticTacToe = new TicTacToe();
        assertThatThrownBy(() -> ticTacToe.play(2,2))
                .isInstanceOf(RuntimeException.class);
    }


}