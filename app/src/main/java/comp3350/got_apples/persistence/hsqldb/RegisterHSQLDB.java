package comp3350.got_apples.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import comp3350.got_apples.objects.CurrentUser;
import comp3350.got_apples.persistence.RegisterInterface;

public class RegisterHSQLDB implements RegisterInterface {

    private final String dbPath;

    public RegisterHSQLDB(String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }


    @Override
    public boolean addUser(CurrentUser currentUser) {

        String QUERY = "INSERT into USERTABLE values (?, ?)";

        try (Connection connection = connect()) {
            final PreparedStatement showAll = connection.prepareStatement(QUERY);
            showAll.setString(1, currentUser.getUserName());
            showAll.setString(2, currentUser.getPassword());
            showAll.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkUserExists(CurrentUser currentUser) {

        boolean userIsInDB = false;
        String QUERY = "SELECT * FROM USERTABLE WHERE userName = ? AND password = ?";

        try (Connection connection = connect()) {
            final PreparedStatement showAll = connection.prepareStatement(QUERY);
            showAll.setString(1, currentUser.getUserName());
            showAll.setString(2, currentUser.getPassword());

            final ResultSet rs = showAll.executeQuery();
            while (rs.next() && userIsInDB == false) {
                userIsInDB = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userIsInDB;
    }

}
