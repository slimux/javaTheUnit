/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javafx.collections.ObservableList;
import model.Produit;

/**
 *
 * @author haythem
 */
public interface IProduitService {
    public void ajouter (Produit p);
    public void modifier(Produit s);
    public void supprimerId(int Id_Produit);
    public Produit ChercherCategorie(String categorie);
    ObservableList ChercherNom(String a);
    public void autoId(Produit p);
}
