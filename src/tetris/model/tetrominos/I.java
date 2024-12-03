package tetris.model.tetrominos;

import java.awt.Color;
import java.awt.Point;

public class I extends Tetromino {

    public I(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void initPoints() {
        this.points = new Point[]{new Point(-1, 0), new Point(-2, 0), new Point(1, 0)};
    }
}
