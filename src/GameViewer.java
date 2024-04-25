import java.awt.*;
import javax.swing.*;


public class GameViewer extends JFrame{
    private Tetrominoes blocks;
    private Game game;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 800;

    public GameViewer(Game game) {
        this.game = game;
         blocks = new Tetrominoes(50, 50, this, 1);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tetris");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        if(!game.isStarted()) {
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.PLAIN, 15));
            g.drawString("How to play Tetris:", 50, 150);
            g.drawString("In Tetris, you must arrange a sequence of small shapes,", 50, 200);
            g.drawString("called Tetriminos, into complete lines.", 50, 250);
            g.drawString("As each line is completed, it will disappear from the screen.", 50, 300);
            g.drawString("Tetriminos fall from the top of the matrix to the bottom.", 50, 350);
            g.drawString("You must rotate the Tetriminos as they fall and fit them", 50, 400);
            g.drawString("together to create lines.", 50, 450);
            g.drawString("If you cannot complete a line, the blocks will eventually", 50, 500);
            g.drawString("stack up and rise to the top of the playing field", 50, 550);
            g.drawString("(“BLOCKING OUT”) and the game will end.", 50, 600);
            g.setColor(Color.green);
            g.drawRect(75, 650, 350, 100);
            g.setFont(new Font("Serif", Font.PLAIN, 75));
            g.drawString("PLAY", 160, 730);
        }
        else if (!game.gameOver()) {
            g.setColor(Color.white);
            // Reset window
            g.drawRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            blocks.draw(g, 50, 50);
        }
    }
}
