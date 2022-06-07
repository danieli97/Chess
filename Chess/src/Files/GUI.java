package Files;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/*
 * Class the creates the main GUI used for the game
 * 
 * Attributes
 * 		board: 			Board object: contains all the information about each players pieces and their locations
 * 
 * Methods
 * 		initBoard:		Initializes the board so a game can be started
 * 
 */

public class GUI  extends JFrame implements ActionListener {

	// Attributes
	private static final String NEW_GAME = "NEWGAME";
	private static final String FORFEIT = "FORFEIT";
	private static final String OFFER_DRAW = "OFFERDRAW";
	private static final String FLIP_BOARD = "FLIPBOARD";
	private static final String SETTINGS = "SETTINGS";
	private static final String STATS = "STATS";
	private static final String QUIT = "QUIT";
	private static final String LEFT = "LEFT";
	private static final String RIGHT = "RIGHT";
	private static final String UP = "UP";
	private static final String DOWN = "DOWN";
	private static final String NORTH_WEST = "NW";
	private static final String NORTH_EAST = "NE";
	private static final String SOUTH_WEST = "SW";
	private static final String SOUTH_EAST = "SE";
	
	private Map<Integer, JLabel> boardMap;	
	public Board board;
	
	// Constructor
	public GUI() {

		super("Chess");
		this.board = new Board();
		this.boardMap = new HashMap<Integer, JLabel>();
		this.setJMenuBar(this.makeMenuBar());
		this.frameConfig();
		this.initBoard();
	}
	
	// Methods
	public void initBoard() {
		JPanel contentPanel = new JPanel();
		contentPanel.add(makeBoardPanel());
		this.setContentPane(contentPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.drawAll();
	}
	
	private final void frameConfig() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(750,750);
		this.setResizable(false);
	}
	
	private final JMenuBar makeMenuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JButton forfeit = this.makeButton("Forfeit", FORFEIT);
		JButton offerDraw = this.makeButton("Offer Draw", OFFER_DRAW);
		JButton flipBoard = this.makeButton("Flip Board", FLIP_BOARD);
		
		bar.add(menu);
		bar.add(new JSeparator());
		bar.add(forfeit);
		bar.add(offerDraw);
		bar.add(flipBoard);

		this.addMenuItem(menu, "New Game", NEW_GAME);
		this.addMenuItem(menu, "Stats", STATS);
		this.addMenuItem(menu, "Settings", SETTINGS);
		menu.addSeparator();
		this.addMenuItem(menu, "Quit", QUIT);
		return bar;
	}
	
	private final void addMenuItem(JMenu menu, String label, String action) {
		JMenuItem item = new JMenuItem(label);
		item.setActionCommand(action);
		item.addActionListener(this);
		menu.add(item);
	}
	
	private static JLabel makeLabel(String s, int r, int g, int b, boolean leftEdge, boolean bottomEdge) {
		JLabel square = new JLabel(s);
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 16);
		square.setFont(font);
		square.setPreferredSize(new Dimension(70, 70));
		square.setMaximumSize(square.getSize());
		square.setOpaque(true);
		Color colour = new Color(r, g, b);
		square.setBackground(colour);
		
		if (leftEdge && bottomEdge) {
			square.setHorizontalTextPosition(JLabel.CENTER);
			square.setVerticalTextPosition(JLabel.BOTTOM);
			square.setText("LETTER");
		}
		else if (leftEdge) {
			square.setHorizontalTextPosition(JLabel.LEFT);
			square.setVerticalTextPosition(JLabel.CENTER);
			square.setText("NUMBER");
		}
		else if (bottomEdge) {
			square.setHorizontalTextPosition(JLabel.CENTER);
			square.setVerticalTextPosition(JLabel.BOTTOM);
			square.setText("LETTER");
		}
		return square;
	}
	
	private JButton makeButton(String s, String cmd) {
		JButton button = new JButton(s);
		button.setBackground(Color.WHITE);
		button.setActionCommand(cmd);
		button.addActionListener(this);
		return button;
	}
	
	private JPanel makeBoardPanel() {
		int width = 8;
		int height = 8;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(height, width, 0, 0));
		for (int coord = 0; coord < 64; coord++) {
			JLabel square;
			boolean leftEdge = false;
			boolean bottomEdge = false;
			if ((coord + 1)% 8 == 1) {
				leftEdge = true;
			}
			if (coord > 55) {
				bottomEdge = true;
			}
			
			boolean beige = (coord / 8 + (coord % 8)) % 2 == 0;
			if (beige) {	// light square (beige)
				square = makeLabel("", 207, 185, 151, leftEdge, bottomEdge);
			} else {						// dark square (dark brown)
				square = makeLabel("", 101, 67, 33, leftEdge, bottomEdge);
			}
			panel.add(square);
			Integer coordinate = coord + 1;
			this.boardMap.put(coordinate, square);
		}
		return panel;
	}
	
	public Map<String, ImageIcon> setImageIcons() {
		
		Map<String, ImageIcon> theIcons = new HashMap<>();
		
		return theIcons;
	}
	
	public void drawAll() {

		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	// Main
	public static void main(String[] args) {
	
		GUI chess = new GUI();
		
	}

}
