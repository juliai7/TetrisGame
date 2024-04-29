import java.awt.*;

public class Tetrominoes {
    private int x;
    private int y;
    private Color[][] shape;
    private GameViewer window;
    private int value;
    private int rotated;
    private int length;
    private int width;

    public Tetrominoes (int x, int y, GameViewer window, int value) {
        this.x = x;
        this.y = y;
        shape = new Color[3][3];
        fillPiece();
        this.window = window;
        this.value = value;
        rotated = 1;
        width = 3;
        length = 2;
    }
    public void fillPiece() {
//        shape[0][0] = Color.pink;
//        shape[0][1] = Color.pink;
//        shape[1][1] = Color.pink;
//        Color[][] temp = new Color[2][2];
//        temp[1][1] = Color.blue;
//        Color[][] c = new Color[2][2];
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                if(shape[i][j] != null && temp[i][j] == null) {
//                    c[i][j] = shape[i][j];
//                }
//            }
        shape[0][0] = Color.pink;
        shape[0][1] = Color.pink;
        shape[1][1] = Color.pink;
        shape[1][2] = Color.pink;
        Color[][] temp = new Color[3][3];
        temp[1][1] = Color.blue;
        Color[][] c = new Color[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(shape[i][j] != null && temp[i][j] == null) {
                    c[i][j] = shape[i][j];
                }
            }
    }


    }
    public void shiftX(int shift, int xLow, int xHigh) {
        if (x + shift <= xLow && shift < 0) {
            x = xLow;
        }
        else if (x + width * 50 + shift >= xHigh && shift > 0) {
            x = xHigh - width * 50;
        }
        else {
            x += shift;
        }
    }
    public void shiftY(int shift, int yLow, int yHigh) {
        if (y + shift <= yLow && shift < 0) {
            y = yLow;
        }
        else if (y + length * 50 + shift >= yHigh && shift > 0) {
            y = yHigh - length * 50;
        }
        else {
            y += shift;
        }
    }
    public void rotate() {
        if (rotated == 1) {
            Color temp = shape[0][0];
            shape[0][0] = null;
            Color temp2 = shape[0][1];
            shape[0][1] = temp;
            temp = shape[1][1];
            shape[1][1] = temp2;
            shape[1][0] = temp;
            shape[2][0] = shape[1][2];
            shape[1][2] = null;
            length = 3;
            width = 2;
            rotated++;
        }
        else {
            shape[0][0] = shape[0][1];
            shape[0][1] = shape[1][1];
            shape[1][1] = shape[1][0];
            shape[1][0] = null;
            shape[1][2] = shape[2][0];
            shape[2][0] = null;
            rotated = 1;
            length = 2;
            width = 3;
        }
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public int getValue() {
        return value;
    }
    public void draw (Graphics g) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < width; j++) {
                if (shape[i][j] != null) {
                    g.setColor(shape[i][j]);
                    g.fillRect(x + j * 50, y + i * 50, 50, 50);
                }
            }
        }
    }

    public int getX() {
        return x;
    }
}
