
package servlets;
import service.AccountService;
import models.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String logout = request.getParameter("logout");
        if (logout != null)  {
            request.setAttribute("logout", "Sucessfully logged out");
            session.invalidate();
        }
        
        else if (session.getAttribute("user") != null)   {
            response.sendRedirect("home");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        request.setAttribute("name", name);
        request.setAttribute("password", password);
        HttpSession session = request.getSession();
        String invalidMessage = "Please fill in your information";
        AccountService accountService = new AccountService();
        
        if (name.length() <= 0 || password.length() <= 0)   {
            request.setAttribute("invalid", invalidMessage);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            return;
        }
        
        else if (accountService.login(name, password) == null)  {
            invalidMessage = "Incorrect credentials";
            request.setAttribute("invalid", invalidMessage);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
        
        else if (accountService.login(name, password) != null)   {
            User user = accountService.login(name, password);
            session.setAttribute("user", user);
            response.sendRedirect("home");
        }
    }
}