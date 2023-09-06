<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>PICT Hostel User Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: url('https://i.pinimg.com/originals/23/8f/58/238f58c2b669e4afdc00cddfc78a5db1.jpg') no-repeat center center fixed;
            background-size: cover;
        }
        .overlay {
            background-color: rgba(0, 0, 0, 0.6);
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
        }
        .header {
            color: white;
            text-align: center;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.7);
        }
        .container {
            max-width: 500px;
            margin: auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            border: 1px solid #ccc;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            margin-top: 50px;
            color: black;
            position: relative;
            z-index: 1;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        .options {
            margin-top: 20px;
            text-align: center;
        }
        .options button {
            display: block;
            margin: 10px auto;
            padding: 12px 24px;
            background-color: #ffc107; /* Yellow color */
            border: none;
            border-radius: 5px;
            color: black;
            font-size: 18px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 100%;
            max-width: 240px; /* Limit button width */
        }
        .options button:hover {
            background-color: #ffa000;
        }
        .welcome-line {
            position: relative;
            margin-top: 10px;
            width: 100%;
            height: 1px;
            background-color: white;
            opacity: 0.7;
            animation: moveLine 4s infinite;
        }
        @keyframes moveLine {
            0% {
                left: 0;
            }
            25% {
                left: 25%;
            }
            50% {
                left: 50%;
            }
            75% {
                left: 75%;
            }
            100% {
                left: 100%;
            }
        }
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div class="overlay"></div>
    <div class="header">
        <h1>Welcome to PICT Hostel User Portal</h1>
        <div class="welcome-line"></div>
    </div>
    <div class="container">
        <div class="options">
            <button onclick="location.href='login.jsp';">Login</button>
        </div>
    </div>
</body>
</html>
