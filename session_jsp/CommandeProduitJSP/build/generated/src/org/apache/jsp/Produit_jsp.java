package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ma.projet.entities.Categorie;
import ma.projet.services.CategorieService;
import java.util.List;
import ma.projet.entities.Produit;
import ma.projet.services.ProduitService;

public final class Produit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://cdn.tailwindcss.com\"></script>\n");
      out.write("                \n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css\">\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@10\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        // Placez le code JavaScript ici\n");
      out.write("        function confirmDelete(productId) {\n");
      out.write("            Swal.fire({\n");
      out.write("                title: 'Confirmation de suppression',\n");
      out.write("                text: 'Êtes-vous sûr de vouloir supprimer ce produit ?',\n");
      out.write("                icon: 'warning',\n");
      out.write("                showCancelButton: true,\n");
      out.write("                confirmButtonText: 'Oui, supprimer',\n");
      out.write("                cancelButtonText: 'Annuler'\n");
      out.write("            }).then((result) => {\n");
      out.write("                if (result.isConfirmed) {\n");
      out.write("                    // L'utilisateur a confirmé la suppression, redirigez vers la page de suppression\n");
      out.write("                    window.location.href = 'ProduitController?op=delete&id=' + productId;\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            tailwind.config = {\n");
      out.write("                theme: {\n");
      out.write("                    screens: {\n");
      out.write("                        sm: '480px',\n");
      out.write("                        md: '768px',\n");
      out.write("                        lg: '1226px',\n");
      out.write("                        xl: '1440px',\n");
      out.write("                    },\n");
      out.write("                    extend: {\n");
      out.write("                        colors: {\n");
      out.write("                            clifford: '#da373d',\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>sidebar</title>\n");
      out.write("        <script src=\"https://cdn.tailwindcss.com\"></script>\n");
      out.write("        <!-- <script src=\"./tailwind3.js\"></script> -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;800&display=swap\"\n");
      out.write("              rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\" font-[Poppins] bg-gray-200 \">\n");
      out.write("\n");
      out.write("        <div class=\"sidebar  fixed top-0 bottom-0 lg:left-0 left-[-300px] duration-1000\n");
      out.write("             px-2 pt-5 w-[230px] overflow-y-auto text-center  bg-gray-900 shadow h-screen\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"text-gray-100 text-xl\">\n");
      out.write("                <div class=\"p-2.5 mt-1 flex justify-center items-center rounded-md \">\n");
      out.write("                    <i class=\"bi bi-bag-check text-white text-bold rounded-md text-xl\"></i>\n");
      out.write("                    <h1 class=\"ml-3 text-xl text-sky-500 font-bold\"><span class=\"text-white\">Gest</span>Commande</h1>\n");
      out.write("                </div>\n");
      out.write("                <hr class=\"my-3 text-gray-600 w-3/4 inline-block border-2 rounded\">\n");
      out.write("\n");
      out.write("                <div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"p-2.5 mt-2 flex items-center rounded-md px-4 duration-300 cursor-pointer  hover:bg-sky-600\">\n");
      out.write("                        <i class=\"bi bi-tags-fill\"></i>\n");
      out.write("                        <span class=\"text-[15px] ml-4 text-gray-200\"><a href=\"Categorie.jsp\">Ctegories</a></span>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"p-2.5 mt-2 flex items-center rounded-md px-4 duration-300 cursor-pointer  hover:bg-sky-600\">\n");
      out.write("                        <i class=\"bi bi-basket2-fill\"></i>\n");
      out.write("                        <span class=\"text-[15px] ml-4 text-gray-200\"><a href=\"Produit.jsp\">Produits</a></span>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"p-2.5 mt-2 flex items-center rounded-md px-4 duration-300 cursor-pointer  hover:bg-sky-600\">\n");
      out.write("                        <i class=\"bi bi-cart-fill\"></i>\n");
      out.write("                        <span class=\"text-[15px] ml-4 text-gray-200\"><a href=\"Commande.jsp\">Commandes</a></span>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                   \n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function dropDown() {\n");
      out.write("                document.querySelector('#submenu').classList.toggle('hidden')\n");
      out.write("                document.querySelector('#arrow').classList.toggle('rotate-0')\n");
      out.write("            }\n");
      out.write("            dropDown()\n");
      out.write("\n");
      out.write("            function Openbar() {\n");
      out.write("                document.querySelector('.sidebar').classList.toggle('left-[-300px]')\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
      out.write("\n");
      out.write("        <div class=\" flex w-7/9 items-center justify-center  md:ml-[60px] xl:ml-[230px]\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"flex flex-col items-center justify-center lg:w-3/5 xl:w-5/6  \">\n");
      out.write("                ");

                    String action = request.getParameter("action");
                    ProduitService produitService = new ProduitService();
                    if (action != null && action.equals("modifier")) {
                        int ProduitId = Integer.parseInt(request.getParameter("id"));
                        Produit produit = produitService.getById(ProduitId);
                
      out.write("\n");
      out.write("                <form action=\"ProduitController\" class=\"flex flex-col  rounded bg-white shadow-lg sm:w-[500px] md:w-[800px] mx-auto mt-10 mb-4 \">\n");
      out.write("                    <a href=\"Produit.jsp\" class=\" top-0 left-0 ml-3 mt-1 text-sky-500 \"><i class=\"bi bi-arrow-left font-bold text-2xl\"></i></a>\n");
      out.write("                    <p class=\"font-semibold text-center pb-5 text-sky-500 text-xl \">Modifier un produit</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 if (produit != null) {
      out.write("\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print( produit.getId());
      out.write("\"/>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                    <div class=\"flex flex-col gap-2 justify-center mx-auto items-start mb-5 md:flex-row lg:w-3/4\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div >\n");
      out.write("                            <p class=\"text-sm text-gray-700\">Reference: </p>\n");
      out.write("                            <input type=\"text\" name=\"reference\" value=\"");
      out.print( (produit != null) ? produit.getReference() : "");
      out.write("\" class=\"rounded  text-sm py-2 px-3 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500 \"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <p class=\"text-sm\">Prix : </p>\n");
      out.write("                            <input type=\"text\" name=\"prix\" value=\"");
      out.print( (produit != null) ? produit.getPrix() : "");
      out.write("\" class=\"rounded outline-none text-sm py-2 px-3 p-1 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500\"/>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div  >\n");
      out.write("                            <p  class=\"text-sm\" >Categorie : </p>\n");
      out.write("                            <select name=\"categorie\"  class=\"  py-2 px-3 p-1  my-2 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 \">\n");
      out.write("                                ");

                                    CategorieService ps = new CategorieService();
                                    List<Categorie> categories = ps.findAll();
                                
      out.write("\n");
      out.write("                                <option value=\"\">Sélectionnez une Categorie</option>\n");
      out.write("                                ");
 for (Categorie c : categories) {
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( c.getId());
      out.write('"');
      out.write(' ');
      out.print( (produit != null && produit.getCategorie() != null && produit.getCategorie().getId() == c.getId()) ? "selected" : "");
      out.write('>');
      out.print( c.getLibelle());
      out.write("</option>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div>\n");
      out.write("                            <input type=\"submit\" value=\"Modifier\" name=\"modifier\" class=\"text-sm  px-3 py-1 md:mt-8  border-2 border-sky-400 rounded-xl text-white bg-sky-400 hover:text-sky-500 hover:border-sky-500 hover:bg-white hover:border-2\"/>\n");
      out.write("                            <p></p>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                ");

                } else {
                
      out.write("\n");
      out.write("                <form action=\"ProduitController\" class=\"flex flex-col justify-center rounded bg-white shadow-lg sm:w-[500px] md:w-[800px] items-center mx-auto mt-10 mb-4 \">\n");
      out.write("\n");
      out.write("                    <p class=\"font-semibold text-center py-3 text-sky-500 text-xl \">Ajouter un produit</p>\n");
      out.write("                    <div class=\"flex flex-col gap-2 justify-center items-start mb-5 md:flex-row lg:w-3/4\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div >\n");
      out.write("                            <p class=\"text-sm text-gray-700\">Reference: </p>\n");
      out.write("                            <input type=\"text\" name=\"reference\" value=\"\" placeholder=\"Entrer le reference \" class=\"rounded  text-sm py-2 px-3 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500 \"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <p class=\"text-sm\">Prix : </p>\n");
      out.write("                            <input type=\"text\" name=\"prix\" value=\"\" placeholder=\"Entrer le prix  \" class=\"rounded outline-none text-sm py-2 px-3 p-1 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500\"/>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div  >\n");
      out.write("                            <p  class=\"text-sm\" >Categorie : </p>\n");
      out.write("                            <select name=\"categorie\"  class=\"  py-2 px-3 p-1  my-2 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 \">\n");
      out.write("                                ");

                                    CategorieService ps = new CategorieService();
                                    List<Categorie> categories = ps.findAll();
                                
      out.write("\n");
      out.write("                                <option value=\"\">Sélectionnez une Categorie</option>\n");
      out.write("                                ");
 for (Categorie c : categories) {
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( c.getId());
      out.write('"');
      out.write('>');
      out.print( c.getLibelle());
      out.write("</option>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div>\n");
      out.write("                            <input type=\"submit\" value=\"Valider\" name=\"valider\" class=\"text-sm  px-3 py-1 md:mt-8  border-2 border-sky-400 rounded-xl text-white bg-sky-400 hover:text-sky-500 hover:border-sky-500 hover:bg-white hover:border-2\"/>\n");
      out.write("                            <p></p>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"flex flex-col justify-center rounded bg-white shadow-lg w-full items-center mx-auto mb-24 mt-10 p-6 \">\n");
      out.write("                    <p class=\"font-semibold  text-sky-500 text-xl mb-5 \">Liste des Produits</p>\n");
      out.write("                    <div  class=\"bg-[#FDFDFD] border border-gray-200 rounded w-11/12  flex flex-col \">\n");
      out.write("\n");
      out.write("                        <div class=\"flex items-center justify-between border-b mb-1 bg-sky-500 rounded-t text-lg text-white font-semibold  \">\n");
      out.write("                            <p class=\"p-2 text-center w-1/6\">Reference</p>\n");
      out.write("                            <p class=\"p-2 text-center w-1/6\">Prix</p>\n");
      out.write("                            <p class=\"p-2 text-center w-2/6\">Categorie</p>\n");
      out.write("                            <p class=\"p-2 text-center w-1/6\">Supprimer</p>\n");
      out.write("                            <p class=\"p-2 text-center w-1/6\">Modifier</p>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                            ProduitService ps = new ProduitService();
                            for (Produit p
                                    : ps.findAll()) {
                        
      out.write("\n");
      out.write("                        <div class=\"flex items-center justify-between  w-full border-b \">\n");
      out.write("                            <p class=\"p-2 text-center w-1/6\">");
      out.print( p.getReference());
      out.write("</p>\n");
      out.write("                            <p class=\"p-2 text-center w-1/6\">");
      out.print( p.getPrix());
      out.write("</p>\n");
      out.write("                            <p class=\"p-2 text-center w-2/6\">");
      out.print( p.getCategorie().getLibelle());
      out.write("</p>\n");
      out.write("                            <p class=\"p-2 text-center w-1/6 text-red-500\">\n");
      out.write("    <a href=\"#\" onclick=\"confirmDelete(");
      out.print( p.getId());
      out.write(")\"><i class=\"bi bi-trash-fill \"></i></a>\n");
      out.write("</p>\n");
      out.write("\n");
      out.write("                            <p class=\"p-2 text-center w-1/6 text-green-500 hover:scale-125\"><a href=\"?action=modifier&id=");
      out.print(p.getId());
      out.write("\" ><i class=\"bi bi-pencil-square\"></i></a></p>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
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
