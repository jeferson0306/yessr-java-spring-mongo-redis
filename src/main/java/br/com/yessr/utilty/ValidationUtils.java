package br.com.yessr.utilty;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class ValidationUtils {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String PHONE_REGEX = "\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}";
    private static final Pattern EMAIL_PATTERN = compile(EMAIL_REGEX);
    private static final Pattern PHONE_PATTERN = compile(PHONE_REGEX);

    private ValidationUtils() {
        throw new IllegalStateException("unable to instantiate this utility class");
    }

    public static boolean isValidCPF(final String document) {

        if (document == null || document.isEmpty() || document.trim().isEmpty() || document.equals("0")) {
            return false;
        }

        final var cpf = document.replaceAll("\\D", "");

        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || cpf.length() != 11) {
            return false;
        }

        char dig10;
        char dig11;
        int sm;
        int i;
        int r;
        int num;
        int peso;

        try {

            sm = 0;
            peso = 10;

            for (i = 0; i < 9; i++) {
                num = cpf.charAt(i) - '0';
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if (r == 10 || r == 11) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + '0');
            }

            sm = 0;
            peso = 11;

            for (i = 0; i < 10; i++) {
                num = cpf.charAt(i) - '0';
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if (r == 10 || r == 11) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + '0');
            }

            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));

        } catch (InputMismatchException erro) {
            return false;
        }
    }

    public static boolean isValidEmail(final String email) {
        final var matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhone(final String phone) {
        final var matcher = PHONE_PATTERN.matcher(phone);
        return matcher.matches();
    }

}
