package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.ArrayList;
import test.Product;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    // Product product = (Product) session.getValue("product");
    final int BUFFER_SIZE = 4096;
    Class.forName("org.gjt.mm.mysql.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal_db" + "?user=root&password=root");

    String sql = "SELECT * FROM images";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    //response.sendRedirect("index.jsp");


      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\n");
      out.write("        <META HTTP-EQUIV=\"Expires\" CONTENT=\"-1\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/newcss.css\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/w3.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: whitesmoke\">\n");
      out.write("        <ul>\n");
      out.write("            <li><a class=\"active\" href=\"loginPage.html\">Admin    </a></li>\n");
      out.write("        </ul>\n");
      out.write("        <div>\n");
      out.write("            <header class=\"myHeader\">\n");
      out.write("                <div class=\"headerText\" style=\"\">Welcome to OBC</div>\n");
      out.write("            </header>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div  style=\"text-align: center;background-color: white;\">\n");
      out.write("            <p style=\"font-size: 30px;font-family:impact;\"> Our Product and Services</p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"w3-container\" style=\"margin:10px\">\n");
      out.write("            <div class=\"row\" style=\"display:flex;flex-direction:row;justify-content:center;flex-wrap:wrap;\">\n");
      out.write("                ");
     while (rs.next()) {
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
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
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
