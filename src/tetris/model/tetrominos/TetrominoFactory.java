package tetris.model.tetrominos;

import java.awt.Color;
import java.util.Random;
import tetris.model.TetrisGrid;

public class TetrominoFactory {

    private static final Random random;
    private static final int START_X = (int) Math.ceil(TetrisGrid.GRID_WIDTH / 2.0);
    private static final int START_Y = 2;
    private static final Color[] tetrominoColors;

    static {
        tetrominoColors = new Color[]{
                Color.YELLOW,
                Color.CYAN,
                Color.GREEN,
                Color.RED,
                Color.ORANGE,
                Color.BLUE,
                Color.MAGENTA, // H
                new Color(128, 0, 128)
        };
        random = new Random();
    }

    public static Tetromino getNewTetromino() {
        int next = random.nextInt(8);
        switch (next) {
            case 0:
                return new O(START_X, START_Y, tetrominoColors[next]);
            case 1:
                return new I(START_X, START_Y, tetrominoColors[next]);
            case 2:
                return new S(START_X, START_Y, tetrominoColors[next]);
            case 3:
                return new Z(START_X, START_Y, tetrominoColors[next]);
            case 4:
                return new L(START_X, START_Y, tetrominoColors[next]);
            case 5:
                return new J(START_X, START_Y, tetrominoColors[next]);
            case 6:
                return new H(START_X, START_Y, tetrominoColors[next]);
            case 7:
                return new T(START_X, START_Y, tetrominoColors[next]);
            default:
                return null;
        }
    }
}
