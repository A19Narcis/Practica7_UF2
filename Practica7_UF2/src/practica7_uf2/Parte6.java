/*
Implementa un programa que faci servir un tipus de dada anomenat “Pila”. 
Una pila és un tipus de dada on es van afegint valors i es van traient en l’ordre 
invers al qual s’han afegit, també conegut com LIFO (Last In First Out). El 
programa ha de presentar el següent menú d’opcions:
  1.- Afegir número (push)
  2.- Treure número (pop)
  3.- Mostrar contingut de la pila
  4.- Sortir
La pila admet com a màxim 10 valors. Si intentem afegir un onzè element el 
sistema no ho ha de permetre i ha d’avisar a l’usuari que la pila es troba plena. 

De la mateixa manera, si intentem treure un número d’una pila que es troba 
buida, també s’ha d’informar a l’usuari que no pot fer aquesta operació.
Al treure un número de la pila, s’ha de mostrar per pantalla quin és el número 
que s’ha tret.

El programa s’ha d’implementar amb un array. No es poden fer servir els tipus 
de dades de les llibreries de Java.
 */
package practica7_uf2;

import utils.utils;

/**
 *
 * @author Narcis i Joan
 */
public class Parte6 {

    public static void main(String[] args) {
        int[] pila = new int[10];
        menu(pila);
    }

    private static void menu(int[] pila) {
        MostraMenu();
        int opcio;
        int contador = 0;
        boolean sortida = false;
        do {
            opcio = utils.LlegirIntLimitat("-> ", 1, 4);
            switch (opcio) {
                case 1://Insertar
                    if (contador == 10) {
                        System.out.println("La pila està plena. Buida per continuar");
                        break;
                    } else {
                        InserirValor(pila, contador);
                        contador++;
                        break;
                    }
                case 2://Expulsar
                    if (contador == 0) {
                        System.out.println("La pila esta buida...");
                        break;
                    } else {
                        TreureValor(pila, contador);
                        contador--;
                        break;
                    }
                case 3://Veure Pila
                    VeurePila(pila);
                    break;
                case 4://SORTIDA
                    sortida = true;
                    break;
            }
        } while (!sortida);
    }

    static void InserirValor(int[] pila, int contador) {
        int numero = utils.LlegirInt("Número: ");
        pila[contador] = numero;
    }

    static void TreureValor(int[] pila, int contador) {
        final int RESET = 0;
        System.out.println("Has retirat el número " + pila[contador - 1]);
        pila[contador - 1] = RESET;
    }

    static void VeurePila(int[] pila) {
        System.out.println("^ PILA ^");
        for (int i = 0; i < pila.length; i++) {
            System.out.println("   " + pila[pila.length - 1 - i]);
        }
        System.out.println("");
    }

    static void MostraMenu() {
        System.out.println("*  MENU DE LA PILA    *");
        System.out.println("    1 - PUSH (+)      ");
        System.out.println("    2 - PULL (-)      ");
        System.out.println("    3 - Veure pila    ");
        System.out.println("    4 - Sortir        ");
    }

}
