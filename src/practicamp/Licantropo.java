/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicamp;

/**
 *
 * @author alfer
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Licantropo extends Personaje implements Serializable {
    private int puntosRabia;

    public Licantropo(String nombre, ArrayList<Arma> listaArmas, ArrayList<Arma> armasActivas, ArrayList<Armadura> listaArmaduras, ArrayList<Esbirro> listaEsbirros, int cantidadOro,int puntos, int victorias, int empates, int derrotas, int oroGanado, int oroPerdido,  int puntosRabia) {
        super(nombre,listaArmas,armasActivas,listaArmaduras,listaEsbirros,cantidadOro, puntos, victorias, empates, derrotas, oroGanado, oroPerdido);
        this.puntosRabia = puntosRabia;
    }


    @Override
    public void añadirEsbirro(Esbirro esbirro) {
            super.addListaEsbirros(esbirro);
    }

    public int getPuntosRabia() {
        return puntosRabia;
    }

    public void setPuntosRabia(int puntosRabia) {
        this.puntosRabia = puntosRabia;
    }
}
