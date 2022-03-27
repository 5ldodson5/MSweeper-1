
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ControllerMap extends JPanel{
	private Tile[][] Map;
	private int numBombs;
	//jLabel for the entire game view
	private JLabel statusbar;
	//----------------------Variables that will be affected by HTML (Difficulty)---------------------------
	private int sideSize;
	//private int score;
	//------------------------------Number variable translations-------------------------------------------
	//private final int mine = 9;
    //private final int coveredTile = 10;
    //private final int flag = 11;
    //private final int wrongFlag = 12;
    //-----------------------------------------------------------------------------------------------------
	
	//private int Tilesize = 15; // size of each side of a tile in pixels
    //private int boardWidth = sideSize * Tilesize + 1;
    //private int boardHeight = sideSize * Tilesize + 1;
	
	
	
	private boolean gameStatus; //Flag variable for when to end the game

	private Image[] imgMap; //stores all images to be displayed on game
	
	public ControllerMap(int size, int bombs) {
		this.sideSize = size;
		Map =  new Tile[size][size];
		for(int k = 0; k< size; k++) {
			for(int z = 0; z<size;z++) {
				Map[k][z] = new Tile(0);
				
			}
		}
		this.numBombs = bombs;
	}
	
	public ControllerMap(Tile[][] x) {
		this.Map = x;
		this.numBombs = 4;
	}
	
	public ControllerMap(JLabel statusbar) {
		this.statusbar = statusbar;
        initBoard();
	}

	private void initBoard() {
		setPreferredSize(new Dimension(sideSize, sideSize));

        imgMap = new Image[13];

        for (int i = 0; i < 13; i++) { 								//populating image map with .png pathway
            String pathway = "src/resources/" + i + ".png";
            imgMap[i] = (new ImageIcon(pathway)).getImage();
        }
        
        addMouseListener(new mouseListener());
        populateMap();
		
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
		 for(int i = 0; i < Map.length; i++) { // This section then assigns each space of number based on the surrounding mines.
	            for (int j = 0; j < Map.length; j++) {
	                if (Map[i][j].getContains() != 9) {
	                    int tempMines = 0;
	                    if ((j - 1) != -1) {
	                        if (Map[i][j - 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i - 1) != -1) {
	                        if (Map[i - 1][j].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i - 1) != -1 && (j - 1) != -1) {
	                        if (Map[i - 1][j - 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i - 1) != -1 && (j + 1) != Map.length) {
	                        if (Map[i - 1][j + 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i + 1) != Map.length) {
	                        if (Map[i + 1][j].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((j + 1) != Map.length) {
	                        if (Map[i][j + 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i + 1) != Map.length && (j + 1) != Map.length) {
	                        if (Map[i + 1][j + 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    if ((i + 1) != Map.length && (j - 1) != -1) {
	                        if (Map[i + 1][j - 1].getContains() == 9) {
	                            tempMines += 1;
	                        }
	                    }
	                    Map[i][j].setContains(tempMines);
	                }
	            }
	        }
	        return (Map);
	    }
	
	public void printMap() {
		for(int row = 0; row<Map.length; row++) {
			for(int col = 0; col < Map.length;col++) {
				System.out.print(Map[row][col].getContains());
				System.out.print("|");
			}
			System.out.print("\n");
			for(int k = 0; k< Map.length; k++) {
				System.out.print("--");
			}
			System.out.print("\n");
		}
	}
	


//I hate git

	
	private class mouseListener extends MouseAdapter{
		
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
}

//I hate git!
