/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizmassimo;

/**
 *
 * @author massimo
 */
public class Pila {
     // Inicio
    private Nodo inicio;
    //Tamaño
    private int tamanio;

    //constructor
    public void Pila() {
        inicio = null;
        tamanio = 0;
    }

    //Consulta si es vacia o no
    public boolean esVacia() {
        return inicio == null;
    }

    //Devuelve el numero de elementos de la lista
    public int getTamanio() {
        return tamanio;
    }

    //Agrega un nodo a la pila 
    public void apilar(int valor) {
        
        Nodo nuevo = new Nodo();
        
        nuevo.setValor(valor);
        
        if (esVacia()) {
           
            inicio = nuevo;
        } 
        else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        
        tamanio++;
    }

    //Quita un nodo de la pila
    public void retirar() {
        if (!esVacia()) {
            
            inicio = inicio.getSiguiente();
            
            tamanio--;
        }
    }

    //COnsulta el valor del nodo en el tope
    public int tope() throws Exception {
        if (!esVacia()) {
            return inicio.getValor();
        } else {
            throw new Exception("");
        }
    }

    //Busca un nodo mediante su valor de referencia
    public boolean buscar(int referencia) {
        
        Nodo aux = inicio;
        
        boolean existe = false;
        
        
        while (existe != true && aux != null) {
            
            if (referencia == aux.getValor()) {
                
                existe = true;
            } else {
                
                aux = aux.getSiguiente();
            }
        }
        
        return existe;
    }

    //Elimina un valor por su valor de referencia
    public void remover(int referencia) {
        
        if (buscar(referencia)) {
           
            Nodo pilaAux = null;
            
            while (referencia != inicio.getValor()) {
                
                Nodo temp = new Nodo();
               
                temp.setValor(inicio.getValor());
                
                if (pilaAux == null) {
                   
                    pilaAux = temp;
                } 
                else {
                    temp.setSiguiente(pilaAux);
                    pilaAux = temp;
                }
               
                retirar();
            }
           
            retirar();
            
           
            while (pilaAux != null) {
               
               
                apilar(pilaAux.getValor());
                
                pilaAux = pilaAux.getSiguiente();
            }
            
            pilaAux = null;
        }
    }

    //Actualiza un valor en la pila con su valor de referencia y el valor nuevo
    public void editar(int referencia, int valor) {
        
        if (buscar(referencia)) {
          
            Nodo pilaAux = null;
           
            while (referencia != inicio.getValor()) {
             
                Nodo temp = new Nodo();
               
                temp.setValor(inicio.getValor());
               
                if (pilaAux == null) {
                  
                    pilaAux = temp;
                }
                else {
                    temp.setSiguiente(pilaAux);
                    pilaAux = temp;
                }
              
                retirar();
            }
            
            inicio.setValor(valor);
           
            while (pilaAux != null) {
               
                apilar(pilaAux.getValor());
                
                pilaAux = pilaAux.getSiguiente();
            }
            
            pilaAux = null;
        }
    }

    //Elimina la pila
    public void eliminar() {
        
        inicio = null;
        
        tamanio = 0;
    }

    //Imprime en consola los elementos de la lista
    public void imprimir() {
        
        Nodo aux = inicio;
        
        while (aux != null) {
            System.out.println("(\t" + aux.getValor() + "\t)");
            System.out.println("-----------------");
            aux = aux.getSiguiente();
        }
    }

    public Pila reverse() throws Exception {
        Pila pilita = new Pila();
        int Size = this.tamanio;

        for (int i = 0; i < Size; i++) {
            pilita.apilar(this.tope());
            this.retirar();

        }

//        Nodo nodo = this.inicio;
//        
//        this.retirar();
//        if(nodo!=null){
//            this.reverse();
//            this.apilar(nodo.getValor());
//        }
        return pilita;
    }

    public void Copiar(Pila origen, Pila copia) throws Exception {

        int elemento = 0;

        if (!origen.esVacia()) {
            elemento = origen.tope();
            origen.retirar();
            Copiar(origen, copia);
            origen.apilar(elemento);
            copia.apilar(elemento);

        }

    }

    public void invertir(Pila origen, Pila copia) throws Exception {
        int elemento = 0;

        if (!origen.esVacia()) {
            elemento = origen.tope();
            origen.retirar();
            copia.apilar(elemento);
            invertir(origen, copia);
            origen.apilar(elemento);

        }

    }

//    public int Suma() throws Exception {
//
//        int Size = this.tamanio;
//        int count = 0;
//   
//        if (Size != count) {
//            int x = 0;
//            int total = 0;
//
//            x = this.tope();
//            this.retirar();
//            total += x;
//
//            Suma();
//            return total;
//        }
//        return total;
//
//    }
    public int Suma() throws Exception {

        int total = 0;
        int count = 0;
        int Size = this.tamanio;

        while (count != Size) {
            total += this.tope();
            this.retirar();
            count++;

        }

        return total;

    }
    
    public double promedio() throws Exception{
        int Size = this.tamanio;
//        System.out.println(Size);
//        System.out.println(Suma());
        
        double prom = (double)Suma()/(double)Size;
        return prom;
        
    }

    
}
