/**
 * Class provides main (driving) method that kickstarts
 * a Hex game between live players || AIPlayers
 *
 * Set of smart AI's wins (going 1st): [739, 751, 749, 745, 735]
 * Set of smart AI's wins (going 2nd): [951, 964, 956, 964, 946]
 *
 * The disparity in wins btwn the smarter AI going 1st and 2nd was
 * unexpected/unexpectedly large (usually going first is a major advantage
 * for a player). The disparity may be the result of
 * the "more intelligent" AI being forced to make a move without
 * any initial read on the opponent, which results in the intelligence
 * being limited to a whole level shallower than it would be
 * if the smart AI had gotten to go 2nd.
 *
 * @author Josh Fisher
 * @author Liz Smith
 */
public class Driver {
  /**
   * Kickstarts hex games
   * @param names player names
   */
  public static void main(String[] names) {
    //Player alice = new HumanPlayer("Alice",HexBoard.WHITE);
    //Player bob = new HumanPlayer("Bob",HexBoard.BLACK);

    //Player winner = alice.play(new HexBoard(),bob);
    //System.out.println(winner.toString() + " wins!");


    /* Extra Credit DRIVER */
    Player aiWhite = new AIPlayer("Smart (white)", HexBoard.WHITE, 10);
    Player aiBlack = new AIPlayer("Dumb (black)", HexBoard.BLACK, 1);

    int aiWhiteWins = 0;
    Player winnerAI;

    //AI's play for 1000 rounds (depth of 10 goes first)
    for (int i = 0; i < 1000; i++) {
      winnerAI = aiWhite.play(new HexBoard(), aiBlack);
      System.out.println(winnerAI + " wins!");
      if (winnerAI == aiWhite)
        aiWhiteWins++;
    }

    //AI's play for 1000 rounds (depth of 1 goes first)
    int aiWhiteWins2 = 0;

    for (int i = 0; i < 1000; i++) {
     winnerAI = aiBlack.play(new HexBoard(), aiWhite);
      if (winnerAI == aiWhite)
        aiWhiteWins2++;
     }

    System.out.println("Smart's wins (going 1st): " + aiWhiteWins);
    System.out.println("Smart's wins (going 2nd): " + aiWhiteWins2);
  }
}
