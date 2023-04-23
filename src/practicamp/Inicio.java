/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicamp;

import java.io.IOException;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author alfer
 */
public class Inicio {
    private Sistema sistema;

    public Inicio() throws IOException, ClassNotFoundException {
        String ruta = "./info.bin";
        File ficheroUsuarios = new File(ruta);
        if(!ficheroUsuarios.exists()){
            try {
                ficheroUsuarios.createNewFile();
                sistema = new Sistema();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } 
        }
        else{
            sistema = deserializarSistema();
            Scanner sc = new Scanner(System.in);
            sistema.menuInicio(sc);
        }
    }

    public Sistema getSistema() {
        return sistema;
    }

    //método encargado de obtener la información en sesiones anteriores
    public Sistema deserializarSistema()throws FileNotFoundException ,IOException, ClassNotFoundException {//Aquí al estar deserializando queremos leer el fichero
            String rutaArchivo = "./info.bin";
            File fichero = new File(rutaArchivo);
            if (fichero.length()>0){
                FileInputStream fis = new FileInputStream(rutaArchivo);
                ObjectInputStream ois = new ObjectInputStream(fis);
                 Sistema datos = (Sistema) ois.readObject();
                return datos;
            }else {
                Sistema sistema = new Sistema();
                return sistema;
                
            }

    }
}    