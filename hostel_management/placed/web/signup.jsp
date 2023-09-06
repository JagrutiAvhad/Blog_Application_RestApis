<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }
        .container {
            max-width: 400px;
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
        .signup-form {
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
        }
        .signup-form label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        .signup-form input[type="text"],
        .signup-form input[type="email"],
        .signup-form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .signup-form input[type="submit"] {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .signup-form input[type="submit"]:hover {
            background-color: #444;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Sign Up</h1>
        </div>
        <div class="signup-form">
            <form action="SignUpServlet" method="post"> <!-- Change action to SignUpServlet -->
                <label for="fullName">Full Name:</label>
                <input type="text" id="fullName" name="fullName" required>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
                <input type="submit" value="Sign Up">
            </form>
            <p>Already have an account? <a href="login.jsp">Log In</a></p>
        </div>
    </div>
</body>
</html>
