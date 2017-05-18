/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;


/**
 *
 * @author SAMSUNG
 */
public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Date DateN;
    private String mdp;
    private String pseudo;
    private String profession;
    private String pays;
    public String pic;

     public Membre(){
         
     }

    public Membre(int id, String nom, String prenom, String email, Date DateN, String mdp, String pseudo, String profession, String pays,String pic) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.DateN = DateN;
        this.mdp = mdp;
        this.pseudo = pseudo;
        this.profession = profession;
        this.pays = pays;
        this.pic=pic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateN() {
        return DateN;
    }

    public void setDateN(Date DateN) {
 
     this.DateN=DateN;
     
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
     
  
   
    
    
    
    
}
