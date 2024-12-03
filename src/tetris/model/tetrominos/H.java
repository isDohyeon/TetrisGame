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

    @Override
    public boolean rotateSelf(Color[][] grid) {
        Point[] oldPoints = this.points.clone();
        for (Point point : points) {
            point.setLocation(point.getY(), point.getX());
        }
        if (isValidPoints(grid)) {
            return true;
        }
        this.points = oldPoints;
        return false;
    }
}
