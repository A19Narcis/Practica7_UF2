/*
 Escriu un procediment anomenat “Titol” que donat un text, el mostri per
 pantalla de forma centrada. Pots assumir que la pantalla té un ample de 80 
 caràcters.
 */
package practica7_uf2;

/**
 *
 * @author Joan i Narcis
 */
public class Parte5 {

    public static void main(String[] args) {
        String frase = "Hola, som el Joan i el Narcís.";
        Titol(frase);
    }

    static void Titol(String text) {
        final int AMPLE_PANTALLA = 80;

        int numEspais = (AMPLE_PANTALLA - text.length()) / 2;
        char[] espais = new char[numEspais];
        
        GeneradorEspais(espais);
        System.out.printf("%s", text);
        GeneradorEspais(espais);
        
        System.out.println("");
    }

    //Genera espais abans i després de la frase
    static void GeneradorEspais(char[] espais) {
        for (int i = 0; i < espais.length; i++) {
            espais[i] = ' ';
            System.out.printf("%c", espais[i]);
        }
    }
}