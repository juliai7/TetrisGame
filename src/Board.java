import java.awt.*;

public class Board {
    private int height;
    private int width;
    private int numRows;
    private int numCols;
    private Color[][] grid;
    private Game game;
    private Tetrominoes piece;
    public Board(Game game) {
        height = 800;
        width = 500;
        numRows = GameViewer.WINDOW_HEIGHT / 50;
        numCols = GameViewer.WINDOW_WIDTH / 50;
        grid = new Color[numRows][numCols];
        this.game = game;
        piece = game.getCurrPiece();

        grid[2][3] = Color.red;
        grid[2][4] = Color.red;
        grid[3][3] = Color.red;
    }
    public boolean validPosition(int x, int y) {
        if (grid[x / 50][y / 50] == null) {
            return true;
        }
        return false;
    }

    public boolean hasHit(Tetrominoes currPiece) {
        currPiece = game.getCurrPiece();
        if (currPiece.getY() == 800 - currPiece.getLength() * 50) {
            return true;
        }
        else if (!validPosition(currPiece.getX(), currPiece.getY())) {
            return true;
        }
        return false;
    }
    public void draw (Graphics g) {
//        if (hasHit(game.getCurrPiece()))
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] != null) {
                    g.setColor(grid[i][j]);
                    g.fillRect(j * GameViewer.PIECE_SIZE, i * GameViewer.PIECE_SIZE, 50, 50);
                }
            }
        }
//    }
    }

}
