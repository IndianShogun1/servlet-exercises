import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(LoginDao.validate(username, password)) {
                response.sendRedirect("add-blog.jsp");
        } else {
                response.sendRedirect("invalid-credentials.jsp");
        }
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","test");
//            PreparedStatement statement =
//                    connection.prepareStatement("SELECT * FROM user_details WHERE username = ? AND password = ?");
//            statement.setString(1, username);
//            statement.setString(2, password);
//            ResultSet resultSet = statement.executeQuery();
//            boolean status = resultSet.next();
//            if(status) {
//                response.sendRedirect("add-blog.jsp");
//            } else {
//                response.sendRedirect("invalid-credentials.jsp");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
