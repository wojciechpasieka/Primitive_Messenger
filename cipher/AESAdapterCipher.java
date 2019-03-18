package pl.sda.cipher;

import pl.sda.cipher.aesCipher.AESCipher;

public class AESAdapterCipher implements Cipher {

    private AESCipher aesCipher;

    public AESAdapterCipher() {
        this.aesCipher = new AESCipher();
    }

    public AESAdapterCipher(String key) {
        this.aesCipher = new AESCipher(key);
    }

    @Override
    public String encryptMessage(String input) {
        return aesCipher.encrypt(input);
    }

    @Override
    public String decryptMessage(String input) {
        return aesCipher.decrypt(input);
    }
}
