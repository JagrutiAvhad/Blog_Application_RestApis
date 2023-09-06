<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Receipt</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }
        .container {
            max-width: 500px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #fff;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
        }
        .header {
            text-align: center;
            margin-bottom: 20px;
        }
        .receipt-details {
            margin-top: 20px;
        }
        .receipt-details table {
            width: 100%;
            border-collapse: collapse;
        }
        .receipt-details th,
        .receipt-details td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        .director {
            margin-top: 20px;
            text-align: right;
            font-style: italic;
            color: #666;
        }
        .signature {
            margin-top: 30px;
            text-align: center;
        }
        .stamp {
            text-align: center;
            margin-top: 10px;
        }
        .year {
            text-align: center;
            margin-top: 10px;
            font-style: italic;
            color: #999;
        }
        .print-button {
            text-align: center;
            margin-top: 20px;
        }
        @media print {
            .container {
                border: none;
                box-shadow: none;
            }
            .print-button,
            .director,
            .signature,
            .stamp,
            .year {
                display: none;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>Receipt</h2>
        </div>
        <div class="receipt-details">
            <table>
                <tr>
                    <th>Student Name:</th>
                    <td>${studentName}</td>
                </tr>
                <tr>
                    <th>Total Fee:</th>
                    <td>${totalFee}</td>
                </tr>
                <tr>
                    <th>Amount Paid:</th>
                    <td>${amountPaid}</td>
                </tr>
                <tr>
                    <th>Remaining Balance:</th>
                    <td>${remainingBalance}</td>
                </tr>
            </table>
        </div>
        <div class="director">
            Director: Jagruti
        </div>
        <div class="signature">
            <img src="path_to_signature_image.png" alt="Signature" width="150">
            <p>Authorized Signature</p>
        </div>
        <div class="stamp">
            <img src="path_to_stamp_image.png" alt="Stamp" width="80">
        </div>
        <div class="year">
            Year: 2023
        </div>
        <div class="print-button">
            <button onclick="window.print()">Print Receipt</button>
        </div>
    </div>
</body>
</html>
