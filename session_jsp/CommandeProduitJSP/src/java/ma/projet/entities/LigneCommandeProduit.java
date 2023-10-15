/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;


@Entity
public class LigneCommandeProduit {
    
    @EmbeddedId
    private LigneCommandeProduitPK id;
            
    private int quantite;
    

    @ManyToOne
    @JoinColumn(name="commande",referencedColumnName="id",insertable = false,updatable = false)
    private Commande commande;
    

    @ManyToOne
    @JoinColumn(name="produit",referencedColumnName="id",insertable = false,updatable = false)
    private Produit produit;

    public LigneCommandeProduit(LigneCommandeProduitPK id, int quantite) {
        this.id = id;
        this.quantite = quantite;
    }
    

    public LigneCommandeProduit(int quantite, Commande commande, Produit produit) {
        this.quantite = quantite;
        this.commande = commande;
        this.produit = produit;
    }

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduitPK getId() {
        return id;
    }

    public void setId(LigneCommandeProduitPK id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
   
    
    
    
    
}
