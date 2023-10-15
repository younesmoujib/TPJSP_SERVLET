<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.tailwindcss.com"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <title>Categories</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
    <script>
        // Placez le code JavaScript ici
        function confirmDelete(categorieId) {
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
                    window.location.href = 'CategorieController?op=delete&id=' + categorieId;
                }
            });
        }
    </script>

    </head>
    <body>
        <%@include file="SidMenu.jsp" %>
        <div class=" flex w-7/9 items-center justify-center ml-[230px]">
            <div class="flex flex-col items-center justify-center w-5/6  ">
                <%
                    String action = request.getParameter("action");
                    CategorieService categorieService = new CategorieService();
                    if (action != null && action.equals("modifier")) {
                        int categorieId = Integer.parseInt(request.getParameter("id"));
                        Categorie categorie = categorieService.getById(categorieId);
                %>
                <form action="CategorieController" class="flex flex-col justify-center rounded bg-white shadow-lg w-3/4  mx-auto mt-10 mb-4 ">
                    
                        <a href="Categorie.jsp" class=" top-0 left-0 ml-3 mt-1 text-sky-500 "><i class="bi bi-arrow-left  text-2xl"></i></a>
                        <p class="font-semibold text-center py-3 text-sky-500 text-xl">Modifier une catégorie</p>
                        <% if (categorie != null) {%>
                        <input type="hidden" name="id" value="<%= categorie.getId()%>"/>
                        <% }%>
                        <div class="flex gap-2 justify-center items-end mb-5 mx-auto" >


                            <div>
                                <p class="text-sm text-gray-700">Code: </p>
                                <input type="text" name="code" value="<%= (categorie != null) ? categorie.getCode() : ""%>" class="rounded  text-sm py-2 px-3 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500 "/>
                            </div>
                            <div>
                                <p class="text-sm">Libelle : </p>
                                <input type="text" name="libelle" value="<%= (categorie != null) ? categorie.getLibelle() : ""%>" class="rounded outline-none text-sm py-2 px-3 p-1 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500"/>
                            </div>

                            <div class="flex text-sm mx-auto px-3 py-1  mb-2.5 border-2 border-sky-400 rounded-xl text-white bg-sky-400 hover:text-sky-500 hover:border-sky-500 hover:bg-white hover:border-2">
                                <i class="bi bi-pencil-square pr-1"></i>
                                <input type="submit" value="Modifier" name="modifier" />
                            </div>

                        </div>
                    
                </form>
                <%
                } else {
                %>
                <form action="CategorieController" class="flex flex-col justify-center rounded bg-white shadow-lg w-3/4 items-center mx-auto mt-10 mb-4 ">

                    <p class="font-semibold text-center py-3 text-sky-500 text-xl ">Ajouter une catégorie</p>
                    <div class="flex gap-2 justify-center items-end mb-5" >
                        <div>
                            <p class="text-sm text-gray-700">Code: </p>
                            <input type="text" name="code" value="" placeholder="Entrer le code" class="rounded  text-sm py-2 px-3 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500 "/>
                        </div>
                        <div>
                            <p class="text-sm">Libelle : </p>
                            <input type="text" name="libelle" value="" placeholder="Entrer la libelle  " class="rounded outline-none text-sm py-2 px-3 p-1 my-2 bg-gray-50 border border-gray-300 focus:outline-none focus:ring focus:border-sky-500"/>
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



                <div class="flex flex-col justify-center rounded bg-white shadow-lg w-full items-center mx-auto mb-24 mt-10 p-6 ">
                    <p class="font-semibold  text-sky-500 text-xl mb-5 ">Liste des catégories</p>
                    <div  class="bg-[#FDFDFD] border border-gray-200 rounded w-11/12  flex flex-col ">

                        <div class="flex items-center justify-between border-b mb-1 bg-sky-500 text-lg text-white font-semibold  ">
                            <p class="p-2 text-center w-2/6">Code</p>
                            <p class="p-2 text-center w-2/6">Libelle</p>
                            <p class="p-2 text-center w-1/6">Supprimer</p>
                            <p class="p-2 text-center w-1/6">Modifier</p>
                        </div>


                        <%
                            CategorieService cs = new CategorieService();
                            for (Categorie c : cs.findAll()) {
                        %>
                        <div class="flex items-center justify-between  w-full border-b ">
                            <p class="p-2 text-center w-1/3"><%= c.getCode()%></p>
                            <p class="p-2 text-center w-1/3"><%= c.getLibelle()%></p>
                            <p class="p-2 text-center w-1/6 text-red-500 hover:scale-125 "><a href="#" onclick="confirmDelete(<%= c.getId()%>)"><i class="bi bi-trash-fill "></i></a></p>
                            <p class="p-2 text-center w-1/6 text-green-500 hover:scale-125"><a href="?action=modifier&id=<%=c.getId()%>" ><i class="bi bi-pencil-square"></i></a></p>
                        </div>
                        <% }%>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
