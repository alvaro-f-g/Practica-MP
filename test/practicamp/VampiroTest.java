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
public class VampiroTest {
    
    public VampiroTest() {
    }


    /**
     * Test of getPuntosSangre method, of class Vampiro.
     */
    @Test
    public void testGetPuntosSangre() {
        System.out.println("getPuntosSangre");
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
        int puntosSangre = 0;
        int edad = 0;
        ArrayList<Esbirro> listaEsbirros = new ArrayList<>();
       Vampiro v = new Vampiro(nombre, listaArmas, armasActivas, listaArmaduras, listaEsbirros, cantidadOro, puntos, victorias, empates, derrotas, oroGanado, oroPerdido, puntosSangre, edad);
        int result = v.getPuntosSangre();
        Assertions.assertEquals(puntosSangre, result);
        
    }

    /**
     * Test of setPuntosSangre method, of class Vampiro.
     */
    @Test
    public void testSetPuntosSangre() {
        System.out.println("setPuntosSangre");
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
        int puntosSangre = 0;
        int edad = 0;
        ArrayList<Esbirro> listaEsbirros = new ArrayList<>();
       Vampiro v = new Vampiro(nombre, listaArmas, armasActivas, listaArmaduras, listaEsbirros, cantidadOro, puntos, victorias, empates, derrotas, oroGanado, oroPerdido, puntosSangre, edad);
        v.setPuntosSangre(puntosSangre);
        Assertions.assertEquals(puntosSangre,v.getPuntosSangre());
    }

    /**
     * Test of getEdad method, of class Vampiro.
     */
    @Test
    public void testGetEdad() {
        System.out.println("getEdad");
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
        int puntosSangre = 0;
        int edad = 0;
        ArrayList<Esbirro> listaEsbirros = new ArrayList<>();
       Vampiro v = new Vampiro(nombre, listaArmas, armasActivas, listaArmaduras, listaEsbirros, cantidadOro, puntos, victorias, empates, derrotas, oroGanado, oroPerdido, puntosSangre, edad);
        int result = v.getEdad();
        Assertions.assertEquals(edad, result);
    }

    /**
     * Test of setEdad method, of class Vampiro.
     */
    @Test
    public void testSetEdad() {
        System.out.println("setEdad");
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
        int puntosSangre = 0;
        int edad = 0;
        ArrayList<Esbirro> listaEsbirros = new ArrayList<>();
       Vampiro v = new Vampiro(nombre, listaArmas, armasActivas, listaArmaduras, listaEsbirros, cantidadOro, puntos, victorias, empates, derrotas, oroGanado, oroPerdido, puntosSangre, edad);
        v.setEdad(edad);
    }
    
}
