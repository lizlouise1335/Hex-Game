# Hex-Game
The following explanations of the project's classes are copy-pasted from the html files. 

class Driver:
Class provides main (driving) method that kickstarts a Hex game between live players

Small Analysis: AIPlayers Set of smart AI's wins (going 1st): [739, 751, 749, 745, 735] Set of smart AI's wins (going 2nd): [951, 964, 956, 964, 946]... 
The disparity in wins btwn the smarter AI going 1st and 2nd was unexpected/unexpectedly large (usually going first is a major advantage for a player). The disparity may be the result of the "more intelligent" AI being forced to make a move without any initial read on the opponent, which results in the intelligence being limited to a whole level shallower than it would be if the smart AI had gotten to go 2nd.

class AIPlayer:
Class allows for the construction of AI players as well as the ability for the AI to select moves i.e. play the game

class GameTree:
The GameTree class allows for the construction of objects that contain vectors of possible board configurations, the evalutation of these configurations, and the return of the estimated best moves a given color may make.

class HumanPlayer:
Class allows the construction of a live player and also allows for live player to interact with their assigned pieces, move pieces legally, and only during their turn

The following classes were not written by me, Liz Smith, and my partner, Josh Fisher. They were given to us at the beginning of the project, largely for animation purposes:
Player, HexBoard, HexMove
