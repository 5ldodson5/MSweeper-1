import org.junit.Before;
import org.junit.Test;

import MineSweeper.derby.DerbyDatabase;
import MineSweeper.db.model.HighScore;
import MineSweeper.db.model.User;
import java.util.List;

import static org.junit.Assert.*;


public class databaseTests {
private DerbyDatabase test;
private List<User> names;
private List<HighScore> scores;


@Before
public void setUp() throws Exception {
	test = new DerbyDatabase();
	names = test.findAllUsers();
	scores = test.findAllHighScoresByDifficulty("Easy");
}


@Test
public void testCheckUsernameAndPasswordT() throws Exception {
	assertEquals(test.checkUsernamePassword("admin", "password"), true);
	assertEquals(test.checkUsernamePassword("JimBob", "jimbob1"), true);
	assertEquals(test.checkUsernamePassword("CerealBowl", "bowlocereal"), true);
	
}


@Test public void testCheckUsernameAndPasswordF() throws Exception{
	assertEquals(test.checkUsernamePassword("carl", "huh"), false);
	assertEquals(test.checkUsernamePassword("Jimbob", "jimbob123"), false);
	assertEquals(test.checkUsernamePassword("CerealBowl", "bowlOFcereal"), false);
}
	



@Test
public void testFindallUsers() throws Exception{
	assertEquals(names.get(5).getUsername(),"admin" );
	assertEquals(names.get(2).getUsername(),"JimBob");
	assertEquals(names.get(0).getUsername(), "CerealBowl");
	assertEquals(names.get(3).getUsername(), "PizzaBox");
	assertEquals(names.get(1).getUsername(), "DeskLamp");
	assertEquals(names.get(4).getUsername(), "RGBKeyboard");
}

@Test
public void testGetHighScores() throws Exception{
	assertEquals(scores.get(0).getScore(), 50);
	assertEquals(scores.get(1).getScore(), 60);
	assertEquals(scores.get(2).getScore(), 70);
	assertEquals(scores.get(3).getScore(), 80);
	assertEquals(scores.get(4).getScore(), 90);
}

@Test
public void testUsernameExistsT() throws Exception{
	assertEquals(test.checkUsernameExists("JimBob"), true);
	assertEquals(test.checkUsernameExists("PizzaBox"), true);
	assertEquals(test.checkUsernameExists("admin"), true);
}

@Test
public void testUsernameExistsF() throws Exception{
	assertEquals(test.checkUsernameExists("Carl"), false);
	assertEquals(test.checkUsernameExists("Fred"), false);
}
 
}
