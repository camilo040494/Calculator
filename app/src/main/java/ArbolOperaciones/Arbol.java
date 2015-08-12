package ArbolOperaciones;

/**
 * Created by Camilo P on 12/08/2015.
 */
public class Arbol {
    private Nodo raiz;

    public Arbol(){
        raiz = null;
    }

    public void agregar(String string){
        if (raiz==null) {
            raiz = new Nodo(string);
        }else{
            if (string.equals("+") || string.equals("-")) {
                Nodo nodoNuevo = new Nodo(string);
                nodoNuevo.setIzquierdo(raiz);
                raiz = nodoNuevo;
            }else if (string.equals("/") || string.equals("*")){
                if (raiz.esHoja()) {
                    Nodo nuevo = new Nodo(string);
                    nuevo.setIzquierdo(raiz);
                    raiz = nuevo;
                }else if (raiz.getContenido().equals("*") || raiz.getContenido().equals("/")) {
                    Nodo nuevo = new Nodo(string);
                    nuevo.setIzquierdo(raiz);
                    raiz = nuevo;
                }{
                    raiz.agregarNodo(string);
                }
            }else{
                raiz.agregarNodoNum(string);
            }
        }
    }

    public void operar() throws Exception{
        raiz.operar();
    }

    public String darValorRaiz(){
        return raiz.getContenido();
    }
}
