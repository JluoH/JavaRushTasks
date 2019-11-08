package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private final static int WINNING_TILE = 2048;
    private Model model;

    public View getView() {
        return view;
    }

    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.resetGame();
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            model.rollback();
        }if (e.getKeyCode() == KeyEvent.VK_R) {
            model.randomMove();
        }if (e.getKeyCode() == KeyEvent.VK_A) {
            model.autoMove();
        }
        if (!model.canMove()) {
            view.isGameLost = true;
        }
        if (!view.isGameLost && !view.isGameWon) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    model.left();
                    break;
                case KeyEvent.VK_RIGHT:
                    model.right();
                    break;
                case KeyEvent.VK_UP:
                    model.up();
                    break;
                case KeyEvent.VK_DOWN:
                    model.down();
            }
        }
        if (model.maxTile == WINNING_TILE) {
            view.isGameWon = true;
        }
        view.repaint();
    }

    public void resetGame() {
        this.model.score = 0;
        view.isGameLost = false;
        view.isGameWon = false;
        this.model.resetGameTiles();
    }

    public int getScore() {
        return this.model.score;
    }

    public Tile[][] getGameTiles() {
        return this.model.getGameTiles();
    }
}
