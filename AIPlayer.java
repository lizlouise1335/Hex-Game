import java.util.Random;
import java.util.Vector;

/**
 * Class allows for the construction of AI players
 * as well as the ability for the AI to select moves
 * i.e. play the game
 *
 * @author Josh Fisher
 * @author Liz Smith
 */
public class AIPlayer extends AbstractPlayer{
  int intelligence; //AI's depth limit for considering future boards

  /**
   * AI player constructor
   * @param name  AI's name
   * @param color AI's char color
   * @param depth levels of children an AI may consider
   */
  public AIPlayer(String name, char color, int depth){
    super.name = name;
    super.color = color;
    this.intelligence = depth;
  }

  /**
   * Allows the AI player to select a move
   * @param  board current board configuration
   * @return       random move from the best scored moves
   */
  public HexMove selectMove(HexBoard board){
    Random random = new Random();
    Vector<HexMove> bestMoves;
    GameTree currentGameTree = new GameTree(board, color, intelligence);
    bestMoves = currentGameTree.bestMoves();

    return bestMoves.get(random.nextInt(bestMoves.size()));
  }
}
