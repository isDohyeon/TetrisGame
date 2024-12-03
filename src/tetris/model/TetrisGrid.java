package tetris.model;

import java.awt.Color;
import tetris.model.tetrominos.Tetromino;
import tetris.model.tetrominos.TetrominoFactory;

public class TetrisGrid {

    public static final int GRID_WIDTH = 10;
    public static final int GRID_HEIGHT = 22;

    private final Color[][] grid;
    private Tetromino tetromino;
    private Tetromino nextTetromino;

    public TetrisGrid() {
        this.nextTetromino = TetrominoFactory.getNewTetromino();
        this.grid = new Color[GRID_HEIGHT][GRID_WIDTH];
    }

    public Color[][] getGridWithTetromino() {
        Color[][] gridWithTetromino = new Color[GRID_HEIGHT][GRID_WIDTH];
        for (int y = 0; y < GRID_HEIGHT; y++) {
            for (int x = 0; x < GRID_WIDTH; x++) {
                if (grid[y][x] != null) {
                    gridWithTetromino[y][x] = new Color(grid[y][x].getRGB());
                }
            }
        }
        if (hasTetromino()) {
            this.tetromino.placeGhost(gridWithTetromino);
            this.tetromino.placeSelf(gridWithTetromino);
        }
        return gridWithTetromino;
    }

    public boolean hasTetromino() {
        return this.tetromino != null;
    }

    public boolean moveTetrominoDown() {
        if (hasTetromino()) {
            return this.tetromino.moveDown(this.grid);
        }
        return false;
    }

    public boolean moveTetrominoLeft() {
        if (hasTetromino()) {
            return this.tetromino.moveLeft(this.grid);
        }
        return false;
    }

    public boolean moveTetrominoRight() {
        if (hasTetromino()) {
            return this.tetromino.moveRight(this.grid);
        }
        return false;
    }

    public boolean rotateTetromino() {
        if (hasTetromino()) {
            return this.tetromino.rotateSelf(this.grid);
        }
        return false;
    }

    public void placeTetromino() {
        if (hasTetromino()) {
            this.tetromino.placeSelf(this.grid);
            this.tetromino = null;
        }
    }

    public boolean dropTetromino() {
        if (hasTetromino()) {
            this.tetromino.dropSelf(this.grid);
            return true;
        }
        return false;
    }

    public boolean getNewTetromino() {
        tetromino = nextTetromino;
        nextTetromino = TetrominoFactory.getNewTetromino();
        if (tetromino.isValidPoints(grid)) {
            return true;
        }
        tetromino = null;
        return false;
    }

    public int handleAllFilledRows() {
        int filled = 0;
        int row = GRID_HEIGHT - 1;
        int topRow = 0;
        while (row >= topRow) {
            if (isFilledRow(row)) {
                filled += 1;
                shiftRows(row, topRow);
                topRow += 1;
                continue;
            }
            row -= 1;
        }
        return filled;
    }

    private boolean isFilledRow(int row) {
        for (int col = 0; col < GRID_WIDTH; col++) {
            if (grid[row][col] == null) {
                return false;
            }
        }
        return true;
    }

    private void shiftRows(int row, int topRow) {
        for (; row > topRow; row--) {
            this.grid[row] = this.grid[row - 1].clone();
        }
        this.grid[topRow] = new Color[GRID_WIDTH];
    }

    public Color[][] getNextTetrominoGrid() {
        return this.nextTetromino.asArray();
    }
}
