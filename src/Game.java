import java.awt.event.MouseEvent;
import java.util.Scanner;

public class Game {
    private Board board;
    private GameViewer window;
    private Tetrominoes currPiece;
    private int score;
    private boolean started;

    public Game() {
        window = new GameViewer(this);
        score = 0;
        started = false;

    }
    public void checkCompletion() {

    }
    //figure out how to get direction input
    public void movePiece() {

    }
    public boolean gameOver() {
        return false;
    }

    public boolean isStarted() {
        return started;
    }

    public void playGame() {

    }
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.playGame();
    }
    public void mousePressed(MouseEvent e) {
        if (75 <= e.getX() && e.getX() <= 425 && e.getY() > )
        started = true;
        window.repaint();
    }

}
