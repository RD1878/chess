package org.example;

import org.example.ChessBoard;
import org.example.ChessPiece;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.isCorrectNewPosition(line, column, toLine, toColumn)) {
            if (line == toLine) {
                for (int i = Math.min(column, toColumn) + 1; i < Math.max(column, toColumn); i++) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            }

            if (column == toColumn) {
                for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            }

            boolean diagonalMove = Math.abs(line - toLine) == Math.abs(column - toColumn);

            if (diagonalMove) {
                for (int i = Math.min(line, toLine) + 1, j = Math.min(column, toColumn) + 1; i < Math.max(line, toLine); i++, j++) {
                    if (chessBoard.board[i][j]!= null) {
                        return false;
                    }
                }
            }

            return line == toLine || column == toColumn || diagonalMove;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}