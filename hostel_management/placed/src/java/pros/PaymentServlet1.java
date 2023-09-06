package pros;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Payment1")
@MultipartConfig
public class PaymentServlet1 extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "JagAvh@2019";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if the studentId and amountPaid parameters are not null or empty
        String studentIdStr = request.getParameter("studentId");
        String amountPaidStr = request.getParameter("amountPaid");

        if (studentIdStr == null || studentIdStr.isEmpty() || amountPaidStr == null || amountPaidStr.isEmpty()) {
            showErrorPage(response, "Invalid parameters. Please provide both studentId and amountPaid.");
            return;
        }

        int studentId;
        double amountPaid;

        try {
            studentId = Integer.parseInt(studentIdStr);
            amountPaid = Double.parseDouble(amountPaidStr);
        } catch (NumberFormatException e) {
            showErrorPage(response, "Invalid parameters. Please provide valid numeric values for studentId and amountPaid.");
            return;
        }

        String paymentMode = request.getParameter("paymentMode");

        if ("credit_card".equals(paymentMode)) {
            // Set the payment details as attributes and forward to the credit card payment page
            request.setAttribute("studentId", studentId);
            request.setAttribute("amountPaid", amountPaid);
            fetchStudentDetailsAndForward(request, response, "credit_card_payment.jsp", studentId, amountPaid);
        } else if ("debit_card".equals(paymentMode)) {
            // Set the payment details as attributes and forward to the debit card payment page
            request.setAttribute("studentId", studentId);
            request.setAttribute("amountPaid", amountPaid);
            fetchStudentDetailsAndForward(request, response, "debit_card_payment.jsp", studentId, amountPaid);
        } else if ("net_banking".equals(paymentMode)) {
            // Set the payment details as attributes and forward to the net banking payment page
            request.setAttribute("studentId", studentId);
            request.setAttribute("amountPaid", amountPaid);
            fetchStudentDetailsAndForward(request, response, "net_banking_payment.jsp", studentId, amountPaid);
        } else if ("cash".equals(paymentMode)) {
            // Set the payment details as attributes and forward directly to the receipt page
            request.setAttribute("studentId", studentId);
            fetchStudentDetailsAndForward(request, response, "receipt.jsp", studentId, amountPaid);
        } else {
            showErrorPage(response, "Invalid payment mode.");
        }
    }

    private void fetchStudentDetailsAndForward(HttpServletRequest request, HttpServletResponse response,
            String targetJsp, int studentId, double amountPaid) throws ServletException, IOException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "JagAvh@2019")) {
            String selectQuery = "SELECT name, total_fee, fees_paid FROM hostelfees WHERE roll_no = ?";
            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
                selectStatement.setInt(1, studentId);
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String studentName = resultSet.getString("name");
                        double totalFee = resultSet.getDouble("total_fee");
                        double feesPaid = resultSet.getDouble("fees_paid");
                        double remainingBalance = totalFee - feesPaid;

                        // Set attributes for JSP page
                        request.setAttribute("studentName", studentName);
                        request.setAttribute("totalFee", totalFee);
                        request.setAttribute("amountPaid", amountPaid);
                        request.setAttribute("remainingBalance", remainingBalance);

                        // Forward to target JSP page
                        request.getRequestDispatcher(targetJsp).forward(request, response);
                    } else {
                        // Handle case when student is not found
                        showErrorPage(response, "Student with ID " + studentId + " not found.");
                    }
                }
            }
        } catch (SQLException e) {
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
