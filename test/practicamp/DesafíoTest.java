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
public class DesafíoTest {
    
    public DesafíoTest() {
    }

    /**
     * Test of getUsuarioDesafiante method, of class Desafío.
     */
    @Test
    public void testGetUsuarioDesafiante() {
        System.out.println("getUsuarioDesafiante");
        ArrayList<Equipo> listaEquipo = new ArrayList<>();
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        listaEquipo.add(espadaPequeña);
        int precio = 2;
        String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuarioDesafiante = new Usuario(nombre,nick,password);
        Desafío desafío = new Desafío(listaEquipo,precio,usuarioDesafiante);
        Usuario expResult = usuarioDesafiante;
        Usuario result = desafío.getUsuarioDesafiante();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of mostrarDesafío method, of class Desafío.
     */
    @Test
    public void testMostrarDesafío() {
        System.out.println("mostrarDesaf\u00edo");
        ArrayList<Equipo> listaEquipo = new ArrayList<>();
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        listaEquipo.add(espadaPequeña);
        int precio = 2;
        String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuarioDesafiante = new Usuario(nombre,nick,password);
        Desafío desafío = new Desafío(listaEquipo,precio,usuarioDesafiante);
        desafío.mostrarDesafío();
    }

    /**
     * Test of getModAtaques method, of class Desafío.
     */
    @Test
    public void testGetModAtaques() {
        System.out.println("getModAtaques");
        ArrayList<Equipo> listaEquipo = new ArrayList<>();
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        listaEquipo.add(espadaPequeña);
        int precio = 2;
        String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuarioDesafiante = new Usuario(nombre,nick,password);
        Desafío desafío = new Desafío(listaEquipo,precio,usuarioDesafiante);
        int total = 0;
        for (Equipo equipo: listaEquipo ) {
            total = total + equipo.getModAtaque();
        }
        int expResult = total;
        int result = desafío.getModAtaques();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of getModDefensa method, of class Desafío.
     */
    @Test
    public void testGetModDefensa() {
        System.out.println("getModDefensa");
        ArrayList<Equipo> listaEquipo = new ArrayList<>();
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        listaEquipo.add(espadaPequeña);
        int precio = 2;
        String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuarioDesafiante = new Usuario(nombre,nick,password);
        Desafío desafío = new Desafío(listaEquipo,precio,usuarioDesafiante);
        int total = 0;
        for (Equipo equipo: listaEquipo ) {
            total = total + equipo.getModDefensa();
        }
        int expResult = total;
        int result = desafío.getModDefensa();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of getListaEquipo method, of class Desafío.
     */
    @Test
    public void testGetListaEquipo() {
        System.out.println("getListaEquipo");
        ArrayList<Equipo> listaEquipo = new ArrayList<>();
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        listaEquipo.add(espadaPequeña);
        int precio = 2;
        String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuarioDesafiante = new Usuario(nombre,nick,password);
        Desafío desafío = new Desafío(listaEquipo,precio,usuarioDesafiante);
        ArrayList<Equipo> expResult = listaEquipo;
        ArrayList<Equipo> result = desafío.getListaEquipo();
        Assertions.assertEquals(expResult, result);
    }


    /**
     * Test of getPrecio method, of class Desafío.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        ArrayList<Equipo> listaEquipo = new ArrayList<>();
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        listaEquipo.add(espadaPequeña);
        int precio = 2;
        String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuarioDesafiante = new Usuario(nombre,nick,password);
        Desafío desafío = new Desafío(listaEquipo,precio,usuarioDesafiante);
        int expResult = precio;
        int result = desafío.getPrecio();
        Assertions.assertEquals(expResult, result);
    }

    
}
