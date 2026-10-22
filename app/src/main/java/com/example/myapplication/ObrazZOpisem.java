package com.example.myapplication;

public class ObrazZOpisem {
    public int idObrazka;
    private String opis;

    public ObrazZOpisem(int idObrazka, String opis) {
        this.idObrazka = idObrazka;
        this.opis = opis;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
