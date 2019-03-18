package pl.sda.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ProxyTask implements Runnable {

    private Socket socket1;
    private Socket socket2;

    public ProxyTask(Socket socket1, Socket socket2){
        this.socket1 = socket1;
        this.socket2 = socket2;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            PrintWriter writer = new PrintWriter(socket2.getOutputStream());

            while(!socket1.isClosed() && !socket2.isClosed()) {
                String line = reader.readLine();

                writer.println(line);
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
