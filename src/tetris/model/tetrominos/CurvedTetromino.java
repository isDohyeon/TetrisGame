package tetris.model.tetrominos;

import java.awt.Color;
import java.awt.Point;

public abstract class CurvedTetromino extends Tetromino {

    public CurvedTetromino(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public boolean rotateSelf(Color[][] grid) {
        Point[] oldPoints = new Point[3];
        for (int i = 0; i < points.length; i++) {
            oldPoints[i] = new Point(points[i]);
        }
        for (Point point : points) {
            point.setLocation(-point.getY(), point.getX());
        }
        if (isValidPoints(grid)) {
            return true;
        }
        this.points = oldPoints;
        return false;
    }
}
