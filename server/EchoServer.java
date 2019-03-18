package pl.sda.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {

        int port = 4443;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Started server on port " + port);

        while (true) {

            System.out.println("Waiting for client...");
            Socket clientSocket1 = serverSocket.accept();
            Socket clientSocket2 = serverSocket.accept();

            ProxyTask proxyTask1 = new ProxyTask(clientSocket1, clientSocket2);
            ProxyTask proxyTask2 = new ProxyTask(clientSocket2, clientSocket1);


            Thread readThread = new Thread(proxyTask1, "reading thread");
            Thread writeThread = new Thread(proxyTask2, "writing thread");

            readThread.start();
            writeThread.start();

        }
    }
}
