import org.junit.Before;
import org.junit.Test;

import MineSweeper.db.model.HighScore;
import MineSweeper.db.model.Pair;
import MineSweeper.db.model.User;

import static org.junit.Assert.*;

public class DBPairModelTest {
private Pair test1;
private User test1U;
private HighScore test1H;
private Pair test2;
private User test2U;
private HighScore test2H;
private Pair test3;
private User test3U;
private HighScore test3H;


@Before
public void setUp() throws Exception {
	test1U = new User();
	test1U.setUserId(1);
	test1U.setUsername("Debra");
	test1U.setPassword("Password");
	
	test2U = new User();
	test2U.setUserId(2);
	test2U.setUsername("Carl");
	test2U.setPassword("IloveCS");
	
	test3U = new User();
	test3U.setUserId(3);
	test3U.setUsername("Bryce");
	test3U.setPassword("ai5g6nc41");
	
	test1H = new HighScore();
	test1H.setUsername("Debra");
	test1H.setDifficulty("Easy");
	test1H.setScore(500);
	
	test2H = new HighScore();
	test2H.setUsername("Carl");
	test2H.setDifficulty("Medium");
	test2H.setScore(1000);
	
	test3H = new HighScore();
	test3H.setUsername("Bryce");
	test3H.setDifficulty("Hard");
	test3H.setScore(9999);
	
	test1 = new Pair(test1U, test1H);
	test2 = new Pair(test2U, test2H);
	test3 = new Pair(test3U, test3H);
	
}


@Test
public void testgetLeft() throws Exception {
	assertEquals(test1.getLeft(), test1U);
	assertEquals(test2.getLeft(), test2U);
	assertEquals(test3.getLeft(), test3U);
	
}

@Test
public void testgetRight() throws Exception {
	assertEquals(test1.getRight(), test1H);
	assertEquals(test2.getRight(), test2H);
	assertEquals(test3.getRight(), test3H);
	
}

@Test
public void testSetRight() throws Exception {
	HighScore temp = new HighScore();
	test1.setRight(temp);
	assertEquals(test1.getRight(), temp);
	
}

@Test
public void testSetLeft() throws Exception {
	User temp = new User();
	test1.setLeft(temp);
	assertEquals(test1.getLeft(), temp);
	
}









}
