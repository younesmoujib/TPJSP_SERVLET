package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SidMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        ");

    // Récupérer l'URL de la requête
    String url = request.getRequestURL().toString();

    // Utiliser une expression régulière pour extraire le nom du fichier JSP
    Pattern pattern = Pattern.compile("[^/]+\\.jsp");
    Matcher matcher = pattern.matcher(url);

    String nomFichierJSP = "";
    if (matcher.find()) {
        nomFichierJSP = matcher.group();
    }

    out.println("Nom du fichier JSP : " + nomFichierJSP);

      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"sidebar  fixed top-0 bottom-0 lg:left-0 left-[-300px] duration-1000\n");
      out.write("             px-2 pt-5 w-[230px] overflow-y-auto text-center  bg-gray-900 shadow h-screen\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"text-gray-100 text-xl\">\n");
      out.write("                <div class=\"p-2.5 mt-1 flex justify-center items-center rounded-md \">\n");
      out.write("                    <i class=\"bi bi-bag-check text-white  rounded-md text-xl\"></i>\n");
      out.write("                    <h1 class=\"ml-3 text-xl text-sky-500 font-semibold\"><span class=\"text-white\">Gest</span>Commande</h1>\n");
      out.write("                </div>\n");
      out.write("                <hr class=\"my-3 text-gray-600 w-3/4 inline-block border-2 rounded\">\n");
      out.write("\n");
      out.write("                <div >\n");
      out.write("                    \n");
      out.write("                    <div  class=\"p-2.5 mt-2 flex items-center  rounded-md px-4 duration-300  cursor-pointer  hover:bg-sky-600\">\n");
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
