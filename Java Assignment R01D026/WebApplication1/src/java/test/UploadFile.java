/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author adib.a
 */
@MultipartConfig(maxFileSize = 169999999)
public class UploadFile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final int BUFFER_SIZE = 4096;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Success</title>");
            out.println("  <link type=\"text/css\" rel=\"stylesheet\" href=\"css/newcss.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<ul>\n"
                    + "  <li><a href=\"index.jsp\">Logout</a></li>\n"
                    + "<li><a href=\"delete.jsp\">Delete Data</a></li>\n" +
"            <li><a href=\"adminPanel.jsp\">Update Data</a></li>"
                    + "  </ul>");
            out.println("<h1> Successfuly insert data to database</h1>");
            out.println("</body>");
            out.println("</html>");

            String name = request.getParameter("prodName");
            String desc = request.getParameter("prodDesc");
            String imageName = request.getParameter("image");
            Part filepart = request.getPart("image");
            InputStream inputstream = null;

            Part filePart = request.getPart("image");
            if (filePart != null) {
                // prints out some information for debugging
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());

                // obtains input stream of the upload file
                inputstream = filePart.getInputStream();
            }

            Class.forName("org.gjt.mm.mysql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal_db" + "?user=root&password=root");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO images(name,image,description) values (?,?,?)");
            ps.setString(1, name);
            if (inputstream != null) {
                // fetches input stream of the upload file for the blob column
                ps.setBlob(2, inputstream);
            }
            ps.setString(3, desc);
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("File uploaded and saved into database");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
