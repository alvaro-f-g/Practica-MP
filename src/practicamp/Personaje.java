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

public abstract class Personaje implements Serializable {
    private String nombre;
    private ArrayList<Arma> listaArmas = new ArrayList<>();
    private ArrayList<Arma> armasActivas = new ArrayList<>();
    private ArrayList<Armadura> listaArmaduras = new ArrayList<>();
    private ArrayList<Esbirro> listaEsbirros = new ArrayList<>();
    private int cantidadOro;
    private int puntos;
    private int victorias;
    private int empates;
    private int derrotas;
    private int oroGanado;
    private int oroPerdido;

    public Personaje(String nombre, ArrayList<Arma> listaArmas, ArrayList<Arma> armasActivas, ArrayList<Armadura> listaArmaduras, ArrayList<Esbirro> listaEsbirros, int cantidadOro, int puntos, int victorias, int empates, int derrotas, int oroGanado, int oroPerdido) {
        this.nombre = nombre;
        this.listaArmas = listaArmas;
        this.armasActivas = armasActivas;
        this.listaArmaduras = listaArmaduras;
        this.listaEsbirros = listaEsbirros;
        this.cantidadOro = cantidadOro;
        this.puntos = puntos;
        this.victorias =  victorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.oroGanado = oroGanado;
        this.oroPerdido = oroPerdido;
    }

    public String getNombre() {
        return nombre;
    }
    public int getAtaque(){
        int totalArmas = 0;
         int totalArmadura = 0;
        for (Arma armas: armasActivas ) {
            totalArmas = totalArmas + armas.getModAtaque();
        }
        for(Armadura armaduras: listaArmaduras){
            totalArmadura = totalArmadura + armaduras.getModAtaque();
        }
        return totalArmas + totalArmadura;
    }
     public int getDefensa(){
        int totalArmas = 0;
         int totalArmadura = 0;
        for (Arma armas: armasActivas ) {
            totalArmas = totalArmas + armas.getModDefensa();
        }
        for(Armadura armaduras: listaArmaduras){
            totalArmadura = totalArmadura + armaduras.getModDefensa();
        }
        return totalArmas + totalArmadura;
    }

    public ArrayList<Arma> getListaArmas() {
        return listaArmas;
    }

    public ArrayList<Arma>  getArmasActivas() {
        return armasActivas;
    }

    public void addArmasActivas(Arma arma) {
        armasActivas.add(arma);
    }

    public void removeArmasActivas(Arma arma) {
        armasActivas.remove(arma);
    }

    public void addListaArmas(Arma arma) {
        listaArmas.add(arma);
    }

    public void removeListaArmas(Arma arma) {
        listaArmas.remove(arma);
    }

    public ArrayList<Armadura> getListaArmaduras() {
        return listaArmaduras;
    }

    public void addListaArmaduras(Armadura armadura) {listaArmaduras.add(armadura); }

    public void removeListaArmaduras(Armadura armadura) {
        listaArmaduras.remove(armadura);
    }
    public ArrayList<Esbirro> getListaEsbirros() {
        return listaEsbirros;
    }

    public void setListaEsbirros(ArrayList<Esbirro> listaEsbirros) {
        this.listaEsbirros = listaEsbirros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadOro(int cantidadOro) {
        this.cantidadOro = cantidadOro;
    }

    public int getCantidadOro() {
        return cantidadOro;
    }

    public abstract void añadirEsbirro(Esbirro esbirro);

    protected void addListaEsbirros(Esbirro esbirro) {listaEsbirros.add(esbirro); }

    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getOroGanado() {
        return oroGanado;
    }

    public void setOroGanado(int oroGanado) {
        this.oroGanado = oroGanado;
    }

    public int getOroPerdido() {
        return oroPerdido;
    }

    public void setOroPerdido(int oroPerdido) {
        this.oroPerdido = oroPerdido;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}
