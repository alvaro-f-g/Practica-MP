/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package practicamp;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alfer
 */
public class DemonioTest {
    
    public DemonioTest() {
    }

    /**
     * Test of CreacionEsbirrosDeDemonio method, of class Demonio.
     */
    @Test
    public void testCreacionEsbirrosDeDemonio() {
        System.out.println("CreacionEsbirrosDeDemonio");
        String nombre = "p";
        int salud = 0;
        String pacto = "fuerte";
        Demonio demonio = new Demonio(nombre,salud,pacto);
        demonio.CreacionEsbirrosDeDemonio(nombre, salud, pacto);
    }

 

    /**
     * Test of getPacto method, of class Demonio.
     */
    @Test
    public void testGetPacto() {
        System.out.println("getPacto");
        String nombre = "p";
        int salud = 0;
        String pacto = "fuerte";
        Demonio demonio = new Demonio(nombre,salud,pacto);
        String expResult = "fuerte";
        String result = demonio.getPacto();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of setPacto method, of class Demonio.
     */
    @Test
    public void testSetPacto() {
        System.out.println("setPacto");
        String nombre = "p";
        int salud = 0;
        String pacto = "fuerte";
        Demonio demonio = new Demonio(nombre,salud,pacto);
        demonio.setPacto(pacto);
        Assertions.assertEquals(pacto, demonio.getPacto());
    }
    
}
