import java.sql.*;

public class LoginDao {
    public static boolean validate(String username, String password) throws SQLException {
        boolean status = false;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","test");
            statement =
                    connection.prepareStatement("SELECT * FROM user_details WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            status = resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resultSet.close();
            statement.close();
            connection.close();
            return status;
        }
    }
}
