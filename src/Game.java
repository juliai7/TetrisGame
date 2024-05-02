import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.*;

public class Game implements MouseListener, MouseMotionListener, KeyListener, ActionListener{
    private Board board;
    private GameViewer window;
    private Tetrominoes currPiece;
    private int score;
    private boolean started;
    private static final int DELAY_IN_MILLISEC = 1005;

    public Game() {
        board = new Board(this);
        window = new GameViewer(this);
        score = 0;
        started = false;
        currPiece = new Tetrominoes(150, 0, window, 1);
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
        window.addKeyListener(this);
        Timer clock = new Timer(DELAY_IN_MILLISEC, this);

        // Now actually start the timer.
        clock.start();
    }

    public Board getBoard() {
        return board;
    }

    public Tetrominoes getCurrPiece() {
        return currPiece;
    }

    public void checkCompletion() {

    }
    public boolean gameOver() {
        return false;
    }

    public boolean isStarted() {
        return started;
    }

    public void playGame() {
    }

    public void setCurrPiece(Tetrominoes currPiece) {
        this.currPiece = currPiece;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (75 <= e.getX() && e.getX() <= 425 && e.getY() <= 750 && e.getY() >= 650) {
            started = true;
            window.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                currPiece.shiftX(-50, 0, 500);
                break;
            case KeyEvent.VK_RIGHT:
                currPiece.shiftX(50, 0, 500);
                break;
            case KeyEvent.VK_DOWN:
                currPiece.shiftY(50, 0, 800);
                break;
            case KeyEvent.VK_UP:
                currPiece.rotate();
                break;
        }
        window.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (started) {
            if(!board.hasHit(currPiece)) {
                currPiece.shiftY(50, 0, 800);
            } else {
                currPiece = new Tetrominoes(150, 0, window, 1);
            }

            window.repaint();
        }
    }

    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.playGame();
    }
}
