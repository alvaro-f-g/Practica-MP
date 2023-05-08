/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package practicamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alfer
 */
public class HumanoTest {
    
    public HumanoTest() {
    }

    /**
     * Test of getLealtad method, of class Humano.
     */
    @Test
    public void testGetLealtad() {
        System.out.println("getLealtad");
        String nombre = "H";
        int salud = 4;
        String lealtad ="ALTA";
        Humano humano = new Humano(nombre,salud,lealtad);
        String expResult = lealtad;
        String result = humano.getLealtad();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of setLealtad method, of class Humano.
     */
    @Test
    public void testSetLealtad() {
        System.out.println("setLealtad");
        String nombre = "H";
        int salud = 4;
        String lealtad ="ALTA";
        Humano humano = new Humano(nombre,salud,lealtad);
        humano.setLealtad(lealtad);
        Assertions.assertEquals(lealtad,humano.getLealtad());
    }

    /**
     * Test of mostrarEsbirro method, of class Humano.
     */
    @Test
    public void testMostrarEsbirro() {
        System.out.println("mostrarEsbirro");
        String nombre = "H";
        int salud = 4;
        String lealtad ="ALTA";
        Humano humano = new Humano(nombre,salud,lealtad);
        humano.mostrarEsbirro();
    }
    
}
