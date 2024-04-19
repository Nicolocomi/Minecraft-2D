package data;

public class Block {
    private char contenuto;
    public static final char DEFAULT_CONTENT = '.';
    private boolean falls_with_gravity;
    private boolean fall_through;


    public Block() {
        this.contenuto = Block.DEFAULT_CONTENT;
        this.falls_with_gravity = false;
        this.fall_through = true;
    }

    public Block(char contenuto) {
        super();
        this.contenuto = contenuto;
        this.falls_with_gravity = true;
        this.fall_through = false;
    }

    public char display() {
        return this.contenuto;
    }
    public boolean isFallsWithGravity() {
        return falls_with_gravity;
    }

    public boolean isFallThrough() {
        return fall_through;
    }

}
