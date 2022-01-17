/*
 Escriu una funció anomenada “CalcularDescompte” que, rebi com a 
 paràmetres el preu i la categoria d’un producte i retorni el preu amb el 
 descompte aplicat. Les categories poden ser de 3 tipus: A, B i C. Els productes 
 de categoria A tenen un 5% de descompte, els de categoria B un 10% de 
 descompte i els de categoria C tenen un 20% de descompte si el preu és 
 inferior a 100€ i de 35% si el preu és igual o superior a 100€.

 */
package practica7_uf2;

import utils.utils;

/**
 *
 * @author Joan i Narcís
 */
public class Parte1 {

    public static void main(String[] args) {
        float preu = utils.LlegirFloat("Preu: ");
        float descompteCatFinal = ComprovacioCategoria(preu);
        float preuFinal = CalcularDescompte(preu, descompteCatFinal);
        System.out.printf("Preu final amb descompte aplicat %.2f €.\n", preuFinal);
    }

    static float CalcularDescompte(float preu, float categoriaFinal) {
        float result;

        result = preu - preu * categoriaFinal;

        return result;
    }

    //Funcio per veure quin preu es rebaixa, mitjançant la lletra de categoria que ens donin.
    static float ComprovacioCategoria(float preu) {
        float result = 0;
        boolean catCorrecta;
        String categoria;
        do {
            categoria = utils.LlegirString("Categoria(A, B o C): ");
            catCorrecta = true;
            switch (categoria) {
                case "A":
                    result = (float) (5 * 0.01);
                    break;
                case "B":
                    result = (float) (10 * 0.01);
                    break;
                case "C":
                    float categoriaC = calculCategoriaC(preu, categoria);
                    break;
                default:
                    System.out.println("Opció no vàlida");
                    catCorrecta = false;
            }
        } while (catCorrecta == false);

        return result;
    }

    static float calculCategoriaC(float preu, String categoria) {
        float result;

        if (preu < 100) {
            result = (float) (20 * 0.01);
        } else {
            result = (float) (35 * 0.01);
        }

        return result;
    }

}
