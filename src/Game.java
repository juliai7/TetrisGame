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
    public void printInstructions() {
        System.out.println("In Tetris, you must arrange a sequence of small\n" +
                "shapes, called Tetriminos, into complete lines.\n" +
                "As each line is completed, it will disappear from\n" +
                "the screen.\n" +
                "Tetriminos fall from the top of the matrix to the\n" +
                "bottom.\n" +
                "You must rotate the Tetriminos as they fall and fit\n" +
                "them together to create lines.\n" +
                "If you cannot complete a line, the blocks will\n" +
                "eventually stack up and rise to the top of the\n" +
                "playing field (“BLOCKING OUT”) and the game\n" +
                "will end. ");
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
        Scanner input = new Scanner(System.in);
        printInstructions();
        System.out.println("Would you like to play? (y/n)");
        String answer = input.nextLine();
        if(answer.equals("n")) {
            //exit the program
        }
        else if (answer.equals("y")) {
            started = true;
            window.repaint();
        }
        else {

        }
    }
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.playGame();
    }

}
