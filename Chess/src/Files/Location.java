package Files;

/* 
 * Class representing the location of a piece on the board
 * 
 * Attributes
 * 		x:			x coordinate of the piece (denoted on the board as a - h)
 * 		y:			y coordinate of the piece (denoted on the board as 1 - 8)
 * 
 * Methods
 * 		getX:		returns the x coordinate valued 1 - 8 (representing a - h)
 * 		getY:		returns the y coordinate valued 1 - 8 (representing 1 - 8)
 * 		setX:		sets the x coordinate of this location object to the given value
 * 		setY:		sets the y coordinate of this location object to the given value
 */

public class Location {

	// Attributes
	private int x;
	private int y;

	// Constructor
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Methods

	// Getters
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	// Setters
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}

