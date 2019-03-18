package pl.sda.messanger;

import pl.sda.cipher.CipherType;
import pl.sda.cipher.FactoryCipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalTime;

public class ReadTask implements Runnable {

    private Socket socket;

    public ReadTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = "";
            String nickName = bufferedReader.readLine();
            while (line != null) {
                line = bufferedReader.readLine();
                line = FactoryCipher.create(CipherType.AES).decryptMessage(line);
                String message = "(" + LocalTime.now() + ") [" + nickName + "]\n" + line;
                //chatWindowAdapter.displayMessage(message);
                System.out.println(message);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
