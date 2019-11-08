package com.javarush.task.task35.task3513;

import java.util.*;
import java.util.stream.Collectors;

public class Model {
    private static final int FIELD_WIDTH = 4;
    public int score;
    public int maxTile;
    private Tile[][] gameTiles;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        this.resetGameTiles();
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] newTiles = copyMass(tiles);
        previousStates.push(newTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousScores.isEmpty() && !previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    private void rotateClockwise() {
        Tile[][] result = copyMass(gameTiles);
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = result[FIELD_WIDTH - j - 1][i];
            }
        }
    }

    private Tile[][] copyMass(Tile[][] tiles) {
        Tile[][] result = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                result[i][j] = new Tile(tiles[i][j].value);
            }
        }
        return result;
    }

    public boolean hasBoardChanged() {
        return totalWeight(gameTiles) != totalWeight(previousStates.peek());
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        if (!hasBoardChanged()) {
            rollback();
            return new MoveEfficiency(-1, 0, move);
        }
        MoveEfficiency efficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        rollback();
        return efficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        queue.peek().getMove().move();
    }

    private int totalWeight(Tile[][] gameTiles) {
        return Arrays.stream(gameTiles).flatMap(Arrays::stream).mapToInt(tile -> tile.value).sum();
    }

    public void randomMove() {
        int n = (int) (Math.random() * 4);
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }
    }

    public boolean canMove() {
        boolean a = false;
        boolean b = !getEmptyTiles().isEmpty();
        kepa:
        for (int i = 0; i < gameTiles.length - 1; i++) {
            for (int j = 0; j < gameTiles.length - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value ||
                        gameTiles[j][i].value == gameTiles[j + 1][i].value) {
                    a = true;
                    break kepa;
                }
            }
        }
        return b || a;
    }

    private boolean compressTiles(Tile[] tiles) {
        String s1 = "";
        for (Tile tile : tiles) {
            s1 += tile.value;
        }
        if (Arrays.stream(tiles).anyMatch(tile -> !tile.isEmpty())) {
            List<Tile> list = new ArrayList<>(Arrays.asList(tiles));
            List<Tile> test = new ArrayList<>(list);
            for (Tile tile : test) {
                if (tile.isEmpty()) {
                    list.remove(tile);
                    list.add(tile);
                }
            }
            for (int i = 0; i < tiles.length; i++) {
                tiles[i] = list.get(i);
            }
        }
        String s2 = "";
        for (Tile tile : tiles) {
            s2 += tile.value;
        }
        return !s1.equals(s2);
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private boolean mergeTiles(Tile[] tiles) {
        String s1 = "";
        for (Tile tile : tiles) {
            s1 += tile.value;
        }
        for (int i = 0; i < tiles.length - 1; i++) {
            Tile temp = tiles[i];
            if (tiles[i].value == tiles[i + 1].value && tiles[i].value != 0) {
                tiles[i].value = tiles[i].value * 2;
                if (i + 2 < tiles.length) {
                    System.arraycopy(tiles, i + 2, tiles, i + 1, tiles.length - i - 2);
                }
                tiles[tiles.length - 1] = new Tile(0);
                if (tiles[i].value > this.maxTile) {
                    this.maxTile = tiles[i].value;
                }
                this.score += tiles[i].value;
            }
        }
        String s2 = "";
        for (Tile tile : tiles) {
            s2 += tile.value;
        }
        return !s1.equals(s2);
    }

    public void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        this.addTile();
        this.addTile();
    }

    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if (!list.isEmpty()) {
            list.get((int) (Math.random() * list.size())).value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles() {
        return Arrays.stream(gameTiles).flatMap(Arrays::stream).filter(tile -> tile.value == 0).collect(Collectors.toList());
    }

    public void up() {
        this.saveState(this.gameTiles);
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        this.left();
        rotateClockwise();
    }

    public void right() {
        this.saveState(this.gameTiles);
        rotateClockwise();
        rotateClockwise();
        this.left();
        rotateClockwise();
        rotateClockwise();
    }

    public void down() {
        this.saveState(this.gameTiles);
        rotateClockwise();
        this.left();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    public void left() {
        if (isSaveNeeded) {
            this.saveState(this.gameTiles);
        }
        for (Tile[] gameTile : gameTiles) {
            if (this.compressTiles(gameTile) | this.mergeTiles(gameTile)) {
                this.addTile();
            }
        }
        isSaveNeeded = true;
    }
}
