/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quizmassimo;

/**
 *
 * @author massimo
 */
public class Quizmassimo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        Lista lista = new Lista();

        // Agregar al final de la lista
        lista.agregarFinal(-5);
        lista.agregarFinal(-10);
        lista.agregarFinal(1);
        lista.agregarFinal(6);
        lista.agregarFinal(2);
        lista.agregarFinal(7);
        lista.agregarFinal(9);
        lista.agregarFinal(19);
        lista.agregarFinal(23);
        lista.agregarFinal(37);
        lista.agregarFinal(-19);
        lista.agregarFinal(40);
        lista.agregarFinal(61);
        lista.agregarFinal(73);
        lista.agregarFinal(88);
        lista.agregarFinal(101);
        lista.agregarFinal(97);
        lista.agregarFinal(24);
        System.out.println("-----Lista original-----\n");
        lista.imprimir();
        System.out.println("\n\n------------------------");

        System.out.println("\n-----Lista 1-----\n");

        Lista primos = new Lista();
        primos = lista.copiar();
        primos.positivos();
        primos.primos();
        primos.Ordena();

        primos.imprimir();
        System.out.println("\n\n------------------------\n");

        Lista lista2 = new Lista();
        Lista suma = new Lista();
        Lista aux = new Lista();
        Lista aux2 = new Lista();

        aux = lista.copiar();
        aux2 = lista.copiar();
        suma = lista.copiar();

        lista2.agregarInicio(suma.Suma());

        aux.positivos();

        lista2.agregarInicio((int) aux.promedio());

        aux2.negativos();
        lista2.agregarInicio((int) aux2.promedio());

        System.out.println("\n-----Lista 2-----\n");
        System.out.println("Primer nodo: Promedio de todos los numeros negativos");
        System.out.println("Segundo nodo: Promedio de todos los numeros positivos");
        System.out.println("Tercer nodo: Sumatoria de los N numeros pertenecientes a la lista\n");

        lista2.imprimir();
        System.out.println("\n\n-----------------\n");
        System.out.println("\n-----Lista 3-----");

        lista.reverse();
        lista.imprimir();
        System.out.println("\n\n-----------------\n");

        System.out.println("\n---------Ahora la pila-----------\n");


        Pila pila = new Pila();

        pila.apilar(2);
        pila.apilar(-4);
        pila.apilar(7);
        pila.apilar(5);
        pila.apilar(1);

        pila.imprimir();

        System.out.println("\n-----Promedio-----\n");
        System.out.println("       " + pila.promedio());
        System.out.println("\n------------------");
    }

}
