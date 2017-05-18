/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connexion.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Produit;
import Interface.IProduitService;
import java.sql.Connection;

/**
 *
 * @author haythem
 */
public class ProduitService implements IProduitService{
     private final Connection cnx;
    
    public ProduitService(){
         cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouter(Produit p) {
        try {
            String sql = "INSERT INTO produit "
                    + " (id_Produit, nom, quantite, prix, description, categorie, image) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement src = cnx.prepareStatement(sql);
            src.setInt(1, p.getId_Produit());
            src.setString(2, p.getNom());
            src.setInt(3, p.getQuantite());
            src.setFloat(4, p.getPrix());
            src.setString(5, p.getDescription());
            src.setString(6, p.getCategorie());
            src.setString(7, p.getImage());
            
            src.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur " + e);
        }

    }
    
    public void modifier(Produit p) {
        String sql = "UPDATE serveur SET nom= ? , quantite = ?, prix= ? , description= ? , categorie= ? , image= ?  WHERE id_Produit =?";
        try {
            PreparedStatement src = cnx.prepareStatement(sql);
            
            src.setInt(1, p.getId_Produit());
            src.setString(2, p.getNom());
            src.setInt(3, p.getQuantite());
            src.setFloat(4, p.getPrix());
            src.setString(5, p.getDescription());
            src.setString(6, p.getCategorie());
            src.setString(7, p.getImage());
            src.executeUpdate();
        } catch (SQLException ex) {
             System.out.println("Erreur " + ex);
        }
    }

    public void supprimerId(int Id_Produit){
     String sql = "DELETE from produit WHERE Id_Produit =?";
     try {
            PreparedStatement src = cnx.prepareStatement(sql);
            
            src.setInt(1, Id_Produit);
            src.executeUpdate();
        } catch (SQLException ex) {
             System.out.println("Erreur " + ex);
        }
     
     }
    
    public ObservableList getAll() {
        Produit p = new Produit();
        ObservableList listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from produit";
            PreparedStatement src = cnx.prepareStatement(sql);
            ResultSet rs = src.executeQuery(sql);
           while (rs.next()) {
              p = new Produit(rs.getInt("id_Produit"),                    
                        rs.getString("nom"),
                        rs.getInt("quantite"),
                        rs.getFloat("prix"),
                        rs.getString("description"),
                        rs.getString("categorie"),
                        rs.getString("image")
                );
                listData.add(p);
            }
        } catch (Exception ex) {
                ex.printStackTrace();       }
        return listData;
    }

    
    public Produit ChercherCategorie(String categorie) {
        Produit s = new Produit();
        String sql = "select Id_Produit, nom, quantite, prix, description, categorie,  image  FROM produit where categorie=?";
        try {
          PreparedStatement src = cnx.prepareStatement(sql);
            src.setString(1, categorie);
            ResultSet resultat = src.executeQuery();
            while (resultat.next()) {
                s.setId_Produit(resultat.getInt(1));
            s.setNom(resultat.getString(2));    
            s.setQuantite(resultat.getInt(3));
            s.setPrix(resultat.getFloat(4));
            s.setDescription(resultat.getString(5));
            s.setCategorie(resultat.getString(6));
            s.setImage(resultat.getString(7));
            

            }
            return s;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'un Serveur " + ex.getMessage());
            return null;
        }

    }
    

     public ObservableList ChercherNom(String a) {
        Produit p  = new Produit();
        ObservableList listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from produit where nom like '%"+a+"%'";
            PreparedStatement src = cnx.prepareStatement(sql);
            ResultSet rs = src.executeQuery(sql);
            while (rs.next()) {
              p = new Produit(rs.getInt("id_Produit"),                    
                        rs.getString("nom"),
                        rs.getInt("quantite"),
                        rs.getFloat("prix"),
                        rs.getString("description"),
                        rs.getString("categorie"),
                        rs.getString("image")
                );
                listData.add(p);
            }
        } catch (Exception ex) {
                System.out.println("erreur lors de la recherche d'un Serveur " + ex.getMessage());        }
        return listData;
    }
    
    public void autoId(Produit p) {
        String sql = "select * from produit";
        try {
            PreparedStatement src = cnx.prepareStatement(sql);
            ResultSet resultat = src.executeQuery();
            while(resultat.next()){
                String code = resultat.getString(1).substring(2);
                String auto = ""+(Integer.parseInt(code)+1);
                String nul = "";
                if (auto.length()==1) {
                    nul = "00";
                }else if (auto.length()==2) {
                    nul = "0";
                }else if (auto.length()==3) {
                    nul = "";
                }
                p.setId_Produit(Integer.parseInt(nul+auto));
            }
            if (p.getId_Produit()== 0) {
                p.setId_Produit(001);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    }
}
        
     
   
    

