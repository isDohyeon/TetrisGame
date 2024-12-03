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

    public abstract boolean rotateSelf(Color[][] grid);

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

    public boolean moveLeft(Color[][] grid) {
        int oldX = this.posX;
        this.posX -= 1;
        if (this.isValidPoints(grid)) {
            return true;
        }
        this.posX = oldX;
        return false;
    }

    public boolean moveRight(Color[][] grid) {
        int oldX = this.posX;
        this.posX += 1;
        if (this.isValidPoints(grid)) {
            return true;
        }
        this.posX = oldX;
        return false;
    }

    public boolean moveDown(Color[][] grid) {
        int oldY = this.posY;
        this.posY += 1;
        if (this.isValidPoints(grid)) {
            return true;
        }
        this.posY = oldY;
        return false;
    }

    public void placeSelf(Color[][] grid) {
        grid[posY][posX] = this.color;
        for (Point point : points) {
            grid[posY + (int) point.getY()][posX + (int) point.getX()] = this.color;
        }
    }

    public void placeGhost(Color[][] grid) {
        int thisX = this.posX;
        int thisY = this.posY;
        Color thisColor = this.color;
        this.color = Color.GRAY;
        dropSelf(grid);
        placeSelf(grid);
        this.color = thisColor;
        this.posX = thisX;
        this.posY = thisY;
    }

    public void dropSelf(Color[][] grid) {
        boolean movedDown;
        do {
            movedDown = this.moveDown(grid);
        } while (movedDown);
    }

    public boolean isValidPoints(Color[][] grid) {
        if (!isValidPos(grid, posX, posY)) {
            return false;
        }
        for (Point point : points) {
            if (!isValidPos(grid, posX + (int) point.getX(), posY + (int) point.getY())) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidPos(Color[][] grid, int x, int y) {
        if (y < 0 || y >= grid.length) {
            return false;
        }
        if (x < 0 || x >= grid[0].length) {
            return false;
        }
        if (grid[y][x] != null) {
            return false;
        }
        return true;
    }
}
