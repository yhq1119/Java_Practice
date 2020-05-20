package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        new Server();
    }
    ServerSocket serverSocket;

    public Server( ) {
        setup();
        connect();
    }

    private void connect() {
        while (true){
            try {
                Socket socket = serverSocket.accept();
                System.out.println("connected"+socket);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void setup(){
        try {
            this.serverSocket = new ServerSocket(8080);
            System.out.println("Running");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
