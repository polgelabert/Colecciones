public class Objeto {

    public String nombreObjeto;
    public String tipoObjeto;
    public String descripcionObjeto;
    public int valorObjeto;
    public int costeObjeto;

    public Objeto (String nombreObjeto, String tipoObjeto, String descripcionObjeto, int valorObjeto, int costeObjeto){
        this.nombreObjeto = nombreObjeto;
        this.tipoObjeto = tipoObjeto;
        this.descripcionObjeto = descripcionObjeto;
        this.valorObjeto = valorObjeto;
        this.costeObjeto = costeObjeto;
    }


    public boolean objetoEsIgual(Objeto o) {

        boolean resp = false;

        if (o.nombreObjeto == this.nombreObjeto && o.tipoObjeto == this.tipoObjeto && o.descripcionObjeto == this.descripcionObjeto && o.valorObjeto == this.valorObjeto && o.costeObjeto == this.costeObjeto) {
            resp = true;
        }

        return resp;
    }



}
