<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>EMI Calculation Result</title>
</head>
<body>
    <h1>EMI Calculation Result</h1>
    <% 
        double principal = Double.parseDouble(request.getParameter("principal"));
        double interestRate = Double.parseDouble(request.getParameter("interest"));
        int tenure = Integer.parseInt(request.getParameter("tenure"));

        double monthlyInterest = interestRate / 12 / 100;
        int totalMonths = tenure;

        double emi = (principal * monthlyInterest * Math.pow(1 + monthlyInterest, totalMonths)) / (Math.pow(1 + monthlyInterest, totalMonths) - 1);
        double totalPayment = emi * totalMonths;

        out.println("Principal Amount: " + principal + "<br>");
        out.println("Interest Rate: " + interestRate + "%<br>");
        out.println("Loan Tenure: " + tenure + " months<br>");
        out.println("EMI: " + emi + "<br>");
        out.println("Total Payment: " + totalPayment + "<br>");
    %>
</body>
</html>
