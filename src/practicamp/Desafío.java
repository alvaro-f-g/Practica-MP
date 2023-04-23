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
import java.util.Date;

public class Desafío implements Serializable {
    private ArrayList<Equipo> listaEquipo;
    private ArrayList<Esbirro> listaEsbirros;
    private int precio;
    private Usuario usuarioDesafiante;

    public Usuario getUsuarioDesafiante() {
        return usuarioDesafiante;
    }

    public Desafío(ArrayList<Equipo> listaEquipo, int precio, Usuario usuarioDesafiante){
        this.listaEquipo = listaEquipo;
        this.precio = precio;
        this.usuarioDesafiante = usuarioDesafiante;
    }
    public void mostrarDesafío(){
        System.out.println("Usuario vendedor: " + usuarioDesafiante.getNick());
        System.out.println("Precio: " + precio);
        System.out.println("Modificadores: ");
        if (!listaEquipo.isEmpty()){
            String equipoModificadores = "";
            for (Equipo equipo: listaEquipo ) {
                equipo.mostrarEquipoModificadores();
            }
            System.out.print(equipoModificadores);
        }
        
    }
    public int getModAtaques(){
        int total = 0;
        for (Equipo equipo: listaEquipo ) {
            total = total + equipo.getModAtaque();
        }
        return total;
        
    }
    public int getModDefensa(){
        int total = 0;
        for (Equipo equipo: listaEquipo ) {
            total = total + equipo.getModDefensa();
        }
        return total;
        
    }

    public ArrayList<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public ArrayList<Esbirro> getListaEsbirros() {
        return listaEsbirros;
    }

    public int getPrecio() {
        return precio;
    }

    public DesafíoGen generarDesafio(String usuario){
        Date date = new Date();
        return new DesafíoGen(date, usuarioDesafiante.getNick(), usuario, listaEquipo, precio);
    }
}
