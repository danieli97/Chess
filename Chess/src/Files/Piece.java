package Files;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.ImageIcon;
import Pieces.*;

/*
 * Abstract class representing any type of piece on the board
 * 
 * Attributes
 * 		colour:		Colour of Piece: White (W) or Black (B)
 * 		name:		Name of Piece: King (K), Queen (Q), Rook (R), Bishop (B), Knight (N), Pawn (P)
 * 		img:		Image of Piece: png or jpg found in Icons package
 * 		loc:		Location of Piece: location defined in Location class
 * 		coord:		int value: represents the one of the 64 locations on the board
 * 		board:		Static Reference to Board: contains all the information about all the pieces
 * 
 * Methods
 * 		getColour:	gets this piece's colour
 * 		getName:	gets this piece's name
 * 		getIcon:	gets this piece's icon
 * 		getLoc:		gets this piece's location
 * 		setLoc:		sets this piece's location to its new location
 * 		getCoord:	gets the current coordinate of this piece
 * 		setCoord:	sets the coordinate of the piece to its new location
 * 		canMove:	checks if the piece can move to the desired location
 * 		move:		sets the location object and the coordinate of the piece to its new values
 * 		makeCopy:	return a copy of this object
 * 		update:		for some command move this piece to some location
 * 
 */

public abstract class Piece {

	// Attributes
	public char colour;
	public String name;
	public ImageIcon img;
	public Location loc;
	public int coord;
	public static Board board;
	
	// Methods
	public char getColour() {
		return this.colour;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ImageIcon getIcon() {
		return this.img;
	}
	
	public Location getLoc() {
		return this.loc;
	}
	
	public void setLoc(int x, int y) {
		this.loc.setX(x);
		this.loc.setY(y);
	}
	
	public int getCoord() {
		return this.coord;
	}
	
	public void setCoord(int x, int y) {
		// edits this piece's coord object
	}
	
	public static Map<String, Piece> getClonables(char colour){
		Map<String, Piece> clonables = new HashMap<String, Piece>();
		LinkedList<Piece> cloneTemplates = new LinkedList<Piece>();
		Location tempLoc = new Location(-1, -1);	// placeholder Location for each mod

		// initialize a single instance of each modification to be copied
		cloneTemplates.add(new King(tempLoc, colour));
		cloneTemplates.add(new Queen(tempLoc, colour));
		cloneTemplates.add(new Rook(tempLoc, colour));
		cloneTemplates.add(new Bishop(tempLoc, colour));
		cloneTemplates.add(new Knight(tempLoc, colour));
		cloneTemplates.add(new Pawn(tempLoc, colour));

		// map each Modification letter to their respective instance
		for (Piece piece : cloneTemplates) {
			clonables.put(piece.getName(), piece);
		}

        return clonables;
    }
	
	public abstract boolean canMove(String cmd);
	public abstract boolean move(String cmd);
	public abstract Piece makeCopy(Location loc);
	public abstract String update(String cmd);
	
}
