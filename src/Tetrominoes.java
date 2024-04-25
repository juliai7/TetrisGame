import java.awt.*;

public class Tetrominoes {
    private int x;
    private int y;
    private Color[][] shape;
    private GameViewer window;
    private int value;

    public Tetrominoes (int x, int y, GameViewer window, int value) {
        this.x = x;
        this.y = y;
        shape = new Color[2][2];
        fillPiece();
        this.window = window;
        this.value = value;
    }
    public void fillPiece() {
        shape[0][0] = Color.pink;
        shape[0][1] = Color.pink;
        shape[1][1] = Color.pink;
        Color[][] temp = new Color[2][2];
        temp[1][1] = Color.blue;
        Color[][] c = new Color[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if(shape[i][j] != null && temp[i][j] == null) {
                    c[i][j] = shape[i][j];
                }
            }
        }


    }

    public int getValue() {
        return value;
    }
    public void draw (Graphics g, int x, int y) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] != null) {
                    g.setColor(shape[i][j]);
                    g.fillRect(x + j * 50, y + i * 50, 50, 50);
                    g.setColor(Color.black);
                    g.drawRect(x + j * 50, y + i * 50, 50, 50);
                }
            }
        }
    }

}
