public class Game {
    private Board board;
    private GameViewer window;
    private Tetrominoes currPiece;
    private int score;

    public Game() {
        window = new GameViewer(this);
        score = 0;

    }
    public void printInstructions() {

    }
    public void checkCompletion() {

    }
    //figure out how to get direction input
    public void movePiece(direction) {

    }
    public boolean gameOver() {

    }
    public void playGame() {

    }
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.playGame();
    }

}
