
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO;
import model.User;
import model.Error;
/**
 *
 * @author SARITA
 */
@WebServlet(name = "ValidateServlet", urlPatterns = {"/validate.do"})
public class ValidateServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        String mail, pass;
        
        mail = request.getParameter("txtMail");
        pass = request.getParameter("txtPass");
        User u = new User(mail, pass);
        User user2 = dao.exist(u);
        
        HttpSession session = request.getSession();
        if(user2.errorExist()){
            /*Enviar error.vies y lista de errore*/
            List<Error> errors = user2.getErrors();
            session.setAttribute("errors", errors);
            request.getRequestDispatcher("error.view").forward(request, response);
        }else{
            /*Menu*/
            session.setAttribute("user", user2);
            request.getRequestDispatcher("menu.view").forward(request, response);
            
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
