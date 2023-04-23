/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicamp;

//import java.util.ArrayList;
//import java.util.Collections;

/**
 *
 * @author alfer
*/
public class Ranking  {
     private Personaje personaje;
     public Ranking(Personaje personaje){
         this.personaje = personaje;
     }
    /*public int getPuntos(){
        return personaje.getPuntos();
    }*/
     public void mostrarRanking(){
          System.out.println("Personaje: " + personaje.getNombre() + " => "+ personaje.getPuntos() + " puntos");
          
      }
     /*public int compareTo(Personaje anotherJugador){
         if(this.personaje.getPuntos() < anotherJugador.getPuntos()) return -1;
         if(this.personaje.getPuntos() == anotherJugador.getPuntos()) return 0;
         return 1;
         
     }*/
}
