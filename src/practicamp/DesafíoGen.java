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
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;

public class DesafíoGen implements Serializable {
    private Date fecha;
    private String usuarioDesafiante, usuarioDesafiado;
    private int precio;
    private ArrayList<Equipo> listaEquipo = new ArrayList<>();
    public DesafíoGen(Date fecha, String usuarioDesafiante, String usuarioDesafiado, ArrayList<Equipo> listaEquipo, int precio) {
        this.fecha = fecha;
        this.usuarioDesafiante = usuarioDesafiante;
        this.usuarioDesafiado = usuarioDesafiado;
        this.listaEquipo = listaEquipo;
        this.precio = precio;
    }
    public void imprimirLog(){
        System.out.print("Fecha: " + fecha);
        System.out.println("Usuario desafiante: " + usuarioDesafiante);
        System.out.println("Usuario desafiado: " + usuarioDesafiado);
        System.out.println("Precio: " + precio);
        System.out.println("Artículos vendidos: ");
        int i;
        if (!listaEquipo.isEmpty()){
            i = 0;
            System.out.println("Equipo: ");
            for (Equipo equipo: listaEquipo ) {
                System.out.println(i + ") ");
                equipo.mostrarEquipo();
                i++;
            }
        }
    }
}
    

