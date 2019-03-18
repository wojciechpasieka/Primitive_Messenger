package pl.sda.messanger;

import java.io.IOException;
import java.net.Socket;

public class MessangerClient {


    public static void main(String[] args) throws IOException, InterruptedException {
       Socket socket = new Socket("localhost", 4443);

        Runnable readTask = new ReadTask(socket);
        Runnable writeTask = new WriteTask(socket, "Wojti");

        Thread readThread = new Thread(readTask, "reading thread");
        Thread writeThread = new Thread(writeTask, "writing thread");

        readThread.start();
        writeThread.start();

        readThread.join();
        writeThread.join();

    }
}
