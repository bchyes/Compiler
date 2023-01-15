package BackEnd.Operand;

public class Register extends Operand {
    public Immediate offset;
    public int color; //0-31 phy reg,32 null

    public boolean inMem;

    public Register(String name) {
        super(name);
        this.inMem = false;
        this.offset = new Immediate(0);
        this.color = 32;
    }
}
