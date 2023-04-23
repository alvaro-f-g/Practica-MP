/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package practicamp;

/**
 *
 * @author alfer
 */
public interface Observado {
    public abstract void suscribirse(Observador observador);
    public abstract void desuscribirse(Observador observador);
    public abstract void notificar();
}
