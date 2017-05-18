/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.List;
import model.Administrateur;


/**
 *
 * @author SAMSUNG
 */
public interface Iadministrateur {
   public void ajouterAdmin(Administrateur a);
    public void supprimerAdmin(Administrateur a);
    public void modifierAdmin(Administrateur a);
    public List<Administrateur> afficherAdmin();
     public int loginAdmin(String pseudo, String mdp);
     public boolean verrifBann(String email);
      public Administrateur findUserByLogin(String email);
    
}
