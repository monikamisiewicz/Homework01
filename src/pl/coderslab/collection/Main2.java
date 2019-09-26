package pl.coderslab.collection;

import java.util.regex.Pattern;

public class Main2 {

    public static void main(String[] args) {

        //liczby zmiennoprzecinkowe (5.65 , 123.123)
        String pattern1 = "[0-9]+\\.[0-9]+";
        String number =  "123.123";
        System.out.println("number " + number.matches(pattern1));
        //lub:
        boolean reg1 = Pattern.matches("\\d+\\.\\d+", "3.3");
        System.out.println("reg1 " + reg1);

        //liczby w notacji naukowej ( 5.4325e+04 ; 2.0000342E-06)
        boolean reg2 = Pattern.matches("\\d\\.\\d{1,9}[eE][+-]\\d{2}", "5.4325e+04");
        System.out.println("reg2 " + reg2);

        //ZLE
        //datę w formacie dd/mm/yyyy
        String date = "^[0-3]?[0-9]\\[0-3]?[0-9]\\(?:[0-9]{2}?[0-9]{2})$";
        boolean reg3 = Pattern.matches("^[0-3]?[0-9]\\/[0-3]?[0-9]\\/(?:[0-9]{2}?[0-9]{2})$", "32/37/1998");
        boolean reg33 = Pattern.matches("^(?:(1[0-2]|0?[1-9])\\/(3[01]|[12][0-9]|0?[1-9])|(3[01]|[12][0-9]|0?[1-9])\\/(1[0-2]|0?[1-9]))/(?:[0-9]{2})?[0-9]{2}$",  "31/07/2019");

        System.out.println("reg3 " + reg3);
        System.out.println("reg33 " + reg33);

        //POPRAWIC
        //datę w formacie yyyy-mm-dd - gdzie rok jest powyżej 2000
        boolean reg4 = Pattern.matches("^[2-9][0-9]{3}-[0-9]{2}-[0-9]{2}$", "2999-02-29");
        System.out.println("reg4 " + reg4);
    }
}
