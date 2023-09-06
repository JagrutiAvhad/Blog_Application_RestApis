<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Net Banking Payment</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
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
        .payment-form {
            padding: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .submit-button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Net Banking Payment</h1>
        </div>
        <div class="payment-form">
            <form action="/placed/process_net_banking_payment" method="post">
                <input type="hidden" name="studentId" value="${param.studentId}">
                <input type="hidden" name="amountPaid" value="${param.amountPaid}">
                
                <div class="form-group">
                    <label for="bankName">Select Your Bank:</label>
                    <select id="bankName" name="bankName" required>
                        <option value="bank1">SBI</option>
                        <option value="bank2">HSBC</option>
                        <option value="bank3">HDFC</option>
                        <!-- Add more bank options here -->
                    </select>
                </div>
                <div class="form-group">
                    <label for="loginId">Login ID:</label>
                    <input type="text" id="loginId" name="loginId" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                
                <button class="submit-button" type="submit">Pay</button>
            </form>
        </div>
    </div>
</body>
</html>
