package pros;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/process_net_banking_payment")
@MultipartConfig
public class NetBankingPaymentServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "JagAvh@2019";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentIdStr = request.getParameter("studentId");
        String amountPaidStr = request.getParameter("amountPaid");
        String bankName = request.getParameter("bankName");
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");

        if (studentIdStr == null || studentIdStr.isEmpty() || amountPaidStr == null || amountPaidStr.isEmpty()
                || bankName == null || loginId == null || password == null) {
            showErrorPage(response, "Invalid parameters. Please provide all required data.");
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

        // Here you can implement the logic to process the net banking payment
        // For example, you can update the payment status in the database and generate a receipt

        // After processing, you can redirect to a receipt page
        response.sendRedirect("receipt.jsp?studentId=" + studentId);
    }

    private void showErrorPage(HttpServletResponse response, String errorMessage) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Error: " + errorMessage + "</h1>");
        out.close();
    }
}
