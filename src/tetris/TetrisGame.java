package tetris;

import javax.swing.JFrame;
import tetris.controller.TetrisEngine;
import tetris.model.TetrisGrid;
import tetris.view.TetrisView;

public class TetrisGame {

    private static final String TITLE = "Tetris";
    private static final int GAME_WIDTH = 400;
    private static final int GAME_HEIGHT = 600;

    private TetrisEngine controller;
    private TetrisGrid model;
    private TetrisView view;
    private JFrame jFrame;
    private final int width;
    private final int height;

    public TetrisGame(int width, int height) {
        this.width = width;
        this.height = height;
        initMVC();
        new Thread(controller).start();
        initJFrame();
    }

    private void initMVC() {
        view = new TetrisView(width, height, TetrisGrid.GRID_WIDTH, TetrisGrid.GRID_HEIGHT);
        model = new TetrisGrid();
        controller = new TetrisEngine(model, view);
    }

    private void initJFrame() {
        jFrame = new JFrame();
        jFrame.add(view);
        jFrame.pack();
        jFrame.setTitle(TITLE);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new TetrisGame(GAME_WIDTH, GAME_HEIGHT);
    }
}
