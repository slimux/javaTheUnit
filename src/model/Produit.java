/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author haythem
 */
public class Produit {
    private int id_Produit;
    private String nom;
    private int quantite;
    private float prix;
    private String description;
    private String categorie;
    private String image;

    public Produit(int id_Produit, String nom, int quantite, float prix, String description, String categorie, String image) {
        this.id_Produit = id_Produit;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.description = description;
        this.categorie = categorie;
        this.image = image;
    }

    public Produit() {
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescription() {
        return description;
    }

    public int getId_Produit() {
        return id_Produit;
    }

    public String getImage() {
        return image;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId_Produit(int id_Produit) {
        this.id_Produit = id_Produit;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_Produit=" + id_Produit + ", nom=" + nom + ", quantite=" + quantite + ", prix=" + prix + ", description=" + description + ", categorie=" + categorie + ", image=" + image + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id_Produit;
        hash = 83 * hash + Objects.hashCode(this.nom);
        hash = 83 * hash + this.quantite;
        hash = 83 * hash + Float.floatToIntBits(this.prix);
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Objects.hashCode(this.categorie);
        hash = 83 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.id_Produit != other.id_Produit) {
            return false;
        }
        if (this.quantite != other.quantite) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }
    
    
}
