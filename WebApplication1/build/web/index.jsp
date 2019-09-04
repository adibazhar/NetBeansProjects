<%-- 
    Document   : index
    Created on : Aug 28, 2019, 8:55:47 AM
    Author     : adib.a
--%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    // Product product = (Product) session.getValue("product");
    final int BUFFER_SIZE = 4096;
    Class.forName("org.gjt.mm.mysql.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal_db" + "?user=root&password=root");

    String sql = "SELECT * FROM images";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    //response.sendRedirect("index.jsp");
  

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <META HTTP-EQUIV="Expires" CONTENT="-1">
        <link type="text/css" rel="stylesheet" href="css/newcss.css">
        <link type="text/css" rel="stylesheet" href="css/w3.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>

    </head>
    <body style="background-color: whitesmoke">
        <ul>
            <li><a class="active" href="loginPage.html">Admin    </a></li>
        </ul>
        <div>
            <header class="myHeader">
                <div class="headerText" >Welcome to OBC</div>
            </header>
        </div>


        <div  style="text-align: center;background-color: white;">
            <p style="font-size: 30px;font-family:impact;"> Our Product and Services</p>
        </div>

        <div class="w3-container" style="margin:10px">
            <div class="row" style="display:flex;flex-direction:row;justify-content:center;flex-wrap:wrap;">
                <%     while (rs.next()) {
                        String imageName = rs.getNString("name");
                        String desc = rs.getString("description");
                        Blob blob = rs.getBlob("image");
                        String dir = "D:\\Users\\adib.a\\Documents\\NetBeansProjects\\WebApplication1\\web\\images\\" + imageName + ".jpg";
                        InputStream inputStream = blob.getBinaryStream();
                        OutputStream outputStream = new FileOutputStream(dir);
                        Product product = new Product();
                        product.setProductName(imageName);
                        product.setProductDesc(desc);

                        int bytesRead = -1;
                        byte[] buffer = new byte[BUFFER_SIZE];
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }

                        /* out.print("<div class=\"column\" style=\"width:300px\""
                         + " <div class=\"w3-card-4\"> "
                         + " <img src=\"images/" + product.getProductName() + ".jpg\"" + " alt=\"Alps\" style=\"width:100%\"> "
                         + "<div class=\"w3-container w3-center\"> "
                         + "   <p>Product</p> "
                         + "</div> "
                         + "</div> "
                         +"</div>");
                         */
                        out.print("<div class=\"col-lg-4\"  > "
                                + " <div class=\"w3-card-4\" style=\"margin-top:10px;\"  > "
                                + " <img src=\"images/" + product.getProductName() + ".jpg\" alt=\"Alps\" style=\"width:100%;max-height:300px;\"> "
                                + " <div class=\"w3-container w3-center\"> "
                                + "<p style=\" font-size:20px;font-family:impact;\">  "
                                + product.getProductName()
                                + "</p> "
                                + "<p>" + product.getProductDesc() + "</p>"
                                + "</div> </div> </div>");

                    }
                %>
            </div>
        </div>


    </body>
</html>
