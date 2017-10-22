import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class Main2 {

    final static Logger log = Logger.getLogger(Main2.class.getName());


    public static void main(String[] args) {

        org.apache.log4j.BasicConfigurator.configure();
        Mundo2 miMundo = new Mundo2();

        String NL = System.lineSeparator();     // Enter en System.out.println()
        ArrayList<Usuario> list_usu = new ArrayList<Usuario>();    // Instancia ArrayList que se se guardaran los Usuarios.
        Usuario usu_consultado;




       // Inicialmente, se añaden 2 usuarios con 1 objeto cada uno.
        list_usu = miMundo.UsuarioInicial(list_usu);


        // AÑADIR OBJETO A USUARIO.
        log.info("AÑADIR USUARIO. Escribe el usuario para AÑADIR un objeto nuevo: ");
        Scanner input = new Scanner(System.in);
        String usu = input.nextLine();
        miMundo.añadirObjetoAUsuario(list_usu, usu);


        // CONSULTAR USUARIO.
        log.info("Para CONSULTAR usuario, especifique el nombre: ");
        input = new Scanner(System.in);
        usu = input.nextLine();
        usu_consultado = miMundo.consultarUsuario(list_usu, usu);


        // CONSULTAR OBJETO DE 1 USUARIO CONCRETO.
        log.info("CONSULTAR OBJETO DE 1 USUARIO. Escriba el USUARIO y el OBJETO a consultar: (Separados por ENTER)");
        Scanner input5 = new Scanner(System.in);
        usu = input5.nextLine();
        String nom_obj = input.nextLine();
        Objeto obj = miMundo.consultarObjetoDeUsuario(list_usu, usu, nom_obj);


        // CONSULTAR OBJETOS DE 1 USUARIO CONCRETO.
        log.info("Para CONSULTAR OBJETOS de un USUARIO, especifique el nombre: ");
        input = new Scanner(System.in);
        usu = input.nextLine();
        List<Objeto> lobj_consult = miMundo.consultarObjetosDeUsuario(list_usu, usu);


        // TRANSFERIR 1 OBJETO ENTRE URUARIOS.
        log.info("TRANSFERIR OBJETO ENTRE USUARIOS. Escriba el USUARIO ORÍGEN, USUARIO DESTINO y el OBJETO a transferir: (Separados por ENTER)");
        input = new Scanner(System.in);
        String orig = input.nextLine();
        String dest = input.nextLine();
        nom_obj = input.nextLine();
        miMundo.transferirObjetoEntreUsuarios(list_usu, orig, dest, nom_obj);


        // ELIMINAR OBJETO de un Usuario.
        log.info("ELMINAR OBJETO. Escribe el USUARIO y el OBJETO a eliminar:");
        Scanner input6 = new Scanner(System.in);
        usu = input6.nextLine();
        nom_obj = input6.nextLine();
        boolean resu = miMundo.eliminarObjetosDeUsuario(list_usu, usu, nom_obj);


        // ELIMINAR USUARIO
        log.info("Escribe el usuario a ELIMINAR: ");
        Scanner input7 = new Scanner(System.in);
        usu = input7.nextLine();
        boolean res = miMundo.eliminarUsuario(list_usu, usu);


        // Muestra todos los usuarios y sus objetos.
        for (int j=0; j < list_usu.size(); j++){
            log.info("----------------");
            log.info("Nombre jugador: " + list_usu.get(j).nombre + NL + "Contraseña: " + list_usu.get(j).password + NL + "Nivel: " + list_usu.get(j).nivel + NL + "Ataque: " + list_usu.get(j).ataque + NL + "Defensa: " + list_usu.get(j).defensa + NL + "Resistencia: " + list_usu.get(j).resistencia + NL + "........................");
            int l  = 0;     // Contador de objetos.
            for (int k = 0; k < list_usu.get(j).list_obj.size(); k++){
                log.info("Nombre objeto " + ++l + ": " + list_usu.get(j).list_obj.get(k).nombreobj + NL + "Tipo obj: " + list_usu.get(j).list_obj.get(k).tipo + NL + "Descripción obj: " + list_usu.get(j).list_obj.get(k).descripcion + NL + "Valor obj: " + list_usu.get(j).list_obj.get(k).valor + NL + "Coste obj: " + list_usu.get(j).list_obj.get(k).coste + NL + "........................");
            }
        }




    }

}
