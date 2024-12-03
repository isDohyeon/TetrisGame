package tetris.model.tetrominos;

import java.awt.Color;
import java.awt.Point;

public class T extends CurvedTetromino {

    public T(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void initPoints() {
        this.points = new Point[]{new Point(1, 0), new Point(-1, 0), new Point(0, 1)};
    }
}
