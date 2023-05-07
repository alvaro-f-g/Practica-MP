/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package practicamp;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alfer
 */
public class LicantropoTest {
    
    public LicantropoTest() {
    }

    /**
     * Test of getPuntosRabia method, of class Licantropo.
     */
    @Test
    public void testGetPuntosRabia() {
        System.out.println("getPuntosRabia");
        String nombre = "P";
         ArrayList<Arma> listaArmas = new ArrayList<>();
         ArrayList<Arma> armasActivas = new ArrayList<>();
     ArrayList<Armadura> listaArmaduras = new ArrayList<>();
     ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
         ArrayList<String> materiales1 = new ArrayList<>(Arrays.asList("Mithril"));
        Armadura cotaMalla = new Armadura(1, 1, "Cota de malla de Mithril", "Rara", materiales1);
        listaArmas.add(espadaPequeña);
        listaArmaduras.add(cotaMalla);
        armasActivas.add(espadaPequeña);
        int cantidadOro = 0;
        int puntos = 0;
        int victorias = 0;
        int empates = 0;
        int derrotas = 0;
        int oroGanado = 0;
        int oroPerdido = 0;
        int puntosRabia = 0;
        ArrayList<Esbirro> listaEsbirros = new ArrayList<>();
       Licantropo l = new Licantropo(nombre, listaArmas, armasActivas, listaArmaduras, listaEsbirros, cantidadOro, puntos, victorias, empates, derrotas, oroGanado, oroPerdido, puntosRabia);
        int result = l.getPuntosRabia();
        Assertions.assertEquals(puntosRabia, result);
        
    }

    /**
     * Test of setPuntosRabia method, of class Licantropo.
     */
    @Test
    public void testSetPuntosRabia() {
        System.out.println("setPuntosRabia");
        String nombre = "P";
         ArrayList<Arma> listaArmas = new ArrayList<>();
         ArrayList<Arma> armasActivas = new ArrayList<>();
     ArrayList<Armadura> listaArmaduras = new ArrayList<>();
     ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
         ArrayList<String> materiales1 = new ArrayList<>(Arrays.asList("Mithril"));
        Armadura cotaMalla = new Armadura(1, 1, "Cota de malla de Mithril", "Rara", materiales1);
        listaArmas.add(espadaPequeña);
        listaArmaduras.add(cotaMalla);
        armasActivas.add(espadaPequeña);
        int cantidadOro = 0;
        int puntos = 0;
        int victorias = 0;
        int empates = 0;
        int derrotas = 0;
        int oroGanado = 0;
        int oroPerdido = 0;
        int puntosRabia = 0;
        ArrayList<Esbirro> listaEsbirros = new ArrayList<>();
       Licantropo l = new Licantropo(nombre, listaArmas, armasActivas, listaArmaduras, listaEsbirros, cantidadOro, puntos, victorias, empates, derrotas, oroGanado, oroPerdido, puntosRabia);
        l.setPuntosRabia(puntosRabia);
        Assertions.assertEquals(puntosRabia, l.getPuntosRabia());
    }
    
}
