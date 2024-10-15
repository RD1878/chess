package org.example;

import org.example.ChessBoard;
import org.example.ChessPiece;

import java.util.Objects;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.isCorrectNewPosition(line, column, toLine, toColumn)) {
            return Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int toColumn) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard.board[i][j] != null && !Objects.equals(chessBoard.board[i][j].getColor(), this.getColor())) {
                    if (chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, toColumn) || chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, 4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}