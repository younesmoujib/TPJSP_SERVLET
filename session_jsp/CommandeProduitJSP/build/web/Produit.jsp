<%-- 
    Document   : Produit
    Created on : 6 oct. 2023, 21:18:55
    Author     : hp
--%>


<%@page import="ma.projet.entities.Categorie"%>
<%@page import="ma.projet.services.CategorieService"%>
<%@page import="java.util.List"%>
<%@page import="ma.projet.entities.Produit"%>
<%@page import="ma.projet.services.ProduitService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        

        
          <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
          <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
           <script src="https://cdn.tailwindcss.com"></script>
    
        
    <script>
        // Placez le code JavaScript ici
        function confirmDelete(productId) {
            Swal.fire({
                title: 'Confirmation de suppression',
                text: 'Êtes-vous sûr de vouloir supprimer ce produit ?',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Oui, supprimer',
                cancelButtonText: 'Annuler'
            }).then((result) => {
                if (result.isConfirmed) {
                    // L'utilisateur a confirmé la suppression, redirigez vers la page de suppression
                    window.location.href = 'ProduitController?op=delete&id=' + productId;
                }
            });
        }
    </script>

        <script>
                    tailwind.config = {
                    theme: {
                    screens: {
                    sm: '480px',
                            md: '768px',
                            lg: '1226px',
                            xl: '1440px',
                    },
                            extend: {
                            colors: {
                            clifford: '#da373d',
                            }
                            }
                    }
                    }
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="SidMenu.jsp" %>
        
        <div class=" flex w-7/9 items-center justify-center  md:ml-[60px] xl:ml-[230px]">
            <div class="flex flex-col items-center justify-center lg:w-3/5 xl:w-5/6  ">
                <%
                    String action = request.getParameter("action");
                    ProduitService produitService = new ProduitService();
                    if (action != null && action.equals("modifier")) {
                        int ProduitId = Integer.parseInt(request.getParameter("id"));
                        Produit produit = produitService.getById(ProduitId);
                %>
                <form action="ProduitController" class="flex flex-col  rounded bg-white shadow-lg sm:w-[500px] md:w-[800px] mx-auto mt-10 mb-4 ">
                    <a href="Produit.jsp" class=" top-0 left-0 ml-3 mt-1 text-sky-500 "><i class="bi bi-arrow-left font-bold text-2xl"></i></a>
                    <p class="font-semibold text-center pb-5 text-sky-500 text-xl ">Modifier un produit</p>


                    <% if (produit != null) {%>
                    <input type="hidden" name="id" value="<%= produit.getId()%>"/>
                    <% }%>
                    <div class="flex flex-col gap-2 justify-center mx-auto items-start mb-5 md:flex-row lg:w-3/4">


                        <div >
                            <p class="text-sm text-gray-700">Reference: </p>
                            <input type="text" name="reference" value="<%= (produit != null) ? produit.getReference() : ""%>" class="rounded  text-sm py-2 px-3 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500 "/>
                        </div>
                        <div>
                            <p class="text-sm">Prix : </p>
                            <input type="text" name="prix" value="<%= (produit != null) ? produit.getPrix() : ""%>" class="rounded outline-none text-sm py-2 px-3 p-1 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500"/>
                        </div>

                        <div  >
                            <p  class="text-sm" >Categorie : </p>
                            <select name="categorie"  class="  py-2 px-3 p-1  my-2 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 ">
                                <%
                                    CategorieService ps = new CategorieService();
                                    List<Categorie> categories = ps.findAll();
                                %>
                                <option value="">Sélectionnez une Categorie</option>
                                <% for (Categorie c : categories) {%>
                                <option value="<%= c.getId()%>" <%= (produit != null && produit.getCategorie() != null && produit.getCategorie().getId() == c.getId()) ? "selected" : ""%>><%= c.getLibelle()%></option>
                                <% } %>

                            </select>
                        </div>

                        <div>
                            <input type="submit" value="Modifier" name="modifier" class="text-sm  px-3 py-1 md:mt-8  border-2 border-sky-400 rounded-xl text-white bg-sky-400 hover:text-sky-500 hover:border-sky-500 hover:bg-white hover:border-2"/>
                            <p></p>
                        </div>

                    </div>

                </form>

                <%
                } else {
                %>
                <form action="ProduitController" class="flex flex-col justify-center rounded bg-white shadow-lg sm:w-[500px] md:w-[800px] items-center mx-auto mt-10 mb-4 ">

                    <p class="font-semibold text-center py-3 text-sky-500 text-xl ">Ajouter un produit</p>
                    <div class="flex flex-col gap-2 justify-center items-end mb-5 md:flex-row lg:w-3/4">


                        <div >
                            <p class="text-sm text-gray-700">Reference: </p>
                            <input type="text" name="reference" value="" placeholder="Entrer le reference " class="rounded  text-sm py-2 px-3 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500 "/>
                        </div>
                        <div>
                            <p class="text-sm">Prix : </p>
                            <input type="text" name="prix" value="" placeholder="Entrer le prix  " class="rounded outline-none text-sm py-2 px-3 p-1 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500"/>
                        </div>

                        <div  >
                            <p  class="text-sm" >Categorie : </p>
                            <select name="categorie"  class="  py-2 px-3 p-1  my-2 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 ">
                                <%
                                    CategorieService ps = new CategorieService();
                                    List<Categorie> categories = ps.findAll();
                                %>
                                <option value="">Sélectionnez une Categorie</option>
                                <% for (Categorie c : categories) {%>
                                <option  value="<%= c.getId()%>"><%= c.getLibelle()%></option>
                                <% } %>

                            </select>
                        </div>

                        <div class="flex text-sm mx-auto px-3 py-1  mb-2.5 border-2 cursor-pointer border-sky-400 rounded-xl text-white bg-sky-400 hover:text-sky-500 hover:border-sky-500 hover:bg-white hover:border-2">
                            <i class="bi bi-plus-lg  pr-1"></i>
                            
                            <input type="submit" value="Ajouter" name="valider" class="cursor-pointer" />

                        </div>

                    </div>

                </form>
                <%
                    }
                %>



                <div class="flex flex-col justify-center rounded bg-white shadow-lg w-full items-center  mx-auto mb-24 mt-10 p-6 ">
                    <p class="font-semibold  text-sky-500 text-xl mb-5 ">Liste des Produits</p>
                    <div  class="bg-[#FDFDFD] border border-gray-200 rounded w-11/12  flex flex-col ">

                        <div class="flex items-center justify-between border-b mb-1 bg-sky-500 rounded-t text-lg text-white font-semibold  ">
                            <p class="p-2 text-center w-1/6">Reference</p>
                            <p class="p-2 text-center w-1/6">Prix</p>
                            <p class="p-2 text-center w-2/6">Categorie</p>
                            <p class="p-2 text-center w-1/6">Supprimer</p>
                            <p class="p-2 text-center w-1/6">Modifier</p>
                        </div>


                        <%
                            ProduitService ps = new ProduitService();
                            for (Produit p
                                    : ps.findAll()) {
                        %>
                        <div class="flex items-center justify-between  w-full border-b ">
                            <p class="p-2 text-center w-1/6"><%= p.getReference()%></p>
                            <p class="p-2 text-center w-1/6"><%= p.getPrix()%></p>
                            <p class="p-2 text-center w-2/6"><%= p.getCategorie().getLibelle()%></p>
                            <p class="p-2 text-center w-1/6 text-red-500">
                                <a href="#" onclick="confirmDelete(<%= p.getId()%>)"><i class="bi bi-trash-fill "></i></a>
                            </p>

                            <p class="p-2 text-center w-1/6 text-green-500 hover:scale-125"><a href="?action=modifier&id=<%=p.getId()%>" ><i class="bi bi-pencil-square"></i></a></p>

                        </div>
                        <% }%>

                    </div>
                </div>
            </div>
        </div>


    </body>

</html>