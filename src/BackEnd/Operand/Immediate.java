package BackEnd.Operand;

public class Immediate extends Operand {
    public int value;

    public Immediate(int value) {
        super(String.valueOf(value));
        this.value = value;
    }

    public Immediate reverse() {
        return new Immediate(-value);
    }

    public String toString() {
        return String.valueOf(value);
    }
}
