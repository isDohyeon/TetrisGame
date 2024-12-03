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

    @Override
    public boolean rotateSelf(Color[][] grid) {
        Point[] oldPoints = this.points.clone();
        if ((int) oldPoints[0].getX() == 0) {
            this.points = new Point[]{new Point(-2, 0), new Point(-1, 0), new Point(1, 0)};
        }
        if ((int) oldPoints[0].getX() != 0) {
            this.points = new Point[]{new Point(0, 2), new Point(0, -1), new Point(0, 1)};
        }
        if (isValidPoints(grid)) {
            return true;
        }
        this.points = oldPoints;
        return false;
    }
}
