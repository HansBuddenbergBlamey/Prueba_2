/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.PostDAO;
import model.dto.Post;
import util.Ayudante;

public class PostController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PostDAO psDAO = new PostDAO();
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        int id = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "eliminar":
                psDAO.eliminar(id);
                response.sendRedirect("../listarPost.jsp");
                break;
            case "buscar":
                Post p = psDAO.buscar(id);
                request.setAttribute("post", p);
                request.getRequestDispatcher("../modificarPost.jsp").forward(request, response);

        }

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
         System.out.println("File opened...");
        
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        
        System.out.print(accion);
        
        switch (accion) {
            case "ingresar":
            PostDAO psDAO = new PostDAO();
        //Profesor p = new Profesor();
            //PostDAO.ingresar();
        }
        
        
        //int usuario_id = request.getParameter("usuario_id");
        String titulo = request.getParameter("titulo");
        String cuerpo = request.getParameter("cuerpo");
        
        //System.out.print(idUpdate);
        PostDAO psDAO = new PostDAO();
        

        switch (accion) {
            case "ingresar":
                Post p = new Post();
                p.setTitulo(titulo);
                p.setCuerpo(cuerpo);
               // p.setCorreo(correo);
               // profeDAO.ingresar(p);
                break;
            case "modificar":
                PostDAO pstDAO = new PostDAO();
                //pstDAO.ingresar(usuario_id);
                //pstDAO.setApellidos(titulo);
                //pstDAO.modificar(cuerpo);
                break;
            default:
                throw new AssertionError();
        }
        //Validaciones
        //Crear objeto profesor y cargar datos desde formulario

        //Redireccionar
        response.sendRedirect("../index.html");

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