package tetris.model.tetrominos;

import java.awt.Color;
import java.awt.Point;

public class H extends CurvedTetromino {

    public H(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void initPoints() {
        this.points = new Point[]{new Point(-1, -1), new Point(-1, 0), new Point(-1, 1), new Point(1, -1),
                new Point(1, 0), new Point(1, 1)};
    }
}
