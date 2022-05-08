import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class mapTest {
	private ControllerMap map1;
	private ControllerMap map2;
	private ControllerMap map3;
	
	
	
	@Before
	public void setUp() throws Exception {
		map1 = new ControllerMap(8,  10);
		map2 = new ControllerMap(10, 20);
		map3 = new ControllerMap(12, 30);
		
		
	}
	
	@Test
	public void testgetBombswithmethod() throws Exception {
		assertEquals(map1.getNumBombs(), 10);
		assertEquals(map2.getNumBombs(), 20);
		assertEquals(map3.getNumBombs(), 30);
	}
	
	@Test
	public void testgetBombsByCount() throws Exception {
		map1.populateMap();
		map2.populateMap();
		map3.populateMap();
		int count1 = 0;
		int count2 = 0; 
		int count3 = 0;
		
		Tile[][] t1 = map1.getMap();
		Tile[][] t2 = map2.getMap();
		Tile[][] t3  = map3.getMap();
		for(int row = 0; row< 8; row ++) {
			for(int col = 0; col < 8; col++) {
				if(t1[row][col].getContains() == 9) {
					count1++;
				}
			}
		}
		
		for(int row = 0; row< 10; row ++) {
			for(int col = 0; col < 10; col++) {
				if(t2[row][col].getContains() == 9) {
					count2++;
				}
			}
		}

		
		for(int row = 0; row< 12; row ++) {
			for(int col = 0; col < 12; col++) {
				if(t3[row][col].getContains() == 9) {
					count3++;
				}
			}
		}
		
		assertEquals(count1, 10);
		assertEquals(count2, 20);
		assertEquals(count3, 30);

	}
	
	@Test
	public void testAllEmpty() throws Exception {
		Tile[][] temp1 = map1.getMap();
		Tile[][] temp2 = map2.getMap();
		Tile[][] temp3 = map3.getMap();
		for(int k = 0; k< map1.getSideSize();k++ ) {
			for(int j = 0; j<map1.getSideSize(); j++) {
				assertEquals(temp1[k][j].getContains(), 0);
			}
		}
		
		for(int k = 0; k< map2.getSideSize();k++ ) {
			for(int j = 0; j<map2.getSideSize(); j++) {
				assertEquals(temp2[k][j].getContains(), 0);
			}
		}
		
		for(int k = 0; k< map2.getSideSize();k++ ) {
			for(int j = 0; j<map2.getSideSize(); j++) {
				assertEquals(temp3[k][j].getContains(), 0);
			}
		}
		}
		
	
	
		
	
	
}
