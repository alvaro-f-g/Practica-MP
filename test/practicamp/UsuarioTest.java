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
public class UsuarioTest {
    
    public UsuarioTest() {
    }

    /**
     * Test of getNombre method, of class Usuario.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuario = new Usuario(nombre,nick,password);
        String expResult = "p";
        String result = usuario.getNombre();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuario = new Usuario(nombre,nick,password);
        usuario.setNombre(nombre);
       Assertions.assertEquals(nombre,usuario.getNombre());
    }

    /**
     * Test of getNick method, of class Usuario.
     */
    @Test
    public void testGetNick() {
        System.out.println("getNick");String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuario = new Usuario(nombre,nick,password);
        String expResult = "n";
        String result = usuario.getNick();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of setNick method, of class Usuario.
     */
    @Test
    public void testSetNick() {
        System.out.println("setNick");
        String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuario = new Usuario(nombre,nick,password);
        usuario.setNick(nick);
        Assertions.assertEquals(nick,usuario.getNick());
    }

    /**
     * Test of getPassword method, of class Usuario.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuario = new Usuario(nombre,nick,password);
        String expResult = "1111";
        String result = usuario.getPassword();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Usuario.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String nombre = "p";
        String nick ="n";
        String password = "1111";
        Usuario usuario = new Usuario(nombre,nick,password);
        usuario.setPassword(password);
        Assertions.assertEquals(password,usuario.getPassword());
    }
    
}
