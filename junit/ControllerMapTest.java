import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ControllerMapTest {
	private Tile[][] Tcorners;// corners are bombs
	private ControllerMap Mcorners;
	private Tile[][] Acorners; //what the correct map should be should be 
	private ControllerMap AMcorners;
	
	private Tile[][] Tpreset;//bombs in random spots (done on paper by dakota)
	private ControllerMap Mpreset;
	private Tile[][] Apreset; //what the correct map should be should be 
	private ControllerMap AMpreset;
	
	
	
	@Before
	public void setUp() throws Exception {
		Tcorners = new Tile[5][5];
		for(int row = 0; row<5;row++) {
			for(int col = 0; col<5;col++) {
				Tcorners[row][col] = new Tile(0);
			}
		}

		Tcorners[0][0].setContains(9);
		Tcorners[0][4].setContains(9);
		Tcorners[4][0].setContains(9);
		Tcorners[4][4].setContains(9);
		Mcorners = new ControllerMap(Tcorners);
		
		Acorners = new Tile[5][5];
		for(int row = 0; row<5;row++) {
			for(int col = 0; col<5;col++) {
				Acorners[row][col] = new Tile(0);
			}
		}
		
		Acorners[0][0].setContains(9);
		Acorners[0][4].setContains(9);
		Acorners[4][0].setContains(9);
		Acorners[4][4].setContains(9);
		
		Acorners[0][3].setContains(1);
		Acorners[1][3].setContains(1);
		Acorners[1][4].setContains(1);

		Acorners[3][0].setContains(1);
		Acorners[3][1].setContains(1);
		Acorners[4][1].setContains(1);
		
		Acorners[3][3].setContains(1);
		Acorners[3][4].setContains(1);
		Acorners[4][3].setContains(1);
		
		Acorners[0][1].setContains(1);
		Acorners[1][0].setContains(1);
		Acorners[1][1].setContains(1);
		
		AMcorners = new ControllerMap(Acorners);
		
		///////////////////////////////////////////////////////////////////////////////////
		Tpreset = new Tile[5][5];
		Apreset = new Tile[5][5];
		for(int row = 0; row<5;row++) {
			for(int col = 0; col<5;col++) {
				Tpreset[row][col] = new Tile(0);
				Apreset[row][col] = new Tile(0);
			}
		}
		
		Tpreset[0][2].setContains(9);
		Tpreset[4][4].setContains(9);
		Tpreset[2][0].setContains(9);
		Tpreset[3][0].setContains(9);
		Tpreset[4][0].setContains(9);
		Tpreset[2][1].setContains(9);
		Tpreset[4][1].setContains(9);
		Tpreset[2][2].setContains(9);
		Tpreset[3][2].setContains(9);
		Tpreset[4][2].setContains(9);
		Mpreset = new ControllerMap(Tpreset);
		
		Apreset[0][0].setContains(0);
		Apreset[0][1].setContains(1);
		Apreset[0][2].setContains(9);
		Apreset[0][3].setContains(1);
		Apreset[0][4].setContains(0);
		Apreset[1][0].setContains(2);
		Apreset[1][1].setContains(4);
		Apreset[1][2].setContains(3);
		Apreset[1][3].setContains(2);
		Apreset[1][4].setContains(0);
		Apreset[2][0].setContains(9);
		Apreset[2][1].setContains(9);
		Apreset[2][2].setContains(9);
		Apreset[2][3].setContains(2);
		Apreset[2][4].setContains(0);
		Apreset[3][0].setContains(9);
		Apreset[3][1].setContains(8);
		Apreset[3][2].setContains(9);
		Apreset[3][3].setContains(4);
		Apreset[3][4].setContains(1);
		Apreset[4][0].setContains(9);
		Apreset[4][1].setContains(9);
		Apreset[4][2].setContains(9);
		Apreset[4][3].setContains(3);
		Apreset[4][4].setContains(9);
		AMpreset = new ControllerMap(Apreset);
		
		
		
		
		
		
	}
	
	@Test
	public void testPlaceNumbers() throws Exception {
		Tile[][] answersb = AMcorners.getMap();
		Mcorners.placeNumbers();
		Tile[][] testborder = Mcorners.getMap();
		
		Tile[][] answersp = AMpreset.getMap();
		Mpreset.placeNumbers();
		Tile[][] testpreset = Mpreset.getMap();
		
		Mpreset.printMap();
		System.out.println();
		AMpreset.printMap();
		
		for(int row = 0; row<5;row++) {
			for(int col = 0; col<5;col++) {
				assertEquals(answersb[row][col].getContains(), testborder[row][col].getContains());
				assertEquals(answersp[row][col].getContains(), testpreset[row][col].getContains());
			}
		}
	}
	
}
