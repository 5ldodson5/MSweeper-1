import java.util.Random;

public class Map{
	private Tile[][] Map;
	private int numBombs;
	
	
	public Map(int size, int bombs) {
		Map =  new Tile[size][size];
		for(int k = 0; k< size; k++) {
			for(int z = 0; k<size;k++) {
				Map[k][z] = new Tile(0);
			}
		}
		numBombs = bombs;
	}
	
	public Map(Tile[][] x) {
		Map = x;
		numBombs = 4;
	}
	
	//returns array of Tiles
	public Tile[][] getMap() {
		return Map;
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
		
		for(int height = 0; height < Map.length; height++) {
			for(int length = 0; length < Map.length; length++) {
				if(Map[height][length].isRevealed() && Map[height][length].getContains() == 9)
					return true;
			}
		}
		
		return false;
	}
	
	public void placeBombs() {
		Random rand = new Random();
		int count = 0;
		int x,y;
		
		//PLACES ALL BOMBS 
		while(count<numBombs) {
			x = rand.nextInt(Map.length);
			y = rand.nextInt(Map.length);
			
			//may produce error here since location might not be initialized
			if(Map[x][y].getContains() != 9) {
				Map[x][y].setContains(9);
				count++;
			}
		}
	}
	
	public Tile[][] placeNumbers() {
		int count;
		//loops through entire map
		for(int row = 0; row<Map.length;row++) {
			for(int col = 0; col<Map.length;col++) {
				if(Map[row][col].getContains() != 9) {
					
				count = 0;
				//instance where the tile it's checking isn't on the edge
				if(row != 0 && col!= 0 && row<Map.length-1 && col<Map.length-1) {
					//loop through 8 tiles around
					for(int subrow = row-1; subrow<row+1;subrow++ ) {
						for(int subcol = col -1; subcol < col+1; subcol++) {
							if(Map[subrow][subcol].getContains()== 9) {
								count++;
							}
						}
					}
					Map[row][col].setContains(count);
					//instance where tile is upper left corner
				}else if(row == 0 && col == 0) {
					//check three possible tiles
					if(Map[0][1].getContains() == 9)
						count++;
					if(Map[1][0].getContains() == 9) 
						count++;
					if(Map[1][1].getContains() == 9)
						count++;
					
					Map[0][0].setContains(count);
					//instance where tile is upper right corner
				}else if(row == 0 && col == Map.length-1) {
					if(Map[0][Map.length-2].getContains() == 9)
						count++;
					if(Map[1][Map.length-2].getContains() == 9)
						count++;
					if(Map[1][Map.length-1].getContains() == 9)
						count++;
					
					Map[0][Map.length-1].setContains(count);
					//instance where tile is bottom left corner
				}else if(col == 0 && row == Map.length-1) {
					if(Map[Map.length-2][0].getContains() == 9)
						count++;
					if(Map[Map.length-2][1].getContains() == 9)
						count++;
					if(Map[Map.length-1][1].getContains() == 9)
						count++;
					Map[Map.length-1][0].setContains(count);
					//instance where tile is bottom right;
				}else if(col == Map.length-1 && row == Map.length -1) {
					if(Map[Map.length-1][Map.length-2].getContains() == 9)
						count++;
					if(Map[Map.length-2][Map.length-1].getContains() == 9)
						count++;
					if(Map[Map.length-2][Map.length-2].getContains() == 9)
						count++;
					
					Map[Map.length-1][Map.length-1].setContains(count);
					//instance where tile is on left border 
				}else if(col == 0) {
					if(Map[row-1][0].getContains() == 9)
						count++;
					if(Map[row+1][0].getContains() == 9)
						count++;
					if(Map[row-1][1].getContains() == 9)
						count++;
					if(Map[row][1].getContains() == 9)
						count++;
					if(Map[row+1][1].getContains() == 9)
						count++;
					Map[row][col].setContains(count);
					//instance where tile is on top border
				}else if(row == 0) {
					if(Map[0][col-1].getContains() == 9)
						count++;
					if(Map[0][col+1].getContains() == 9)
						count++;
					if(Map[1][col-1].getContains() == 9)
						count++;
					if(Map[1][col].getContains() == 9)
						count++;
					if(Map[1][col+1].getContains() == 9)
						count++;
					Map[row][col].setContains(count);
					//instance where tile is on right border
				}else if(col == Map.length-1) {
					if(Map[row-1][Map.length-1].getContains() == 9)
						count++;
					if(Map[row+1][Map.length-1].getContains() == 9)
						count++;
					if(Map[row-1][Map.length-2].getContains() == 9)
						count++;
					if(Map[row][Map.length-2].getContains() == 9)
						count++;
					if(Map[row+1][Map.length-2].getContains() == 9)
						count++;
					Map[row][col].setContains(count);
					//tile is on the bottom row
				}else {
					if(Map[Map.length-1][col-1].getContains() == 9)
						count++;
					if(Map[Map.length-1][col+1].getContains() == 9)
						count++;
					if(Map[Map.length-2][col-1].getContains() == 9)
						count++;
					if(Map[Map.length-2][col].getContains() == 9)
						count++;
					if(Map[Map.length-2][col+1].getContains() == 9)
						count++;
					Map[row][col].setContains(count);
				}
			}
			}
		}
		return Map;
	}
	
	public void printMap() {
		for(int row = 0; row<Map.length; row++) {
			for(int col = 0; col < Map.length;col++) {
				System.out.print(Map[row][col].getContains());
				System.out.print("|");
			}
			for(int k = 0; k< Map.length; k++) {
				System.out.print("--");
			}
		}
	}
	
}
