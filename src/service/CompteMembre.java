/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Membre;
import Interface.Imembre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import connexion.MyConnection;
import java.sql.Date;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author SAMSUNG
 */

public class CompteMembre implements Imembre {
    private final Connection cnx;
    
    public CompteMembre(){
        cnx = MyConnection.getInstance().getConnection();
    }

    @Override
    public int ajouterMembre(Membre m) {
       int status =0;
        try{
             String sql = "INSERT INTO membre "
                    + " (id_Membre, nom, prenom, mo_de_passe, email, date_Naissance, profession, pseudo, pays,photo ) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement src = cnx.prepareStatement(sql);
            src.setInt(1, m.getId());
            src.setString(2, m.getNom());
            src.setString(3, m.getPrenom());
              src.setString(4, m.getMdp());
            src.setString(5, m.getEmail());
          
            src.setDate(6, (Date)(m.getDateN()));
            src.setString(7, m.getProfession());
            src.setString(8, m.getPseudo());
            src.setString(9, m.getPays());
             src.setString(10, m.getPic());
            
            src.executeUpdate();

            System.out.println("Compte membre ajouté");
            status =1;
            
        }catch(Exception e){
            System.out.println("Erreur " + e);
            
        }
        return status;
    }

    @Override
    public void supprimerMembre(Membre m) {
       
       try 
           {
               
            String sql = "DELETE FROM `membre` WHERE id_Membre=?";

            PreparedStatement src = cnx.prepareStatement(sql);
            src.setInt(1, m.getId());
            src.executeUpdate();
            System.out.println("Compte membre supprimé");
            } catch (Exception e) {
            System.out.println("Erreur " + e);
        }
    }
@Override
    public void modifierMembre(Membre m) {
        
    try {
            String sql = "UPDATE `membre` SET nom=?, prenom=?,mo_de_passe=?, profession=?, pseudo=?, pays=?,photo=?  WHERE id_Membre=?";
             PreparedStatement src = cnx.prepareStatement(sql);
           
          
           src.setString(1, m.getNom());
           src.setString(2, m.getPrenom());
           src.setString(3, m.getMdp());
           src.setString(4, m.getProfession());
           src.setString(5, m.getPseudo());
           src.setString(6, m.getPays());
           src.setString(7, m.getPic());
           src.setInt(8, m.getId());
          
            
            
            int rowsUpdated = src.executeUpdate();
             if (rowsUpdated > 0) {
             System.out.println("Compte membre modifié");
             }

        } catch (Exception e) {
            System.out.println("Erreur " + e);
        }
    

    }
    @Override
    public ObservableList getAll() {
        Membre s = new Membre();
        ObservableList listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from membre";
            PreparedStatement src = cnx.prepareStatement(sql);
            ResultSet rs = src.executeQuery(sql);
            while (rs.next()) {
                s = new Membre(rs.getInt("id_Membre"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getDate("Date_Naissance"),
                        rs.getString("mo_de_passe"),
                        rs.getString("pseudo"),
                        rs.getString("pays"),
                        rs.getString("profession"),
                        rs.getString("photo")
                );
                listData.add(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listData;
    }
     public  ResultSet findAll(){
           // List<Utilisateur> utilisateurs = new ArrayList<>();
        String requete = "select * from membre";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

           /* while (resultat.next()) {
                Utilisateur u = new Utilisateur();
                u.setLogin(resultat.getString("login"));
                u.setId(resultat.getInt("id"));
                u.setNom(resultat.getString("nom"));
                u.setPrenom(resultat.getString("prenom"));
                u.setMail(resultat.getString("email"));
                u.setSolde(resultat.getInt("solde"));
                
                utilisateurs.add(u);*/
           
         //   }
            return resultat;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des comptes" + ex.getMessage());
            return null;
        }   
              
    }
    
    
    @Override
    public ObservableList<Membre> afficherMembre() {
         
       ObservableList<Membre> lm = FXCollections.observableArrayList();
       
        try {
            String sql = "SELECT * FROM membre";

            PreparedStatement src = cnx.prepareStatement(sql);
            ResultSet res = src.executeQuery(sql);
            while (res.next()) {
             
   Membre m = new Membre();
      m.setId(res.getInt(1));
        m.setNom(res.getString(2));
            m.setPrenom(res.getString(3));
             m.setEmail(res.getString(4));
            m.setMdp(res.getString(5));
            m.setDateN(res.getDate(6));
            m.setProfession(res.getString(7));
            m.setPseudo(res.getString(8));
            m.setPays(res.getString(9));
            lm.add(m);
            }
                    return lm;

        } catch (SQLException e) {
            System.err.println("Erreur ");
        }
        return lm;           
    }
    @Override
    public List<Membre> displayMembre() {
        List<Membre> lm = new ArrayList<Membre>();
       
        try {
            String sql = "SELECT * FROM `membre` ";

            PreparedStatement src = cnx.prepareStatement(sql);
            ResultSet res = src.executeQuery(sql);
            while (res.next()) {
                Membre m=new Membre();
   
      m.setId(res.getInt(1));
        m.setNom(res.getString(2));
            m.setPrenom(res.getString(3));
             m.setEmail(res.getString(4));
            m.setMdp(res.getString(5));
            m.setDateN(res.getDate(6));
            m.setProfession(res.getString(7));
            m.setPseudo(res.getString(8));
            m.setPays(res.getString(9));
            m.setPic(res.getString(10));
            lm.add(m);
            }
        } catch (SQLException e) {
            System.err.println("Erreur ");
        }
        return lm;
    }
     @Override
    public Membre getMembreById(int id) {
        Membre m=null;
        try {
            
            String sql = "SELECT * FROM `membre` WHERE id_Membre=?";
 
            PreparedStatement src = cnx.prepareStatement(sql);
             src.setInt(1,id);
            ResultSet res = src.executeQuery(sql);
            while (res.next()) {
            m = new Membre();
            m.setNom(res.getString(2));
            m.setPrenom(res.getString(3));
             m.setEmail(res.getString(4));
            m.setMdp(res.getString(5));
            m.setDateN(res.getDate(6));
            m.setProfession(res.getString(7));
            m.setPseudo(res.getString(8));
            m.setPays(res.getString(9));
               
         
            }
             System.err.println("Membre existe");
            
        } catch (Exception e) {
            System.out.println("Erreur " + e);
            System.err.println("Membre n'existe pas");
            
        }
        return m;
    }
 public boolean verrifBann(String pseudo) {
            Membre m = null;
        PreparedStatement pst;
        ResultSet res;

        try {
            pst = cnx.prepareStatement("select * from membre where pseudo=?");
            pst.setString(1, pseudo);
            res = pst.executeQuery();
            if (res.last()&&res.getInt("bann_compte") == 1)
            {
                   return false;
            }
            return true;
        }
          catch (SQLException ex) {
            Logger.getLogger(CompteMembre.class.getName()).log(Level.SEVERE, null, ex);
            //error
        
     }
         return false;  
           
       }
   @Override
 public Membre findUserByLogin(String pseudo){
     
     Membre m = new Membre();
        String requete = "select * from membre where pseudo='"+pseudo+"'";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
               m = new Membre();
            m.setNom(res.getString(2));
            m.setPrenom(res.getString(3));
             m.setEmail(res.getString(4));
            m.setMdp(res.getString(5));
            m.setDateN(res.getDate(6));
            m.setProfession(res.getString(7));
            m.setPseudo(res.getString(8));
            m.setPays(res.getString(9));
            m.setPic(res.getString(10));
                return m;
            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du compte " + ex.getMessage());
        }   
    return null;
 }
     
    public int login(String pseudo, String mdp) {
        Membre m = null;
        PreparedStatement pst;
        ResultSet res;

        try {
            pst = cnx.prepareStatement("select * from membre where pseudo=?");
            pst.setString(1, pseudo);
            res = pst.executeQuery();
            if (res.last())//kan il9a il user
            {
                if (mdp.equals(res.getString("mo_de_passe"))) {
                   
                   
                    m = new Membre(res.getInt("id_Membre"), res.getString("nom"),res.getString("prenom"), res.getString("email"), res.getDate("date_Naissance"), res.getString("mo_de_passe"), res.getString("pseudo"), res.getString("profession"), res.getString("pays"),res.getString("photo"));
                        return 1;//login correct
                }
                else {
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
     
    

    @Override
    public boolean seekUserByLogin(String pseudo) {
        String requete = "select * from membre where pseudo='"+pseudo+"'";
           try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            return resultat.first();

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du membre " + ex.getMessage());
            return true;
        }
        
    }

    @Override
    public boolean seekUserByEmail(String email) {
       String requete = "select * from membre where email='"+email+"'";
            try {
       
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            return resultat.first();

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du membre " + ex.getMessage());
            return true;
        }  
    }

    @Override
    public void supprimerId(int id) {
      String sql = "DELETE from membre WHERE id_Membre =?";
        try {
            PreparedStatement src = cnx.prepareStatement(sql);
            src.setInt(1, id);
            src.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erreur " + ex);
        }
 //To change body of generated methods, choose Tools | Templates.
    }
    @Override
        public ObservableList rechercheNom(String a) {
            
                                               
   Membre s = new Membre();
        ObservableList listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from membre where nom,prenom,email,mo_de_passe,pseudo,Date_Naissance,pays,profession like '%" + a + "%'";
            PreparedStatement src = cnx.prepareStatement(sql);
            ResultSet rs = src.executeQuery(sql);
            while (rs.next()) {
                s = new Membre(rs.getInt("id_Membre"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getDate("Date_Naissance"),
                        rs.getString("mo_de_passe"),
                        rs.getString("pseudo"),
                        rs.getString("pays"),
                        rs.getString("profession"),
                        rs.getString("pic")
                );
                listData.add(s);
            }
        } catch (Exception ex) {
            System.out.println("erreur lors de la recherche d'un membre " + ex.getMessage());
        }
        return listData;

    }
}
    
    
    

