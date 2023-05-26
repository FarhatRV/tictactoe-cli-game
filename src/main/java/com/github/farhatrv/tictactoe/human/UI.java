package com.github.farhatrv.tictactoe.human;

import com.github.farhatrv.tictactoe.View.Cell;

public interface UI {
   void draw(Cell[][] cells);

   Position askForMove();

   interface Position {
      Cell selectFrom(Cell[][] cells);
   }
}
