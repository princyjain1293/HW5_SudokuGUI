package GUI.model;
public class Cell {

    private static final int SIZE = 9;
    private static final int UNASSIGNED = -1;
    private int x;
    private int y;
    private int value;

    public Cell(int x, int y) {

        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            throw new IndexOutOfBoundsException();
        }

        this.x = x;
        this.y = y;
        value = UNASSIGNED;
    }



    public int getValue() {
        return value;
    }

    public void setValue(int value) {

        if (value >= 1 && value <= SIZE) {
            this.value = value;
        }
    }



}