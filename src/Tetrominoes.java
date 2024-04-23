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
        this.window = window;
        this.value = value;
    }
    public void pieces() {
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

    }

}
