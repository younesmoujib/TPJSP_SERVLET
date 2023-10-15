package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ma.projet.entities.Produit;
import java.util.List;
import ma.projet.services.ProduitService;
import ma.projet.entities.Commande;
import ma.projet.services.CommandeService;

public final class Commande_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/SidMenu.jsp");
  }

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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://cdn.tailwindcss.com\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            function ajouterLigne() {\n");
      out.write("                var conteneurLignes = document.getElementById('conteneurLignes');\n");
      out.write("\n");
      out.write("                // Créez une nouvelle div pour la ligne de commande\n");
      out.write("                var nouvelleLigne = document.createElement('div');\n");
      out.write("                nouvelleLigne.className = 'flex items-center p-2';\n");
      out.write("\n");
      out.write("                // Créez le menu déroulant pour choisir le produit\n");
      out.write("                var selectProduit = document.createElement('select');\n");
      out.write("                selectProduit.className = '';\n");
      out.write("                selectProduit.name='produit';\n");
      out.write("                // Remplissez la liste déroulante avec les produits depuis le serveur\n");
      out.write("                ");

                    ProduitService ps = new ProduitService();
                    List<Produit> produits = ps.findAll();
                    for (Produit produit : produits) {
                
      out.write("\n");
      out.write("                var option = document.createElement('option');\n");
      out.write("                option.value = '");
      out.print( produit.getId() );
      out.write("';\n");
      out.write("                \n");
      out.write("                option.text = '");
      out.print( produit.getReference() );
      out.write("';\n");
      out.write("                selectProduit.appendChild(option);\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("                // Créez le champ d'entrée numérique pour la quantité\n");
      out.write("                var quantiteInput = document.createElement('input');\n");
      out.write("                quantiteInput.type = 'number';\n");
      out.write("                quantiteInput.name = 'quantite';\n");
      out.write("\n");
      out.write("                // Ajoutez les éléments à la nouvelle ligne de commande\n");
      out.write("                nouvelleLigne.appendChild(selectProduit);\n");
      out.write("                nouvelleLigne.appendChild(quantiteInput);\n");
      out.write("\n");
      out.write("                // Ajoutez la nouvelle ligne de commande au conteneur des lignes de commande\n");
      out.write("                conteneurLignes.appendChild(nouvelleLigne);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"flex\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <ul>\n");
      out.write("                <li ><a href=\"Categorie.jsp\">Categories</a></li>\n");
      out.write("                <li><a href=\"Produit.jsp\">Produits</a></li>\n");
      out.write("                <li><a href=\"Commande.jsp\">Commande</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            <div class=\"flex flex-col items-center justify-center\">\n");
      out.write("                <form action=\"CommandeController\" class=\"flex flex-col justify-center rounded bg-gray-100 w-1/4 items-center mx-auto my-4 \">\n");
      out.write("                    <button type=\"button\" onclick=\"ajouterLigne()\"> Ajouter un produit </button>\n");
      out.write("                    <div class=\"flex flex-col\" id=\"conteneurLignes\">\n");
      out.write("                        <!-- Les lignes de commande seront ajoutées ici dynamiquement -->\n");
      out.write("                    </div>\n");
      out.write("                    <input type=\"submit\" value=\"Ajouter\" name=\"ajouter\"/>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <!-- Reste du code de votre page ici -->\n");
      out.write("                <fieldset class=\"flex flex-col justify-center rounded bg-gray-100 w-4/5 items-center mx-auto mb-24 mt-10 \">\n");
      out.write("                    <div class=\"text-gray-400 font-bold text-center m-3\">Liste des catégories</div>\n");
      out.write("                    <table border=\"0\" class=\"bg-white rounded mb-5 mt-2 w-4/5\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr class=\"border-b mb-1\">\n");
      out.write("                                <th class=\"py-2\">id</th>\n");
      out.write("                                <th>Date</th>\n");
      out.write("                                <th>Supprimer</th>\n");
      out.write("                                <th>Modifier</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                                CommandeService cs = new CommandeService();
                                for (Commande c : cs.findAll()) {

                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"p-2 text-center \">");
      out.print( c.getId());
      out.write("</td>\n");
      out.write("                                <td class=\"p-2 text-center\">");
      out.print( c.getDate());
      out.write("</td>\n");
      out.write("                                <td class=\"p-2 text-center text-red-500\"><a href=\"CommandeController?op=delete&id=");
      out.print(c.getId());
      out.write("\">Supprimer</a></td>\n");
      out.write("                                <td class=\"p-2 text-center text-sky-500\"><a href=\"?action=modifier&id=");
      out.print(c.getId());
      out.write("\" >Modifier</a></td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </fieldset>\n");
      out.write("\n");
      out.write("            </div>\n");
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
