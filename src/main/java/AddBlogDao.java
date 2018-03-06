import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddBlogDao {
    public static boolean addBlog(int id, String content) {
        int status = -1;
        PreparedStatement statement;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","test");
            statement =
                    connection.prepareStatement("INSERT INTO blog VALUES(?, ?)");
            statement.setInt(1,id);
            statement.setString(2,content);
            status = statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(status <= 0) {
                return false;
            } else {
                return true;
            }
        }
    }
}
