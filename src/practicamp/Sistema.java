/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicamp;

/**
 *
 * @author alfer
 */
 import java.io.*;
import java.net.PortUnreachableException;
import java.util.*;
//import java.util.Collections;
//import java.util.ArrayList;

public class Sistema  implements Serializable {
    private Usuario usuario;
    private ArrayList<Usuario> usuariosAceptados, usuariosBaneados = new ArrayList<>();
    private ArrayList<Desafío> listaDesafíos,listaDesafíosNoValidados = new ArrayList<>();
    private ArrayList<Notificador> listaNotificadores = new ArrayList<>();
    private ArrayList<DesafíoGen> listaLogs = new ArrayList<>();
    private ArrayList<Arma> conjuntoArmas = new ArrayList<>();
    private ArrayList<Armadura> conjuntoArmaduras = new ArrayList<>();
    private Personaje p;
    private ArrayList<Ranking> rankings = new ArrayList<>();

    public Sistema() throws IOException {
        if (listaDesafíos == null){
            listaDesafíos = new ArrayList<>();
        }
        Scanner sc = new Scanner(System.in);
        inicializarArmaduras();
        inicializarArmas();
        menuInicio(sc);
    }
    public void rechazarDesafío(Scanner sc, Desafío desafío){
        int opción;
        System.out.println("¿Quieres rechazar el desafio");
        System.out.println("Pulse 0 si quiere rechazarlo, o 1 en caso contrario");
        opción = sc.nextInt();
        switch(opción){
            case 0: 
                System.out.println("Desafio rechazado");
                int cantidadOro = ((Jugador)usuario).getPersonaje().getCantidadOro();
                int cantidadOroPerdida = desafío.getPrecio()*(int)0.1;
                int nuevaCantidadOro = ((Jugador)usuario).getPersonaje().getCantidadOro() - cantidadOroPerdida;
                nuevaCantidadOro = ((Jugador)usuario).getPersonaje().getCantidadOro();
                break;
            case 1: 
                System.out.println("Volviendo al menu de desafios");
                break;
        }
    }
    public void consultarDesafío(Scanner sc) {
        int i = 1;
        ArrayList <Desafío> copiaListaDesafíos = new ArrayList<Desafío>(listaDesafíos);
        boolean mostrar = false; 
        if (!listaDesafíos.isEmpty()) {
            for (Desafío desafío : listaDesafíos) {
                if(!desafío.getUsuarioDesafiante().getNick().equals(usuario.getNick())) {
                    System.out.println("Desafio numero " + i + ")");
                    desafío.mostrarDesafío();
                    System.out.println("");
                    mostrar = true;
                }
                i++;
            }
            if (mostrar){
                System.out.println("Pulse 1 para aceptar desafios, 2 para rechazarlos o presione 0 para salir");
                int opcion,option;
                do{
                    opcion = sc.nextInt();
                    System.out.println("");
                }while(opcion >=2 && opcion<=0);
                if(opcion == 1){
                    System.out.println("Seleccione el numero del desafio que quiere aceptar o presione 0 para salir");
                    do{
                        option = sc.nextInt();
                    } while(option > listaDesafíos.size() || option < 0 );
                    if (option != 0) {
                        boolean oroDisponible = comprarDesafío(listaDesafíos.get(option - 1));
                        if (!oroDisponible) {
                            System.out.println("No hay oro disponible");
                        }
                    }else{
                        System.out.println("Volviendo");
                        menuDesafio(sc);
                    } 
                }
                else if(opcion == 2){
                    System.out.println("Seleccione el numero del desafío que quiere rechazar o presione 0 para salir");
                    int option2;
                    do{
                        option2 = sc.nextInt();
                    } while(option2 > listaDesafíos.size() || option2 < 0 );
                    rechazarDesafío(sc, listaDesafíos.get(option2 -1));
                }else if (opcion == 0){
                    menuDesafio(sc);
                }else{
                    System.out.println("Escriba un numero entre 0 y 2");
                    System.out.println("");
                   consultarDesafío(sc); 
                }
               
            } else{
                    System.out.println("No hay desafios disponibles");
            }
        } else {
            System.out.println("No hay desafios disponibles");
        }
    }
    public void resultadoDesafío(Desafío desafío,Usuario usuario, int cantidadOro, int cantidadOroDesafiante){
        if ((desafío.getModAtaques() > ((Jugador) usuario).getPersonaje().getAtaque()) && (desafío.getModDefensa() > ((Jugador) usuario).getPersonaje().getDefensa())){
                System.out.println("El usuario desafiante" + desafío.getUsuarioDesafiante().getNick() +" ha ganado el desafio");
                ((Jugador) desafío.getUsuarioDesafiante()).getPersonaje().setCantidadOro(cantidadOroDesafiante + desafío.getPrecio());
                ((Jugador) usuario).getPersonaje().setCantidadOro(cantidadOro - desafío.getPrecio());
                int puntosUsuarioDesafiante = ((Jugador) desafío.getUsuarioDesafiante()).getPersonaje().getPuntos();
                ((Jugador)desafío.getUsuarioDesafiante()).getPersonaje().setPuntos(puntosUsuarioDesafiante + 3);
                rankings.add(((Jugador) desafío.getUsuarioDesafiante()));
                rankings.add(((Jugador) usuario));
            }else if ((desafío.getModAtaques() < ((Jugador) usuario).getPersonaje().getAtaque()) && (desafío.getModDefensa() < ((Jugador) usuario).getPersonaje().getDefensa())){
                System.out.println("El usuario desafiado " + usuario.getNick() +" ha ganado el desafio");
                ((Jugador) desafío.getUsuarioDesafiante()).getPersonaje().setCantidadOro(cantidadOroDesafiante - desafío.getPrecio());
                ((Jugador) usuario).getPersonaje().setCantidadOro(cantidadOro + desafío.getPrecio());
                int puntosUsuarioDesafiado = ((Jugador) usuario).getPersonaje().getPuntos();
                ((Jugador)usuario).getPersonaje().setPuntos(puntosUsuarioDesafiado + 3);
                rankings.add(((Jugador) desafío.getUsuarioDesafiante()));
                rankings.add(((Jugador) usuario));
            }else
                System.out.println("Se ha producido un empate");
                rankings.add(((Jugador) desafío.getUsuarioDesafiante()));
                rankings.add(((Jugador) usuario));    
    }
    private boolean comprarDesafío(Desafío desafío) {
        int cantidadOro = ((Jugador) usuario).getPersonaje().getCantidadOro();
        int cantidadOroDesafiante = ((Jugador) desafío.getUsuarioDesafiante()).getPersonaje().getCantidadOro();
        if (cantidadOro >= desafío.getPrecio()) {
            for (Equipo equipo : desafío.getListaEquipo()) {
                if (equipo instanceof Arma) {
                    Arma arma = ((Arma) equipo);
                    ((Jugador) usuario).getPersonaje().addListaArmas(arma);
                } else {
                    Armadura armadura = ((Armadura) equipo);
                    ((Jugador) usuario).getPersonaje().addListaArmaduras(armadura);
                }
            }
            resultadoDesafío(desafío,usuario,cantidadOro,cantidadOroDesafiante);
            listaDesafíos.remove(desafío);
            return true;
        } else {
            System.out.println("No se puede aceptar el desafío");
            return false;
        }
    }

    public void menuInicio(Scanner sc) throws IOException {
        int opcionmenú;
        System.out.println("   Bienvenido al Menu de Inicio   ");
        System.out.println("Seleccione una opcion      ");
        System.out.println("1 - Registrarse                   ");
        System.out.println("2 - Iniciar sesion                ");
        System.out.println("3 - Terminar ejecucion");
        System.out.println("");
        do{
            opcionmenú = sc.nextInt();
            if(opcionmenú < 1 || opcionmenú > 3){
                System.out.println("Introduce una opcion correcta");
            }
        } while(opcionmenú < 1 || opcionmenú > 3);
        switch (opcionmenú) {
            case 1:
                usuario = null;
                registrarCuenta(sc);
                break;
            case 2:
                usuario = null;
                iniciarSesion(sc);
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
        }
    }

    private void registrarCuenta(Scanner sc) throws IOException {
        System.out.println("Como quieres registrarte:");
        System.out.println("1. Jugador");
        System.out.println("2. Operador");
        System.out.println("3. Volver al menu de inicio");
        int opcion;
        do {
            opcion = sc.nextInt();
            if (opcion < 1 || opcion >3){
                System.out.println("Introduce una opcion correcta");
            }
        }while(opcion < 1 || opcion > 3);
        switch (opcion) {
            case 1:
                System.out.println("Introduce el nombre");
                String nombre = sc.next();
                String nick;
                do { 
                    System.out.println("Introduce el nick");
                    nick = sc.next();
                } while (encontrarNick(nick));

                System.out.println("Introduce la contrasena");
                String contraseña = sc.next();
                while (contraseña.length() < 8 || contraseña.length() > 12) {
                    System.out.println("La contrasena debe contener entre 8 y 12 caracteres, vuelva a intentarlo");
                    contraseña = sc.next();
                }
                registrarPersonaje(sc);
                Personaje personaje = p;
                String numeroReg = calcularNumRegistro();
                Jugador jugador1 = new Jugador(nombre, nick, contraseña, personaje, numeroReg);
                usuario = jugador1;
                int opcionEquipo;
                do {
                    añadirEquipo(sc);
                    System.out.println("Si quieres anadir mas equipo pulsa 1, sino, pulsa 0");
                    opcionEquipo = sc.nextInt();
                }while(opcionEquipo != 0);
                elegirArmasActivas(sc);
                break;
            case 2:
                System.out.println("Introduzca el codigo secreto o introduzca 1 para cancelar");
                int codigo = sc.nextInt();
                while (codigo != 1 && codigo != 1234) {
                    System.out.println("Codigo incorrecto, introduzcalo de nuevo o cancele la accion");
                    codigo = sc.nextInt();
                }
                switch (codigo) {
                    case 1:
                        registrarCuenta(sc);
                        break;
                    case 1234:
                        System.out.println("Introduce el nombre");
                        String nombreOp = sc.next();
                        String nickOp;
                        do {
                            System.out.println("Introduce el nick");
                            nickOp = sc.next();
                        } while (encontrarNick(nickOp));
                        System.out.println("Introduce la contrasena");
                        String contraseñaOp = sc.next();
                        Operador admin = new Operador(nombreOp, nickOp, contraseñaOp);
                        usuario = admin;
                        break;
                }
                break;
            case 3:
                menuInicio(sc);
                break;
        }
        if (opcion != 3){
            crearUsuario();
            menuPrincipal(sc);
        }
    }

    private void crearUsuario() throws IOException {
        if (usuariosAceptados != null) {
            usuariosAceptados.add(usuario);
            serializarSistema();
        } else {
            usuariosAceptados = new ArrayList<>();
            usuariosAceptados.add(usuario);
            serializarSistema();
        }
    }

    public void menuPrincipal(Scanner sc) throws IOException {
        if (usuario instanceof Jugador) {
            menuJugador(sc);
        } else {
            menuOperador(sc);
        }
        serializarSistema();
    }

    private void menuOperador(Scanner sc) throws IOException {
        int opcionMenúOP;
        System.out.println("Bienvenido al menu principal " + usuario.getNick());
        System.out.println("Elige una de las siguientes opciones");
        System.out.println("1. Validar desafios");
        System.out.println("2. Gestionar usuarios");
        System.out.println("3. Darse de baja");
        System.out.println("4. Salir");
        System.out.println("");
        do{
            opcionMenúOP = sc.nextInt();
        } while(opcionMenúOP < 1 || opcionMenúOP > 4);

        switch (opcionMenúOP) {
            case 1:
                validarDesafío(sc);
                break;
            case 2:
                menuUsuario(sc);
                break;
            case 3:
                darseDeBaja(sc);
                break;
            case 4:
                salir(sc);
                break;
        }
        if (opcionMenúOP != 4 && opcionMenúOP != 3){
            menuPrincipal(sc);
        }
    }

    private void menuJugador(Scanner sc) throws IOException {
        int opcionMenúJ;
        System.out.println("Bienvenido al menu principal " + usuario.getNick());
        System.out.println("Elige una de las siguientes opciones");
        System.out.println("1. Gestion avanzada de personaje");
        System.out.println("2. Gestion avanzada de los desafios");
        System.out.println("3. Darse de baja");
        System.out.println("4. Mostrar Notificaciones");
        //System.out.println("5.Consultar ranking");
        System.out.println("5. Salir");
        System.out.println("");
        if (!((Jugador) usuario).getListaNotificaciones().isEmpty()){
            System.out.println("*¡Tienes nuevas notificaciones!*");
        }
        do{
            opcionMenúJ = sc.nextInt();
            if(opcionMenúJ > 5 || opcionMenúJ < 1){
                System.out.println("Introduce una opcion correcta");
            }
        }while(opcionMenúJ > 5 || opcionMenúJ < 1);

        switch (opcionMenúJ) {
            case 1:
                menuAvanzadoPersonaje(sc);
                break;
            case 2:
                menuDesafio(sc);
                break;
            case 3:
                darseDeBaja(sc);
                break;
            case 4:
                mostrarNotificaciones();
                break;
            /*case 5 :
                mostrarRankingOrdenado();
                break;*/
            case 5:
                salir(sc);
                break;
                        

        }
        if (opcionMenúJ != 5 && opcionMenúJ != 3){
            menuPrincipal(sc);
        }
    }
    /* public  void mostrarRankingOrdenado(){
         
          System.out.println("Personaje: " + p.getNombre() + " => "+ p.getPuntos() + " puntos");
          Collections.sort(rankings);
          
      }*/
    
    public void mostrarNotificaciones() {
        ((Jugador) usuario).mostrarNotificaciones();
        ((Jugador) usuario).vaciarListaNotificaciones();
    }

    private void menuAvanzadoPersonaje(Scanner sc) throws IOException {
        int opcionMenuP2;
        System.out.println("Bienvenido al menu avanzado para personajes " + usuario.getNick());
        System.out.println("Elige una de las siguientes opciones");
        System.out.println("1. Modificar equipo");
        System.out.println("2. Modificar oro");
        System.out.println("3. Consultar informacion del personaje");
        System.out.println("4. Volver al menu principal");
        System.out.println("");
        do{
            opcionMenuP2 = sc.nextInt();
            if (opcionMenuP2 > 4 || opcionMenuP2 < 1) {
                System.out.println("Introduce una opcion correcta");
            }
        }while(opcionMenuP2 > 4 || opcionMenuP2 < 1);
        switch (opcionMenuP2) {
            case 1:
                modEquipo(sc);
                break;
            case 2:
                modOro(sc);
                break;
            case 3:
                consultarInformacionPersonaje(sc);
                break;
        }
    }

    private void menuDesafio(Scanner sc) {
        int opcionMenúD = -1;
        System.out.println("Bienvenido al menu de desafios " + usuario.getNick());
        System.out.println("¿Que operacion desea realizar?");
        System.out.println("1. Desafiar ");
        System.out.println("2. Aceptar o rechazar desafios");
        System.out.println("3. Volver al menu principal");
        System.out.println(" ");
        do {
            try {
                System.out.println("Escribe una de las opciones");
                opcionMenúD = sc.nextInt();
                switch (opcionMenúD) {
                    case 1:
                        crearDesafío(sc);
                        break;
                    case 2:
                        consultarDesafío(sc);
                        break;
                    case 3:
                        break;
                }   
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }while (opcionMenúD > 3 || opcionMenúD < 1) ;
        
    }
    private void darseDeBaja(Scanner sc) throws IOException {
        usuariosAceptados.remove(usuario);
        System.out.println("Se ha dado de baja correctamente");
        menuInicio(sc);
    }
    public void verArmas(Personaje per, int i){
         if(!per.getListaArmas().isEmpty()) {
            while (i < per.getListaArmas().size()) {
                if(!per.getArmasActivas().contains(per.getListaArmas().get(i))) {
                    System.out.println(i + 1 + ". " + per.getListaArmas().get(i).getNombre());
                }
                i += 1;
            }
        }else {
            System.out.println("Este personaje no tiene Armas");
        }
    } 
    public void verArmaduras(Personaje per, int i){
        if(!per.getListaArmaduras().isEmpty()) {
            while (i < per.getListaArmaduras().size()) {
                System.out.println(i + 1 + ". " + per.getListaArmaduras().get(i).getNombre());
                i += 1;
            }
        }else {
            System.out.println("Este personaje no tiene Armaduras");
        }
    }
    public void verArmasActivas(Personaje per, int i){
        if(!per.getArmasActivas().isEmpty()) {
            while (i < per.getArmasActivas().size()) {
                System.out.println(i + 1 + ".");
                per.getArmasActivas().get(i).mostrarEquipo();
                i += 1;
            }
        }else {
            System.out.println("Este personaje no tiene Armas Activas");
        }
    }
    public void consultarInformacionPersonaje(Scanner sc) throws IOException {
        System.out.println("Cantidad de oro del Personaje: " + p.getCantidadOro() + " de oro");
        System.out.println("Armas del Personaje:");
        int i = 0;
        verArmas(p,i);
        System.out.println("Armaduras del Personaje:");
        i = 0;
        verArmaduras(p,i);
        System.out.println("Armas activas:");
        i = 0;
        verArmasActivas(p,i);
        System.out.println("Esbirros del Personaje:");
        i = 0;
        if(!p.getListaEsbirros().isEmpty()) {
            while (i < p.getListaEsbirros().size()) {
                Esbirro esbirro = p.getListaEsbirros().get(i);
                esbirro.mostrarEsbirro();
                i += 1;
            }
        }else {
            System.out.println("Este personaje no tiene Esbirros");
        }
    }

    private void salir(Scanner sc) throws IOException {
        menuInicio(sc);
    }
    private Personaje crearPersonajeBase(Scanner sc) {
        System.out.println("Introduce el nombre del personaje");
        String nombre = sc.next();
        System.out.println("Introduzca la cantidad de oro del personaje");
        int cantidadOro = sc.nextInt();
        ArrayList<Arma> armasActivas = new ArrayList<>();
        ArrayList<Esbirro> listaEsbirros = new ArrayList<>();
        int puntos = 0;
        p = new Personaje(nombre, new ArrayList<Arma>(), armasActivas, new ArrayList<Armadura>(), listaEsbirros, cantidadOro, puntos) {
            @Override
            public void añadirEsbirro(Esbirro esbirro) {
            }
        };
        return p;
    }
    public void crearEsbirro(Scanner sc) {
        System.out.println("Elige el tipo de esbirro que quieres crear");
        System.out.println("1 - Humano");
        System.out.println("2 - Ghoul");
        System.out.println("3 - Demonio");
        int opcion = sc.nextInt();
        System.out.println("Introduce el nombre del esbirro");
        String nombreEsbirro = sc.next();
        System.out.println("Introduce la salud para el esbirro");
        int salud = sc.nextInt();
        switch (opcion) {
            case 1:
                if (p instanceof Vampiro) {
                    System.out.println("Los vampiros no pueden tener humanos, introduzca otro tipo de esbirro");
                    crearEsbirro(sc);
                } else {
                    System.out.println("Introduce el tipo de lealtad (ALTA,NORMAL o BAJA)");
                    String lealtad = sc.next().toUpperCase();
                    while (!lealtad.equals("ALTA") && !lealtad.equals("NORMAL") && !lealtad.equals("BAJA")) {
                        System.out.println("El tipo de lealtad tiene que ser ALTO,NORMAL o BAJA");
                        lealtad = sc.next().toUpperCase();
                    }
                    Humano h = new Humano(nombreEsbirro, salud, lealtad);
                    p.getListaEsbirros().add(h);
                }
                break;
            case 2:
                boolean error = false;
                System.out.println("Introduce la dependencia");
                int dependencia = 0;
                do {
                    try {
                        dependencia = sc.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println("El valor debe ser numerico");
                        error = true;
                    }
                    while (dependencia < 1 || dependencia > 5) {
                        System.out.println("La dependencia debe ser un numero entre 1 y 5");
                        dependencia = sc.nextInt();
                    }
                } while (error);
                Ghoul g = new Ghoul(nombreEsbirro, salud, dependencia);
                p.getListaEsbirros().add(g);
                break;
            case 3:
                System.out.println("Dime la descripcion del pacto");
                String descripcion = sc.next();
                Demonio demonio = new Demonio(nombreEsbirro, salud, descripcion);
                p.getListaEsbirros().add(demonio);
                break;
            default:
                System.out.println("Introduce una opcion correcta");
                crearEsbirro(sc);
                break;
        }
    }
    private Personaje registrarPersonaje(Scanner sc) {
        int opcionRol;
        p = crearPersonajeBase(sc);
        System.out.println("Elige un rol");
        System.out.println("1. Cazador");
        System.out.println("2. Vampiro");
        System.out.println("3. Licantropo");
        opcionRol = sc.nextInt();
        switch (opcionRol) {
            case 1:
                CrearCazador cazador = new CrearCazador();
                p = cazador.crearPersonaje(p.getNombre(), p.getListaArmas(), p.getArmasActivas(), p.getListaArmaduras(), p.getListaEsbirros(), p.getCantidadOro(), p.getPuntos() ,sc);
                break;
            case 2:
                CrearVampiro vampiro = new CrearVampiro();
                p = vampiro.crearPersonaje(p.getNombre(), p.getListaArmas(), p.getArmasActivas(), p.getListaArmaduras(), p.getListaEsbirros(), p.getCantidadOro(), p.getPuntos(), sc);
                break;
            case 3:
                CrearLicantropo licantropo = new CrearLicantropo();
                p = licantropo.crearPersonaje(p.getNombre(), p.getListaArmas(), p.getArmasActivas(), p.getListaArmaduras(), p.getListaEsbirros(), p.getCantidadOro(), p.getPuntos(), sc);
                break;
            default:
                System.out.println("Introduce una opcion correcta");
                registrarPersonaje(sc);
                break;
        }
        crearEsbirro(sc);
        return p;
    }


    public void iniciarSesion(Scanner sc) throws IOException {

            System.out.println("Nombre de usuario");
            String nick = sc.next();
            System.out.println("Contrasena");
            String contraseña = sc.next();

            if (comprobarSesion(nick, contraseña) && !encontrarBaneado(nick)) {
                usuario = atribuirUsuario(nick,contraseña, sc);
                if (usuario != null)
                    menuPrincipal(sc);
                else{
                    menuInicio(sc);
                }
            } else if (!comprobarSesion(nick, contraseña)) {
                System.out.println("Inicio de sesion erroneo vuelva a intentarlo");
                System.out.println();
                menuInicio(sc);
            } else {
                System.out.println("Su usuario esta baneado");
                System.out.println();
                menuInicio(sc);
            }
    }

    private Usuario atribuirUsuario(String nick, String contraseña, Scanner sc) throws IOException {
        if (usuariosAceptados != null) {
            int i = 0;
            boolean registrado = false;
            while (i < usuariosAceptados.size() && !registrado) {
                registrado = usuariosAceptados.get(i).getNick().equals(nick) && usuariosAceptados.get(i).getPassword().equals(contraseña);
                i = i + 1;
            }
            if (registrado && usuariosAceptados.get(i - 1) instanceof Jugador) {
                usuario = usuariosAceptados.get(i - 1);
                p = ((Jugador) usuariosAceptados.get(i - 1)).getPersonaje();
            }
            return usuariosAceptados.get(i-1);
        } else {
            System.out.println("Error");
        }
        return usuario;
    }

    public void modEquipo(Scanner sc) throws IOException {
        System.out.println("Seleccione una opcion");
        System.out.println("1. Anadir Equipo");
        System.out.println("2. Eliminar Equipo");
        System.out.println("3. Elegir Armas Activas");
        System.out.println("4. Volver al menu principal");
        int opcion;
        do {
            opcion = sc.nextInt();
            if(opcion < 1 || opcion > 4){
                System.out.println("Introduzca una opcion valida");
            }
        } while(opcion < 1 || opcion > 4);
        switch (opcion) {
            case 1:
                añadirEquipo(sc);
                break;
            case 2:
                eliminarEquipo(sc);
                break;
            case 3:
                elegirArmasActivas(sc);
                break;
        }
    }

    private void añadirEquipo(Scanner sc) {
        ArrayList<Equipo> listaEquipo = new ArrayList<>();
        System.out.println("Seleccione el equipo que desea anadir");
        System.out.println("Armaduras:");
        int i = 1;
        for (Armadura armadura : conjuntoArmaduras) {
            if (!((Jugador) usuario).getPersonaje().getListaArmaduras().contains(armadura)) {
                System.out.println("Numero: " + i + ")");
                armadura.mostrarEquipo();
                System.out.println();
                listaEquipo.add(armadura);
                i++;
            }
        }
        System.out.println("Armas:");
        for (Arma arma : conjuntoArmas) {
            if (!((Jugador) usuario).getPersonaje().getListaArmas().contains(arma)) {
                System.out.println("Numero: " + i + ")");
                arma.mostrarEquipo();
                System.out.println();
                listaEquipo.add(arma);
                i++;
            }
        }
        int opcion;
        do {
            opcion = sc.nextInt();
        } while (opcion > listaEquipo.size() || opcion < 1 );
        Equipo e = listaEquipo.get(opcion-1);
        if (e instanceof Arma) {
            if (((Jugador) usuario).getPersonaje().getListaArmas().size() < 4) {
                ((Jugador) usuario).getPersonaje().addListaArmas((Arma) e);
            } else {
                System.out.println("No puedes anadir mas de 3 armas a tu personaje");
            }
        } else {
            if (((Jugador) usuario).getPersonaje().getListaArmaduras().size() < 4) {
                ((Jugador) usuario).getPersonaje().addListaArmaduras((Armadura) e);
            } else {
                System.out.println("No puedes anadir mas de 3 armaduras a tu personaje");
            }
        }
    }

    private void eliminarEquipo(Scanner sc) {
        ArrayList<Equipo> listaEquipo = new ArrayList<>();
        int i;
        if (((Jugador) usuario).getPersonaje().getListaArmas().isEmpty() && ((Jugador) usuario).getPersonaje().getListaArmaduras().isEmpty()) {
            System.out.println("No tienes equipo para eliminar");
        } else {
            if (!((Jugador) usuario).getPersonaje().getListaArmaduras().isEmpty()) {
                System.out.println("Armaduras:");
                i = 1;
                for (Armadura armadura : ((Jugador) usuario).getPersonaje().getListaArmaduras()) {
                    System.out.println("Numero: " + i + ")");
                    armadura.mostrarEquipo();
                    System.out.println();
                    listaEquipo.add(armadura);
                    i++;
                }
            }
            if (!((Jugador) usuario).getPersonaje().getListaArmas().isEmpty()) {
                System.out.println("Armas:");
                i = 1;
                for (Arma arma : ((Jugador) usuario).getPersonaje().getListaArmas()) {
                    System.out.println("Numero: " + i + ")");
                    arma.mostrarEquipo();
                    System.out.println();
                    listaEquipo.add(arma);
                    i++;
                }
            }
            int opcion;
            do{
                opcion = sc.nextInt();
            } while(opcion > listaEquipo.size() || opcion < 1);
            Equipo e = listaEquipo.get(opcion-1);
            if (e instanceof Arma) {
                ((Jugador) usuario).getPersonaje().removeListaArmas((Arma) e);
                if (((Jugador) usuario).getPersonaje().getArmasActivas().contains((e))) {
                    ((Jugador) usuario).getPersonaje().removeArmasActivas((Arma) e);
                }
            } else {
                ((Jugador) usuario).getPersonaje().removeListaArmaduras((Armadura) e);
            }

        }
    }

    private void elegirArmasActivas(Scanner sc) {
        if(!(((Jugador) usuario).getPersonaje().getListaArmas().isEmpty())) {
            ((Jugador) usuario).getPersonaje().getArmasActivas().clear();
            System.out.println("Elija una o dos armas activas o pulse 0 para salir");
            System.out.println();
            int i = 0;
            int opcion;
            do {
                int j = 1;
                for(Arma arma:((Jugador) usuario).getPersonaje().getListaArmas()){
                    if(!p.getArmasActivas().contains(arma)) {
                        System.out.println("Arma " + (j) + ":");
                        System.out.println();
                        arma.mostrarEquipo();
                    }
                    j+=1;
                }
                System.out.println();
                opcion = sc.nextInt();
                if(opcion <=0 || opcion > ((Jugador) usuario).getPersonaje().getListaArmas().size()){
                    if(opcion == 0){
                        System.out.println("Saliendo del menu elegir armas activas...");
                    }else {
                        System.out.println("Ese numero no es valido, porfavor escoja un numero valido para poder elegir el arma");
                        System.out.println();
                        opcion = 1;
                    }
                } else{
                    if(p.getListaArmas().size() == 1) {
                        ((Jugador) usuario).getPersonaje().addArmasActivas(((Jugador) usuario).getPersonaje().getListaArmas().get(opcion - 1));
                        System.out.println("No tienes mas armas para poder ponerlas como armas activas");

                        opcion = 0;
                    }else{
                        ((Jugador) usuario).getPersonaje().addArmasActivas((((Jugador) usuario).getPersonaje().getListaArmas().get(opcion - 1)));
                        i +=1;
                        System.out.println("Si quieres salir pulsa 0, sino, pulse 1");
                        opcion = sc.nextInt();
                    }
                }
            } while(i<2 && opcion != 0);
            if(i >= 2){
                System.out.println("Lo sentimos, no puede anadir mas de 2 armas activas");
            }
        }else{ 
            System.out.println("Este personaje no tiene armas, añada armas al personaje para poder anadirlas a las armas activas");
        }

    }

    public ArrayList<Desafío> getListaDesafiosNoValidados() {
        return listaDesafíosNoValidados;
    }

    private void inicializarArmas() {
        //armas ofensivas
        ArrayList<String> materiales1 = new ArrayList<>(Arrays.asList("Cobre", "Hierro", "Madera"));
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Acero", "Hierro"));
        ArrayList<String> materiales3 = new ArrayList<>(Arrays.asList("Diamante", "Hierro", "Madera","Oro"));
        ArrayList<String> materiales4 = new ArrayList<>(Arrays.asList("Acero", "Cuero"));
        ArrayList<String> materiales5 = new ArrayList<>(Arrays.asList("Plata", "Acero"));
        ArrayList<String> materiales6 = new ArrayList<>(Arrays.asList("Cobre"));
        ArrayList<String> materiales7 = new ArrayList<>(Arrays.asList("Cuero"));
        Arma espadaPequeña = new Arma(2, 0, 1, "Espada pequena", "Comun", materiales2);
        Arma espadon = new Arma(3, 1, 2, "Espadon", "Raro", materiales1);
        Arma sable = new Arma(3, 1, 2, "Sable", "Raro", materiales3);
        Arma bayoneta = new Arma(1, 1, 1, "Bayoneta", "Comun", materiales4);
        Arma guantesMagicos = new Arma(3, 1, 2, "Guantes Magicos", "Epico", materiales7);
        Arma varitaMagica = new Arma(2, 1, 2, "Varita Magica", "Legendario", materiales3);
        Arma hacha = new Arma(2, 1, 1, "Hacha exaltante", "Epico", materiales5);
        Arma excalibur = new Arma(1, 1, 1, "Espada Excalibur", "Legendario", materiales3);
        Arma tridente = new Arma(3,2,1,"Tridente","Epico",materiales6);

        //armas defensivas
        Arma escudoPequeño = new Arma(1, 2, 1, "Escudo Pequeño", "Comun", materiales1);
        Arma escudoGrande = new Arma(1, 3, 1, "Escudo Grande", "Raro", materiales1);
        Arma escudoPuas = new Arma(1, 1, 1, "Escudo de Puas  , (protege e  intimida.)", "Epico", materiales5);

        conjuntoArmas = new ArrayList<>(Arrays.asList(espadaPequeña, espadon, sable, bayoneta, guantesMagicos, varitaMagica, hacha, excalibur, tridente, escudoPequeño, escudoGrande, escudoPuas));

    }

    private void inicializarArmaduras() {
        //armadura
        ArrayList<String> materiales1 = new ArrayList<>(Arrays.asList("Mithril"));
        ArrayList<String> materiales2 = new ArrayList<>(Arrays.asList("Cuero"));
        ArrayList<String> materiales3 = new ArrayList<>(Arrays.asList("Hierro", "Acero", "Piel de Dragon", "Diamante"));
        ArrayList<String> materiales4 = new ArrayList<>(Arrays.asList("Diamante", "Oro"));
        ArrayList<String> materiales5 = new ArrayList<>(Arrays.asList("Beskar"));
        
        Armadura cotaMalla = new Armadura(1, 1, "Cota de malla de Mithril", "Rara", materiales1);
        Armadura armaduraBasica = new Armadura(1, 3, "Armadura Basica", "Comun", materiales2);
        Armadura armaduraBeskar = new Armadura(1, 3, "Armadura de Beskar", "Epico", materiales5);
        Armadura armaduraDragon = new Armadura(2, 2, "Armadura Dragon", "Legendaria", materiales3);
        Armadura armaduraReluciente = new Armadura(3, 3, "Armadura Reluciente", "Epico", materiales4);

        conjuntoArmaduras = new ArrayList<Armadura>(Arrays.asList(cotaMalla, armaduraBasica, armaduraBeskar, armaduraDragon, armaduraReluciente));

    }

    public void serializarSistema() throws FileNotFoundException, IOException {
        String rutaArchivo = "./info.bin";
        File f1 = new File(rutaArchivo);
        ObjectOutputStream datosSalida = new ObjectOutputStream(new FileOutputStream(f1));
        datosSalida.writeObject(this);
    }

    public Usuario getUsuario() {
        return usuario; 
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Usuario> getWhiteList() {
        return usuariosAceptados;
    }

    public void setlistaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.usuariosAceptados = listaUsuarios;
    }

    private Boolean comprobarSesion(String nick, String contraseña) {
        if (usuariosAceptados != null) {
            int i = 0;
            boolean registrado = false;
            while (i < usuariosAceptados.size() && !registrado) {
                registrado = usuariosAceptados.get(i).getNick().equals(nick) && usuariosAceptados.get(i).getPassword().equals(contraseña);
                i = i + 1;
            }
            if (registrado && usuariosAceptados.get(i - 1) instanceof Jugador) {
                usuario = usuariosAceptados.get(i - 1);
                p = ((Jugador) usuariosAceptados.get(i - 1)).getPersonaje();
            }
            return registrado;
        } else {
            return false;
        }
    }

    public void modOro(Scanner sc) {
        int cantidadOro = ((Jugador) usuario).getPersonaje().getCantidadOro();
        System.out.println("1) Sumar oro");
        System.out.println("2) Restar oro");
        int opcion;
        do {
            opcion = sc.nextInt();
        } while (opcion < 1 || opcion > 2);
        if (opcion == 1) {
            System.out.println("Indica cuánto oro quieres sumarte entre 0 y 1000");
        } else {
            System.out.println("Indica cuánto oro quieres restarte entre 0 y 1000");
        }
        int oroASumar = -1;
        while (oroASumar < 0 || oroASumar > 1000) {
            oroASumar = sc.nextInt();
            if (oroASumar < 0 || oroASumar > 1000) {
                System.out.println("Vuélvelo a intentar, introduzca un número entre 0 y 1000");
            }
        }
        if (opcion == 1) {
            cantidadOro += oroASumar;
        } else {
            cantidadOro -= oroASumar;
            if (cantidadOro < 0) {
                cantidadOro = 0;
            }
        }

        ((Jugador) usuario).getPersonaje().setCantidadOro(cantidadOro);
        System.out.println("El oro se ha modificado correctamente");
        System.out.println("Nuevo saldo: " + ((Jugador) usuario).getPersonaje().getCantidadOro());
    }

    public void menuUsuario(Scanner sc){
        int opcionMU;
        System.out.println("Bienvenido al menu de gestion de usuarios " + usuario.getNick());
        System.out.println("Elige una de las siguientes opciones");
        System.out.println("1. Banear usuario");
        System.out.println("2. Desbanear usuario");
        System.out.println("3. Volver al menu del operador");
        System.out.println(" ");
        do{
            opcionMU = sc.nextInt();
            if(opcionMU < 1 || opcionMU > 3){
                System.out.println("Introduce una opcion correcta");
            }
        } while(opcionMU < 1 || opcionMU > 3);
        switch (opcionMU) {
            case 1:
                banearUsuario(sc);
                break;
            case 2:
                desbanearUsuario(sc);
                break;
        }
    }

    public ArrayList<Usuario> getBlackList() {
        return usuariosBaneados;
    }

    private void banearUsuario(Scanner sc) {
        if (!usuariosAceptados.isEmpty()) {
            System.out.println("¿Qué usuario quieres banear?");
            int i = 0;
            for (Usuario user : usuariosAceptados) {
                System.out.println(i + ") " + user.getNick());
                i += 1;
            }
            int opcion = -1;
            i -= 1;
            while (opcion < 0 || opcion > i) {
                opcion = sc.nextInt();
            }

            Usuario user = usuariosAceptados.get(opcion);
            usuariosAceptados.remove(user);
            usuariosBaneados.add(user);
        } else {
            System.out.println("No hay jugadores para banear");
        }
    }

    private void desbanearUsuario(Scanner sc) {
        if (!usuariosBaneados.isEmpty()) {
            System.out.println("¿Qué usuario quieres desbanear?");
            int i = 0;
            for (Usuario user : usuariosBaneados) {
                System.out.println(i + ") " + ((Jugador) user).getNick());
                i += 1;
            }
            i -= 1;
            int opcion = -1;
            while (opcion < 0 || opcion > i) {
                opcion = sc.nextInt();
            }

            Usuario user = usuariosBaneados.get(opcion);
            usuariosBaneados.remove(user);
            usuariosAceptados.add(user);
        } else {
            System.out.println("No hay jugadores baneados");
        }
    }

    public void consultarVentas() {
        if (!listaLogs.isEmpty()) {
            int i = 0;
            for (DesafíoGen log : listaLogs) {
                System.out.println(i + ") ");
                log.imprimirLog();
                i += 1;
            }
        } else {
            System.out.println("No tuvo lugar ninguna venta");
        }
    }

    public void crearDesafío(Scanner sc) {
        ArrayList<Equipo> listaEquipo = new ArrayList<>();
        int opcion = -1;
        int opcion2 = -1;
        String nick;
        while (opcion < 2 ) {
            do{
            System.out.println("Introduzca el usuario a quien quiere desafíar o escriba SALIR para volver ");
            nick = sc.next();
            }while (!encontrarNick(nick))  ;
            if (encontrarNick(nick)){
               System.out.println("1)Elegir cantidad de oro ");
               System.out.println("2)Cancelar desafio");
               opcion=sc.nextInt();
               
            }else{
                menuDesafio(sc);
            }    
            switch (opcion) { 
                case 1:
                    if ((((Jugador)usuario).getPersonaje().getCantidadOro()) == 0){
                        System.out.println("No se puede apostar oro");
                    } else {
                        int oroApostado;
                        System.out.println("Cuanto oro quieres apostar");
                        oroApostado = sc.nextInt();
                        Desafío desafío = new Desafío(listaEquipo, oroApostado, usuario);
                        listaDesafíosNoValidados.add(desafío);
                        
                    }
                    break;
                case 2:
                    System.out.println("Volviendo al menu de desafios");
            }break;
        }
                    
    }
    public void validarDesafío(Scanner sc) {
        if (listaDesafíosNoValidados.isEmpty()) {
            System.out.println("No hay desafios para validar.");
        } else {
            int opcion;
            do {
                System.out.println("1) Validar desafios");
                System.out.println("2) Salir");
                do {
                    opcion = sc.nextInt();
                    sc.nextLine();
                } while (opcion < 1 || opcion > 2);
                if (opcion != 2) {
                    int i = 0;
                    System.out.println("Elija un desafio para validar: ");
                    for (Desafío desafío : listaDesafíosNoValidados) {
                        System.out.println(i + ") ");
                        desafío.mostrarDesafío();
                        i++;
                    }
                    i--;
                    int opcion2;
                    do {
                        opcion2 = sc.nextInt();
                        sc.nextLine();
                    } while (opcion2 < 0 || opcion2 > i);
                    System.out.println("Desea validar el desafio?");
                    System.out.println("0) Si");
                    System.out.println("1) No");
                    int opcion3;
                    do{
                        opcion3 = sc.nextInt();
                    } while(opcion3 != 0 && opcion3 != 1);
                    if (opcion3 == 0){
                        Desafío desafío = listaDesafíosNoValidados.remove(opcion2);
                        listaDesafíos.add(desafío);
                        notificarDesafíos(desafío);
                        System.out.println("El desafio ha sido validada");
                    } else{
                        Desafío desafío = listaDesafíosNoValidados.remove(opcion2);
                        int oroDevuelto = desafío.getPrecio();
                        int oroPersonaje2 = (((Jugador)usuario).getPersonaje().getCantidadOro()) ;
                        int oroRestante2 = oroPersonaje2 - oroDevuelto;
                        oroRestante2 = (((Jugador)usuario).getPersonaje().getCantidadOro());
                        System.out.println("El oro apostado fue devuelto");
                    }
                }
            } while (opcion != 2 && !listaDesafíosNoValidados.isEmpty());
            if (listaDesafíosNoValidados.isEmpty()) {
                System.out.println("No hay mas desafios para validar.");
            }
        }
    }

    private Boolean encontrarNick(String nick) {
        if (usuariosAceptados != null && usuariosBaneados != null) {
            int i = 0;
            boolean encontrado = false;
            while (i < usuariosAceptados.size() && !encontrado) {
                encontrado = usuariosAceptados.get(i).getNick().equals(nick);
                i = i + 1;
            }
            i = 0;
            while (i < usuariosBaneados.size() && !encontrado) {
                encontrado = usuariosBaneados.get(i).getNick().equals(nick);
                i = i + 1;
            }
            return encontrado;
        } else {
            return false;
        }
   }

    private Boolean encontrarBaneado(String nick) {
        if (!usuariosBaneados.isEmpty()) {
            int i = 0;
            boolean encontrado = false;
            while (i < usuariosBaneados.size() && !encontrado) {
                encontrado = usuariosBaneados.get(i).getNick().equals(nick);
                i = i + 1;
            }
            return encontrado;
        } else {
            return false;
        }
    }

    private Boolean encontrarNumReg(String numReg) {
        if (usuariosAceptados != null) {
            int i = 0;
            boolean encontrado = false;
            while (i < usuariosAceptados.size() && !encontrado) {
                if (usuariosAceptados.get(i) instanceof Jugador) {
                    Jugador user = (Jugador) usuariosAceptados.get(i);
                    encontrado = user.getNumRegistro().equals(numReg);

                }
                i++;
            }
            i = 0;
            while (i < usuariosBaneados.size() && !encontrado) {
                Jugador user2 = (Jugador) usuariosBaneados.get(i);
                encontrado = user2.getNumRegistro().equals(numReg);
                i = i + 1;
            }
            return encontrado;
        } else {
            return false;
        }
    }

    private String calcularNumRegistro() {
        Random rd = new Random();
        String numero;
        do {
            numero = new String();
            char n = (char) (rd.nextInt(26) + 'a');
            String caracter = String.valueOf(n);
            numero = numero.concat(caracter);
            for (int i = 0; i < 2; i++) {
                n = (char) (rd.nextInt(9) + '0');
                caracter = String.valueOf(n);
                numero = numero.concat(caracter);
            }
            for (int i = 0; i < 2; i++) {
                n = (char) ((char) rd.nextInt(26) + 'a');
                caracter = String.valueOf(n);
                numero = numero.concat(caracter);
            }
        } while (encontrarNumReg(numero));
        return numero;
    }

    public ArrayList<Desafío> getListaDesafios() {
        return listaDesafíos;
    }

    private void notificarDesafíos(Desafío desafío) {
        Jugador jugador = (Jugador) desafío.getUsuarioDesafiante();

        for (Notificador notificador : listaNotificadores) {
            String filtro = notificador.getFiltro();
            if(filtro.startsWith("Min: ")) {
                String[] parts = filtro.split("\n");
                parts[0] = parts[0].replace("Min: ", "");
                parts[1] = parts[1].replace("Max: ", "");
                parts[0] = parts[0].replace(" oro \n", "");
                parts[1] = parts[1].replace(" oro", "");
                int min = Integer.parseInt(parts[0]);
                int max = Integer.parseInt(parts[1]);
            }
            boolean notificar = false;
            int max = -1,min = -1;
            if (!desafío.getListaEquipo().isEmpty()) {
                boolean hayArma = false, hayArmadura = false;
                for (Equipo equipo : desafío.getListaEquipo()) {
                    if (filtro.contains(equipo.getCategoria())) {
                        notificar = true;
                    }
                    if (equipo instanceof Arma) {
                        hayArma = true;
                    } else {
                        hayArmadura = true;
                    }
                }
                if (filtro.contains("Armas") && hayArma) {
                    notificar = true;
                } else if (filtro.contains("Armaduras") && hayArmadura) {
                    notificar = true;
                }
            } else if (desafío.getPrecio() <= max && desafío.getPrecio() >= min) {
                notificar = true;
            } else if (filtro.contains(jugador.getPersonaje().getClass().getName())) {
                notificar = true;
            }
            if (notificar) {
                notificador.añadirDesafío(desafío);
                notificador.notificar();
            }
        }
    }

    //MÉTODOS PARA TESTING

    public ArrayList<Notificador> getListaNotificadores() {
        return listaNotificadores;
    }

    public ArrayList<DesafíoGen> getListaLogs() {
        return listaLogs;
    } 

    public ArrayList<Arma> getConjuntoArmas() {
        return conjuntoArmas;
    }

    public ArrayList<Armadura> getConjuntoArmaduras() {
        return conjuntoArmaduras;
    }
}

    
