/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package practicamp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alfer
 */
public class SistemaTest {
    
    public SistemaTest() {
    }
   

    @Test
    public void MenuInicioTest() throws IOException {
        int numEquipo = 15; //Es un arma
        String data = 
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
    @Test
    public void MenuJugadorTest() throws IOException {
        int numEquipo = 2; //Es un arma
        String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n6" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
    @Test
    public void MenuOperadorTest() throws IOException {
        int numEquipo = 15; //Es un arma
        String data = "1" +
                "\n2" + //registrar jugador
                "\n1234" + //codigo secreto
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\n4" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
    @Test
    public void ValidarDesafíoTest() throws IOException {
        int numEquipo = 15; //Es un arma
        String data = "1" +
                "\n2" + //registrar jugador
                "\n1234" + //codigo secreto
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\n1" + //validarDesafios
                "\n4" + //salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
    @Test
    public void GestionarUsuariosTest() throws IOException {
        int numEquipo = 15; //Es un arma
        String data = "1" +
                "\n2" + //registrar jugador
                "\n1234" + //codigo secreto
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\n2" + //GestionarUsuario
                "\n3" + //volver al MenuOperador
                "\n4" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
    @Test
    public void DarseBajaOperadorTest() throws IOException {
        int numEquipo = 15; //Es un arma
        String data = "1" +
                "\n2" + //registrar jugador
                "\n1234" + //codigo secreto
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\n3" + //darse de baja
                "\n4" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
    @Test
    public void MenuAvanzadoPersonajeTest() throws IOException {
        int numEquipo = 15; //Es un arma
String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n0" + //no quiero más armas
                "\n1" + //menuAvanzadoPersonajes
                "\n4" + //volveralMenuPrincipal
                "\n6" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
      @Test
    public void modEquipoTest() throws IOException {
        int numEquipo = 15; //Es un arma
String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n0" + //no quiero más armas
                "\n1" + //menuAvanzadoPersonajes
                "\n1" + //modificarEquipo
                "\n4" + //volveralMenuPrincipal
                "\n6" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
      @Test
    public void modOroTest() throws IOException {
        int numEquipo = 15; //Es un arma
String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n0" + //no quiero más armas
                "\n1" + //menuAvanzadoPersonajes
                "\n2" + //modOro
                "\n1" + //Sumar oro
                "\n500" + //oro sumado
                "\n4" + //volveralMenuPrincipal
                "\n6" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
      @Test
    public void consultarInformaciónPersonajeTest() throws IOException {
        int numEquipo = 15; //Es un arma
String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n0" + //no quiero más armas
                "\n1" + //menuAvanzadoPersonajes
                "\n3" + //consultar Informacion del Personaje
                "\n6" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
      @Test
    public void MenuDesafíoTest() throws IOException {
        int numEquipo = 15; //Es un arma
String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n0" + //no quiero más armas
                "\n2" + //menuDesafío
                "\n4" + //volveralMenuPrincipal
                "\n6" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
    @Test
     public void DesafiarTest() throws IOException {
        int numEquipo = 15; //Es un arma
String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n0" + //no quiero más armas
                "\n2" + //menuDesafío
                "\n1" + //desafiar
                "\nTester1" + //introduzco usuario
                "\n1" + //elegir oro
                "\n50" + //oroaApostar
                "\n6" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
     @Test
      public void AceptarRechazarTest() throws IOException {
        int numEquipo = 15; //Es un arma
String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n0" + //no quiero más armas
                "\n2" + //menuDesafío
                "\n2" + //Aceptar o rechazar
                "\n0" + //salimos
                "\n6" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
      @Test
       public void ConsultarRankingTest() throws IOException {
        int numEquipo = 15; //Es un arma
String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n0" + //no quiero más armas
                "\n2" + //menuDesafío
                "\n3" + //consultarRanking
                "\n6" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
          @Test
    public void ConsultarOroTest() throws IOException {
        int numEquipo = 15; //Es un arma
String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n0" + //no quiero más armas
                "\n3" + //consultarOro
                "\n1" + //consultarOroGanado
                "\n6" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
       @Test
    public void DarseBAjaTest() throws IOException {
        int numEquipo = 15; //Es un arma
String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n0" + //no quiero más armas
                "\n4" + //darse de baja
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
       @Test
    public void mostrarNotificacionesTest() throws IOException {
        int numEquipo = 15; //Es un arma
String data = "1" +
                "\n1" + //registrar jugador
                "\nTester" + //nombre usuario
                "\nTester1" + //nick
                "\n123412344" + //contraseña
                "\nPersonaje" + //nombre personaje
                "\n500" + //cantidad oro
                "\n1" +  //Rol de Personaje
                "\n1" + //puntos de voluntad
                "\n1" + //tipo de esbirro
                "\nHumano" + //nombre de esbirro
                "\n1" + //salud de esbirro
                "\nALTA" + //lealtad (en este caso)
                "\n" + numEquipo +//numero de arma a elegir
                "\n0" + //no quiero más armas
                "\n0" + //no quiero más armas
                "\n5" + //mostrar notificaciones
                "\n6" +//Salir
                "\n3"; //Terminar ejecucion

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Sistema sistema = new Sistema();
    }
         
}



