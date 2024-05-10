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
                    // If the area below the piece is filled then you can't move the current piece down
                    // any further
                    if (grid[currPiece.getRow() + i + 1][currPiece.getCol() + j] != null) {
                        return false;
                    }
                }
            }
        }
        // If there's no filled areas one row below the current piece then its a valid position
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
    public void removeRow() {
        // Starts from the bottom and works way up
        for (int fullRow = numRows - 1; fullRow > 0; fullRow--) {
            // If the row is filled
            if (filledRow(fullRow)) {
                for(int row = fullRow; row > 0; row--) {
                    for (int j = 0; j < numCols; j++) {
                        // Shift every piece above the filled row down one
                        grid[row][j] = grid[row - 1][j];
                        grid[row - 1][j] = null;
                    }
                }
                // Now that everything is shifted down, if you don't stay at the same row then there will
                // be one row not checked
                fullRow++;
                // Add points for every row completed
                game.setScore(game.getScore() + 50);
            }

        }


    }
    public boolean gameOver() {
        // If any part of the row with the red line is filled
        for (int i = 0; i < numCols; i++) {
            if (grid[1][i] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean hasHit(Tetrominoes currPiece) {
        // If it has hit the bottom or hit another piece
        if (currPiece.getRow() == numRows - currPiece.getLength() || !validPosition(currPiece)) {
            for (int i = 0; i < currPiece.getLength(); i++) {
                for (int j = 0; j < currPiece.getWidth(); j++) {
                    // Copy the piece into the board
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
                // Draws the pieces once they've been copied into the board
                if (grid[i][j] != null) {
                    g.setColor(grid[i][j]);
                    g.fillRect(j * GameViewer.PIECE_SIZE, i * GameViewer.PIECE_SIZE, 50, 50);
                }
            }
        }

    }


}
