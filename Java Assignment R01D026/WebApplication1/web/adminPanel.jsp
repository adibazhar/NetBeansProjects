<%-- 
    Document   : newjsp
    Created on : Aug 27, 2019, 9:09:36 AM
    Author     : adib.a
--%>

<%@page import="test.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
            Admin admin = (Admin) session.getValue("data");
            String user = admin.getUsername();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="css/w3.css">
         <link type="text/css" rel="stylesheet" href="css/newcss.css">
        <title>Admin</title>
    </head>
    <body style="postion:relative">
        <ul>
            <li><a href="index.jsp">Logout</a></li>
            <li><a href="delete.jsp">Delete Data</a></li>
            <li><a href="adminPanel.jsp">Update Data</a></li>
            <li style="float: left;background-color: grey"><a>Administrator || Welcome <%out.println(user);%></a>
        </ul>
        
        >
            <div  style="position:absolute;top: 50%;left: 50%;margin-right: -50%;transform: translate(-50%,-50%)">
            <form action="UploadFile" method="post" enctype="multipart/form-data">
                <h1 style="text-align: center">Add new product and services</h1>
                <label for="name"><b>Product/Services Name</b></label>
                <input type="text" placeholder="Enter Product/Services Name" name="prodName" required>
                
                <label for="name"><b>Description</b></label>
                 <textarea  placeholder="Enter Product/Services Description" name="prodDesc" required></textarea>

                <label for="image"><b>Upload Image</b></label>
                <input  type="file" name="image" accept="image/*">

                <input type="submit" value="Submit" > 
            </form>
        </div>
           
    </body>
</html>
