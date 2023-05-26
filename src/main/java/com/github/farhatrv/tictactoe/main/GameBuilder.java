package com.github.farhatrv.tictactoe.main;

import com.github.farhatrv.tictactoe.square.SquareBoard;
import com.github.farhatrv.tictactoe.human.HumanPlayer;
import com.github.farhatrv.tictactoe.console.ConsoleUI;
import com.github.farhatrv.tictactoe.Game;
import com.github.farhatrv.tictactoe.Board;

public final class GameBuilder {
   public Game build() {
      Board board = new SquareBoard(3);
      return new Game(board,
            new HumanPlayer(board.getPlayer1View(), new ConsoleUI('X', 'O')),
            new HumanPlayer(board.getPlayer2View(), new ConsoleUI('O', 'X')));
   }
}
