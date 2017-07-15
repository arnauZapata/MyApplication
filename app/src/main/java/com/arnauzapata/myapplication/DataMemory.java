package com.arnauzapata.myapplication;

/**
 * Created by usuari on 12/07/17.
 */

public class DataMemory {
    private int[] soluciones;
    int[] colores;
    boolean [] solved;
    boolean [] selected;
    int image1; int image2;
    int select1, select2;
    int pasos;

    public int[] getSoluciones() {
        return soluciones;
    }

    public void setSoluciones(int[] soluciones) {
        this.soluciones = soluciones;
    }
}
