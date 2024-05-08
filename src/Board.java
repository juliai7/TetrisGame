import java.awt.*;

public class Board {
    private int height;
    private int width;
    private int numRows;
    private int numCols;
    private Color[][] grid;
    private Game game;
    public Board(Game game) {
        height = 800;
        width = 500;
        numRows = GameViewer.WINDOW_HEIGHT / 50;
        numCols = GameViewer.WINDOW_WIDTH / 50;
        grid = new Color[numRows][numCols];
        this.game = game;
    }
    public boolean validPosition(Tetrominoes currPiece) {
        for (int i = 0; i < currPiece.getLength(); i++) {
            for (int j = 0; j < currPiece.getWidth(); j++) {
                if (currPiece.getShape()[i][j] != null) {
                    int temp = currPiece.getCol() + j;
                    if (grid[currPiece.getRow() + i + 1][currPiece.getCol() + j] != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean filledRow(int row) {
        for (int i = 0; i < numCols; i++) {
            if (grid[row][i] == null) {
                return false;
            }
        }
        return true;
    }
    // the second row only deletes after another block has been placed down
    public void removeRow() {
        for (int fullRow = numRows - 1; fullRow > 0; fullRow--) {
            if (filledRow(fullRow)) {
                for(int row = fullRow; row > 0; row--) {
                    for (int j = 0; j < numCols; j++) {

                        grid[row][j] = grid[row - 1][j];
                        grid[row - 1][j] = null;
                    }
                }
                fullRow++;
                game.setScore(game.getScore() + 50);
            }

        }


    }
    public boolean gameOver() {
        for (int i = 0; i < numCols; i++) {
            if (grid[2][i] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean hasHit(Tetrominoes currPiece) {
        if (currPiece.getRow() == numRows - currPiece.getLength() || !validPosition(currPiece)) {
            for (int i = 0; i < currPiece.getLength(); i++) {
                for (int j = 0; j < currPiece.getWidth(); j++) {
                    if(currPiece.getShape()[i][j] != null && grid[currPiece.getRow() + i][currPiece.getCol() + j] == null) {
                        grid[currPiece.getRow() + i][currPiece.getCol() + j] = currPiece.getShape()[i][j];
                    }
                }
            }
            return true;
        }
        return false;
    }
    public void draw (Graphics g) {
        Tetrominoes piece = game.getCurrPiece();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] != null) {
                    g.setColor(grid[i][j]);
                    g.fillRect(j * GameViewer.PIECE_SIZE, i * GameViewer.PIECE_SIZE, 50, 50);
                }
            }
        }

    }


}
