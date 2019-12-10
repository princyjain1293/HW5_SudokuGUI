package GUI.model;
public class Grid {

    private static final int SIZE = 9;
    private Cell[][] grid;

    public Grid() {
        grid = new Cell[SIZE][SIZE];
        initGrid();
    }

    private void initGrid() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }



    public Cell getCell(int x, int y) {

        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            throw new IndexOutOfBoundsException();
        }
        return grid[x][y];
    }

}