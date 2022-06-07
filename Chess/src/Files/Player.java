package Files;

import java.util.ArrayList;
import java.util.Map;

/*
 * Abstract class representing one of the two possible players: Human or AI
 * 
 * Attributes
 * 		pieces:			ArrayList of Pieces: contains all the pieces belonging to this Player that are still in the game
 * 		checkMated:		Boolean value: true if this Player has been checkmated, false if not
 * 		staleMated:		Boolean value: true if this Player has been stalemated, false if not 
 * 
 * Methods
 * 		
 * 
 */

public abstract class Player {

	// Attributes
	public ArrayList<Piece> pieces;
	public static Board board;
	public char colour;
	public boolean checkMated;
	public boolean staleMated;
	public Map<String, Piece> clonables;
	
	// Methods
	public ArrayList<Piece> getPieces() {
		return this.pieces;
	}
	
	public void initPieces() {
		ArrayList<Piece> thePieces = new ArrayList();
		
		Piece.getClonables(this.colour);
		
		this.pieces = thePieces;
	}
	
	public boolean getCheckMated() {
		return this.checkMated;
	}
	
	public void setCheckMated() {
		this.checkMated = true;
	}
	
	public boolean getStaleMated() {
		return this.checkMated;
	}
	
	public void setStaleMated() {
		this.staleMated = true;
	}
}
