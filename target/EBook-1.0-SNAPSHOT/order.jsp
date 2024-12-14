<%-- 
    Author     : kali
--%>
<%@page import="com.dto.BookOrder"%>
<%@page import="java.util.List"%>

<%@page import="com.serviceFactory.BookOrderServiceFactory"%>
<%@page import="com.service.IBookOrderService"%>
<%@page import="com.dto.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Order Page - EBook</title>
        <%@include file="all_component/all_css.jsp" %>
    </head>
    <body style="background-color: #f0f1f2">
        <c:if test="${empty userobj}">
            <c:redirect url="login.jsp" />
        </c:if>
        <%@include file="all_component/navbar.jsp" %>
        <div class="container mt-2">
            <h1 class="text-center">Your Orders</h1>
            <table class="table text-center" style="background-color: white;">
                <thead class="bg-primary text-white">
                    <tr>
                        <th scope="col">Order Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Book Name</th>
                        <th scope="col">Author</th>
                        <th scope="col">Price</th>
                        <th scope="col">Payment Type</th>
                        <th scope="col">Order Time</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        User u = (User) session.getAttribute("userobj");
                        
                        IBookOrderService bookOrderService = BookOrderServiceFactory.getBookOrderService();
                        List<BookOrder> list = bookOrderService.getAllBookByUser(u.getEmail());

                        for (BookOrder b : list) {
                    %>
                    <tr>
                        <th scope="row"><%= b.getOrderId() %></th>
                        <td><%= b.getUserName()%></td>
                        <td><%= b.getBookName()%></td>
                        <td><%= b.getAuthorName()%></td>
                        <td>&#8360;. <%= b.getPrice()%></td>
                        <td><%= b.getPaymentType()%></td>
                        <td><%= b.getOrderTime() %></td>
                    </tr>
                    <%
                        }
                    %>
                    
                    
                </tbody>
            </table>
        </div>
        <%@include file="all_component/footer.jsp" %>
    </body>
</html>
