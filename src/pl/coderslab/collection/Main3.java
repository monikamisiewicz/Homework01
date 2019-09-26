package pl.coderslab.collection;

import java.util.regex.Pattern;

public class Main3 {

    public static void main(String[] args) {

        System.out.println(verifyLogin("2dfdf-_"));
        System.out.println(verifyLogin("jl"));
        System.out.println(verifyLogin("a234LK_-kjlkxpl"));
        System.out.println(verifyLogin("qw-df_dfkj../"));
    }

    //ZLE
    static boolean verifyLogin(String email) {

        //zwróci true jeżeli ciąg znaków:
        //Ma minimum 5 znaków. {5,}
        //Zawiera tylko litery, cyfry, znak podkreślenia, myślnik \\w
        //Nie zaczyna się od cyfry ^\D

        if(Pattern.matches("^\\D[\\w-]{5,}", email)) {
            return true;
        } else {
            return false;
        }
    }
}
