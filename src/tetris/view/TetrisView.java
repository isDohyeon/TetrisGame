package tetris.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class TetrisView extends JPanel {

    private static final double GAME_SCORE_AREA_RATIO = 0.75;
    private static final Color DEFAULT_COLOR = Color.BLACK;

    private int tileSize;
    private int nextTetrominoTileSize;
    private Color[][] grid;
    private Color[][] nextTetrominoGrid;
    private int gridWidth;
    private int gridHeight;
    private int width;
    private int height;
    private int gameWidth;
    private int sideWidth;

    public TetrisView(int width, int height, int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        initDimensions(width, height);
        initTileSize();
        revisitDimensions();
        initView();
        this.setPreferredSize(new Dimension(this.width, this.height));
    }

    private void revisitDimensions() {
        this.height = tileSize * (gridHeight - 2);
        this.gameWidth = tileSize * gridWidth;
        this.width = gameWidth + sideWidth + 1;
    }

    private void initDimensions(int width, int height) {
        this.width = width;
        this.height = height;
        this.gameWidth = (int) Math.floor(width * GAME_SCORE_AREA_RATIO);
        this.sideWidth = width - this.gameWidth - 1;
    }

    private void initTileSize() {
        int xSize = gameWidth / gridWidth;
        int ySize = height / gridHeight;
        if (xSize < ySize) {
            tileSize = xSize;
        }
        if (xSize >= ySize){
            tileSize = ySize;
        }
        nextTetrominoTileSize = sideWidth / 6;
    }

    private void initView() {
        this.grid = new Color[gridHeight][gameWidth];
        this.nextTetrominoGrid = new Color[4][4];
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawGamerGrid(g2d);
        fillSidePanel(g2d);
        drawScore(g2d);
        drawNextTetrominoPanel(g2d);
    }

    private void drawNextTetrominoPanel(Graphics2D g2d) {
        g2d.setColor(new Color(255, 200, 0));
        g2d.drawString("NEXT", this.width - this.sideWidth + nextTetrominoTileSize,
                this.height - 6 * nextTetrominoTileSize);

        int x;
        int y;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                setNextTetrominoColor(g2d, row, col);
                y = this.height - nextTetrominoTileSize - (4 - row) * nextTetrominoTileSize;
                x = this.width - this.sideWidth + nextTetrominoTileSize + col * nextTetrominoTileSize;
                g2d.fillRect(x, y, nextTetrominoTileSize, nextTetrominoTileSize);
                g2d.setPaint(Color.LIGHT_GRAY);
                g2d.drawRect(x, y, nextTetrominoTileSize, nextTetrominoTileSize);
            }
        }
    }

    private void setNextTetrominoColor(Graphics2D g2d, int row, int col) {
        Color nextColor = nextTetrominoGrid[row][col];
        if (nextColor != null) {
            g2d.setPaint(nextColor);
            return;
        }
        g2d.setPaint(DEFAULT_COLOR);
    }

    private void fillSidePanel(Graphics2D g2d) {
        g2d.setPaint(new Color(0, 8, 52));
        g2d.fillRect(width - sideWidth, 0, sideWidth, height);
    }

    private void drawScore(Graphics2D g2d) {
        g2d.setColor(new Color(255, 233, 0));
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        g2d.drawString("SCORE : ", this.width - this.sideWidth + nextTetrominoTileSize, metrics.getHeight());
        String scoreString = Long.toString(0);
        g2d.drawString(scoreString, this.width - this.sideWidth + nextTetrominoTileSize, metrics.getHeight() * 2);
    }

    private void drawGamerGrid(Graphics2D g2d) {
        for (int row = 2; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                setGridColor(g2d, row, col);
                g2d.fillRect(col * tileSize, (row - 2) * tileSize, tileSize, tileSize);
                g2d.setPaint(Color.WHITE);
                g2d.drawRect(col * tileSize, (row - 2) * tileSize, tileSize, tileSize);
            }
        }
    }

    private void setGridColor(Graphics2D g2d, int row, int col) {
        Color gridColor = grid[row][col];
        if (gridColor != null) {
            g2d.setPaint(gridColor);
            return;
        }
        g2d.setPaint(DEFAULT_COLOR);
    }

    public void updateGrid(Color[][] grid) {
        arrayCopy(grid, this.grid);
        this.repaint();
    }

    public void arrayCopy(Color[][] array, Color[][] copyArray) {
        for (int i = 0; i < array.length; i++) {
            copyArray[i] = array[i].clone();
        }
    }

    public void updateNextTetrominoGrid(Color[][] nextTetrominoGrid) {
        arrayCopy(nextTetrominoGrid, this.nextTetrominoGrid);
        this.repaint();
    }
}
