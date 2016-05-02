public class Player {
/*
This class creates a player to play a variation of Nim, where each player takes turns
removing cakes from the center pile and whoever takes the last cake loses.
There is an additional rule that a player can't remove the same
number of cakes that were removed the turn before.
firstMove() decides if the player wants to play first.
move() looks at the current state of the game, then returns the number of cakes to take.
*/
  public Player(int cakes) {
  }
	// Decide who move first - player or opponent (true if player)
  public boolean firstMove(int cakes) {
    if ((cakes-2)%4 == 0 || cakes <=2) {return false;}
    else
    // I wish to move first
    return true;
  }
	
	// Decide your next move
  public int move(int cakes, int last) {
    if ((cakes-2)%4 == 0 || (cakes-2)%4 == 2) {return last == 3 ? 2 : 3;} //first condition checks for loss, second checks for win; either way take high value.
    if ((cakes-2)%4 == 1) {return last == 1 ? 3 : 1;} //return 1 to win; if last was 1, return 3 to end game quicker.
    if ((cakes-2)%4 == 3) {return last == 3 ? 2: 3;} //return 3 to win; if last was 3, return 2 to end game quicker.
    System.out.printf("There are %d cakes and %d was taken last",cakes,last);
    return 1; //This only triggers on a loss with 1 or 2 cakes.
  }
}