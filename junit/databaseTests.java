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
	assertEquals(test.checkUsernamePassword("Jim Bob", "jimbob1"), true);
	assertEquals(test.checkUsernamePassword("Cereal Bowl", "bowlocereal"), true);
	
}


@Test public void testCheckUsernameAndPasswordF() throws Exception{
	assertEquals(test.checkUsernamePassword("carl", "huh"), false);
	assertEquals(test.checkUsernamePassword("Jim bob", "jimbob123"), false);
	assertEquals(test.checkUsernamePassword("Cereal Bowl", "bowlOFcereal"), false);
}
	



@Test
public void testFindallUsers() throws Exception{
	assertEquals(names.get(5).getUsername(),"admin" );
	assertEquals(names.get(2).getUsername(),"Jim Bob");
	assertEquals(names.get(0).getUsername(), "Cereal Bowl");
	assertEquals(names.get(3).getUsername(), "Pizza Box");
	assertEquals(names.get(1).getUsername(), "Desk Lamp");
	assertEquals(names.get(4).getUsername(), "RGB Keyboard");
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
	assertEquals(test.checkUsernameExists("Jim Bob"), true);
	assertEquals(test.checkUsernameExists("Pizza Box"), true);
	assertEquals(test.checkUsernameExists("admin"), true);
}

@Test
public void testUsernameExistsF() throws Exception{
	assertEquals(test.checkUsernameExists("Carl"), false);
	assertEquals(test.checkUsernameExists("Fred"), false);
}
 
}
