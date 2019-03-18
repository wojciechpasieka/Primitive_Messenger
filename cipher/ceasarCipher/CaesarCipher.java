package pl.sda.cipher.ceasarCipher;

import pl.sda.cipher.Cipher;

public class CaesarCipher implements Cipher {

    private int shift;

    private static int LETTER_NUMBER = 26;
    private static int SMALL_LETTER_BEGIN = 97;
    private static int CAPITAL_LETTER_BEGIN = 65;

    public CaesarCipher(int shift) {
        if (shift >= 0 && shift <= 26){
            this.shift = shift;
        } else {
            throw new IllegalArgumentException("Przesunięcie musi być być w przedziale od 0 do 26");
        }
    }

    @Override
    public String encryptMessage(String input) {
        char[] charArray = input.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char c : charArray) {
            if (isSmallLetter(c)) {
                int value = c;
                value = offsetModulo(value, SMALL_LETTER_BEGIN);
                char character = (char) value;
                result.append(character);

            } else if (isCapitalLetter(c)) {
                int value = c;
                value = offsetModulo(value, CAPITAL_LETTER_BEGIN);

                char character = (char) value;
                result.append(character);
            } else {
                result.append(c);
            }

        }

        return result.toString();
    }

    @Override
    public String decryptMessage(String input) {
        char[] charArray = input.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char c : charArray) {
            if (isSmallLetter(c)) {
                int value = c;
                value = offsetModuloForDecrypt(value, SMALL_LETTER_BEGIN);

                char character = (char) value;
                result.append(character);

            } else if (isCapitalLetter(c)) {
                int value = c;
                value = offsetModuloForDecrypt(value, CAPITAL_LETTER_BEGIN);

                char character = (char) value;
                result.append(character);
            } else {
                result.append(c);
            }

        }

        return result.toString();
    }


    private int offsetModulo(int value, int indexBegin) {
        value = value - indexBegin;
        value = value + shift;
        value = value % LETTER_NUMBER;
        value = value + indexBegin;
        return value;
    }

    private int offsetModuloForDecrypt(int value, int indexBegin) {
        value = value - indexBegin;
        value = value - shift;
        value = value + LETTER_NUMBER;
        value = value % LETTER_NUMBER;
        value = value + indexBegin;
        return value;
    }

    private boolean isCapitalLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isSmallLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
}
