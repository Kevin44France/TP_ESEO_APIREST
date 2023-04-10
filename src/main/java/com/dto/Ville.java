package com.dto;

public class Ville {
    private String codeCommune;
    private String nomCommune;
    private String codePostal;
    private String libelle;
    private String ligne;
    private String latitude;
    private String longitude;


    public Ville(String codeCommune, String nomCommune,
                 String codePostal, String libelle,
                 String ligne, String latitude, String longitude) {

        this.codeCommune = codeCommune;
        this.nomCommune = nomCommune;
        this.codePostal = codePostal;
        this.libelle = libelle;
        this.ligne = ligne;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Ville(String codeCommune, String nomCommune, String codePostal) {
        this.nomCommune = nomCommune;
        this.codePostal = codePostal;
        this.codeCommune = codeCommune;
        this.libelle = nomCommune;
    }

    public Ville() {

    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    public String getCodeCommune() {
        return this.codeCommune;
    }

    public void setCodeCommune(String codeCommune) {
        this.codeCommune = codeCommune;
    }


    public String getCodePostal() {
        return codePostal;
    }

    public String getLigne() {
        return ligne;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setLigne(String ligne) {
        this.ligne = ligne;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }
}
