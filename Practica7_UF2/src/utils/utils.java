package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Llibreria d'utilitats
 *
 * @author Sergi
 * @version 1.0
 *
 */
public class utils {
// <editor-fold defaultstate="collapsed" desc="Implementació de LlegirInt()">

    private static Scanner scan = null;

    /**
     *
     * @return <h2>result torna amb un valor que s'ha llegit a través de
     * l'scanner</h2>
     */
    public static int LlegirInt() {
        int result;

        if (scan == null) {
            scan = new Scanner(System.in);
        }
        result = LlegirInt(scan);

        return result;
    }

    /**
     *
     * @param missatge
     * @return <h2>torna el nombre enter llegit per l'scanner</h2>
     */
    public static int LlegirInt(String missatge) {
        int result;

        if (scan == null) {
            scan = new Scanner(System.in);
        }
        result = LlegirInt(scan, missatge);

        return result;
    }

    /**
     *
     * @param scan <h2>es el valor que hem introduit avants en missatge
     * (llegirInt)</h2>
     * @return
     */
    public static int LlegirInt(Scanner scan) {
        return LlegirInt(scan, null);
    }

    /**
     *
     * @param scan
     * @param missatge
     * @param valorMin
     * @param valorMax
     * @return
     */
    public static int LlegirInt(Scanner scan, String missatge, int valorMin, int valorMax) {
        int result = 0;
        do {
            result = LlegirInt(scan, missatge);
        } while (result < valorMin || result > valorMax);

        return result;
    }

    /**
     *
     * @param scan
     * @param missatge
     * @return
     */
    public static int LlegirInt(Scanner scan, String missatge) {
        boolean dadesCorrectes;
        int result = 0;
        do {
            if (missatge != null) {
                System.out.print(missatge);
            }
            dadesCorrectes = scan.hasNextInt();
            if (dadesCorrectes) {
                result = scan.nextInt();
            } else if (scan.hasNext()) {
                scan.nextLine();
            }
        } while (!dadesCorrectes);

        return result;
    }

    public static int LlegirIntLimitat(String missatge, int limitMin, int limitMax) {
        Scanner scann = new Scanner(System.in);
        int result = 0;
        boolean correcte = false;
        while (!correcte) {
            System.out.print(missatge);
            if (scann.hasNextInt()) {
                result = scann.nextInt();
                if (result >= limitMin && result <= limitMax) {
                    correcte = true;
                } else {
                    System.out.println("Número fora de rang...");
                }
            } else {
                System.out.println("Aixó no és un número");
                scann.nextLine();
            }
        }
        return result;
    }

    public static double LlegirDouble(String missatge) {
        Scanner scann = new Scanner(System.in);
        double result = 0;
        boolean correcte = false;
        while (!correcte) {
            System.out.print(missatge);
            if (scann.hasNextDouble()) {
                result = scann.nextDouble();
                correcte = true;
            } else {
                scann.next();
            }
        }
        return result;
    }

    public static float LlegirFloat(String missatge) {
        Scanner scann = new Scanner(System.in);
        float result = 0;
        boolean correcte = false;
        while (!correcte) {
            System.out.print(missatge);
            if (scann.hasNextFloat()) {
                result = scann.nextFloat();
                if (result > 0) {
                    correcte = true;
                } else {
                    System.out.println("Ha de ser un número positiu...");
                }
            } else {
                scann.next();
            }
        }
        return result;
    }

    public static String LlegirString(String missatge) {
        String result;

        if (scan == null) {
            scan = new Scanner(System.in);
        }
        result = LlegirString(scan, missatge);

        return result;
    }

    public static String LlegirString(Scanner scan) {
        return LlegirString(scan, null);
    }

    public static String LlegirString(Scanner scan, String missatge) {
        String result;

        if (missatge != null) {
            System.out.print(missatge);
        }

        result = scan.nextLine();

        return result;
    }

    //Comprovació de la data (SMART)
    static boolean LlegirData(String data) {
        boolean dataValida;

        try {
            LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.SMART));
            dataValida = true;
        } catch (DateTimeParseException e) {
            System.out.println("Data no vàlida");
            dataValida = false;
        }

        return dataValida;
    }

    //Passar de String a Date
    static Date StringAData(String data) {
        Date result = null;

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            result = formato.parse(data);
        } catch (ParseException ex) {
            System.out.println("No valid");
        }

        return result;
    }

// </editor-fold>
}
