/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package practicamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alfer
 */
public class CazadorTest {
    
    public CazadorTest() {
    }

    /**
     * Test of getPuntosVoluntad method, of class Cazador.
     */
    @Test
    public void testGetPuntosVoluntad() {
        System.out.println("getPuntosVoluntad");
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
        int puntosVoluntad = 0;
        ArrayList<Esbirro> listaEsbirros = new ArrayList<>();
       Cazador c = new Cazador(nombre, listaArmas, armasActivas, listaArmaduras, listaEsbirros, cantidadOro, puntos, victorias, empates, derrotas, oroGanado, oroPerdido, puntosVoluntad);
        int result = c.getPuntosVoluntad();
        Assertions.assertEquals(puntosVoluntad, result);
    }

    /**
     * Test of setPuntosVoluntad method, of class Cazador.
     */
    @Test
    public void testSetPuntosVoluntad() {
        System.out.println("setPuntosVoluntad");
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
        int puntosVoluntad = 0;
        ArrayList<Esbirro> listaEsbirros = new ArrayList<>();
       Cazador c = new Cazador(nombre, listaArmas, armasActivas, listaArmaduras, listaEsbirros, cantidadOro, puntos, victorias, empates, derrotas, oroGanado, oroPerdido, puntosVoluntad);
        c.setPuntosVoluntad(puntosVoluntad);
        Assertions.assertEquals(puntosVoluntad,c.getPuntosVoluntad());
    }
    
}
