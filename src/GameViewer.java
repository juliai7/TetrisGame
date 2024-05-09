import java.awt.*;
import javax.swing.*;


public class GameViewer extends JFrame{
    private Tetrominoes blocks;
    private Game game;
    public static int WINDOW_WIDTH = 500;
    public static int WINDOW_HEIGHT = 800;
    private Board board;
    public static int PIECE_SIZE = 50;

    public GameViewer(Game game) {
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tetris");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        board = game.getBoard();
    }

    public void paint (Graphics g) {
        if(!game.isStarted()) {
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.PLAIN, 15));
            g.drawString("How to play Tetris:", 50, 180);
            g.drawString("In Tetris, you must arrange a sequence of small shapes,", 50, 220);
            g.drawString("called Tetriminos, into complete lines.", 50, 260);
            g.drawString("As each line is completed, it will disappear from the screen.", 50, 300);
            g.drawString("Tetriminos fall from the top of the matrix to the bottom.", 50, 340);
            g.drawString("You must rotate the Tetriminos as they fall and fit them", 50, 380);
            g.drawString("together to create lines.", 50, 420);
            g.drawString("If you cannot complete a line, the blocks will eventually", 50, 460);
            g.drawString("stack up and rise to the top of the playing field", 50, 500);
            g.drawString("(“BLOCKING OUT”) and the game will end.", 50, 540);
            g.drawString("Press the up arrow to rotate the piece, the down arrow to", 50, 580);
            g.drawString("make it fall faster, and the left and right arrows to move it.", 50, 620);
            g.setColor(Color.green);
            g.drawRect(75, 650, 350, 100);
            g.setFont(new Font("Serif", Font.PLAIN, 75));
            g.drawString("PLAY", 160, 730);
            g.setFont(new Font("Serif", Font.PLAIN, 100));
            g.setColor(new Color(89, 146, 218, 255));
            g.drawString("TETRIS", 85, 125);
        }
        else if (!board.gameOver()) {
            g.setColor(Color.black);
            // Reset window
            g.drawRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.red);
            g.drawLine(0, 100, 500, 100);
            g.setColor(Color.white);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            int digits = 0;
            if (game.getScore() >= 10 && game.getScore() < 100) {
                digits = 1;
            }
            else if (100 <= game.getScore() && game.getScore() < 1000) {
                digits = 2;
            }
            else if (game.getScore() >= 1000 && game.getScore() < 10000) {
                digits = 3;
            }
            else if (game.getScore() >= 10000 && game.getScore() < 100000) {
                digits = 4;
            }
            g.drawString(String.valueOf(game.getScore()), 230 - digits * 15, 80);
            blocks = game.getCurrPiece();
            blocks.draw(g);
            board.draw(g);
        }
        else {
            g.setColor(Color.black);
            // Reset window
            g.drawRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.red);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("GAME OVER", 110, 350);
        }
    }
}
