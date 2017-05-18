/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

public class Serveur {

    private int id_Serveur;
    private String nom;
    private String location;
    private String type_jeu;
    private int rank;
    private String ip;
    
     
    public Serveur() {
    }

    public Serveur(int id_Serveur, String nom, String location, String type_jeu, int rank, String ip) {
        this.id_Serveur = id_Serveur;
        this.nom = nom;
        this.location = location;
        this.type_jeu = type_jeu;
        this.rank = rank;
        this.ip = ip;
    }
    
    public Serveur(String nom, String location, String type_jeu, int rank, String ip) {
        this.nom = nom;
        this.location = location;
        this.type_jeu = type_jeu;
        this.rank = rank;
        this.ip = ip;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id_Serveur;
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.location);
        hash = 97 * hash + Objects.hashCode(this.type_jeu);
        hash = 97 * hash + this.rank;
        hash = 97 * hash + Objects.hashCode(this.ip);
        return hash;
    }

    public int getId_Serveur() {
        return id_Serveur;
    }

    public String getIp() {
        return ip;
    }

    public String getLocation() {
        return location;
    }

    public String getNom() {
        return nom;
    }

    public int getRank() {
        return rank;
    }

    public String getType_jeu() {
        return type_jeu;
    }

    public void setId_Serveur(int id_Serveur) {
        this.id_Serveur = id_Serveur;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setType_jeu(String type_jeu) {
        this.type_jeu = type_jeu;
    }

    @Override
    public String toString() {
        return "Serveur{" + "id_Serveur=" + id_Serveur + ", nom=" + nom + ", location=" + location + ", type_jeu=" + type_jeu + ", rank=" + rank + ", ip=" + ip + '}';
    }

}
