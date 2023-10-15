
<%@page import="ma.projet.entities.LigneCommandeProduit"%>
<%@page import="ma.projet.entities.Produit"%>
<%@page import="java.util.List"%>
<%@page import="ma.projet.services.ProduitService"%>
<%@page import="ma.projet.entities.Commande"%>
<%@page import="ma.projet.services.CommandeService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.tailwindcss.com"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <title>Commande</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
        <script>
        // Placez le code JavaScript ici
        function confirmDelete(direction) {
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
                    window.location.href = direction;
                }
            });
        }
    </script>








        <script>
            function ajouterLigne() {
                var conteneurLignes = document.getElementById('conteneurLignes');
                // Créez une nouvelle div pour la ligne de commande
                var nouvelleLigne = document.createElement('div');
                nouvelleLigne.className = 'flex bg-gray-50 p-2 rounded border';
                // Créez le menu déroulant pour choisir le produit
                var selectProduit = document.createElement('select');
                selectProduit.className = 'outline-none w-2/3 bg-gray-50 text-gray-500 rounded ';
                selectProduit.name = 'produit_id';
                // Remplissez la liste déroulante avec les produits depuis le serveur
            <%
                ProduitService ps = new ProduitService();
                List<Produit> produits = ps.findAll();
                for (Produit produit : produits) {
            %>
                var option = document.createElement('option');
                option.value = '<%= produit.getId()%>';
                option.className = '';
                option.text = '<%= produit.getReference()%>';
                selectProduit.appendChild(option);
            <%
                }
            %>

                // Créez le champ d'entrée numérique pour la quantité
                var quantiteInput = document.createElement('input');
                quantiteInput.type = 'number';
                quantiteInput.name = 'quantite';
                quantiteInput.value = '1';
                quantiteInput.className = 'w-1/3 bg-gray-100 outline-none pl-6 border rounded';
                // Ajoutez les éléments à la nouvelle ligne de commande
                nouvelleLigne.appendChild(selectProduit);
                nouvelleLigne.appendChild(quantiteInput);
                // Ajoutez la nouvelle ligne de commande au conteneur des lignes de commande
                conteneurLignes.appendChild(nouvelleLigne);
            }
        </script>
    </head>

    <body>

        <%@include file="SidMenu.jsp" %>
        <div class=" flex w-7/9 items-center justify-center ml-[230px] min-h-screen">
            <div class="flex flex-col items-center justify-center w-10/12  my-auto">
                <%
                    String action = request.getParameter("action");
                    CommandeService cs = new CommandeService();
                    ProduitService ps1 = new ProduitService();

                    if (action != null && action.equals("Modifier")) {
                        int commandeId = Integer.parseInt(request.getParameter("id"));
                        Commande c = cs.getById(commandeId);
                        List<LigneCommandeProduit> ls = ps.findProduitByCommande1(c);


                %>

                <div class="flex flex-col justify-center items-center rounded-xl bg-white shadow-lg w-11/12 items-center mx-auto  my-4 py-4 ">
                    <div class="items-center justify-center w-full">
                        <form action="CommandeController" class="flex flex-col justify-center items-center">
                            <p class="font-semibold text-center pb-3 text-sky-500 text-xl"> Modification d'une commande</p>
                            <div class="flex justify-between mx-20 mt-5 mb-8 text-xl w-5/6">
                                <p class=''><span class="font-semibold">Commnande </span>: <%=c.getId()%></p>
                                <p class=''><span class="font-semibold">Date </span>: <%=c.getDate()%></p>
                            </div>
                            <div class="flex items-center justify-between border-b mb-3 bg-sky-500 text-white font-semibold text-center rounded w-5/6">
                                <p class=" text-lg w-1/4">Reference</p>
                                <p class=" text-lg w-1/4">Prix</p>
                                <p class=" text-lg w-1/4">Quantite</p>
                                <p class=" text-lg w-1/4"></p>
                            </div>
                            <input type="hidden" name="commande_id" value="<%=c.getId()%>"/>

                            <%

                                List<LigneCommandeProduit> ls0 = ps.findProduitByCommande1(c);
                                double prixTotal0 = 0;
                                int nbrProduit0 = 0;
                                for (LigneCommandeProduit l : ls0) {
                                    prixTotal0 += l.getQuantite() * l.getProduit().getPrix();
                                    nbrProduit0 += l.getQuantite();
                                }

                                for (LigneCommandeProduit l : ls) {
                            %>
                            <div class="flex items-center justify-between  text-center w-5/6 my-1">

                                <input  type="hidden" name="produit_id" value="<%=l.getProduit().getId()%>"/>

                                <p class="text-lg w-1/4"><%=l.getProduit().getReference()%></p>
                                <p class="text-lg w-1/4"><%=l.getProduit().getPrix()%></p>
                                <input class="text-center text-lg w-1/4 border outline-none bg-gray-200 rounded-xl mx-8 focus:outline-none focus:ring focus:border-sky-200" type="number" name="quantite" value="<%=l.getQuantite()%>"/>
                                <p class="font-semibold text-lg w-1/4 text-red-500 hover:scale-125 "><a  href="#" onclick="confirmDelete('CommandeController?op=Supprimer_l&commande_id=<%=c.getId()%>&produit_id=<%=l.getProduit().getId()%>');">
                                        <i class="bi bi-trash-fill "></i>
                                    </a></p>


                            </div>
                            <%}
                                List<Produit> produits3 = ps.findAll();
                            %>

                            <div class="flex flex-col items-center justify-center mt-5 mb-6">

                                <p class='my-2'><span class="font-semibold">Quantite total des produits </span>: <%=nbrProduit0%></p>
                                <p class='my-2'><span class="font-semibold">Total </span>: <%=prixTotal0%> DH</p>
                            </div>



                            <div class="flex gap-4 items-center justify-center">

                                <div class="flex p-2 text-center text-white bg-green-500 hover:scale-105 cursor-pointer  hover:bg-green-700 rounded items-center justify-center">
                                    <i class="bi bi-pencil-square pr-2"></i>
                                    <input type="submit" name="op" value="Modifier" />
                                </div>


                                <a class="flex p-2 text-center text-white bg-red-500 hover:scale-105 hover:bg-red-700 rounded items-center justify-center" onclick="confirmDelete('CommandeController?op=Supprimer_c&commande_id=<%=c.getId()%>');" href="#">
                                    <i class="bi bi-trash-fill pr-2 "></i>
                                    <p>Supprimer</p>
                                </a>

                            </div>
                        </form>
                    </div>
                    <hr class="mt-4  w-5/6 inline-block border rounded">
                    <div>

                        <form action="CommandeController" class="flex gap-4 bg-white p-3 my-2 rounded">
                            <input type="hidden" name="commande_id" value="<%=c.getId()%>">
                            <input type="hidden" name="op" value="Ajouter_p">
                            <div class="flex bg-gray-100 p-2 rounded border">
                                <select name="produit_id" class="outline-none w-2/3 bg-gray-50 text-gray-500 rounded ">
                                    <%for (Produit p : produits3) {%>
                                    <option value="<%=p.getId()%>"><%=p.getReference()%></option>
                                    <%}%>
                                    <input type="number" name="quantite" class="w-1/3 outline-none mx-auto"/>

                                </select>

                            </div>

                            <input type="submit" value="Ajouter le produit" class="rounded bg-green-400 p-2 text-white cursor-pointer hover:bg-green-700 ">
                        </form>

                    </div>
                </div>
            </div>


            <%} else {
                ProduitService ps2 = new ProduitService();
                List<Produit> produits2 = ps.findAll();
            %>

            <form action="CommandeController" class="flex flex-col justify-center rounded bg-white shadow-lg w-3/4 items-center mt-7 mx-auto ">
                <p class="font-semibold text-center py-3 text-sky-500 text-xl mb-2 ">Ajouter une commande</p>

                <div class="grid grid-cols-3 gap-4 w-5/6 " id="conteneurLignes">
                    <div class="flex bg-gray-50 p-2 rounded border ">
                        <select name="produit_id" class="outline-none w-2/3 bg-gray-50 text-gray-500 rounded  ">
                            <%for (Produit p : produits2) {%>
                            <option value="<%=p.getId()%>"><%=p.getReference()%></option>
                            <%}%>

                        </select>
                        <input type="number" value="1" name="quantite" class="w-1/3 bg-gray-100 outline-none pl-6 border rounded "/>
                    </div>
                    <!-- Les lignes de commande seront ajoutées ici dynamiquement -->
                </div>
                <div class="flex items-center justify-center gap-2 my-5">
                    <button type="button" onclick="ajouterLigne()" class="flex text-sm mx-auto px-3 py-1  mb-2.5  rounded-xl text-white bg-green-400  hover:bg-green-700 hover:scale-105">
                        <i class="bi bi-plus-circle-fill pr-2"></i>
                        <p > Produit </p>
                    </button>
                    <div class="flex text-sm mx-auto px-3 py-1  cursor-pointer mb-2.5  rounded-xl text-white bg-sky-400  hover:bg-sky-700 hover:scale-105">
                        <i class="bi bi-save2 pr-2"></i>
                        <input type="submit" name="op" class="cursor-pointer" value="Ajouter"/>
                    </div>
                </div>
            </form>



            <div class="flex flex-col justify-center rounded bg-white shadow-lg w-full items-center mx-auto mb-24 mt-10 p-6 ">
                <p class="font-semibold  text-sky-500 text-xl mb-5">Liste des commandes</p>
                <div class="bg-[#FDFDFD] border border-gray-200 rounded w-11/12  flex flex-col ">

                    <div class="flex items-center justify-between border-b mb-1 rounded-t bg-sky-500 text-lg text-white font-semibold  ">
                        <div class="p-2 text-center w-1/12">id</div>
                        <div class="p-2 text-center w-2/12">Produits</div>
                        <div class="p-2 text-center w-2/12">Quantite</div>
                        <div class="p-2 text-center w-2/12">Prix(DH)</div>
                        <div class="p-2 text-center w-2/12">Date</div>
                        <div class="p-2 text-center w-2/12">Supprimer</div>
                        <div class="p-2 text-center w-1/12">Voir</div>
                    </div>


                    <%

                        for (Commande c : cs.findAll()) {
                            List<LigneCommandeProduit> ls = ps.findProduitByCommande1(c);
                            double prixTotal = 0;
                            int nbrProduit = 0;
                            for (LigneCommandeProduit l : ls) {
                                prixTotal += l.getQuantite() * l.getProduit().getPrix();
                                nbrProduit += l.getQuantite();
                            }

                    %>
                    <div class="flex items-center justify-between  w-full border-b ">
                        <div class="p-2 text-center w-1/12"><%= c.getId()%></div>
                        <div class="p-2 text-center w-2/12"><%= ls.size()%></div>
                        <div class="p-2 text-center w-2/12"><%= nbrProduit%></div>
                        <div class="p-2 text-center w-2/12"><%= prixTotal%></div>
                        <div class="p-2 text-center w-2/12"><%= c.getDate()%></div>
                        <div class="p-2 text-center w-2/12 text-red-500 hover:scale-125 ">
                            <a href="#" onclick="confirmDelete('CommandeController?op=Supprimer_c&commande_id=<%=c.getId()%>');">
                                <i class="bi bi-trash-fill "></i>
                            </a>
                        </div>
                        <div class="p-2 text-center w-1/12 text-green-500 hover:scale-125 "><a href="?action=Modifier&id=<%=c.getId()%>" ><i class="bi bi-pencil-square"></i></a></div>

                    </div>
                    <% }%>

                </div>
            </div>
            <%}%>


        </div>
    </div>

</body>
</html>
