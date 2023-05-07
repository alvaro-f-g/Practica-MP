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
public class ArmaTest {
    
    public ArmaTest() {
    }

    /**
     * Test of getNumManos method, of class Arma.
     */
    @Test
    public void testGetNumManos() {
        System.out.println("getNumManos");
         ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        int expResult = 1;
        int result = espadaPequeña.getNumManos();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of setNumManos method, of class Arma.
     */
    @Test
    public void testSetNumManos() {
        System.out.println("setNumManos");
        int numManos = 0;
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        espadaPequeña.setNumManos(numManos);
       Assertions.assertEquals(numManos,espadaPequeña.getNumManos());
    }

    /**
     * Test of getModAtaque method, of class Arma.
     */
    @Test
    public void testGetModAtaque() {
        System.out.println("getModAtaque");
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        int expResult = 1;
        int result = espadaPequeña.getModAtaque();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of setModAtaque method, of class Arma.
     */
    @Test
    public void testSetModAtaque() {
        System.out.println("setModAtaque");
        int modAtaque = 0;
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        espadaPequeña.setModAtaque(modAtaque);
       Assertions.assertEquals(modAtaque,espadaPequeña.getModAtaque());
    }

    /**
     * Test of getModDefensa method, of class Arma.
     */
    @Test
    public void testGetModDefensa() {
        System.out.println("getModDefensa");
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        int expResult = 0;
        int result = espadaPequeña.getModDefensa();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModDefensa method, of class Arma.
     */
    @Test
    public void testSetModDefensa() {
        System.out.println("setModDefensa");
        int modDefensa = 0;
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        espadaPequeña.setModDefensa(modDefensa);
        Assertions.assertEquals(modDefensa,espadaPequeña.getModDefensa());
    }

    /**
     * Test of getNombre method, of class Arma.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        String expResult = "Espada pequena";
        String result = espadaPequeña.getNombre();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Arma.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre") ;
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        String nombre = "Espada pequena";
        espadaPequeña.setNombre(nombre);
        Assertions.assertEquals(nombre,espadaPequeña.getNombre());
    }

    /**
     * Test of getListaMateriales method, of class Arma.
     */
    @Test
    public void testGetListaMateriales() {
        System.out.println("getListaMateriales");
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        ArrayList<String> expResult = materiales2;
        ArrayList<String> result = espadaPequeña.getListaMateriales();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of setListaMateriales method, of class Arma.
     */
    @Test
    public void testSetListaMateriales() {
        System.out.println("setListaMateriales");
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        ArrayList<String> listaMateriales = espadaPequeña.getListaMateriales();
        espadaPequeña.setListaMateriales(listaMateriales);
       Assertions.assertEquals(materiales2,listaMateriales);
    }

    /**
     * Test of getCategoria method, of class Arma.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        String expResult = "Comun";
        String result = espadaPequeña.getCategoria();
        Assertions.assertEquals(expResult, result);

    }

    /**
     * Test of setCategoria method, of class Arma.
     */
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        Arma  espadaPequeña = new Arma(1, 0, 1, "Espada pequena", "Comun", materiales2);
        String categoria = "Comun";
        espadaPequeña.setCategoria(categoria);
        Assertions.assertEquals(categoria,espadaPequeña.getCategoria());
    }
    
}
