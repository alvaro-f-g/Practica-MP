package practicamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmaduraTest {
    @Test
    public void testGetModAtaque() {
        System.out.println("getModAtaque");
        ArrayList<String> materiales1 = new ArrayList<>(Arrays.asList("Mithril"));
        Armadura cotaMalla = new Armadura(1, 1, "Cota de malla de Mithril", "Rara", materiales1);
        int expResult = 1;
        int result = cotaMalla.getModAtaque();
        Assertions.assertEquals(expResult, result);
    }

    /**
     * Test of setModAtaque method, of class Arma.
     */
    @Test
    public void testSetModAtaque() {
        System.out.println("setModAtaque");
        int modAtaque = 0;
        ArrayList<String> materiales1 = new ArrayList<>(Arrays.asList("Mithril"));
        Armadura cotaMalla = new Armadura(1, 1, "Cota de malla de Mithril", "Rara", materiales1);
        cotaMalla.setModAtaque(modAtaque);
        Assertions.assertEquals(modAtaque,cotaMalla.getModAtaque());
    }

    /**
     * Test of getModDefensa method, of class Arma.
     */
    @Test
    public void testGetModDefensa() {
        System.out.println("getModDefensa");
        ArrayList<String> materiales1 = new ArrayList<>(Arrays.asList("Mithril"));
        Armadura cotaMalla = new Armadura(1, 1, "Cota de malla de Mithril", "Rara", materiales1);
        int expResult = 1;
        int result = cotaMalla.getModDefensa();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModDefensa method, of class Arma.
     */
    @Test
    public void testSetModDefensa() {
        System.out.println("setModDefensa");
        int modDefensa = 0;
        ArrayList<String> materiales1 = new ArrayList<>(Arrays.asList("Mithril"));
        Armadura cotaMalla = new Armadura(1, 1, "Cota de malla de Mithril", "Rara", materiales1);
        cotaMalla.setModDefensa(modDefensa);
        Assertions.assertEquals(modDefensa,cotaMalla.getModDefensa());
    }

}
