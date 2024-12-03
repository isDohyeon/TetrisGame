package tetris;

public class TetrisEngine implements Runnable {

    private TetrisGrid model;
    private TetrisView view;

    public TetrisEngine(TetrisGrid model, TetrisView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void run() {
        boolean gameContinues = true;
        while (gameContinues) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

