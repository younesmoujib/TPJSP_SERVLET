/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.controllers;

import com.mchange.v2.c3p0.test.PSLoadPoolBackedDataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.projet.entities.Commande;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.entities.LigneCommandeProduitPK;
import ma.projet.entities.Produit;
import ma.projet.services.CategorieService;
import ma.projet.services.CommandeService;
import ma.projet.services.LigneCommandeProduitService;
import ma.projet.services.ProduitService;
import org.w3c.dom.ls.LSException;

/**
 *
 * @author YahyaMrd
 */
@WebServlet(name = "CommandeController", urlPatterns = {"/CommandeController"})
public class CommandeController extends HttpServlet {

    private CommandeService cs;
    private ProduitService ps;
    private LigneCommandeProduitService ls;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        cs = new CommandeService();
        ps = new ProduitService();
        ls = new LigneCommandeProduitService();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op != null && op.equals("Ajouter")) {
            String[] produitsIds = request.getParameterValues("produit_id");
            String[] quantites = request.getParameterValues("quantite");
            Commande commande = new Commande(new Date());
            cs.create(commande);

            for (int i = 0; i < produitsIds.length; i++) {
                int produitId = Integer.parseInt(produitsIds[i]);
                int quantite = Integer.parseInt(quantites[i]);

                Produit produit = ps.getById(produitId);
                LigneCommandeProduit ligneCommandeProduit = new LigneCommandeProduit(new LigneCommandeProduitPK(produit.getId(), commande.getId()), quantite);
                ls.create(ligneCommandeProduit);

            }
            response.sendRedirect("Commande.jsp");
        } else if (op != null && op.equals("Modifier")) {
            Commande c = cs.getById(Integer.parseInt(request.getParameter("commande_id")));
            String[] produitsIds = request.getParameterValues("produit_id");
            String[] quantites = request.getParameterValues("quantite");
            for (int i = 0; i < produitsIds.length; i++) {
                int produitId = Integer.parseInt(produitsIds[i]);
                int quantite = Integer.parseInt(quantites[i]);
                Produit produit = ps.getById(produitId);
                LigneCommandeProduitPK lpk = new LigneCommandeProduitPK(produitId, c.getId());
                LigneCommandeProduit l = ls.getById(lpk);
                l.setQuantite(quantite);
                ls.update(l);

            }
            response.sendRedirect("Commande.jsp");
        } else if (op != null && op.equals("Supprimer_l")) {
            int commande_id = Integer.parseInt(request.getParameter("commande_id"));
            int produitId = Integer.parseInt(request.getParameter("produit_id"));
            LigneCommandeProduitPK lpk = new LigneCommandeProduitPK(produitId, commande_id);
            ls.delete(ls.getById(lpk));
            String direction = "Commande.jsp?action=Modifier&id=" + commande_id;
            response.sendRedirect(direction);

        }else if (op != null && op.equals("Supprimer_c")){
            int commande_id = Integer.parseInt(request.getParameter("commande_id"));
            for(LigneCommandeProduit lcp : ps.findProduitByCommande1(cs.getById(commande_id)))
                ls.delete(lcp);
            cs.delete(cs.getById(commande_id));
            response.sendRedirect("Commande.jsp");
            
        } else if (op != null && op.equals("Ajouter_p")){
            int commande_id = Integer.parseInt(request.getParameter("commande_id"));
            int produit_id = Integer.parseInt(request.getParameter("produit_id"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            LigneCommandeProduitPK lpk = new LigneCommandeProduitPK(produit_id, commande_id);
            ls.create(new LigneCommandeProduit(lpk, quantite));
            String direction = "Commande.jsp?action=Modifier&id="+commande_id;
            response.sendRedirect(direction);
            
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
