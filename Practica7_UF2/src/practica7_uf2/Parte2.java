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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.utils;

/**
 *
 * @author Narcis i Joan
 */
public class Parte2 {

    public static void main(String[] args) {
        float preu = utils.LlegirFloat("Preu: ");

        String data1 = "01/01/1986";
        String data2 = "01/01/1992";
        String data3 = "01/01/1993";
        String data4 = "01/01/1995";
        String data5 = "01/01/2010";
        String data6 = "15/07/2012";

        String dataIVA;
        boolean comprovacioData;
        do {
            dataIVA = utils.LlegirString("Data(dd/MM/yyyy): ");
            comprovacioData = LlegirData(dataIVA);
        } while (comprovacioData == false);

        Date transData = StringAData(dataIVA);
        Date date1 = StringAData(data1);
        Date date2 = StringAData(data1);
        Date date3 = StringAData(data1);
        Date date4 = StringAData(data1);
        Date date5 = StringAData(data1);

        int tipusIVA = EleccioIVA();

        float IVAAplicat = CalcularIVA(preu, tipusIVA, transData, date1);
        System.out.printf("Preu final del producte %.2f €\n", IVAAplicat);
    }

    static float CalcularIVA(float preu, int tipusIVA, Date transData, Date data1) {
        float resultat = 0;

        if (tipusIVA == 1 && transData.after(data1)) {
            resultat = preu - (float) preu * (float) (21 / 100);
        }

        return resultat;
    }

    static boolean LlegirData(String dataIVA) {
        boolean dataValida;

        try {
            LocalDate.parse(dataIVA, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            dataValida = true;
        } catch (DateTimeParseException e) {
            System.out.println("Data no vàlida");
            dataValida = false;
        }

        return dataValida;
    }

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

    static int EleccioIVA() {
        int result = 0;
        boolean numValid;

        do {
            int tipusIVA = utils.LlegirInt("IVA (1-General, 2-Reduït, 3-Superreduit, 4-Exempt): ");
            numValid = true;
            switch (tipusIVA) {
                case 1:
                    result = 1;
                    break;
                case 2:
                    result = 2;
                    break;
                case 3:
                    result = 3;
                    break;
                case 4:
                    result = 4;
                    break;
                default:
                    System.out.println("Opció no vàlida");
                    numValid = false;
            }
        } while (numValid == false);

        return result;
    }

}
