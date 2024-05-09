import java.awt.*;
//ask how to make it not error when rotated green piece on the edge and it goes out of bounds
public class Tetrominoes {
    private int x;
    private int y;
    private Color[][] shape;
    private GameViewer window;
    private int value;
    private int rotated;
    private int length;
    private int width;
    private int row;
    private int col;
    private int piece;

    public Tetrominoes (int x, int y, GameViewer window, int value) {
        this.x = x;
        this.y = y;
        shape = new Color[4][4];
        piece = (int)(Math.random() * 7) + 1;
        fillPiece();
        this.window = window;
        this.value = value;
        rotated = 1;
        row = 1;
        col = 4;
    }

    public Color[][] getShape() {
        return shape;
    }


    public void fillPiece() {
        if (piece == 1) {
            width = 3;
            length = 2;
            shape[0][0] = new Color (255, 251, 0, 255);
            shape[0][1] = new Color (255, 251, 0, 255);
            shape[1][1] = new Color (255, 251, 0, 255);
            shape[1][2] = new Color (255, 251, 0, 255);
            Color[][] temp = new Color[3][3];
            temp[1][1] = Color.blue;
            Color[][] c = new Color[3][3];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (shape[i][j] != null && temp[i][j] == null) {
                        c[i][j] = shape[i][j];
                    }
                }
            }
        }
        else if (piece == 2) {
            length = 2;
            width = 3;
            shape[0][1] = Color.blue;
            shape[0][2] = Color.blue;
            shape[1][0] = Color.blue;
            shape[1][1] = Color.blue;
            Color[][] temp = new Color[3][3];
            temp[1][1] = Color.blue;
            Color[][] c = new Color[3][3];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (shape[i][j] != null && temp[i][j] == null) {
                        c[i][j] = shape[i][j];
                    }
                }
            }
        }
        else if (piece == 3) {
            length = 2;
            width = 3;
            shape[0][1] = Color.red;
            shape[1][0] = Color.red;
            shape[1][1] = Color.red;
            shape[1][2] = Color.red;
            Color[][] temp = new Color[3][3];
            temp[1][1] = Color.blue;
            Color[][] c = new Color[3][3];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (shape[i][j] != null && temp[i][j] == null) {
                        c[i][j] = shape[i][j];
                    }
                }
            }

        }
        else if (piece == 4) {
            length = 4;
            width = 1;
            shape[0][0] = Color.green;
            shape[1][0] = Color.green;
            shape[2][0] = Color.green;
            shape[3][0] = Color.green;
            Color[][] temp = new Color[4][3];
            temp[1][1] = Color.blue;
            Color[][] c = new Color[4][3];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (shape[i][j] != null && temp[i][j] == null) {
                        c[i][j] = shape[i][j];
                    }
                }
            }
        }
        else if (piece == 5) {
            length = 3;
            width = 2;
            shape[0][0] = new Color(139, 17, 213,255);
            shape[1][0] = new Color(139, 17, 213,255);
            shape[2][0] = new Color(139, 17, 213,255);
            shape[2][1] = new Color(139, 17, 213,255);
            Color[][] temp = new Color[3][3];
            temp[1][1] = Color.blue;
            Color[][] c = new Color[3][3];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (shape[i][j] != null && temp[i][j] == null) {
                        c[i][j] = shape[i][j];
                    }
                }
            }
        }
        else if (piece == 6) {
            length = 3;
            width = 2;
            shape[0][1] = new Color(220, 96, 8, 255);
            shape[1][1] = new Color(220, 96, 8, 255);
            shape[2][1] = new Color(220, 96, 8, 255);
            shape[2][0] = new Color(220, 96, 8, 255);
            Color[][] temp = new Color[3][3];
            temp[1][1] = Color.blue;
            Color[][] c = new Color[3][3];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (shape[i][j] != null && temp[i][j] == null) {
                        c[i][j] = shape[i][j];
                    }
                }
            }
        }
        else {
            length = 2;
            width = 2;
            shape[0][0] = new Color (26, 226, 231, 255);
            shape[0][1] = new Color (26, 226, 231, 255);
            shape[1][0] = new Color (26, 226, 231, 255);
            shape[1][1] = new Color (26, 226, 231, 255);
            Color[][] temp = new Color[3][3];
            temp[1][1] = Color.blue;
            Color[][] c = new Color[3][3];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (shape[i][j] != null && temp[i][j] == null) {
                        c[i][j] = shape[i][j];
                    }
                }
            }
        }

    }
    public void shiftX(int shift, int xLow, int xHigh) {
        if (x + shift <= xLow && shift < 0) {
            x = xLow;
            col = 0;
        }
        else if (x + width * 50 + shift >= xHigh && shift > 0) {
            x = xHigh - width * 50;
            col = 10 - width;
        }
        else {
            x += shift;
            if (shift > 0) {
                col++;
            }
            else {
                col--;
            }
        }
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
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
            row++;
        }
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
    public void rotatePieceOne() {
        if (rotated == 1) {
            shape[1][0] = shape[0][0];
            shape[0][0] = null;
            shape[2][0] = shape[1][2];
            shape[1][2] = null;
            length = 3;
            width = 2;
            rotated++;
        } else {
            if (x == 500 - width * 50) {
                shiftX(-50, 0, 500);
            }
            shape[0][0] = shape[1][0];
            shape[1][0] = null;
            shape[1][2] = shape[2][0];
            shape[2][0] = null;
            rotated = 1;
            length = 2;
            width = 3;
        }
    }
    public void rotatePieceTwo() {
        if (rotated == 1) {
            shape[0][0] = shape[0][2];
            shape[0][2] = null;
            shape[2][1] = shape[0][1];
            shape[0][1] = null;
            length = 3;
            width = 2;
            rotated++;
        }
        else {
            if (x == 500 - width * 50) {
                shiftX(-50, 0, 500);
            }
            shape[0][1] = shape[0][0];
            shape[0][0] = null;
            shape[0][2] = shape[2][1];
            shape[2][1] = null;
            length = 2;
            width = 3;
            rotated = 1;
        }
    }
    public void rotatePieceThree() {
        if (rotated == 1) {
            shape[0][0] = shape[1][0];
            shape[1][0] = shape[1][1];
            shape[2][0] = shape[1][2];
            shape[1][1] = shape[0][1];
            shape[1][2] = null;
            shape[0][1] = null;
            length = 3;
            width = 2;
            rotated++;
        }
        else if (rotated == 2) {
            if (x == 500 - width * 50) {
                shiftX(-50, 0, 500);
            }
            shape[0][0] = shape[2][0];
            shape[0][1] = shape[1][0];
            shape[0][2] = shape[0][0];
            shape[2][0] = null;
            shape[1][0] = null;
            length = 2;
            width = 3;
            rotated++;
        }
        else if (rotated == 3) {
            shape[0][1] = shape[0][0];
            shape[1][1] = shape[0][1];
            shape[2][1] = shape[0][2];
            shape[1][0] = shape[1][1];
            shape[0][0] = null;
            shape[0][2] = null;
            length = 3;
            width = 2;
            rotated++;
        }
        else {
            if (x == 500 - width * 50) {
                shiftX(-50, 0, 500);
            }
            shape[1][0] = shape[2][1];
            shape[0][1] = shape[1][0];
            shape[1][2] = shape[0][1];
            shape[2][1] = null;
            length = 2;
            width = 3;
            rotated = 1;
        }
    }
    public void rotatePieceFour() {
        if (rotated == 1) {
            if (x == 500 - width * 50) {
                shiftX(-150, 0, 500);
                col = 6;
            }
            for (int i = 1; i <= 3; i++) {
                shape[0][i] = shape[i][0];
                shape[i][0] = null;
            }
            length = 1;
            width = 4;
            rotated++;
        }
        else {
            for (int i = 1; i <= 3; i++) {
                shape[i][0] = shape[0][i];
                shape[0][i] = null;
            }
            width = 1;
            length = 4;
            rotated = 1;
        }
    }
    public void rotatePieceFive() {
        if (rotated == 1) {
            if (x == 500 - width * 50) {
                shiftX(-50, 0, 500);
            }
            shape[0][1] = shape[2][0];
            shape[2][0] = null;
            shape[0][2] = shape[2][1];
            shape[2][1] = null;
            rotated++;
            length = 2;
            width = 3;
        }
        else if (rotated == 2) {
            shape[1][1] = shape[1][0];
            shape[1][0] = null;
            shape[2][1] = shape[0][2];
            shape[0][2] = null;
            rotated++;
            length = 3;
            width = 2;
        }
        else if (rotated == 3) {
            if (x == 500 - width * 50) {
                shiftX(-50, 0, 500);
            }
            shape[0][2] = shape[0][0];
            shape[0][0] = null;
            shape[1][2] = shape[0][1];
            shape[0][1] = null;
            shape[1][0] = shape[2][1];
            shape[2][1] = null;
            rotated++;
            length = 2;
            width = 3;
        }
        else {
            shape[0][0] = shape[1][1];
            shape[1][1] = null;
            shape[2][0] = shape[1][2];
            shape[1][2] = null;
            shape[2][1] = shape[0][2];
            shape[0][2] = null;
            rotated = 1;
            length = 3;
            width = 2;
        }
    }
    public void rotatePieceSix() {
        if (rotated == 1) {
            if (x == 500 - width * 50) {
                shiftX(-50, 0, 500);
            }
            shape[0][0] = shape[2][0];
            shape[2][0] = null;
            shape[1][0] = shape[2][1];
            shape[2][1] = null;
            shape[1][2] = shape[0][1];
            shape[0][1] = null;
            rotated++;
            length = 2;
            width = 3;
        }
        else if (rotated == 2) {
            shape[0][1] = shape[1][1];
            shape[1][1] = null;
            shape[2][0] = shape[1][2];
            shape[1][2] = null;
            rotated++;
            length = 3;
            width = 2;
        }
        else if (rotated == 3) {
            if (x == 500 - width * 50) {
                shiftX(-50, 0, 500);
            }
            shape[0][2] = shape[1][0];
            shape[1][0] = null;
            shape[1][2] = shape[2][0];
            shape[2][0] = null;
            rotated++;
            width = 3;
            length = 2;
        }
        else {
            shape[1][1] = shape[0][0];
            shape[0][0] = null;
            shape[2][0] = shape[0][2];
            shape[0][2] = null;
            shape[2][1] = shape[1][2];
            shape[1][2] = null;
            rotated = 1;
            width = 2;
            length = 3;
        }
    }

    public void rotate() {
        if (piece == 1) {
            rotatePieceOne();
        }
        else if (piece == 2) {
            rotatePieceTwo();
        }
        else if (piece == 3) {
            rotatePieceThree();
        }
        else if (piece == 4) {
            rotatePieceFour();
        }
        else if (piece == 5) {
            rotatePieceFive();
        }
        else if (piece == 6) {
            rotatePieceSix();
        }
    }

    public int getWidth() {
        return width;
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
        for (int i = 0; i < length; i++) {
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
