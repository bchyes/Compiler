package Utils;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Position {
    private int row, column;

    public Position(int row_, int col_) {
        this.row = row_;
        this.column = col_;
    }

    public Position(Token token) {
        this.row = token.getLine();
        this.column = token.getCharPositionInLine();
    }

    public Position(ParserRuleContext ctx) {
        this(ctx.getStart());
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public String toString() {
        return "( row : " + row + ", column : " + column + " )";
    }
}
