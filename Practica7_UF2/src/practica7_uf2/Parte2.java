/*
 Escriu una funció anomenada “CalcularIVA” a la que se li passa un preu, un
 tipus d’IVA i la data de la compra i retorna el preu amb l’IVA aplicat. El tipus
 d’IVA pot ser General, Reduït, Superreduït o Exempt. El percentatge a aplicar
 és el vigent en la data de compra i el podem trobar en aquesta taula:

        Data inici vigència General Reduït Superreduit Exempt
           01-01-1986         12%      6%    No existeix   0%
           01-01-1992         15%      6%    No existeix   0%
           01-01-1993         15%      6%       3%         0%
           01-01-1995         16%      7%       4%         0%
           01-01-2010         18%      8%       4%         0%
           15-07-2012         21%     10%       4%         0%

 */
package practica7_uf2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import utils.utils;

/**
 *
 * @author Narcis i Joan
 */
public class Parte2 {

    public static void main(String[] args) {
        float preu = utils.LlegirFloat("Preu: ");
        String data1 = null, data2 = null, data3 = null, data4 = null, data5 = null, data6 = null;
        DatesGenerals(data1, data2, data3, data4, data5, data6);

        String dataIVA;
        boolean comprovacioData;
        do {
            dataIVA = utils.LlegirString("Data(dd/MM/yyyy): ");
            comprovacioData = LlegirData(dataIVA);
        } while (comprovacioData == false);

        Date transData = StringAData(dataIVA);
        Date date1 = StringAData(data1);
        Date date2 = StringAData(data2);
        Date date3 = StringAData(data3);
        Date date4 = StringAData(data4);
        Date date5 = StringAData(data5);
        Date date6 = StringAData(data6);

        int tipusIVA = EleccioIVA();

        double IVAAplicat = CalcularIVA(preu, tipusIVA, transData, date1, date2, date3, date4, date5, date6);
        System.out.printf("Preu final del producte %.2f €\n", IVAAplicat);
    }

    //Donar valors a les dates de que fan de marge a la taula
    static void DatesGenerals(String data1, String data2, String data3, String data4, String data5, String data6) {
        data1 = "01/01/1986";
        data2 = "01/01/1992";
        data3 = "01/01/1993";
        data4 = "01/01/1995";
        data5 = "01/01/2010";
        data6 = "15/07/2012";
    }

    //IVA GENERAL
    static double CalcularIVA1(float preu, int tipusIVA, Date transData, Date date1, Date date2, Date date3, Date date4, Date date5, Date date6) {
        double resultat = 0;

        if (transData.after(date6) || transData.equals(date6)) {
            resultat = preu + preu * (double) 21 / 100;
        } else if (transData.before(date6) && (transData.after(date5) || transData.equals(date5))) {
            resultat = preu + preu * (double) 18 / 100;
        } else if (transData.before(date5) && (transData.after(date4) || transData.equals(date4))) {
            resultat = preu + preu * (double) 16 / 100;
        } else if (transData.before(date4) && (transData.after(date2) || transData.equals(date2))) {
            resultat = preu + preu * (double) 15 / 100;
        } else {
            resultat = preu + preu * (double) 12 / 100;
        }

        return resultat;
    }

    //IVA REDUÏT
    static double CalcularIVA2(float preu, int tipusIVA, Date transData, Date date1, Date date2, Date date3, Date date4, Date date5, Date date6) {
        double resultat = 0;

        if (transData.after(date6) || transData.equals(date6)) {
            resultat = preu + preu * (double) 10 / 100;
        } else if (transData.before(date6) && (transData.after(date5) || transData.equals(date5))) {
            resultat = preu + preu * (double) 8 / 100;
        } else if (transData.before(date5) && (transData.after(date4) || transData.equals(date4))) {
            resultat = preu + preu * (double) 7 / 100;
        } else {
            resultat = preu + preu * (double) 6 / 100;
        }

        return resultat;
    }

    //IVA SUPERREDUIT
    static double CalcularIVA3(float preu, int tipusIVA, Date transData, Date date1, Date date2, Date date3, Date date4, Date date5, Date date6) {
        double resultat = 0;

        if (transData.after(date4) || transData.equals(date4)) {
            resultat = preu + preu * (double) 4 / 100;
        } else if (transData.before(date4) && (transData.after(date3) || transData.equals(date3))) {
            resultat = preu + preu * (double) 3 / 100;
        } else {
            resultat = preu;
        }

        return resultat;
    }

    //IVA EXEMPT
    static double CalcularIVA(float preu, int tipusIVA, Date transData, Date date1, Date date2, Date date3, Date date4, Date date5, Date date6) {
        double result = 0;

        if (tipusIVA == 1) {
            result = CalcularIVA1(preu, tipusIVA, transData, date1, date2, date3, date4, date5, date6);
        } else if (tipusIVA == 2) {
            result = CalcularIVA2(preu, tipusIVA, transData, date1, date2, date3, date4, date5, date6);
        } else if (tipusIVA == 3) {
            result = CalcularIVA3(preu, tipusIVA, transData, date1, date2, date3, date4, date5, date6);
        } else {
            result = preu;
        }

        return result;

    }

    //Comprovació de la data (SMART)
    static boolean LlegirData(String dataIVA) {
        boolean dataValida;

        try {
            LocalDate.parse(dataIVA, DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.SMART));
            dataValida = true;
        } catch (DateTimeParseException e) {
            System.out.println("Data no vàlida");
            dataValida = false;
        }

        return dataValida;
    }

    //Passar de String a Date
    static Date StringAData(String dataIVA) {
        Date result = null;

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            result = formato.parse(dataIVA);
        } catch (ParseException ex) {
            System.out.println("No valid");
        }

        return result;
    }

    //Veure la seca eleccio(1, 2, 3, 4)
    static int EleccioIVA() {
        int result = 0;
        boolean numValid;

        do {
            int tipusIVA = utils.LlegirInt("IVA (1-General, 2-Reduït, 3-Superreduit, 4-Exempt): ");
            numValid = true;
            if (tipusIVA == 1) {
                result = 1;
            } else if (tipusIVA == 2) {
                result = 2;
            } else if (tipusIVA == 3) {
                result = 3;
            } else if (tipusIVA == 4) {
                result = 4;
            } else {
                numValid = false;
            }
        } while (numValid == false);

        return result;
    }

}
