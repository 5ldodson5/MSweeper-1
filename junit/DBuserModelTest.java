import org.junit.Before;
import org.junit.Test;

import MineSweeper.db.model.User;

import static org.junit.Assert.*;

public class DBuserModelTest {
private User test1;
private User test2;
private User test3;


@Before
public void setUp() throws Exception {
	test1 = new User();
	test1.setUserId(1);
	test1.setUsername("Debra");
	test1.setPassword("Password");
	
	test2 = new User();
	test2.setUserId(2);
	test2.setUsername("Carl");
	test2.setPassword("IloveCS");
	
	test3 = new User();
	test3.setUserId(3);
	test3.setUsername("Bryce");
	test3.setPassword("ai5g6nc41");
	
	
}


@Test
public void testGetUserId() throws Exception {
	assertEquals(test1.getUserId(), 1);
	assertEquals(test2.getUserId(), 2);
	assertEquals(test3.getUserId(), 3);
}

@Test
public void testGetPassword() throws Exception {
	assertEquals(test1.getPassword(), "Password");
	assertEquals(test2.getPassword(), "IloveCS");
	assertEquals(test3.getPassword(), "ai5g6nc41");
}

@Test
public void testGetUsername() throws Exception {
	assertEquals(test1.getUsername(), "Debra");
	assertEquals(test2.getUsername(), "Carl");
	assertEquals(test3.getUsername(), "Bryce");
}

}
