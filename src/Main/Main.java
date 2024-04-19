package Main;

import visual.Map;

import java.util.Scanner;

public class Main {
    private static final int INTERAZIONI = 5;
    private static Map mappa;

    public static void main(String[] args) {
        change_at_coords();
    }

    private static void change_at_coords() {
        mappa = new Map();
        mappa.display_on_out();
        for (int i = 0; i < INTERAZIONI; i++) {
            System.out.print("Enter row: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();

            System.out.print("Enter column: ");
            int col = myObj.nextInt();
            System.out.println("Changing: " + row + " - " + col);
            mappa.change_cell(row, col);
            mappa.display_on_out();

        }

    }
}