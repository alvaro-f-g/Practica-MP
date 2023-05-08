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
public class GhoulTest {
    
    public GhoulTest() {
    }

    /**
     * Test of getDependencia method, of class Ghoul.
     */
    @Test
    public void testGetDependencia() {
        System.out.println("getDependencia");
        String nombre = "p";
        int salud = 5;
        int dependencia = 2;
        Ghoul ghoul = new Ghoul(nombre,salud,dependencia);
        int expResult = 2;
        int result = ghoul.getDependencia();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of setDependencia method, of class Ghoul.
     */
    @Test
    public void testSetDependencia() {
        System.out.println("setDependencia");
        String nombre = "p";
        int salud = 5;
        int dependencia = 2;
        Ghoul ghoul = new Ghoul(nombre,salud,dependencia);
        ghoul.setDependencia(dependencia);
        Assertions.assertEquals(dependencia,ghoul.getDependencia());
    }

    /**
     * Test of mostrarEsbirro method, of class Ghoul.
     */
    @Test
    public void testMostrarEsbirro() {
        System.out.println("mostrarEsbirro");
        String nombre = "p";
        int salud = 5;
        int dependencia = 2;
        Ghoul ghoul = new Ghoul(nombre,salud,dependencia);
        ghoul.mostrarEsbirro();
    }
    
}
