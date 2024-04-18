import java.awt.*;

public class GameViewer {
    private Image[] piecesImages;
    private Game game;
    private final int WINDOW_WIDTH;
    private final int WINDOW_HEIGHT;

    public GameViewer(Game game) {
        this.game = game;
        WINDOW_WIDTH = 500;
        WINDOW_HEIGHT = 800;
        piecesImages = new Image[6];
    }

    public Image[] getPiecesImages() {
        return piecesImages;
    }
    public void paint (Graphics g) {

    }
}
