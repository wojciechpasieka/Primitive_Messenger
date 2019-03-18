package pl.sda.cipher.aesCipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Demo {

    private static BufferedReader bufferedReader;
    private static PrintWriter printWriter;

    public static void main(String[] args) throws IOException {

        String s = Arrays.toString(args);
        String alghoritm = args[0];
        String mode = args[1];
        String filePath = args[2];
        System.out.println(s);



        AESCipher aesCipher = new AESCipher();

        String originalString = "my messageść²¢€’ó";
        String encryptedString = aesCipher.encrypt(originalString);
        String decryptedString = aesCipher.decrypt(encryptedString);

        System.out.println("Before encrypt:" + originalString);
        System.out.println("Encrypted:" + encryptedString);
        System.out.println("Decrypted:" + decryptedString);


    }



}
