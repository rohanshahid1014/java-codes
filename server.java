

import java.io.*;
import java.net.*;

public class server {

    ServerSocket ServerS;
    Socket ClientS;
    BufferedReader in;
    PrintWriter out;

    public void startServer() throws IOException 
    {
        ServerS = new ServerSocket(9090);
        System.out.println("Server is running and waiting for client connection...");
        ClientS = ServerS.accept();
        System.out.println("Client connected!");

        in = new BufferedReader(new InputStreamReader(ClientS.getInputStream()));
        out = new PrintWriter(ClientS.getOutputStream(), true);
    }

    public String receive() throws IOException 
    {
        String message = in.readLine();
        System.out.println("Client says: " + message);
        return message;
    }

    public void send(String message) 
    {
        out.println(message);
    }

    public void closeConnections() throws IOException 
    {
        ClientS.close();
        ServerS.close();
    }

    public static void main(String args[]) throws IOException 
    {
        server s = new server();
        s.startServer();

        String clientMsg = s.receive();

        s.send("Hello from server!");
        System.out.println(clientMsg);

        s.closeConnections();
        System.out.println("Server closed.");
    }
}
