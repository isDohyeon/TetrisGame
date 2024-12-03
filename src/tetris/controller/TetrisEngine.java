package tetris.controller;

import tetris.view.TetrisView;
import tetris.model.TetrisGrid;

public class TetrisEngine implements Runnable {

    private TetrisGrid model;
    private TetrisView view;

    public TetrisEngine(TetrisGrid model, TetrisView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void run() {
        boolean gameContinues = model.getNewTetromino();
        this.updateViewGrid();
        this.updateViewNextTetromino();
        while (gameContinues) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateViewGrid() {
        this.view.updateGrid(this.model.getGridWithTetromino());
    }

    private void updateViewNextTetromino() {
        this.view.updateNextTetrominoGrid(this.model.getNextTetrominoGrid());
    }
}

