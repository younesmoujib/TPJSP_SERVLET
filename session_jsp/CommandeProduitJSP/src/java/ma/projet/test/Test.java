/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.entities.Commande;
import ma.projet.services.CommandeService;
import ma.projet.util.HibernateUtil;
import sun.applet.Main;

/**
 *
 * @author Lachgar
 */
public class Test {
    public static void main (String [] args){
//        HibernateUtil.getSessionFactory();
        CommandeService cs = new CommandeService();
        Commande c = new Commande(new Date());
        
        System.out.println(c.getId());
        
    }
}
