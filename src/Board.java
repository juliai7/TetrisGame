import java.awt.*;

public class Board {
    private int height;
    private int width;
    private Color[][] grid;
    public Board() {
        height = 800;
        width = 500;
        grid = new Color[15][10];
    }
    public boolean validPosition(int x, int y) {
        if (grid[x][y] == null) {
            return true;
        }
        return false;
    }
}
