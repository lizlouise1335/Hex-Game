
import java.util.Vector;

/**
 * The GameTree class allows for the construction of objects that contain
 * vectors of possible board configurations, the evalutation of these
 * configurations, and the return of the estimated best moves a given
 * color may make.
 *
 * @author Josh Fisher
 * @author Liz Smith
 *
 */
public class GameTree{
  private HexBoard board;
  private char currentPlayerColor;
  private char lastPlayerColor;
  private Vector<GameTree> children;

  /**
   * GameTree Constructor - creates object that finds and holds info of a gameplay instances
   *                        as well as all childrens' info (recursive constructor)
   *                        until pre-determined depth is reached
   * @param board              current board configuration
   * @param currentPlayerColor current player's char signifier
   * @param depth              how many levels of parent and children should be traversed through
   */
  public GameTree(HexBoard board, char currentPlayerColor, int depth){
    this.board = board;
    this.currentPlayerColor = currentPlayerColor;
    this.children = new Vector<GameTree>();

    if (currentPlayerColor == HexBoard.WHITE) lastPlayerColor = HexBoard.BLACK;
    else lastPlayerColor = HexBoard.WHITE;

    //makes sure given depth has not been exceeded
    if (depth == 0 || board.win(this.lastPlayerColor))
      return;

    //Constructs vector of the GameTree's GameTree children
    Vector<HexMove> colorMoves = board.moves(currentPlayerColor);
    for (int i = 0; i < colorMoves.size(); i++){
      GameTree child = new GameTree(new HexBoard(board, colorMoves.get(i)), lastPlayerColor, depth - 1);
      this.children.add(child);
    }
  }


/**
 * Determines how good/bad each possible future board configuration (child) is
 * @param  tree GameTree object
 * @return      avg of score of the children of a tree object
 */
  private double evaluate(GameTree tree){
    double score = 0;
    //if a leaf of the tree has been reached
    if (tree.children.isEmpty()){
      if (tree.board.win(this.lastPlayerColor)){
        if (this.currentPlayerColor == tree.lastPlayerColor){
          return 1;
        }
        else {
          return -1;
        }
      }
      return 0;
    }

    //calculates score of the GameTree object (through descendents)
    for(GameTree child : tree.children){
      score += evaluate(child)) / tree.children.size();
    }

    return score;
  }


  /**
   * Creates a vector with the best moves that can be made next
   * @return vector with the highest scoring move(s)
   */
  public Vector<HexMove> bestMoves(){
    Vector<HexMove> bestMoves = new Vector<HexMove>();
    Vector<Double> scores = new Vector<Double>();

    //checks if the GameTree object has children to evaluate
    if (this.children.isEmpty())
      return null;

    //evaluates and adds the score of all children to vector scores
    for (GameTree rootChildren : this.children)
      scores.add(evaluate(rootChildren));

    //finds the max double in vector scores
    double max = Double.NEGATIVE_INFINITY;

    for (Double d : scores){
      if (d > max)
        max = d;
    }

    //if a score == max, child's moves are
    for (int i = 0; i < scores.size(); i++){
      if (scores.get(i) == max)
        bestMoves.add(board.moves(currentPlayerColor).get(i));
    }

    return bestMoves;
  }
}
