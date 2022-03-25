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
	
	//returns arrray of Tiles
	public Tile[][] getMap() {
		return Map;
	}
	
	//populates the map. first places all the bombs and than goes back through to calculate
	//what number a tile should contain
	public void populateMap() {
		this.placeBombs();
		
		
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
	
	public void placeNumbers() {
		for(int k = 0; k<Map.length;k++) {
			for(int z = 0; z<Map.length;k++) {
				//i want to die...respectfully
			}
		}
	}
	
	
	
}