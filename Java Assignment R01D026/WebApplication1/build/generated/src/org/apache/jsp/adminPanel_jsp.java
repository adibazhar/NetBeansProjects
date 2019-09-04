package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import test.Admin;

public final class adminPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");

            Admin admin = (Admin) session.getValue("data");
            String user = admin.getUsername();

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/w3.css\">\n");
      out.write("         <link type=\"text/css\" rel=\"stylesheet\" href=\"css/newcss.css\">\n");
      out.write("        <title>Admin</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"postion:relative\">\n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"index.jsp\">Logout</a></li>\n");
      out.write("            <li style=\"float: left;background-color: grey\"><a>Administrator || Welcome ");
out.println(user);
      out.write("</a>\n");
      out.write("        </ul>\n");
      out.write("        \n");
      out.write("        >\n");
      out.write("            <div  style=\"position:absolute;top: 50%;left: 50%;margin-right: -50%;transform: translate(-50%,-50%)\">\n");
      out.write("            <form action=\"UploadFile\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                <h1 style=\"text-align: center\">Add new product and services</h1>\n");
      out.write("                <label for=\"name\"><b>Product/Services Name</b></label>\n");
      out.write("                <input type=\"text\" placeholder=\"Enter Product/Services Name\" name=\"prodName\" required>\n");
      out.write("                \n");
      out.write("                <label for=\"name\"><b>Description</b></label>\n");
      out.write("                 <textarea  placeholder=\"Enter Product/Services Description\" name=\"prodDesc\" required></textarea>\n");
      out.write("\n");
      out.write("                <label for=\"image\"><b>Upload Image</b></label>\n");
      out.write("                <input  type=\"file\" name=\"image\" accept=\"image/*\">\n");
      out.write("\n");
      out.write("                <input type=\"submit\" value=\"Submit\" > \n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("           \n");
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
