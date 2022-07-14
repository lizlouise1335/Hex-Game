import java.util.Scanner;
import java.util.Vector;

/**
 * @author Josh Fisher
 * @author Liz Smith
 *
 * Class allows the construction of a live player
 * and also allows for live player to interact with their assigned pieces,
 * move pieces legally, and only during their turn
 */
public class HumanPlayer extends AbstractPlayer{
  Scanner obj = new Scanner(System.in);

  /**
   * Construct a live player
   * @param name  name of player
   * @param color char rep of color of player's pieces (black or white)
   */
  public HumanPlayer(String name, char color){
    super.name = name;
    super.color = color;
  }

  /**
   * Allows player to legally move their pieces during their turn
   * @param  board current board configuration
   * @return       the HexMove the player selects
   */
  public HexMove selectMove(HexBoard board){
    String go; //string rep of the color moving
    if (this.color == HexBoard.WHITE)
      go = "White";
    else go = "Black";

    Vector<HexMove> moves = board.moves(this.color); //available moves

    System.out.println("Your move " + go + " ("+ super.name + ").");
    for(int i = 0; i < moves.size(); i++){ //Displays move options
    System.out.println("Option " + (i + 1) + ": " + moves.get(i));
    }

    System.out.println("Which option do you choose?");
    try {
      String theMove = obj.nextLine(); //read user input
      return moves.get(Integer.parseInt(theMove)-1);

    } catch (Exception e) {
      System.out.println("Index invalid.");
      return this.selectMove(board);
    }
  }
}
