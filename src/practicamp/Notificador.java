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

public class Notificador implements Observado, Serializable {
    private ArrayList<Jugador> escuchadores;
    private String filtro;
    private Desafío desafío;


    public String getFiltro() {
        return filtro;
    }


    public Notificador(String filtro){
        this.filtro = filtro;
        this.escuchadores = new ArrayList<>();
    }

    public void añadirDesafío(Desafío desafío){
        this.desafío = desafío;
        notificar();
    }

    @Override
    public void suscribirse(Observador observador) {
        escuchadores.add((Jugador) observador);
    }

    @Override
    public void desuscribirse(Observador observador) {

    }

    @Override
    public void notificar() {
        for (Jugador jugador: escuchadores){
            String nick1 = jugador.getNick();
            String nick2 = desafío.getUsuarioDesafiante().getNick();
            if (!nick1.equals(nick2)){
                String notificacion = "Hay una nuevo desafío de las siguientes caracteristicas: \n";
                notificacion = notificacion.concat(filtro + "\n");
                jugador.actualizar(notificacion);
            }
        }
    }

}
