import java.util.HashMap;
import java.util.List;


//public class Mundo implements IMundo{
public class Mundo{

    HashMap<String,Usuario> map = new HashMap<>();
    List<Objeto> list_obj_cons;



    public boolean crearUsuario(Usuario u){

        map.put(u.nombre, u);
        return true;
    }

    public void añadirObjetoAUsuario (String nombre, Objeto objeto) throws Exception.UsuarioNoExisteException {

        // map.get(u).listaObjetos.add(o);
        Usuario usuario = map.get(nombre);

        if (usuario == null) throw new Exception.UsuarioNoExisteException();
        usuario.insertarObjeto(objeto);

    }

    public Usuario consultarUsuario (String nombre) throws Exception.UsuarioNoExisteException {

        Usuario usuario = getUser(nombre);
        if( usuario == null) throw new Exception.UsuarioNoExisteException();
        return usuario;
    }



    /**
     * retorna un objeto asociado a un usuario. En caso que el usuario no exista, se retornará un null,
     * @param nombre
     * @param nombreObjeto
     * @return
     * //@throws lanza una excepcion en caso que ...
     */
    public Objeto consultarObjetoDeUsuario(String nombre, String nombreObjeto) throws Exception.UsuarioNoExisteException, Exception.UsuarioSinObjetosException, Exception.ObjetoNoEncontradoException {


        Usuario usuario = getUser(nombre);
        Objeto objeto = usuario.getObjeto(nombreObjeto);
        return objeto;

    }

    /**
     * @param nombre nombre del usuario
     * @return la lista de objetos de un usuario.
     * @throws Exception.ListaObjetosVaciaException
     * @throws Exception.UsuarioNoExisteException
     */
    public List<Objeto> consultarObjetosDeUsuario (String nombre) throws Exception.ListaObjetosVaciaException, Exception.UsuarioNoExisteException {

        Usuario usuario = getUser(nombre);
        List<Objeto> listaObjetos = usuario.getListaObjetos(nombre);
        if (listaObjetos == null) throw new Exception.ListaObjetosVaciaException();
        return listaObjetos;
        //return  map.get(nombre).listaObjetos;
    }

    public boolean eliminarUsuario (String nombre) throws Exception.UsuarioNoExisteException {

        Usuario usuario = getUser(nombre);
        removeUser(usuario);

        //map.remove(nombre);
        return true;
    }

    public boolean eliminarObjetosDeUsuario(String nombre) throws Exception.UsuarioNoExisteException, Exception.UsuarioSinObjetosException {

        Usuario usuario = getUser(nombre);
        removeObject(usuario);
        return true;

        /*
            if(map.get(nombre).listaObjetos.size() > 0){
            map.get(nombre).listaObjetos.remove(0);
            return true;
            } else {
            return false;
            }
        */
    }

    public void transferirObjetoEntreUsuarios (String origen, String destino, String nom_obj) throws Exception.UsuarioNoExisteException, Exception.UsuarioSinObjetosException, Exception.ObjetoNoEncontradoException {

        Objeto objeto = consultarObjetoDeUsuario(origen, nom_obj);
        Usuario dest = getUser(destino);
        dest.listaObjetos.add(objeto);
        Usuario orig = getUser(origen);
        orig.listaObjetos.remove(objeto);
    }

    private Usuario getUser(String nombre) throws Exception.UsuarioNoExisteException {

        if (map.get(nombre) == null) throw new Exception.UsuarioNoExisteException();
        return map.get(nombre);
    }

    private void removeUser(Usuario usuario) {

        map.remove(usuario.nombre, usuario);
    }

    private void removeObject(Usuario usuario) throws Exception.UsuarioSinObjetosException {

        if(usuario.listaObjetos.size() == 0) throw new Exception.UsuarioSinObjetosException();
        usuario.listaObjetos.remove(0);
    }

















}
