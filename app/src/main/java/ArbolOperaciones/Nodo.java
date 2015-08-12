package ArbolOperaciones;

/**
 * Created by Camilo P on 12/08/2015.
 */
public class Nodo {
    private Nodo derecho;
    private Nodo izquierdo;
    private String contenido;

    public Nodo(String string){
        derecho = null;
        izquierdo = null;
        contenido = string;
    }

    public boolean esHoja(){
        return (derecho==null) && (izquierdo==null);
    }

    public void agregarNodo(String string){
        if (derecho!=null) {
            if (derecho.esHoja()) {
                Nodo nuevo = new Nodo(string);
                nuevo.izquierdo = derecho;
                derecho = nuevo;
            }else if(derecho.contenido.equals("*") || derecho.contenido.equals("/")){
                Nodo nuevo = new Nodo(string);
                nuevo.izquierdo = derecho;
                derecho = nuevo;
            }else{
                derecho.agregarNodo(string);
            }
        }
    }

    public void agregarNodoNum(String string){
        if (derecho==null) {
            derecho = new Nodo(string);
        }else{
            derecho.agregarNodoNum(string);
        }
    }

    public void operar(){
        if (esHoja()) {
            return;
        }
        if (esNumero(derecho.contenido) && esNumero(izquierdo.contenido)) {
            double num1 = Double.parseDouble(izquierdo.contenido);
            double num2 = Double.parseDouble(derecho.contenido);
            switch (contenido) {
                case "*":
                    contenido = (num1*num2)+"";
                    break;

                case "/":
                    contenido = (num1/num2)+"";
                    break;

                case "+":
                    contenido = (num1+num2)+"";
                    break;

                case "-":
                    contenido = (num1-num2)+"";
                    break;
            }
            derecho = null;
            izquierdo = null;
        }else{
            izquierdo.operar();
            derecho.operar();
            operar();
        }
    }

    public boolean esNumero(String valor){
        if (valor.equals("+") || valor.equals("-") || valor.equals("/") || valor.equals("*")) {
            return false;
        }else{
            return true;
        }
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
