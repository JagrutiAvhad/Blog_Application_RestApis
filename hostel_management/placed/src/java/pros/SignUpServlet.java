package pros;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "JagAvh@2019";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

                // Insert the new user into the database
                String insertQuery = "INSERT INTO users (full_name, email, username, password) VALUES (?, ?, ?, ?)";
                try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                    insertStatement.setString(1, fullName);
                    insertStatement.setString(2, email);
                    insertStatement.setString(3, username);
                    insertStatement.setString(4, password);
                    int rowsAffected = insertStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        // Successful sign-up
                        response.sendRedirect("login.jsp");
                    } else {
                        // Sign-up failed
                        showErrorPage(response, "Sign-up failed. Please try again.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                showErrorPage(response, "An error occurred while processing the request.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            showErrorPage(response, "An error occurred while processing the request.");
        }
    }

    private void showErrorPage(HttpServletResponse response, String errorMessage) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Error: " + errorMessage + "</h1>");
        out.close();
    }
}
