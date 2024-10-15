package org.example;
import org.example.ChessBoard;

public abstract class ChessPiece {
    protected String color;
    public boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    protected abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    protected abstract String getSymbol();
}
