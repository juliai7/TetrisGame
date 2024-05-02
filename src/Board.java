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
    public boolean validPosition(Tetrominoes currPiece, int x, int y) {
        if (grid[currPiece.getRow()][currPiece.getCol()] == null) {
            return true;
        }
        return false;
    }

    public boolean hasHit(Tetrominoes currPiece) {
        if (currPiece.getY() == 800 - (currPiece.getLength() * 50)) {
            for (int i = 0; i < currPiece.getLength(); i++) {
                for (int j = 0; j < currPiece.getWidth(); j++) {
                    if(currPiece.getShape()[i][j] != null && grid[currPiece.getRow() + i][currPiece.getCol() + j] == null) {
                        grid[currPiece.getRow() + i][currPiece.getCol() + j] = currPiece.getShape()[i][j];
                    }
                }
            }
            return true;
        }
        else if (!validPosition(currPiece, currPiece.getX(), currPiece.getY())) {
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
