<%-- 
    Author     : kali
--%>

<%@page import="com.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.Books"%>
<%@page import="com.serviceFactory.BookServiceFactory"%>
<%@page import="com.service.IBookService"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page - EBook</title>
        <%@include file="all_component/all_css.jsp" %>
        <style>
            .back-img{
                background: url("img/book3.jpeg");
                height: 57vh;
                width: 100%;
                background-size: cover;
                background-repeat: no-repeat;
            }
            .crd-ho:hover{
                background-color: #f0f1f2;
            }
        </style>
    </head>
    <body style="background-color: #f0f1f2">
        <%@include file="all_component/navbar.jsp" %>
        <%
            User u = (User) session.getAttribute("userobj");
        %>
        <div class="container-fluid back-img">
            <h2 class="text-center text-white"><i class="fa-solid fa-book"></i> E-Book Management System</h2>
        </div>
        <!--start recent book-->
        <div class="container">
            <h1 class="text-center mt-2"><i class="fa-solid fa-book"></i> Recent Book</h1>
            <div class="row">
                <%
                    IBookService bookService1 = BookServiceFactory.getBookService();
                    List<Books> list1 = bookService1.getRecentBooks();
                    for (Books book1 : list1) {
                %>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/<%= book1.getPhotoName()%>" alt="" style="width: 150px; height: 200px;" class="img-thumblin" />
                            <p><b>Name: </b><%= book1.getBookName()%></p>
                            <p><b>Author: </b><%= book1.getAuthor()%></p>
                            <p><b>Category: </b><%= book1.getBookCategory()%></p>
                            <%
                                if (book1.getBookCategory().equals("Old")) {
                            %>
                            <div class="row">
                                <a href="#" class="btn btn-success btn-sm ml-5">Details</a>
                                <button  class="btn btn-danger btn-sm ml-1">&#8360;. <%= book1.getPrice()%></button>
                            </div>
                            <%
                            } else {
                            %>
                            <div class="row text-center">
                                <%
                                    if (u == null) {
                                %>
                                <a href="login.jsp" class="btn btn-danger btn-sm ml-3"><i class="fa-solid fa-cart-plus"></i> Add Cart</a>
                                <%
                                } else {
                                %>
                                <a href="Cart?id=<%= book1.getBookId()%>&&uid=<%= u.getUserId()%>" class="btn btn-danger btn-sm ml-3"><i class="fa-solid fa-cart-plus"></i> Add Cart</a>
                                <%
                                    }
                                %>

                                <a href="view_book_details.jsp?id=<%=book1.getBookId()%>" class="btn btn-success btn-sm ml-1">Details</a>
                                <button  class="btn btn-danger btn-sm ml-1">&#8360;. <%= book1.getPrice()%></button>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
            <div class="text-center mt-1">
                <a href="all_recent_books.jsp" class="btn btn-danger btn-block text-white">View All</a>
            </div>
        </div>
        <!--end recent book-->
        <hr>
        <!--start new book-->
        <div class="container">
            <h1 class="text-center mt-2"><i class="fa-solid fa-book"></i> New Book</h1>
            <div class="row">

                <%
                   IBookService bookService = BookServiceFactory.getBookService();
                    List<Books> list = bookService.getNewBooks();
                    for (Books books : list) {
                %>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/<%= books.getPhotoName()%>" alt="" style="width: 150px; height: 200px;" class="img-thumblin" />
                            <p><b>Name: </b><%= books.getBookName()%></p>
                            <p><b>Author: </b><%= books.getAuthor()%></p>
                            <p><b>Category: </b><%= books.getBookCategory()%></p>
                            <div class="row">
                                <%
                                    if (u == null) {
                                %>
                                <a href="login.jsp" class="btn btn-danger btn-sm ml-3"><i class="fa-solid fa-cart-plus"></i> Add Cart</a>
                                <%
                                } else {
                                %>
                                <a href="Cart?id=<%= books.getBookId()%>&&uid=<%= u.getUserId()%>" class="btn btn-danger btn-sm ml-3"><i class="fa-solid fa-cart-plus"></i> Add Cart</a>
                                <%
                                    }
                                %>
                                <a href="view_book_details.jsp?id=<%=books.getBookId()%>" class="btn btn-success btn-sm ml-1">Details</a>
                                <button  class="btn btn-danger btn-sm ml-1">&#8360;. <%= books.getPrice()%></button>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
            <div class="text-center mt-1">
                <a href="all_new_books.jsp" class="btn btn-danger btn-block text-white">View All</a>
            </div>
        </div>
        <!--end new book-->
        <hr>
        <!--start old book-->
        <div class="container">
            <h1 class="text-center mt-2"><i class="fa-solid fa-book"></i> Old Book</h1>
            <div class="row">
                <%
                    IBookService bookService2 = BookServiceFactory.getBookService();
                    List<Books> list2 = bookService2.getOldBooks();
                    for (Books books : list2) {
                %>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="book/<%= books.getPhotoName()%>" alt="" style="width: 150px; height: 200px;" class="img-thumblin" />
                            <p><b>Name: </b><%= books.getBookName()%></p>
                            <p><b>Author: </b><%= books.getAuthor()%></p>
                            <p><b>Category: </b><%= books.getBookCategory()%></p>
                            <div class="row">
                                <a href="view_book_details.jsp?id=<%=books.getBookId()%>" class="btn btn-success btn-sm ml-5">Details</a>
                                <button  class="btn btn-danger btn-sm ml-1">&#8360;. <%= books.getPrice()%></button>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
            <div class="text-center mt-1">
                <a href="all_old_books.jsp" class="btn btn-danger btn-block text-white"> View All</a>
            </div>
        </div>
        <!--end old book-->

        <%@include file="all_component/footer.jsp" %>
    </body>
</html>
