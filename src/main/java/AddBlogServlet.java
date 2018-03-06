import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddBlogServlet")
public class AddBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int id = Integer.valueOf(request.getParameter("id"));
        String content = request.getParameter("content");
        if(AddBlogDao.addBlog(id, content)){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Save successful');");
            out.println("location='add-blog.jsp';");
            out.println("</script>");
//            response.sendRedirect("add-blog.jsp");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Save unsuccessful');");
            out.println("location='add-blog.jsp';");
            out.println("</script>");
//            response.sendRedirect("add-blog.jsp");
        }
    }
}
