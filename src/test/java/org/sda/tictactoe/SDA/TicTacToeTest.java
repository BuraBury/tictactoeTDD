package org.sda.tictactoe.SDA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

        assertThatThrownBy(() -> ticTacToe.play(5, 3))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void whenYIsOutside() {

        assertThatThrownBy(() -> ticTacToe.play(5, 3))
                .isInstanceOf(RuntimeException.class);
    }
    @Test
    public void whenOccupiedThenRuntimeException() {
        //given
        ticTacToe.play(2,2);

        //then
        assertThatThrownBy(() -> ticTacToe.play(2,2))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX() {
        assertThat(ticTacToe.nextPlayer())
        .isEqualTo('X');
    }


}