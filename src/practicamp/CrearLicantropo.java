/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicamp;

/**
 *
 * @author alfer
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CrearLicantropo extends Creator implements Serializable {
    //Scanner sc = new Scanner(System.in);
    @Override
    public Personaje crearPersonaje(String nombre, ArrayList<Arma> listaArmas, ArrayList<Arma> armasActivas, ArrayList<Armadura> listaArmaduras, ArrayList<Esbirro> listaEsbirros, int cantidadOro, int puntos, Scanner sc) {
        System.out.println("Introduzca un valor de rabia entre (0 - 3)");
        int rabia = sc.nextInt();
        while (rabia < 0 || rabia > 3) {
            System.out.println("Introduzca los puntos de rabia del Licántropo, solo entre 0 y 3");
            rabia = sc.nextInt();
        }
        Licantropo l = new Licantropo(nombre,listaArmas,armasActivas,listaArmaduras,listaEsbirros,cantidadOro,puntos,rabia);
        return l;
    }
}
