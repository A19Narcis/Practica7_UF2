/*
 Escriu una funció anomenada “Roman” al que se li passa un número enter 
 entre 1 i 3999 i retorni el seu valor en números romans
 */
package practica7_uf2;

import utils.utils;

/**
 *
 * @author Narcis i Joan
 */
public class Parte3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int numero = utils.LlegirIntLimitat("Número: ", 1, 3999);

        //separem les 4 possibles xifres
        int mil = numero / 1000;
        int cent = numero / 100 % 10;
        int dece = numero / 10 % 10;
        int uni = numero % 10;

        String numeroRoman = Roman(numero, mil, cent, dece, uni);
        System.out.println("Valor ROMAN --> " + numeroRoman);
    }

    static String Roman(int numero, int mil, int cent, int dece, int uni) {
        String result;

        String m = CalculMil(numero, mil);
        String c = CalculCent(numero, cent);
        String d = CalculDec(numero, dece);
        String u = CalculUni(numero, uni);

        result = m + c + d + u;

        return result;
    }

    static String CalculMil(int numero, int mil) {
        String mileni;

        switch (mil) {
            case 1:
                mileni = "M";
                break;
            case 2:
                mileni = "MM";
                break;
            case 3:
                mileni = "MMM";
                break;
            default:
                mileni = "";
        }

        return mileni;
    }

    private static String CalculCent(int numero, int cent) {
        String centena;

        switch (cent) {
            case 1:
                centena = "C";
                break;
            case 2:
                centena = "CC";
                break;
            case 3:
                centena = "CCC";
                break;
            case 4:
                centena = "CD";
                break;
            case 5:
                centena = "D";
                break;
            case 6:
                centena = "DC";
                break;
            case 7:
                centena = "DCC";
                break;
            case 8:
                centena = "DCCC";
                break;
            case 9:
                centena = "CM";
                break;
            default:
                centena = "";
        }
        return centena;
    }

    private static String CalculDec(int numero, int dece) {
        String decena;

        switch (dece) {
            case 1:
                decena = "X";
                break;
            case 2:
                decena = "XX";
                break;
            case 3:
                decena = "XXX";
                break;
            case 4:
                decena = "XL";
                break;
            case 5:
                decena = "L";
                break;
            case 6:
                decena = "LX";
                break;
            case 7:
                decena = "LXX";
                break;
            case 8:
                decena = "LXXX";
                break;
            case 9:
                decena = "XC";
                break;
            default:
                decena = "";
        }
        return decena;
    }

    private static String CalculUni(int numero, int uni) {
        String unitat;

        switch (uni) {
            case 1:
                unitat = "I";
                break;
            case 2:
                unitat = "II";
                break;
            case 3:
                unitat = "III";
                break;
            case 4:
                unitat = "IV";
                break;
            case 5:
                unitat = "V";
                break;
            case 6:
                unitat = "VI";
                break;
            case 7:
                unitat = "VII";
                break;
            case 8:
                unitat = "VIII";
                break;
            case 9:
                unitat = "IX";
                break;
            default:
                unitat = "";
        }
        return unitat;
    }

}