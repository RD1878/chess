package org.example;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.isCorrectNewPosition(line, column, toLine, toColumn)) {
            boolean diagonalMove = Math.abs(line - toLine) == Math.abs(column - toColumn);

            if (diagonalMove) {
                for (int i = Math.min(line, toLine) + 1, j = Math.min(column, toColumn) + 1; i < Math.max(line, toLine); i++, j++) {
                    if (chessBoard.board[i][j]!= null) {
                        return false;
                    }
                }
            }

            return diagonalMove;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "B";

    }
}
