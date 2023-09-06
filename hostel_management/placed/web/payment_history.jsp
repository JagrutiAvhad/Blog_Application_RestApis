<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Payment History</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
                color: #333;
            }
            .container {
                max-width: 800px;
                margin: auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
            }
            .header {
                text-align: center;
                margin-bottom: 20px;
            }
            .header h1 {
                color: #333;
            }
            .payment-history table {
                width: 100%;
                border-collapse: collapse;
                border: 1px solid #ccc;
                margin-top: 20px;
            }
            .payment-history th, .payment-history td {
                padding: 10px;
                text-align: left;
                border-bottom: 1px solid #ccc;
            }
            .payment-history th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h1>Payment History</h1>
            </div>
            <div class="payment-history">
                <!-- Display payment history here -->
                <table>
                    <tr>
                        <th>Date and Time</th>
                        <th>Amount Paid</th>
                    </tr>
                    <%-- Loop through payment history data and display it --%>
                    <c:forEach items="${paymentHistory}" var="payment">
                        <tr>
                            <td>${payment.dateTime}</td>
                            <td>${payment.amountPaid}</td>
                        </tr>
                        <%-- Debug line: --%>
                        <p>${payment.dateTime} - ${payment.amountPaid}</p>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
