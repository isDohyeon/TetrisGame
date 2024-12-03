package tetris.model;

import java.awt.Color;
import tetris.model.tetrominos.Tetromino;
import tetris.model.tetrominos.TetrominoFactory;

public class TetrisGrid {

    public static final int GRID_WIDTH = 10;
    public static final int GRID_HEIGHT = 22;

    private Tetromino tetromino;
    private Tetromino nextTetromino;

    public TetrisGrid() {
        this.nextTetromino = TetrominoFactory.getNewTetromino();
    }

    public Color[][] getGridWithTetromino() {
        Color[][] gridWithTetromino = new Color[GRID_HEIGHT][GRID_WIDTH];
        this.tetromino.placeSelf(gridWithTetromino);
        return gridWithTetromino;
    }

    public boolean getNewTetromino() {
        tetromino = nextTetromino;
        nextTetromino = TetrominoFactory.getNewTetromino();
        return true;
    }

    public Color[][] getNextTetrominoGrid() {
        return this.nextTetromino.asArray();
    }
}
