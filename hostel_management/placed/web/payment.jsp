<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Fees Payment</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .header {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #333;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .payment-history-link {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>PICT HOSTEL</h1>
        <p>Student Fees Payment</p>
    </div>
    <div class="container">
        <form action="/placed/Payment1" method="post">
            <label for="studentId">Roll No:</label>
            <input type="text" id="studentId" name="studentId" required>
            
            <label for="amountPaid">Amount Paid:</label>
            <input type="text" id="amountPaid" name="amountPaid" required>
            
            <label for="paymentMode">Payment Mode:</label>
            <select id="paymentMode" name="paymentMode">
                <option value="credit_card">Credit Card</option>
                <option value="debit_card">Debit Card</option>
                <option value="net_banking">Net Banking</option>
                <option value="cash">Cash</option>
            </select>
            
            <input type="submit" value="Proceed to Payment">
        </form>
    </div>
</body>
</html>
