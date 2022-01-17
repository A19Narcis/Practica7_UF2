/*

 */
package practica7_uf2;

import utils.utils;

/**
 *
 * @author Narcis i Joan
 */
public class Parte4 {

    public static void main(String[] args) {
        String passwdSuper = "Narcis12345";
        if (ValidarSuperusuari(passwdSuper) == true) {
            System.out.println("Has encertat la contrasenya!");
        } else {
            System.out.println("No has encertat la contrasenya!");
        }
    }

    static boolean ValidarSuperusuari(String passwdSuper) {
        boolean coincideix = false;

        String passwd;
        for (int i = 0; i < 3 && !coincideix; i++) {
            passwd = utils.LlegirString("Contrasenya: ");
            if (passwd.equals(passwdSuper)) {
                coincideix = true;
            }
        }

        return coincideix;
    }

}
