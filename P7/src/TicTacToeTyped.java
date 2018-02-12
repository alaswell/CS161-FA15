// Alex Laswell
// CS 161
// Program 7 TicTacToe
// Email: alaswell@cs.colostate.edu

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class TicTacToe extends JFrame
{
	//*****************************//
	// INSTANCE VARIABLE CONSTANTS //
	//*****************************// 
	
	public static final int ROWS = 3; // ROWS by COLS cells
	public static final int COLS = 3;

	// Named-constants of the various dimensions used for graphics drawing
	public static final int CELL_SIZE = 100; // cell width and height (square)
	public static final int CANVAS_WIDTH = CELL_SIZE * COLS; // drawing the canvas
	public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
	public static final int GRID_WIDTH = 8;				// Grid-line's width
	public static final int GRID_WIDTH_HALF = GRID_WIDTH / 2;	// Grid-line's half-width

	// Symbols (cross/nought) are displayed inside a cell, with padding from border
	public static final int CELL_PADDING = CELL_SIZE / 6;
	public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2; // widht/height
	public static final int SYMBOL_STROK_WIDTH = 8;	// pen's stroke width

	//**********************************//
	// INSTANCE VARIABLES for game play //
	//**********************************//
	
	private GameState currentState; // the current game state
	private Mark currentPlayer; 	// the current player
	private Mark[][] board; 	// Game board of ROWS-by-COLS cells
	private Random random;
	
	//*********************************//
	// INSTANCE VARIABLES for graphics //
	//*********************************//
	
	private DrawCanvas canvas; 	// Drawing canvas (JPanel) for the game board
	private JLabel statusBar; 	// Status Bar
	
	//***************//
	// INNER CLASSES //
	//***************//
	
	// Use an enum (inner class) to represent the various states of the game.
	public enum GameState { PLAYING, DRAW, CROSS_WON, NAUGHT_WON }

	// Use an enum (inner class) to represent the markers in each cell
	public enum Mark { EMPTY, CROSS, NAUGHT }

	//**************//
	// CONSTRUCTOR  //
	//**************//
	
	public TicTacToe()
	{
		// First, build all graphics components
		canvas = new DrawCanvas(); // Construct a drawing canvas (a JPanel)
		canvas.setPrefferedSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

		// The canvas (JPanel) fires a MouseEvent upon mouse-click
		canvas.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// mouse-clicked handler

				// Get the x and y coordinates of the screen pixel that was clicked
				int mouseX = e.getX();
				int mouseY = e.getY();
				
				// Convert the x,y screen coordinates to a row and column index
				int rowSelected = mouseY / CELL_SIZE;
				int colSelected = mouseX / CELL_SIZE;
				
				// Make the selected move and update the state of the game
				makeMoveOrRestart(rowSelected, colSelected

				// Refresh the drawing canvas by posting the repaint event,
				// which signals the JPanel code to call it's paintComponent method
				repaint();
			}
		});
	
		// Setup the status bar (JLabel) to display status message
		statusBar = new JLabel("  ");
		statusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
		statusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));

		// Create a container for holding graphics components, and add the canvas and status bar
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(canvas, BorderLayout.CENTER);
		cp.add(statusBar, BorderLayout.PAGE_END);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); // pack all the components and initialize the game
		setTitle("Tic Tac Toe");
		setVisible(true); // show this JFrame

		// NOW define game components and initialize the game
	
		random = new Random();
		board = new Mark[ROWS][COLS]; // allocate the array
		restartGame(); // initialize the game board contents and game variables
	}

	
	// Initialize the game-board contents and the status 
	pubic void restartGame() 
	{
		for (int row = 0; row < ROWS; ++row)
		{
			for (int col = 0; co < COLS; ++col)
			{
				board[row][col] = Mark.EMPTY; // all cells empty
			}
		}
		currentState = GameState.PLAYING; // ready to play
		currentPlayer = Mark.CROSS; 	  // cross plays first
	}

	// If game is not a win or draw yet and this is a valid move, make the move and update game state.
	// Add code here to automatically make the opponent's move, if the currentState is still GameState.PLAYING
	public void makeMoveOrRestart( int rowSelected, int colSelected)
	{
		if (currentState == GameState.PLAYING)
		{
			if (validMove(rowSelected,colSelected))
			{
				udateGameState(currentPlayer, rowSelected, colSelected);
				switchPlayer();
			}
		}
		else {			// game over
			restartGame();	// restart game
		}
	}

	// Is row,col a valid move?
	public boolean validMove( int row, int col)
	{
		return row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == Mark.EMPTY;
	}

	// Make the move and update the state of the game. 
	public void updateGameState(Mark theMark, int rowSelected, int colSelected)
	{
		board[rowSelected][colSelected] = currentPlayer; // Make the move
