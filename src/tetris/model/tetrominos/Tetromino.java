package tetris.model.tetrominos;

import java.awt.Color;
import java.awt.Point;

public abstract class Tetromino {

    protected Point[] points;
    protected Color color;
    protected int posX;
    protected int posY;

    public Tetromino(int x, int y, Color color) {
        this.posX = x;
        this.posY = y;
        this.color = color;
        initPoints();
    }

    public abstract void initPoints();

    public Color[][] asArray() {
        Color[][] array = new Color[4][4];
        final int CENTER_Y = 1;
        final int CENTER_X = 2;
        array[CENTER_Y][CENTER_X] = color;
        for (Point point : points) {
            array[CENTER_Y + (int) point.getY()][CENTER_X + (int) point.getX()] = color;
        }
        return array;
    }

    public void placeSelf(Color[][] grid) {
        grid[posY][posX] = this.color;
        for (Point point : points) {
            grid[posY + (int) point.getY()][posX + (int) point.getX()] = this.color;
        }
    }
}
