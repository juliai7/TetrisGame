import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.awt.event.*;

public class Game implements MouseListener, MouseMotionListener, KeyListener{
    private Board board;
    private GameViewer window;
    private Tetrominoes currPiece;
    private int score;
    private boolean started;

    public Game() {
        window = new GameViewer(this);
        score = 0;
        started = false;
        currPiece = new Tetrominoes(200, 27, window, 1);
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
        window.addKeyListener(this);
    }

    public Tetrominoes getCurrPiece() {
        return currPiece;
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
//        if (currPiece.getY() == 700) {
//            currPiece = new Tetrominoes(200, 0, window, 1);
//            window.repaint();
//        }
    }
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.playGame();
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
}
