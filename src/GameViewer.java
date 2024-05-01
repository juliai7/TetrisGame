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
            g.drawString("How to play Tetris:", 50, 200);
            g.drawString("In Tetris, you must arrange a sequence of small shapes,", 50, 240);
            g.drawString("called Tetriminos, into complete lines.", 50, 280);
            g.drawString("As each line is completed, it will disappear from the screen.", 50, 320);
            g.drawString("Tetriminos fall from the top of the matrix to the bottom.", 50, 360);
            g.drawString("You must rotate the Tetriminos as they fall and fit them", 50, 400);
            g.drawString("together to create lines.", 50, 440);
            g.drawString("If you cannot complete a line, the blocks will eventually", 50, 480);
            g.drawString("stack up and rise to the top of the playing field", 50, 520);
            g.drawString("(“BLOCKING OUT”) and the game will end.", 50, 560);
            g.setColor(Color.green);
            g.drawRect(75, 650, 350, 100);
            g.setFont(new Font("Serif", Font.PLAIN, 75));
            g.drawString("PLAY", 160, 730);
            g.setFont(new Font("Serif", Font.PLAIN, 100));
            g.setColor(new Color(89, 146, 218, 255));
            g.drawString("TETRIS", 85, 125);
        }
        else if (!game.gameOver()) {
            g.setColor(Color.black);
            // Reset window
            g.drawRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.red);
            g.drawLine(0, 100, 500, 100);
            blocks = game.getCurrPiece();
            blocks.draw(g);
            board.draw(g);

        }
    }
}
