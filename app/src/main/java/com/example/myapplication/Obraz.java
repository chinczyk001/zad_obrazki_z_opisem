package com.example.myapplication;

public abstract class Obraz {
    public int idObrazka;

    public Obraz(int idObrazka) {
        this.idObrazka = idObrazka;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }
}
