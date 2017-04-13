/***********************************************************
 * Project #2 (CIS 181, Fall 2008)                         *
 * Submitted By: Your name here !!!                        *
 * SID: Your new SID starting with "00"                    *
 * Date: Your submission date                              *
 ***********************************************************/

/**
 * CIS 181 Array Based Implementation of Conway's Game Of Life
 * The game of life class: GameOfLife.java
 *
 * @author Haiping Xu
 * Created on October 25, 2008
 **/

public class GameOfLife implements GameInterface {
    private boolean[][] originalMap,    // The initial cell configuration
                                map,    // The current cell configuration
                             newMap;    // The next generation configuration
    private GameGUI gui;
    private int generation = 0;
    private FileIO fileIO;

    // GameOfLife constructor
    public GameOfLife() {
        originalMap = new boolean[MAX_ROWS][MAX_COLS];
        map = new boolean[MAX_ROWS][MAX_COLS];
        newMap = new boolean[MAX_ROWS][MAX_COLS];
        gui = new GameGUI(this, map);
        gui.setTitle("CIS 181 Array Based Game Of Life");
        fileIO = new FileIO("life", "Game of Life Text Files");
        readExample(2);
    }

    //  ====>>>>> Complete the methods below this line! <<<<<====

    // copyMap:
    // Precondtions: None.
    // Postcondtion: 'map' is a deep copy of 'sourceMap'.
    //
    private void copyMap(boolean sourceMap[][]) {
    	for(int i = 0; i < sourceMap.length; ++i){
    		for(int j = 0; j < sourceMap[i].length; ++j){
    			map[i][j] = sourceMap[i][j];
    		}
    	}	
    }

    // clearMap:
    // Precondtions: None.
    // Postcondtion: Sets all cells of the 'targetMap' to DEAD.
    //
    private void clearMap(boolean targetMap[][]) {
    	for(int i = 0; i < targetMap.length; ++i){
    		for(int j = 0; j < targetMap[i].length; ++j){
    			targetMap[i][j] = false;

    		}
    	}	
    }

    //  getFlatNeighborCount:
    //  Precondtions:  0 <= row < MAX_ROWS and 0 <= col < MAX_COLS.
    //  Postcondtion:  A count of all LIVE neighbors of the cell at [row, col] is
    //                 returned where its neighbors are all the ADJACENT cells
    //                 including those
    //                 a) In the rows BELOW and ABOVE the cell (if any exist).
    //                 b) In the columns LEFT and RIGHT of the cell (if any exist).
    //                 Thus, a cell adjacent to a board edge (or corner) has
    //                 fewer neighbors than other cells.
    //
    private int getFlatNeighborCount(int row, int col){

		/* 
			Top row
		{ -1, -1 },  r-1 c-1 
		{ -1, 0  },  r-1 c
		{ -1,  1 },  r-1 c+1

			Sides
		{ 0, -1  },  r c-1 
		{ 0, 1   },  r c + 1

			Bottom Row 
		{ 1, -1  },  r+1 c-1
		{ 1,  0  },  r+1 c
		{ 1,  1  }   r+1 c+1

		*/
	    
    	int count = 0; 
    	
        // Iterate through the rows 
		for(int x = row-1; x <= row+1; ++x) {

			// Check if in bounds 
			if(x >= 0 && x < MAX_ROWS) {
				// Iterate through columns
				for(int y = col-1; y <= col+1; ++y) {

					// check if inbounds
					if(y >= 0 && y < MAX_COLS) {
						// If its not the (row, col) then its a neighbor
						if(map[x][y])
							++count;
					}

				}
			}
		}
		
		// Dont count RC 
		if(map[row][col])
			--count;

        return count;
    }


    // nextGenerationForFlatGrid:
    // Precondtions: None
    // Postcondtion: The next generation of live and dead cells is calculated using
    //               a) the FLAT neighbor counts.
    //               b) the current birth, survival and death count rules.
    //               c) the rules are applied to the counts obtained from the current
    //                  generation's configuration of live and dead cells.
    //               The current 'map' is updated to the next generation's configuration
    //               of live and dead cells.
    //		     d) the global variable 'generation' is increased by 1
    //	
    public  void nextGenerationForFlatGrid() {
    	
		for(int i = 0; i < map.length; ++i) {
    		for(int j = 0; j < map[i].length; ++j) {
    			
    			// A)
    			boolean point = map[i][j];
    			
    			int neighborCount = getFlatNeighborCount(i, j);
    			
    			
    			// A dead cell with 3 neighbors is reborn
    			if(point == DEAD && neighborCount == BIRTH_NBR_COUNTS) {
    				newMap[i][j] = ALIVE;  
    			} else if (point == ALIVE && (neighborCount == SURV_NBR_COUNTS_2 || neighborCount == SURV_NBR_COUNTS_3)) { // a cell with two or three living neighbors remains alive next generation   				
    				newMap[i][j] = ALIVE;
    			} else if (point == ALIVE && neighborCount >= 4) { // A live cell with 4 or more neighbors dies due to over population 
    				newMap[i][j] = DEAD;
    			} else if(point == ALIVE && neighborCount <= 1) { // A live cell with one or fewer living neighbors dies from loneliness
    				newMap[i][j] = DEAD; 
    			}
    			
    		}
    	}
    	
    	copyMap(newMap); 
    	clearMap(newMap);
    	// D)
    	++generation;
    }


   // ==> 5. Implement the game of life for torus grid.
    
    // getTorusNeighborCount:
    // Precondtions:   
    //  Postcondtion:  A count of all LIVE neighbors of the cell at [row, col] is
    //                 returned where its neighbors are all the ADJACENT cells
    //                 including those
    //                 a) In the rows BELOW and ABOVE the cell (if any exist).
    //                 b) In the columns LEFT and RIGHT of the cell (if any exist).
    //                 c) If it steps out of bounds then it will wrap around to the other side of the grid
	//					i.e [5,49] has a neighbor at [5,0], this applies to the top and bottom as well, [0,15] has a neighbor at [49, 15]
    //                 Thus, a cell adjacent to a board edge (or corner) has
    //                 as many neighbors as other cells.
    public int getTorusNeighborCount(int row, int col) {
        int count = 0;
        
        // Wrapping for x and y 
        int dx = 0;
        int dy = 0; 

        // each row 
		for(int x = row-1; x <= row+1; ++x) {

			// Wrapping effect
			dx = x;

			if(x < 0) {	
				dx = 49;
			}
			
			if(x >= 50) {
				dx = 0;
			}
			

			// Each col
			for(int y = col-1; y <= col+1; ++y) {

				// Wrapping effect
				dy = y;
				
				if(y < 0) {
					dy = 49;
				}

				if(y >= 50) {
					dy = 0;
				} 
				

				// If its not the (row, col) then its a neighbor
				if(map[dx][dy])
					++count;
			}

		}
		
		// Don't count this 
		if(map[row][col])
			--count;
		
				
        return count;
    }

    // nextGenerationForFlatGrid:
    // Precondtions: None
    // Postcondtion: The next generation of live and dead cells is calculated using
    //               a) the TORUS neighbor counts.
    //               b) the current birth, survival and death count rules.
    //               c) the rules are applied to the counts obtained from the current
    //                  generation's configuration of live and dead cells.
    //               The current 'map' is updated to the next generation's configuration
    //               of live and dead cells.
    //		     d) the global variable 'generation' is increased by 1
    //	
    public void nextGenerationForTorusGrid() {
		for(int i = 0; i < map.length; ++i) {
    		for(int j = 0; j < map[i].length; ++j) {
    			
    			// A)
    			boolean point = map[i][j];
    			
    			// B)
    			int neighborCount = getTorusNeighborCount(i, j);
    			
    			
    			// C)
    			// A dead cell with 3 neighbors is reborn
    			if(point == DEAD && neighborCount == BIRTH_NBR_COUNTS) {
    				newMap[i][j] = ALIVE;  
    			} else if (point == ALIVE && (neighborCount == SURV_NBR_COUNTS_2 || neighborCount == SURV_NBR_COUNTS_3)) { // a cell with two or three living neighbors remains alive next generation   				
    				newMap[i][j] = ALIVE;
    			} else if (point == ALIVE && neighborCount >= 4) { // A live cell with 4 or more neighbors dies due to over population 
    				newMap[i][j] = DEAD;
    			} else if(point == ALIVE && neighborCount <= 1) { // A live cell with one or fewer living neighbors dies from loneliness
    				newMap[i][j] = DEAD; 
    			}
    			
    		}
    	}
    	
    	copyMap(newMap); 
    	clearMap(newMap);
    	// D)
    	++generation;
    }




    //  ====>>>>> Don't touch the code below this line! <<<<<====

    // Return the next generation
    public int getGeneration() {
        return generation;
    }

    // Reset the map to the original map
    public void reset() {
        copyMap(originalMap);
        generation = 0;
        gui.repaint();
    }

    // Game of life examples 1-4: Fish, Plus, Glider, FlyingMachine
    public void readExample(int n) {
        System.out.println("Initializing with example " + n + " ...");
        clearMap(originalMap);

        switch (n) {
           case 1: // Example 1: Fish
             for (int col = 23; col <= 26; col++)
                 originalMap[13][col] = ALIVE;
             originalMap[14][22] = ALIVE;
             originalMap[14][26] = ALIVE;
             originalMap[15][26] = ALIVE;
             originalMap[16][22] = ALIVE;
             originalMap[16][25] = ALIVE;
             break;
           case 2: // Example 2: Plus
               for (int col = 6; col < 43; col++)
                 originalMap[24][col] = ALIVE;
             for (int row = 6; row < 43; row++)
                 originalMap[row][24] = ALIVE;
             break;
           case 3: // Example 3: Glider
                originalMap[14][23] = ALIVE;
             originalMap[15][24] = ALIVE;
             for (int row = 13; row <= 15; row++)
                 originalMap[row][25] = ALIVE;
             break;
           case 4: // Example 4: FlyingMachine
                for (int col = 22; col <= 25; col++) {
                 originalMap[11][col] = ALIVE;
                 originalMap[19][col] = ALIVE;
             }
             for (int row = 14; row <= 16; row++)
                 for (int col = 17; col <= 18; col++)
                     originalMap[row][col] = ALIVE;
             originalMap[15][19] = ALIVE;
             for (int row = 12; row <= 18; row = row+2)
                 originalMap[row][21] = ALIVE;
             originalMap[14][24] = ALIVE;
             originalMap[16][24] = ALIVE;
             originalMap[12][25] = ALIVE;
             originalMap[13][25] = ALIVE;
             originalMap[17][25] = ALIVE;
             originalMap[18][25] = ALIVE;
             break;
           default: // Default Example: ClearSpace
             break;
        }

        copyMap(originalMap);
        generation = 0;
        gui.repaint();
    }

    //  Read map from file
    public void readInMap() {
        clearMap(originalMap);
        if (fileIO.read(originalMap)) {
            copyMap(originalMap);
            generation = 0;
        } else
            readExample(2);
        gui.repaint();
    }

    // Write map to file
    public void writeMap() {
       fileIO.write(map);
    }

    // Change the state of a cell
    public void updateMap(int row, int col) {
        map[row][col] = !map[row][col];

    }

    // Destroy the GUI window
    public void destroy() {
        gui.dispose();
    }

    // The main method of GameOfLife
    public static void  main(String[] args) {
        GameOfLife game = new GameOfLife();
    }
}
