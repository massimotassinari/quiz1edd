/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizmassimo;

/**
 *
 * @author massimo
 */
public class Lista {
    
    //Inicio lista
    private Nodo inicio;
    // Tamaño lista
    private int tamanio;

    //COnstructor
    public void Lista() {
        inicio = null;
        tamanio = 0;
    }

    //Metodo lista vacia o no
    public boolean esVacia() {
        return inicio == null;
    }

    //Metodo taaño lista
    public int getTamanio() {
        return tamanio;
    }

    //Agrega nodo al final de la lista
    public void agregarFinal(int valor) {
       
        Nodo nuevo = new Nodo();
        
        nuevo.setValor(valor);
        
        if (esVacia()) {
            
            inicio = nuevo;
            
        } else {
            
            Nodo aux = inicio;
            
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
           
            aux.setSiguiente(nuevo);
        }
        
        tamanio++;
    }

    //Nuevo nodo al inicio lista
    public void agregarInicio(int valor) {
        
        Nodo nuevo = new Nodo();
        
        nuevo.setValor(valor);
        
        if (esVacia()) {
            
            inicio = nuevo;
            
        } else {
            
            nuevo.setSiguiente(inicio);
            
            inicio = nuevo;
        }
        
        tamanio++;
    }

    //Inserta un nodo despues del nodo al que se da referencia
    public void insertarPorReferencia(int referencia, int valor) {
        
        Nodo nuevo = new Nodo();
       
        nuevo.setValor(valor);
        
        if (!esVacia()) {
            
            if (buscar(referencia)) {
                
                Nodo aux = inicio;
                
                while (aux.getValor() != referencia) {
                    aux = aux.getSiguiente();
                }
                
                Nodo siguiente = aux.getSiguiente();
                
                aux.setSiguiente(nuevo);
                
                nuevo.setSiguiente(siguiente);

                
                tamanio++;
            }
        }
    }

    //Inserta un nodo despues del nodo que se da por index
    public void insrtarPorPosicion(int posicion, int valor) {
        
        if (posicion >= 0 && posicion <= tamanio) {
            Nodo nuevo = new Nodo();
            nuevo.setValor(valor);
            
            if (posicion == 0) {
                
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            } else {
                
                if (posicion == tamanio) {
                    Nodo aux = inicio;
                    
                    while (aux.getSiguiente() != null) {
                        aux = aux.getSiguiente();
                    }
                    
                    aux.setSiguiente(nuevo);
                } else {
                    
                    Nodo aux = inicio;
                   
                    for (int i = 0; i < (posicion - 1); i++) {
                        aux = aux.getSiguiente();
                    }
                    
                    Nodo siguiente = aux.getSiguiente();
                    
                    aux.setSiguiente(nuevo);
                    
                    nuevo.setSiguiente(siguiente);
                }
            }
            
            tamanio++;
        }
    }

    //Obtiene valor del nodo en un index dado
    public int getValor(int posicion) throws Exception {
  
        if (posicion >= 0 && posicion < tamanio) {
           
            if (posicion == 0) {
              
                return inicio.getValor();
            } else {
               
                Nodo aux = inicio;
               
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                
                return aux.getValor();
            }
            
        } else {
            throw new Exception("Posicion inexistente en la lista.");
        }
    }

    //Busca
    public boolean buscar(int referencia) {
        
        Nodo aux = inicio;
        
        boolean encontrado = false;
        
        
        while (aux != null && encontrado != true) {
            
            if (referencia == aux.getValor()) {
                
                encontrado = true;
            } else {
                
                aux = aux.getSiguiente();
            }
        }
        
        return encontrado;
    }

    //Obtiene el index a partir del valor del nodo
    public int getPosicion(int referencia) throws Exception {
        
        if (buscar(referencia)) {
           
            Nodo aux = inicio;
            
            int cont = 0;
            
            while (referencia != aux.getValor()) {
               
                cont++;
                
                aux = aux.getSiguiente();
            }
           
            return cont;
            
        } else {
            throw new Exception("Valor inexistente en la lista.");
        }
    }

    //Edita el valor de un nodo a partir del valor que le demos
//    public void editarPorReferencia(int referencia, int valor) {
//        // Consulta si el valor existe en la lista.
//        if (buscar(referencia)) {
//            // Crea ua copia de la lista.
//            Nodo aux = inicio;
//            // Recorre la lista hasta llegar al nodo de referencia.
//            while (aux.getValor() != referencia) {
//                aux = aux.getSiguiente();
//            }
//            // Actualizamos el valor del nodo
//            aux.setValor(valor);
//        }
//    }

    //Edita el valor de un nodo a partir del index que le demos
//    public void editarPorPosicion(int posicion, int valor) {
//        // Verifica si la posición ingresada se encuentre en el rango
//        // >= 0 y < que el numero de elementos del la lista.
//        if (posicion >= 0 && posicion < tamanio) {
//            // Consulta si el nodo a eliminar es el primero.
//            if (posicion == 0) {
//                // Alctualiza el valor delprimer nodo.
//                inicio.setValor(valor);
//            } else {
//                // En caso que el nodo a eliminar este por el medio 
//                // o sea el ultimo
//                Nodo aux = inicio;
//                // Recorre la lista hasta lleger al nodo anterior al eliminar.
//                for (int i = 0; i < posicion; i++) {
//                    aux = aux.getSiguiente();
//                }
//                // Alctualiza el valor del nodo.
//                aux.setValor(valor);
//            }
//        }
//    }

    //Elimina un nodo de la lista ubicandolo por su valor como referencia
    public void removerPorReferencia(int referencia) {
        
        if (buscar(referencia)) {
            
            if (inicio.getValor() == referencia) {
                
                inicio = inicio.getSiguiente();
            } else {
               
                Nodo aux = inicio;
               
                
                while (aux.getSiguiente().getValor() != referencia) {
                    aux = aux.getSiguiente();
                }
                
                Nodo siguiente = aux.getSiguiente().getSiguiente();
                
                aux.setSiguiente(siguiente);
            }
            
            tamanio--;
        }
    }

    //Eliminar un nodo de la lista dandole el index como referencia
    public void removerPorPosicion(int posicion) {
     
        if (posicion >= 0 && posicion < tamanio) {
         
            if (posicion == 0) {
               
                inicio = inicio.getSiguiente();
            } 
            else {
              
                Nodo aux = inicio;
               
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getSiguiente();
                }
                
                Nodo siguiente = aux.getSiguiente();
                
                aux.setSiguiente(siguiente.getSiguiente());
            }
            
            tamanio--;
        }
    }

    //Elimina toda la lista
    public void eliminar() {
        
        inicio = null;
        
        tamanio = 0;
    }

    //Imprime la lista
    public void imprimir() {
        
        if (!esVacia()) {
            
            Nodo aux = inicio;
            
            int i = 0;
            
            while (aux != null) {
                
                System.out.print("["+i+"]" + ".( " + aux.getValor() + " )" + " =>  ");
                
                aux = aux.getSiguiente();
                
                i++;
            }
        }
    }

    public static boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
//        System.out.println("paso");
        if (numero < 0) {
            numero = numero * -1;
        }
//&& numero != 1)
        while ((primo) && (contador != numero) ) {
//            System.out.println(numero);
//            System.out.println(numero % contador);

            if (numero % contador == 0) {

                primo = false;
            }
            contador++;
        }
        return primo;
    }

    public void primos() throws Exception {
        boolean status = true;

        while (status) {

            for (int i = 0; i < this.tamanio; i++) {
//                System.out.println("iteracion");
//                System.out.println(this.tamanio);
//                System.out.println(i);
//                System.out.println(this.getValor(i));

                if (esPrimo(this.getValor(i)) == false) {
                    this.removerPorPosicion(i);
//                    this.imprimir();
                    status = false;
                    break;

                }

            }

            for (int i = 0; i < this.tamanio; i++) {
                if (esPrimo(this.getValor(i)) == false) {
                    status = true;
                }

            }

        }
    }


    public void Ordena() throws Exception {

        int Size = this.tamanio;
        int cont = 0;

        if (Size != cont) {
            int mayor = this.getValor(0);

            for (int i = 0; i < this.tamanio; i++) {

                if (mayor < this.getValor(i)) {
                    mayor = this.getValor(i);

                }

            }
            this.removerPorReferencia(mayor);
            Ordena();

            this.agregarFinal(mayor);

        }
    }

//    ELIMINA AL PRINCIPIO CONNNN EL RETORNO DEL NODO QUE ELIMINO---------------------
    public Nodo deleteAtTheStart() {
        Nodo node = inicio;
        if (!esVacia()) {

            inicio = inicio.getSiguiente();
            tamanio = tamanio - 1;

        } else {
            System.out.println("");
        }

        return node;
    }
//LE HACE REVERSE A LA LISA---------------------------------------------------------

    public void reverse() {
//        NO HACE FALTA EL NODO NODE = PFIRST PORQUE YA ME LO RETORNA LA FUNCION DE LISTA DELETE AT THE START
//        Nodo node = pFirst;

        Nodo node = this.deleteAtTheStart();


        if (node != null) {
            this.reverse();
            this.agregarFinal(node.getValor());

        }

    }

    public int Suma() throws Exception {

        int total = 0;
        int count = 0;
        int Size = this.tamanio;

        while (count != Size) {
            total += this.getValor(0);
            this.deleteAtTheStart();
            count++;

        }

        return total;

    }

    public double promedio() throws Exception {
        int Size = this.tamanio;
//        System.out.println(Size);
//        System.out.println(Suma());

        double prom = (double) Suma() / (double) Size;
        return prom;

    }

    public void positivos() throws Exception {
        boolean status = true;

        while (status) {

            for (int i = 0; i < this.tamanio; i++) {
//                System.out.println("iteracion");
//                System.out.println(this.tamanio);
//                System.out.println(i);
//                System.out.println(this.getValor(i));

                if (this.getValor(i) < 0) {
                    this.removerPorPosicion(i);
//                    this.imprimir();
                    status = false;
                    break;

                }

            }

            for (int i = 0; i < this.tamanio; i++) {
                if (this.getValor(i) < 0) {
                    status = true;
                }

            }

        }

    }

    public void negativos() throws Exception {
        boolean status = true;

        while (status) {

            for (int i = 0; i < this.tamanio; i++) {
//                System.out.println("iteracion");
//                System.out.println(this.tamanio);
//                System.out.println(i);
//                System.out.println(this.getValor(i));

                if (this.getValor(i) > 0) {
                    this.removerPorPosicion(i);
//                    this.imprimir();
                    status = false;
                    break;

                }

            }

            for (int i = 0; i < this.tamanio; i++) {
                if (this.getValor(i) > 0) {
                    status = true;
                }

            }

        }

    }
    
    public Lista copiar() throws Exception{
        Lista listica = new Lista();
        
        for (int i = 0; i < this.tamanio; i++) {
            listica.agregarFinal(this.getValor(i));
            
            
            
        }
        return listica;
    }
    
}
