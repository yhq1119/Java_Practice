package network;

import java.net.Socket;

public class Client {
    static String add = "121.208.200.174";
    static int port = 8080;

    public static void main(String[] args) {
        try {Socket socket = new Socket(add, port);
            System.out.println("success");
        }
        catch (Exception e){

        }
    }
}
