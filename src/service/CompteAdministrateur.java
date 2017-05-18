/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Administrateur;
import model.Membre;
import Interface.Iadministrateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import connexion.MyConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public class CompteAdministrateur implements Iadministrateur {
       private final Connection cnx;
    
    
    public CompteAdministrateur(){
         cnx = MyConnection.getInstance().getConnection();
    }

    @Override
    public void ajouterAdmin(Administrateur a) {
        try{
             String sql = "INSERT INTO administrateur "
                    + " (id_Admin, nom, prenom, mot_de_passe, email ) "
                    + " VALUES (?,?,?,?,?)";
            PreparedStatement src = cnx.prepareStatement(sql);
            src.setInt(1, a.getId());
            src.setString(2, a.getNom());
            src.setString(3, a.getPrenom());
            src.setString(4, a.getMdp());
            src.setString(5, a.getEmail());
         
            
            src.executeUpdate();

            System.out.println("Compte ADMINISTRATEUR ajouté");
            
            
        }catch(Exception e){
            System.err.println("Erreur " + e);
            
        }
    }

    

    @Override
    public void supprimerAdmin(Administrateur a) {
       try {
            String sql = "DELETE FROM `membre` WHERE id_Admin=?";

            PreparedStatement src = cnx.prepareStatement(sql);
            src.setInt(1, a.getId());
            src.executeUpdate();
            System.out.println("Compte Admin supprimé");
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }

    @Override
    public void modifierAdmin(Administrateur a) {
       try {
            String sql = "UPDATE `membre` SET nom=?, prenom=?,mo_de_passe=? WHERE id_Membre=?";
             PreparedStatement src = cnx.prepareStatement(sql);
           
          
           src.setString(1, a.getNom());
           src.setString(2, a.getPrenom());
           src.setString(3, a.getMdp());
           
           src.setInt(4, a.getId());
          
            int rowsUpdated = src.executeUpdate();
             if (rowsUpdated > 0) {
             System.out.println("Compte membre modifié");
             }

        } catch (Exception e) {
            System.out.println("Erreur " + e);
        }
    

    }
 /*public int loginAdmin(String pseudo, String mdp) {
        Membre m = null;
        PreparedStatement pst;
        ResultSet res;

        try {
            pst = cnx.getConnexion().prepareStatement("select * from administrateur where pseudo=?");
            pst.setString(1, pseudo);
            res = pst.executeQuery();
            if (res.last())//kan il9a il user
            {
                if (mdp.equals("admin"))) {
               
                        return 4;//login correct but compte blocked
                    }
                    else if (verrifBann(pseudo) == false) {
                    m = new Membre(res.getInt("id"), res.getString("nom"),res.getString("prenom"), res.getString("email"), res.getDate("DateN"), res.getString("mdp"), res.getString("pseudo"), res.getString("profession"), res.getString("pays"));
                        return 1;//login correct
                }
                }else {
                        return 3;//user s7i7 pass 8alet
                }
            } 
                    return 2;//user mal9ahech
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CompteMembre.class.getName()).log(Level.SEVERE, null, ex);
            //error
        
     }
        return 0;
     }
     */
    

    @Override
    public List<Administrateur> afficherAdmin() {
      List<Administrateur> lm = new ArrayList<Administrateur>();
       
        try {
            String sql = "SELECT * FROM `administrateur`";

            PreparedStatement src = cnx.prepareStatement(sql);
            ResultSet res = src.executeQuery(sql);
            while (res.next()) {
                Administrateur m=new Administrateur();
   
      m.setId(res.getInt(1));
        m.setNom(res.getString(2));
            m.setPrenom(res.getString(3));
             m.setEmail(res.getString(4));
            m.setMdp(res.getString(5));
           
            lm.add(m);
            }
        } catch (Exception e) {
            System.err.println("Erreur ");
            e.printStackTrace();
        }
        return lm;
    }
     @Override
    public boolean verrifBann(String email) {
            Administrateur m = null;
        PreparedStatement pst;
        ResultSet res;

        try {
            pst = cnx.prepareStatement("select * from administrateur where email=?");
            pst.setString(1, email);
            res = pst.executeQuery();
            if (res.last()&&res.getInt("bann_compte") == 1)
            {
                   return false;
            }
            return true;
        }
          catch (SQLException ex) {
            Logger.getLogger(CompteAdministrateur.class.getName()).log(Level.SEVERE, null, ex);
            //error
        
     }
         return false;  
           
       }
    public int loginAdmin(String email, String mdp) {
        Administrateur m = null;
        PreparedStatement pst;
        ResultSet res;

        try {
            pst = cnx.prepareStatement("select * from Administrateur where email=?");
            pst.setString(1, email);
            res = pst.executeQuery();
            if (res.last())//kan il9a il user
            {
                if (mdp.equals(res.getString("mot_de_passe"))) {
                   
                    
                    m = new Administrateur(res.getInt("id_Admin"), res.getString("nom"),res.getString("prenom"), res.getString("mot_de_passe"),  res.getString("email"));
                        return 1;//login correct
                }
                else {
                        return 3;//user s7i7 pass 8alet
                }
            } 
                    return 2;//user mal9ahech
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CompteAdministrateur.class.getName()).log(Level.SEVERE, null, ex);
            //error
        
     }
        return 0;
     }

    @Override
    public Administrateur findUserByLogin(String email) {
         Administrateur m = new Administrateur();
        String requete = "select * from administrateur where email='"+email+"'";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
               m = new Administrateur();
            m.setNom(res.getString(2));
            m.setPrenom(res.getString(3));
             m.setEmail(res.getString(4));
            m.setMdp(res.getString(5));
           
                return m;
            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du compte " + ex.getMessage());
        }   
    return null;
    }
     
}
