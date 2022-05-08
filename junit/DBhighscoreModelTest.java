import org.junit.Before;
import org.junit.Test;

import MineSweeper.db.model.HighScore;

import static org.junit.Assert.*;

public class DBhighscoreModelTest {
private HighScore test1;
private HighScore test2;
private HighScore test3;


@Before
public void setUp() throws Exception {
	test1 = new HighScore();
	test1.setUsername("Debra");
	test1.setDifficulty("Easy");
	test1.setScore(500);
	
	test2 = new HighScore();
	test2.setUsername("Paul");
	test2.setDifficulty("Medium");
	test2.setScore(1000);
	
	test3 = new HighScore();
	test3.setUsername("Bryce");
	test3.setDifficulty("Hard");
	test3.setScore(9999);
	
	
}


@Test
public void testgetUsername() throws Exception {
	assertEquals(test1.getUsername(), "Debra");
	assertEquals(test2.getUsername(), "Paul");
	assertEquals(test3.getUsername(), "Bryce");
}

@Test
public void testgetDifficulty() throws Exception {
	assertEquals(test1.getDifficulty(), "Easy");
	assertEquals(test2.getDifficulty(), "Medium");
	assertEquals(test3.getDifficulty(), "Hard");
}

@Test
public void testgetScore() throws Exception {
	assertEquals(test1.getScore(), 500);
	assertEquals(test2.getScore(), 1000);
	assertEquals(test3.getScore(), 9999);
}



}
