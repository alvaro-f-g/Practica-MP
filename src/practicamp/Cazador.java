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

public class Cazador extends Personaje implements Serializable {
    private int puntosVoluntad;

    public Cazador(String nombre, ArrayList<Arma> listaArmas, ArrayList<Arma> armasActivas, ArrayList<Armadura> listaArmaduras, ArrayList<Esbirro> listaEsbirros, int cantidadOro, int puntos, int puntosVoluntad) {
        super(nombre, listaArmas, armasActivas, listaArmaduras, listaEsbirros, cantidadOro, puntos);
        this.puntosVoluntad = puntosVoluntad;
    }

    @Override
    public void añadirEsbirro(Esbirro esbirro) {super.addListaEsbirros(esbirro); }

    public int getPuntosVoluntad() {
        return puntosVoluntad;
    }

    public void setPuntosVoluntad(int puntosVoluntad) {
        this.puntosVoluntad = puntosVoluntad;
    }
}
