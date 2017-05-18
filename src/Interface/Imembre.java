/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.ResultSet;
import model.Membre;
import java.util.List;
import javafx.collections.ObservableList;


/**
 *
 * @author SAMSUNG
 */
public interface Imembre {
    public int ajouterMembre(Membre m);
    public void supprimerMembre(Membre m);
      public List<Membre> displayMembre() ;
    public void modifierMembre(Membre m);
    public ObservableList<Membre> afficherMembre();
     public Membre getMembreById(int id);
     public boolean seekUserByLogin(String pseudo);
    public boolean seekUserByEmail(String email);
    public Membre findUserByLogin(String login);
    public void supprimerId(int Id_Membre);
    public ObservableList rechercheNom(String a);
     public ObservableList getAll();
     public  ResultSet findAll();
   

}
