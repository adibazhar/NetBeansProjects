package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class delete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"w3-container\">\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <td> Name</td>\n");
      out.write("                    <td>Image</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    try {
                        final int BUFFER_SIZE = 4096;

                        Class.forName("org.gjt.mm.mysql.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal_db" + "?user=root&password=root");

                        String sql = "SELECT * FROM images";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {

                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
 out.println(rs.getString("name"));
      out.write("</td>\n");
      out.write("                    <td><img src=\"images/");
 out.println(rs.getString("name"));
      out.write(".jpg\"</td>\n");
      out.write("                    <td><a href=\"deleteFunction.jsp?id=");
      out.print(rs.getString("id") );
      out.write("\"><button type=\"button\" class=\"delete\">Delete</button></a></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        }

                    }catch (Exception e) {
e.printStackTrace();
}
                    
                
      out.write("\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
