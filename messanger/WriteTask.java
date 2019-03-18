package pl.sda.messanger;

import pl.sda.cipher.CipherType;
import pl.sda.cipher.FactoryCipher;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteTask implements Runnable {

    private Socket socket;
    private String nickName;

    public WriteTask(Socket socket, String nickName) {
        this.socket = socket;
        this.nickName = nickName;
    }

    @Override
    public void run() {


        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            printWriter.println(nickName);
            printWriter.flush();
            while (!socket.isClosed()) {
                String line = scanner.nextLine();
                line = FactoryCipher.create(CipherType.AES).encryptMessage(line);
                printWriter.println(line);
                printWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
