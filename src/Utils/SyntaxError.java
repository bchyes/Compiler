package Utils;

public class SyntaxError extends RuntimeException {
    private Position pos;

    public SyntaxError(String msg, Position pos_) {
        super(msg);
        this.pos = pos_;
    }

    public String getMessage() {
        return "[Syntax Error] : " + super.getMessage() + " in " + pos.toString();
    }
}
