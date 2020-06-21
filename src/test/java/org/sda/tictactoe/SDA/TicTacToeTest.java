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

    @Test
    public void givenSecondTurnWhenNextPlayerThenY() {
        ticTacToe.play(1, 1);
        assertThat(ticTacToe.nextPlayer())
                .isEqualTo('O');
    }

    //ten test jest niepotrzebny bo poprzedni już to sprawdza:
//    @Test
//    public void backToFirstPlayer() {
//        ticTacToe.play(1,1);
//        ticTacToe.play(2,1);
//        assertThat(ticTacToe.nextPlayer())
//                .isEqualTo('X');
//    }

    @Test
    public void whenPlayThenNoWinner() {
        String actual = ticTacToe.play(1,1);

        assertThat(actual)
                .isEqualTo("No winner");
    }

    @Test
    public void WhenPlayAndWholeHorizontalLineThenWinner() {
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 1);
        ticTacToe.play(2, 2);
       String actual = ticTacToe.play(3, 1);

        assertThat(actual)
                .isEqualTo("X is the winner");
    }
    @Test
    public void WhenPlayAndWholeVerticalLineThenWinner() {
        ticTacToe.play(1, 1);
        ticTacToe.play(2, 2);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 3);
        String actual = ticTacToe.play(1, 3);

        assertThat(actual)
                .isEqualTo("X is the winner");
    }


}