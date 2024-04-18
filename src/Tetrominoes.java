import java.awt.*;

public class Tetrominoes {
    private int x;
    private int y;
    private Image image;
    private GameViewer window;
    private int value;

    public Tetrominoes (int x, int y, Image image, GameViewer window, int value) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.window = window;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public void draw (Graphics g, int x, int y) {

    }

}
