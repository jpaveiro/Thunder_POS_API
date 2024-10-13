package br.com.jpaveiro.thunderpos.application.utils;


import java.util.regex.Pattern;

public class Utils {

    public static boolean validarEmail(String email) {
        final String PADRAO_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(PADRAO_EMAIL);

        return pattern.matcher(email).matches();
    }
}
