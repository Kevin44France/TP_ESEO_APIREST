package com.dto;

public class Ville {
    private String codePostal;
    private String ligne;

    private String nomCommune;

    public Ville(String codePostal, String ligne, String nomCommune) {
        this.codePostal = codePostal;
        this.ligne = ligne;
        this.nomCommune = nomCommune;
    }

    public Ville() {

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
