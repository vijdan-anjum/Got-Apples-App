package comp3350.got_apples.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.CurrentUser;
import comp3350.got_apples.persistence.hsqldb.RegisterHSQLDB;
import comp3350.got_apples.utils.TestUtils;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegisterHandlerIT {
    private RegisterHandler registerHandler;
    private File tempDB;
    private CurrentUser currentUser;
    @Before
    public void setup() throws IOException {
        System.out.println("Starting integration testing for RegisterHandler!");

        this.tempDB = TestUtils.copyDB();
        final RegisterHSQLDB db = new RegisterHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.registerHandler = new RegisterHandler(db);
    }

    @Test
    public void testExistingUser() throws InvalidInputException {
        assertTrue("Testing if we are accesing the database",registerHandler!=null);
        currentUser = new CurrentUser("RutuBarvaliya","Rutu1234");
        registerHandler.addUser(currentUser);
        assertTrue("See if the user existing",registerHandler.isExistingUser(currentUser));

        CurrentUser currentUser1 = new CurrentUser("Jonathans","Jonas123");
        assertFalse("check for user not in database",registerHandler.isExistingUser(currentUser1));
    }

    @Test
    public void testAddingUser() throws InvalidInputException {
        assertFalse("Can not add the duplicate user!",registerHandler.addUser(currentUser));
        CurrentUser currentUser2 = new CurrentUser("RobertGud","Robert12");
        assertTrue("added the user to the database",registerHandler.addUser(currentUser2));

        assertTrue("check if the user is in database",registerHandler.isExistingUser(currentUser2));
    }
    @After
    public void finish()
    {
        System.out.println("End of the test for Register!");
    }

}
