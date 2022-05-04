import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class tileTest {
	Tile notrevealed;
	Tile revealed;
	Tile hasFlag;
	Tile hasnoFlag;
	
	
	@Before
	public void setUp() throws Exception {
		notrevealed = new Tile(1);
		revealed = new Tile(2);
		revealed.reveal();
		hasFlag = new Tile(3);
		hasFlag.placeFlag();
		hasnoFlag = new Tile(4);
	}
	
	@Test
	public void testGetContains() throws Exception {
		assertEquals(notrevealed.getContains(), 1);
		assertEquals(revealed.getContains(), 2);
		assertEquals(hasFlag.getContains(), 3);
		assertEquals(hasnoFlag.getContains(), 4);
	}
	
	@Test
	public void testGetFlag() throws Exception {
		assertEquals(notrevealed.getFlag(), false);
		assertEquals(revealed.getFlag(), false);
		assertEquals(hasFlag.getFlag(), true);
		assertEquals(hasnoFlag.getFlag(), false);
	}
	
	@Test
	public void testGetRevealed() throws Exception {
		assertEquals(notrevealed.isRevealed(), false);
		assertEquals(revealed.isRevealed(), true);
		assertEquals(hasFlag.isRevealed(), false);
		assertEquals(hasnoFlag.isRevealed(), false);
	}
	
	@Test
	public void testSetContains() throws Exception {
		notrevealed.setContains(9);
		revealed.setContains(8);
		hasFlag.setContains(7);
		hasnoFlag.setContains(6);
		
		assertEquals(notrevealed.getContains(), 9);
		assertEquals(revealed.getContains(), 8);
		assertEquals(hasFlag.getContains(), 7);
		assertEquals(hasnoFlag.getContains(), 6);
	}
	
	@Test
	public void testRemoveFlag() throws Exception {
		hasFlag.removeFlag();
		hasnoFlag.removeFlag();

		
		assertEquals(hasFlag.getFlag(), false);
		assertEquals(hasnoFlag.getFlag(), false);
	}
	
	
	
	
	
}

//kill eclipse