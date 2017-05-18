/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javafx.collections.ObservableList;
import model.Serveur;

/**
 *
 * @author haythem
 */
public interface IServeurService {
    public void ajouter (Serveur s);
    public void modifier(Serveur s);
    public void supprimerId(int Id_Serveur);
    public Serveur ChercherLocation(String location);
    public Serveur ChercherRank(int rank);
    ObservableList ChercherNom(String a);
    ObservableList getAll();
    public void autoId(Serveur s);
    
}
