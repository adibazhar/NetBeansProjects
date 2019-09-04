<%-- 
    Document   : deleteFunction
    Created on : Aug 30, 2019, 3:01:44 PM
    Author     : adib.a
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
String id=request.getParameter("id");
try
{
Class.forName("org.gjt.mm.mysql.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal_db" + "?user=root&password=root");
Statement st=conn.createStatement();
int i=st.executeUpdate("DELETE FROM images WHERE id="+id);
out.println("Data Deleted Successfully!");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
    </body>
</html>
