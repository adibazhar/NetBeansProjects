<%--
    Document   : delete
    Created on : Aug 30, 2019, 11:22:39 AM
    Author     : adib.a
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link type="text/css" rel="stylesheet" href="css/newcss.css">
        <link type="text/css" rel="stylesheet" href="css/w3.css">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <li><a href="index.jsp">Logout</a></li>
            <li><a href="delete.jsp">Delete Data</a></li>
            <li><a href="adminPanel.jsp">Update Data</a></li>
            
        </ul>
        <div class="w3-container">
            <table border="1">
                <tr>
                    <td> Name</td>
                    <td>Image</td>
                </tr>
                <%
                    try {

                        Class.forName("org.gjt.mm.mysql.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal_db" + "?user=root&password=root");

                        String sql = "SELECT * FROM images";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {

                %>
                <tr>
                    <td><% out.println(rs.getString("name"));%></td>
                    <td><% out.println(rs.getString("description"));%></td>
                    <td><img src="images/<% out.println(rs.getString("name"));%>.jpg"</td>
                    <td><a href="deleteFunction.jsp?id=<%=rs.getString("id") %>"><button type="button" class="delete">Delete</button></a></td>
                </tr>
                <%
                        }

                    }catch (Exception e) {
e.printStackTrace();
}
                    
                %>
                </tr>
            </table>
        </div>
    </body>
</html>
