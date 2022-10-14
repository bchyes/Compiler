package Utils;

public class SemanticError extends RuntimeException {
    public Position pos;

    public SemanticError(String msg, Position tmp) {
        super(msg);
        this.pos = tmp;
    }

    public String getMessage() {
        return "[Semantic Error]\"" + super.getMessage() + "\" in " + pos;
    }
}
