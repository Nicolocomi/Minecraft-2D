package visual;

import data.Block;


public class Map {
    private static final int RIGHE = 10;
    private static final int COLONNE = 10;
    private Block[][] Matrix;
    // the default map is a random one

    public Map() {
        Matrix = new Block[RIGHE][COLONNE];
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                Matrix[i][j] = new Block();
            }
        }
    }

    public void display_on_out() {
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                System.out.print(this.Matrix[i][j].display());
            }
            System.out.println();
        }
    }

    public void change_cell(int row, int col) {
        if (row >= RIGHE || col >= COLONNE) {
            return;
        }
        Matrix[row][col] = new Block('A');
    }

    /*Aggiungete un metodo swap a Map che prende due coordinate
    e scambia il blocco a quelle coordinate con il blocco di
    sotto.*/
    public void swap(int row, int col) {
        if ((row < 0 || row - 1 >= RIGHE) || (col < 0 || col > COLONNE)) {
            return;
        }
        Block temp = null;
        temp = this.Matrix[row][col];
        this.Matrix[row][col] = this.Matrix[row + 1][col];
        this.Matrix[row + 1][col] = temp;
    }

    /*Aggiungete un metodo insert_at_coords a Map per inserire
    un Block a delle coordinate specifiche.
    Una volta inserito il blocco, verificate se il blocco
    cade secondo la gravita` o no.
    Per far cadere il blocco, utilizzate il metodo swap con
    le coordinate del blocco appena inserito.*/

    private void insert_block_at_coords(Block b, int row, int col) {
        move_iter(row,col);
        //move_rec();
    }
    private void move_iter (int row, int col){
        if (!this.Matrix[row][col].isFallsWithGravity()){
            return;
        }
        for (int i= row; i<RIGHE; i++)
        {
            if (!this.Matrix[i+1][col].isFallThrough()){
                break;
            }
            this.swap(i,col); // arrivo se i campi del blocco

        }
    }
    private void move_rec (int row, int col){
        if (row == Map.RIGHE-1){
            return;
        }
        if (!this.Matrix[row][col].isFallsWithGravity()){
            return;
        }
        if (!this.Matrix[row+1][col].isFallThrough(){
            return;
        }
        this.swap(row,col);
        this.move_rec(row+1,col);
    }
}
