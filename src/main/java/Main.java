import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class Main {

    final static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Mundo miMundo = new Mundo();

        Usuario u, usuario;
        Objeto o, objeto;
        ArrayList<Objeto> listaObjetos = new ArrayList<>();
        ArrayList<Objeto> lobj2 = new ArrayList<>();
        List<Objeto> listaObjetosReturned;
        String origen, destino, nombreObjeto, nombre, password, tipoObjeto, descripcionObjeto;
        int nivel, ataque, defensa, resistencia, valorObjeto, costeObjeto;
        boolean b;

        int m;
        String NL = System.lineSeparator();
        Scanner input;




        // Inicialmente, se añaden 2 usuarios con 1 objeto cada uno.
        try {
            u = new Usuario("pol", "1234", 10, 20, 30, 40);
            o = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);
            u.listaObjetos.add(o);
            miMundo.crearUsuario(u);
            u = new Usuario("marc", "marc_pass", 50, 60, 70, 80);
            o = new Objeto("puñal", "asesinato", "puñal para asesinar a los enemigos", 300, 150);
            u.listaObjetos.add(o);
            miMundo.crearUsuario(u);

        } catch (Exception e){
            log.fatal(e.getMessage() + e.getCause());
            e.printStackTrace();
        }




        log.info("MENÚ: Escribe la operación que quieras realizar:" + NL + "1 -> Crear un nuevo Usuario."+ NL + "2 -> Crear un nuevo Objeto al Usuario."+ NL + "3 -> Consultar un Usuario."+ NL + "4 -> Consultar la lista de objetos de un Usuario."+ NL + "5 -> Consultar un objeto de un Usuario."+ NL + "6 -> Transferir un objeto entre dos Usuarios."+ NL + "7 -> Eliminar un Usuario."+ NL + "8 -> Eliminar un Objeto."+ NL + "9 -> Salir.");
        input = new Scanner(System.in);
        m = input.nextInt();

        // CREAR USUARIO.
        if(m == 1) {
            try {
                log.info("introduce nombre de usuario, contraseña, nivel, ataque, defensa y resistencia: (separados por ENTER)");
                input = new Scanner(System.in);
                nombre = input.nextLine();
                if (miMundo.consultarUsuario(nombre) != null) throw new Exceptions.UsuarioYaExisteException();
                password = input.nextLine();
                nivel = input.nextInt();
                ataque = input.nextInt();
                defensa = input.nextInt();
                resistencia = input.nextInt();
                listaObjetos = new ArrayList<>();    // ArrayList que se se guardaran los objetos de cada jugador.

                log.info("Introduce el objeto: nombre, tipoObjeto, descripción, valorObjeto y costeObjeto: (separados por ENTER)");
                Scanner input4 = new Scanner(System.in);
                nombreObjeto = input4.nextLine();
                tipoObjeto = input4.nextLine();
                descripcionObjeto = input4.nextLine();
                valorObjeto = input4.nextInt();
                costeObjeto = input4.nextInt();
                o = new Objeto (nombreObjeto, tipoObjeto, descripcionObjeto, valorObjeto, costeObjeto);
                listaObjetos.add(o);

                u = new Usuario(nombre, password, nivel, ataque, defensa, resistencia, listaObjetos);

                b = miMundo.crearUsuario(u);

            } catch (Exception e){
                log.fatal(e.getMessage() + e.getCause());
                e.printStackTrace();
            }

        }


        // 2 - AÑADIR OBJETO AL USUARIO.
        if (m == 2) {
            try{
                log.info("Introduce el nombre de usuario para añadir el objeto:");
                input = new Scanner(System.in);
                nombre = input.nextLine();
                if( miMundo.consultarUsuario(nombre) == null) throw new Exceptions.UsuarioNoExisteException();

                log.info("Introduce el objeto: nombre, tipoObjeto, descripción, valorObjeto y costeObjeto: (separados por ENTER)");
                Scanner input4 = new Scanner(System.in);
                nombreObjeto = input4.nextLine();
                tipoObjeto = input4.nextLine();
                descripcionObjeto = input4.nextLine();
                valorObjeto = input4.nextInt();
                costeObjeto = input4.nextInt();
                objeto = new Objeto(nombreObjeto, tipoObjeto, descripcionObjeto, valorObjeto, costeObjeto);

               // miMundo.map.get(nombre).listaObjetos.add(o);
                miMundo.añadirObjetoAUsuario(nombre, objeto);

            } catch (Exception e) {
                log.fatal(e.getMessage() + e.getCause());
                e.printStackTrace();
            }
        }


        // 3 - CONSULTAR UN USUARIO.
        if (m == 3){
            try {
                log.info("Introduce el nombre de usuario para consultar:");
                input = new Scanner(System.in);
                nombre = input.nextLine();
                usuario = miMundo.consultarUsuario(nombre);

            } catch (Exception e) {
                log.fatal(e.getMessage() + e.getCause());
                e.printStackTrace();
            }

        }


        // 4 - CONSULTAR LISTA OBJETOS USUARIO.
        if (m == 4){
            try {
                log.info("Introduce el nombre de usuario para consultar la lista de objetos:");
                input = new Scanner(System.in);
                nombre = input.nextLine();
                listaObjetosReturned = miMundo.consultarObjetosDeUsuario(nombre);

            } catch (Exception e) {
                log.fatal(e.getMessage() + e.getCause());
                e.printStackTrace();
            }
        }


        // 5 - CONSULTAR OBJETO DE USUARIO.
        if (m == 5){
            try {
                log.info("Introduce el nombre de usuario y nombre del objeto a consultar: (Separados por Enter)");
                input = new Scanner(System.in);
                nombre = input.nextLine();
                nombreObjeto = input.nextLine();
                objeto = miMundo.consultarObjetoDeUsuario(nombre, nombreObjeto);


            } catch (Exception e) {
                log.fatal(e.getMessage() + e.getCause());
                e.printStackTrace();
            }


        }


        // 6 - TRANSFERIR OBJETO ENTRE USUARIOS.
        if (m == 6){
            try{
                log.info("Introduce el usuario origen, usuario destino y objeto a transferir: (Separados por Enter)");
                input = new Scanner(System.in);
                origen = input.nextLine();
                destino = input.nextLine();
                nombreObjeto = input.nextLine();
                miMundo.transferirObjetoEntreUsuarios(origen, destino, nombreObjeto);

            } catch (Exception e) {
                log.fatal(e.getMessage() + e.getCause());
                e.printStackTrace();
            }

        }


        // 7 - ELIMINAR USUARIO.
        if (m == 7){
            try {
                log.info("Introduce el nombre de usuario a eliminar: (Separados por Enter)");
                input = new Scanner(System.in);
                nombre = input.nextLine();
                b = miMundo.eliminarUsuario(nombre);

            } catch (Exception e) {
                log.fatal(e.getMessage() + e.getCause());
                e.printStackTrace();
            }
        }


        // 8 - ELIMINAR OBJETO.
        if (m == 8){
            try {
                log.info("Introduce el usuario del que quieras eliminar un objeto:");
                input = new Scanner(System.in);
                nombre = input.nextLine();
                b = miMundo.eliminarObjetosDeUsuario(nombre);

            } catch (Exception e) {
                log.fatal(e.getMessage() + e.getCause());
                e.printStackTrace();
            }

        }




    }
}
