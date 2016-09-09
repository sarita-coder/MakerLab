/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import dao.DaoPersonas;
import dao.impl.DaoPersonaImpl;
import dto.Personas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sql.Convierte;

/**
 *
 * @author SENCICO
 */
@WebServlet(name = "ServletPersonas", urlPatterns = {"/Personas"})
public class ServletPersonas extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        String result = null;
        String target = "redirec.jsp";

        DaoPersonas daoPersonas = new DaoPersonaImpl();
        if (accion == null) {
            result = "Solicitud no recibida.";

        } else if (accion.equals("QRY")) {
            List<Personas> list = daoPersonas.personaQry();
            if (list != null) {
                request.setAttribute("list", list);
            } else {
                result = "Sin acceso a Notas";
            }
            target = "notasQry.jsp";
        } else if (accion.equals("INS")) {
            Personas personas = new Personas();
            result = valida(request, personas);

            if (result == null) {
                result = daoPersonas.personasIns(personas);
            }

            if (result != null) {
                request.setAttribute("personas", personas);
                target = "notasIns.jsp";
            }
        } else if (accion.equals("DEL")) {
            String ide = request.getParameter("ide");

            List<Integer> list = ide(ide);
            if (list != null) {
                result = daoPersonas.personasDel(list);
            } else {
                result = "ID(s) de notas incorrectos";
                List<Personas> qry = daoPersonas.personaQry();
                request.setAttribute("list", qry);

                target = "notasQry.jsp";
            }
        } else if (accion.equals("GET")) {
            Integer ide = Convierte.aInteger(request.getParameter("ide"));

            if (ide == null) {
                result = "ID notas incorrecto";
            } else {
                Personas p = daoPersonas.personasGet(ide);

                if (p != null) {
                    request.setAttribute("personas", p);
                } else {
                    result = "No es posible obtener personas";
                }
            }

            target = "notasUpd.jsp";
        } else if (accion.equals("UPD")) {
            Personas personas = new Personas();
            result = valida(request, personas);

            if (result == null) {
                result = daoPersonas. personasUpd(personas);
            }

            if (result != null) {
                request.setAttribute("personas", personas);
                target = "notasUpd.jsp";
            }
        } else {
            result = "Solicitud no reconocida.";
        }

        if (result == null) {
            request.setAttribute("msg", result);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }

    private List<Integer> ide(String _ide) {
        List<Integer> list = null;

        if ((_ide != null) && (_ide.trim().length() > 0)) {
            String[] ide = _ide.split(",");

            list = new LinkedList<>();
            for (String ix : ide) {
                Integer x = Convierte.aInteger(ix);

                if (x != null) {
                    list.add(x);
                } else {
                    list = null;
                    break;
                }
            }
        }

        return list;
    }

    private String valida(HttpServletRequest request, Personas personas) {
        String result = "<ul>";

        Integer ide = Convierte.aInteger(request.getParameter("ide"));
        Integer dni = Convierte.aInteger(request.getParameter("dni"));
        String apepad = request.getParameter("apepad");
        String nombres = request.getParameter("nombres");
        Integer celular = Convierte.aInteger(request.getParameter("celular"));
        String correo= request.getParameter("correo");
        String direccion= request.getParameter("direccion");
        Integer longitud=Convierte.aInteger(request.getParameter("longitud"));
        Integer latitud= Convierte.aInteger(request.getParameter("latitud"));
        if (dni == null) {
            result += "<li>Ingrese el dni</li>";
        }
        if ((apepad == null) || (apepad.trim().length() == 0)) {
            result += "<li>ingrese apellidos del empleador</li>";
        }
        if (nombres == null) {
            result += "<li>Ingrese nombres de empleado</li>";
        }
        if (celular == null) {
            result += "<li>Ingrese el celular</li>";
        }
        if (correo == null) {
            result += "<li>Ingrese el correo</li>";
        }
        if (direccion == null) {
            result += "<li>Ingrese el dirección</li>";
        }
        if (longitud == null) {
            result += "<li>Ingrese el longitud</li>";
        }
        if (latitud == null) {
            result += "<li>Ingrese el latitud</li>";
        }

        personas.setIde(ide);
        personas.setDni(dni);
        personas.setApepad(apepad);
        personas.setNombres(nombres);
        personas.setCelular(celular);
        personas.setCorreo(correo);
        personas.setDireccion(direccion);
        personas.setLongitud(longitud);
        personas.setLatitud(latitud);


        if (result.equals("<ul>")) {
            result = null;
        } else {
            result += "</ul>";
        }

        return result;
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
