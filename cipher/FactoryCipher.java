package pl.sda.cipher;

import pl.sda.cipher.ceasarCipher.CaesarCipher;

public class FactoryCipher {


    public static Cipher create(CipherType cipherType) {
        if (cipherType == CipherType.AES) {
            return new AESAdapterCipher();
        } else if (cipherType == CipherType.CAESAR) {
            return new CaesarCipher(5);
        } else {
            return null;
        }
    }
}
