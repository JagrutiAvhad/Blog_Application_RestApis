package pros;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check username and password, perform authentication logic
        // Replace the condition below with your authentication logic
        if (isValidUser(username, password)) {
            response.sendRedirect("Main.jsp");
        } else {
            // Handle failed login
            response.sendRedirect("login.jsp");
        }
    }

    // Replace this method with your actual authentication logic
    private boolean isValidUser(String username, String password) {
        // Example: Check if username and password match in your database
        // You may use a database, hardcoded values, or any other method
        // Return true if authentication is successful, false otherwise
        return username.equals("Jagruti") && password.equals("123");
    }
}
