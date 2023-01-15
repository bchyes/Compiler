package BackEnd.Operand;

public class VirtualRegister extends Register {
    public VirtualRegister(int virtualCount) {
        super("v" + virtualCount);
        this.offset = new Immediate(0);
    }

    public VirtualRegister(VirtualRegister other) {
        super(other.name);
        this.offset = new Immediate(other.offset.value);
        this.color = other.color;
    }

    public VirtualRegister(int color, int virtualCount) {
        super("v" + virtualCount);
        this.color = color;
        this.offset = new Immediate(0);
    }

    public VirtualRegister(Immediate offset, int color, int virtualCount) {
        super("v" + virtualCount);
        this.color = color;
        this.offset = offset;
    }

    public String getName() {
        if (color == 32) {
            return this.name;
        } else return PhysicalRegister.phyRegName.get(color);
    }
}
