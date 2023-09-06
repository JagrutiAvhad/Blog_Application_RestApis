package pros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/PaymentHistoryServlet")
public class PaymentHistoryServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "JagAvh@2019";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentIdStr = request.getParameter("studentId"); // Get student ID

        try {
            // Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "JagAvh@2019")) {

                // Fetch payment history for the student from the database
                String query = "SELECT payment_date_time, amount_paid FROM payment_history WHERE student_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, studentIdStr);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        List<PaymentRecord> paymentHistory = new ArrayList<>();
                        while (resultSet.next()) {
                            String paymentDate = resultSet.getString("payment_date_time");
                            double amountPaid = resultSet.getDouble("amount_paid");
                            paymentHistory.add(new PaymentRecord(paymentDate, amountPaid));
                        }

                        // Set the payment history data in request attribute
                        request.setAttribute("paymentHistory", paymentHistory);
                        request.getRequestDispatcher("/payment_history.jsp").forward(request, response);
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
