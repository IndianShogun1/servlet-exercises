import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddBlogServlet")
public class AddBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int id = Integer.valueOf(request.getParameter("id"));
        String content = request.getParameter("content");
        try {
            if(AddBlogDao.addBlog(id, content)){
                response.sendRedirect("success.jsp");
            } else {
                response.sendRedirect("failure.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
