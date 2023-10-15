<%-- 
    Document   : header
    Created on : 7 oct. 2023, 10:36:35
    Author     : pc
--%>

<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>sidebar</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <!-- <script src="./tailwind3.js"></script> -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;800&display=swap"
              rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        
    </head>

    <body class=" font-[Poppins] bg-gray-200 ">
        <%
    // Récupérer l'URL de la requête
    String url = request.getRequestURL().toString();

    // Utiliser une expression régulière pour extraire le nom du fichier JSP
    Pattern pattern = Pattern.compile("[^/]+\\.jsp");
    Matcher matcher = pattern.matcher(url);

    String nomFichierJSP = "";
    if (matcher.find()) {
        nomFichierJSP = matcher.group();
    }

    
%>

        <div class="sidebar  fixed top-0 bottom-0 lg:left-0 left-[-300px] duration-1000
             px-2 pt-5 w-[230px] overflow-y-auto text-center  bg-gray-900 shadow h-screen">


            <div class="text-gray-100 text-xl">
                <div class="p-2.5 mt-1 flex justify-center items-center rounded-md ">
                    <i class="bi bi-bag-check text-white  rounded-md text-xl"></i>
                    <h1 class="ml-3 text-xl text-sky-500 font-semibold"><span class="text-white">Gest</span>Commande</h1>
                </div>
                <hr class="my-3 text-gray-600 w-3/4 inline-block border-2 rounded">

                <div >
                    
                    <div  class="p-2.5 mt-2 flex items-center  rounded-md px-4 <%if (nomFichierJSP.equals("Categorie.jsp")){%>bg-sky-600 <%}%> duration-300  cursor-pointer  hover:bg-sky-600">
                        <i class="bi bi-tags-fill"></i>
                        <span class="text-[15px] ml-4 text-gray-200 "><a href="Categorie.jsp">Ctegories</a></span>
                    </div>
                    
                    <div class="p-2.5 mt-2 flex items-center rounded-md px-4 <%if (nomFichierJSP.equals("Produit.jsp")){%>bg-sky-600 <%}%>duration-300 cursor-pointer  hover:bg-sky-600">
                        <i class="bi bi-basket2-fill"></i>
                        <span class="text-[15px] ml-4 text-gray-200"><a href="Produit.jsp">Produits</a></span>
                    </div>
                    
                    <div class="p-2.5 mt-2 flex items-center rounded-md px-4 <%if (nomFichierJSP.equals("Commande.jsp")){%>bg-sky-600 <%}%> duration-300 cursor-pointer  hover:bg-sky-600">
                        <i class="bi bi-cart-fill"></i>
                        <span class="text-[15px] ml-4 text-gray-200"><a href="Commande.jsp">Commandes</a></span>
                    </div>
                    
                   


                </div>
            </div>
        </div>

        <script>
            function dropDown() {
                document.querySelector('#submenu').classList.toggle('hidden')
                document.querySelector('#arrow').classList.toggle('rotate-0')
            }
            dropDown()

            function Openbar() {
                document.querySelector('.sidebar').classList.toggle('left-[-300px]')
            }
        </script>


    </body>

</html>