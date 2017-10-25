import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class Main {

    final static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Mundo miMundo = new Mundo();

        Usuario u;
        Objeto o;
        ArrayList<Objeto> lobj = new ArrayList<>();
        ArrayList<Objeto> lobj2 = new ArrayList<>();
        List<Objeto> list_obj;
        String usu, origen, destino, nom_obj, n, p, nobj, t, des;
        int niv, a, d, r, v, c;
        boolean b;

        int m;
        String NL = System.lineSeparator();
        Scanner input;




        // Inicialmente, se añaden 2 usuarios con 1 objeto cada uno.
        u = new Usuario("pol", "1234", 10, 20, 30, 40, lobj);
        o = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);
        u.list_obj.add(o);
        miMundo.Map.put(u.nombre, u);
        miMundo.crearUsuario(u);
        u = new Usuario("marc", "marc_pass", 50, 60, 70, 80, lobj2);
        o = new Objeto("puñal", "asesinato", "puñal para asesinar a los enemigos", 300, 150);
        u.list_obj.add(o);
        miMundo.Map.put(u.nombre, u);
        miMundo.crearUsuario(u);



        log.info("MENÚ: Escribe la operación que quieras realizar:" + NL + "1 -> Crear un nuevo Usuario."+ NL + "2 -> Crear un nuevo Objeto al Usuario."+ NL + "3 -> Consultar un Usuario."+ NL + "4 -> Consultar la lista de objetos de un Usuario."+ NL + "5 -> Consultar un objeto de un Usuario."+ NL + "6 -> Transferir un objeto entre dos Usuarios."+ NL + "7 -> Eliminar un Usuario."+ NL + "8 -> Eliminar un Objeto."+ NL + "9 -> Salir.");
        input = new Scanner(System.in);
        m = input.nextInt();

        // CREAR USUARIO.
        if(m == 1) {
            try{
                log.info("introduce nombre de usuario, contraseña, nivel, ataque, defensa y resistencia: (separados por ENTER)");
                input = new Scanner(System.in);
                n = input.nextLine();
                p = input.nextLine();
                niv = input.nextInt();
                a = input.nextInt();
                d = input.nextInt();
                r = input.nextInt();
                lobj = new ArrayList<>();    // ArrayList que se se guardaran los objetos de cada jugador.

                log.info("Introduce el objeto: nombre, tipo, descripción, valor y coste: (separados por ENTER)");
                Scanner input4 = new Scanner(System.in);
                nobj = input4.nextLine();
                t = input4.nextLine();
                des = input4.nextLine();
                v = input4.nextInt();
                c = input4.nextInt();
                o = new Objeto (nobj, t, des, v, c);
                lobj.add(o);

                u = new Usuario(n, p, niv, a, d, r, lobj);

                b = miMundo.crearUsuario(u);

            } catch (Exception e){
                log.fatal(e.getMessage());
            }

        }


        // 2 - AÑADIR OBJETO AL USUARIO.
        if (m == 2) {
            try{
                log.info("Introduce el nombre de usuario para añadir el objeto:");
                input = new Scanner(System.in);
                usu = input.nextLine();

                log.info("Introduce el objeto: nombre, tipo, descripción, valor y coste: (separados por ENTER)");
                Scanner input4 = new Scanner(System.in);
                nobj = input4.nextLine();
                t = input4.nextLine();
                des = input4.nextLine();
                v = input4.nextInt();
                c = input4.nextInt();
                o = new Objeto(nobj, t, des, v, c);

                miMundo.Map.get(usu).list_obj.add(o);

            } catch (Exception e) {
                log.fatal(e.getMessage());
            }
        }


        // 3 - CONSULTAR UN USUARIO.
        if (m == 3){
            log.info("Introduce el nombre de usuario para consultar:");
            input = new Scanner(System.in);
            usu = input.nextLine();
            u = miMundo.consultarUsuario(usu);
        }


        // 4 - CONSULTAR LISTA OBJETOS USUARIO.
        if (m == 4){
            log.info("Introduce el nombre de usuario para consultar la lista de objetos:");
            input = new Scanner(System.in);
            usu = input.nextLine();
            list_obj = miMundo.consultarObjetosDeUsuario(usu);

        }


        // 5 - CONSULTAR OBJETO DE USUARIO.
        if (m == 5){
            log.info("Introduce el nombre de usuario y nombre del objeto a consultar: (Separados por Enter)");
            input = new Scanner(System.in);
            usu = input.nextLine();
            nom_obj = input.nextLine();
            o = miMundo.consultarObjetoDeUsuario(usu, nom_obj);

        }


        // 6 - TRANSFERIR OBJETO ENTRE USUARIOS.
        if (m == 6){
            log.info("Introduce el usuario origen, usuario destino y objeto a transferir: (Separados por Enter)");
            input = new Scanner(System.in);
            origen = input.nextLine();
            destino = input.nextLine();
            nom_obj = input.nextLine();
            try{
                miMundo.transferirObjetoEntreUsuarios(origen, destino, nom_obj);
            } catch (Exception e){
                log.fatal(e.getMessage());
            }

        }


        // 7 - ELIMINAR USUARIO.
        if (m == 7){
            log.info("Introduce el nombre de usuario a eliminar: (Separados por Enter)");
            input = new Scanner(System.in);
            usu = input.nextLine();
            b = miMundo.eliminarUsuario(usu);

        }


        // 8 - ELIMINAR OBJETO.
        if (m == 8){
            log.info("Introduce el usuario del que quieras eliminar un objeto: (Separados por Enter)");
            input = new Scanner(System.in);
            usu = input.nextLine();
            b = miMundo.eliminarObjetosDeUsuario(usu);

        }





    }
}
