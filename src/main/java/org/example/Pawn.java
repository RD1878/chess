package org.example;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.isCorrectNewPosition(line, column, toLine, toColumn)) {
            if (this.getColor().equals("White")) {
                return (toLine == line + 1 && (toColumn == column || toColumn == column - 1 || toColumn == column + 1)) || ((toLine == line + 2 || toLine == line + 1) && line == 1 && toColumn == column);
            } else {
                return (toLine == line - 1 && (toColumn == column || toColumn == column - 1 || toColumn == column + 1)) || ((toLine == line - 2 || toLine == line - 1) && line == 6 && toColumn == column);
            }
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
