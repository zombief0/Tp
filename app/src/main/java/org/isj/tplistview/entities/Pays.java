package org.isj.tplistview.entities;

import java.io.Serializable;

/**
 * Created by Daniel FOUOMENE  daniel.fouomene@objis-cameroun.com on 01/2019.
 */
public class Pays implements Serializable {

    private String nomPays;
    private String nomFichierDrapeau; // sans extension
    private int population;

    public Pays() {
    }

    public Pays(String nomPays, String nomFichierDrapeau, int population) {
        this.nomPays = nomPays;
        this.nomFichierDrapeau = nomFichierDrapeau;
        this.population = population;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public String getNomFichierDrapeau() {
        return nomFichierDrapeau;
    }

    public void setNomFichierDrapeau(String nomFichierDrapeau) {
        this.nomFichierDrapeau = nomFichierDrapeau;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Pays{" +
                "nomPays='" + nomPays + '\'' +
                ", nomFichierDrapeau='" + nomFichierDrapeau + '\'' +
                ", population=" + population +
                '}';
    }
}
