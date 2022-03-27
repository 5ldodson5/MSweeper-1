

public class ControllerMap{
	private Tile[][] CMap;
	private int numBombs;
	
	
	public ControllerMap(int size, int bombs) {
		CMap =  new Tile[size][size];
		for(int k = 0; k< size; k++) {
			for(int z = 0; z<size;z++) {
				CMap[k][z] = new Tile(0);
			}
		}
		numBombs = bombs;
	}
	
	public ControllerMap(Tile[][] x) {
		CMap = x;
		numBombs = 4;
	}
	
	//returns array of Tiles
	public Tile[][] getMap() {
		return CMap;
	}
	
	//populates the map. first places all the bombs and than goes back through to calculate
	//what number a tile should contain
	public void populateMap() {
		this.placeBombs();
		this.placeNumbers();
		
		
	}
	
	public int getNumBombs() {
		return numBombs;
	}
	
	public boolean checkLose(){
		
		for(int height = 0; height < CMap.length; height++) {
			for(int length = 0; length < CMap.length; length++) {
				if(CMap[height][length].isRevealed() && CMap[height][length].getContains() == 9)
					return true;
			}
		}
		
		return false;
	}
	
	public void placeBombs() {
		int count = 0;
		int x,y;
		
		//PLACES ALL BOMBS 
		while(count<numBombs) {
			x = (int)(Math.random()*CMap[0].length);
			y = (int)(Math.random()*CMap[0].length);
			
			//may produce error here since location might not be initialized
			if(CMap[x][y].getContains() == 0) {
				CMap[x][y].setContains(9);
				count++;
			}
		}
	}
	
	public Tile[][] placeNumbers() {
		 for(int i = 0; i < CMap.length; i++) { // This section then assigns each space of number based on the surrounding mines.
	            for (int j = 0; j < CMap.length; j++) {
	                if (CMap[i][j].getContains() != 9) {
	                    int tempMines = 0;
	                    if ((j - 1) != -1) {
	                        if (CMap[i][j - 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i - 1) != -1) {
	                        if (CMap[i - 1][j].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i - 1) != -1 && (j - 1) != -1) {
	                        if (CMap[i - 1][j - 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i - 1) != -1 && (j + 1) != CMap.length) {
	                        if (CMap[i - 1][j + 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i + 1) != CMap.length) {
	                        if (CMap[i + 1][j].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((j + 1) != CMap.length) {
	                        if (CMap[i][j + 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i + 1) != CMap.length && (j + 1) != CMap.length) {
	                        if (CMap[i + 1][j + 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i + 1) != CMap.length && (j - 1) != -1) {
	                        if (CMap[i + 1][j - 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    CMap[i][j].setContains(tempMines);
	                }
	            }
	        }
	        return (CMap);
	    }
	
	public void printMap() {
		for(int row = 0; row<CMap.length; row++) {
			for(int col = 0; col < CMap.length;col++) {
				System.out.print(CMap[row][col].getContains());
				System.out.print("|");
			}
			System.out.print("\n");
			for(int k = 0; k< CMap.length; k++) {
				System.out.print("--");
			}
			System.out.print("\n");
		}
	}
	
}

//I hate git
