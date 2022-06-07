package Files;

import java.util.ArrayList;
import java.util.Map;

/*
 * Class representing the Board
 * 
 * Attributes
 * 		player1: 			Player object: contains all of player1's information regarding their pieces
 * 		player2:			Player object: contains all of player2's information regarding their pieces
 * 		turn:				char value: represents the colour of the players whos turn it is: White (W) or Black (B)
 * 		locs:				HashMap: contains integers (1 - 64) each pointing to either null or a Location object depending on if a piece is at that locaiton
 * 		pieceLocs:			HashMap: contains Location objects each pointing to a corresponding Piece.
 * 
 * Methods
 * 		getPlayerPieces:	
 * 		checkTurn:			
 * 		changeTurns:		
 * 		getLoc:				
 * 		getPieceLocs:		
 * 		check4Check:		
 * 		check4CheckMate:	
 * 		check4StaleMate:	
 * 		notifyObservers:	
 */

public class Board {

	// Attributes
	public Player player1;
	public Player player2;
	public char turn;
	public Map<Integer, Location> locs;
	public Map<Location, Piece> pieceLocs;
	
	// Constructor
	public Board() {
		// initialize player objects (player1, player2)
		this.turn = 'W';
		// create locs 
		// create pieceLocs
	}
	
	// Methods
	public ArrayList<Piece> getPlayerPieces(Player player) {
		return player.getPieces();
	}
	
	public char checkTurn() {
		return this.turn;
	}
	
	public void changeTurns() {
		if (this.turn == 'W') {
			this.turn = 'B';
		} else { // this.turn == 'B'
			this.turn = 'W';
		}
	}
	
	public Map<Integer, Location> getLocs() {
		return this.locs;
	}
	
	public Map<Location, Piece> getPieceLocs() {
		return this.pieceLocs;
	}
	
	public boolean check4Check() {
		
		return true;
	}
	
	public boolean check4CheckMate() {
		
		return true;
	}
	
	public boolean check4StaleMate() {
		
		return true;
	}
	
	public void notifyObservers(String cmd) {
		
	}
}
