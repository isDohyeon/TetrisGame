package tetris;

import java.awt.Color;

public class TetrisGrid {

    public static final int GRID_WIDTH = 10;
    public static final int GRID_HEIGHT = 22;
    private Color[][] grid;

    public TetrisGrid() {
        this.grid = new Color[GRID_HEIGHT][GRID_WIDTH];
    }
}
