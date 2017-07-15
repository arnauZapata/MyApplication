package com.arnauzapata.myapplication;

/**
 * Created by usuari on 12/07/17.
 */

interface Comunicador {

    public int getPositionMusic(int[] soluciones);
    public DataMemory enviarDatosCalculadora();
    public void borrarMemoriaCalculadora();
    public DataCalculadora enviarDatosCalculadora2();
    public void borrarMemoriaCalculadora2();
}
