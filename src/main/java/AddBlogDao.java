import java.sql.*;

public class AddBlogDao {
    public static boolean addBlog(int id, String content) throws SQLException {
        int status = -1;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","test");
            statement =
                    connection.prepareStatement("INSERT INTO blog VALUES(?, ?)");
            statement.setInt(1,id);
            statement.setString(2,content);
            status = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
            if(status <= 0) {
                return false;
            } else {
                return true;
            }
        }
    }
}
