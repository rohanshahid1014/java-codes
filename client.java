

import java.io.*;
import java.net.*;

public class client {
    Socket socket;
    OutputStream os;
    PrintWriter out;
    InputStream is;
    InputStreamReader isr;
    BufferedReader br;

    public client(String IP, int PortNum) throws IOException
    {
        socket = new Socket(IP, PortNum);
        os = socket.getOutputStream();
        out = new PrintWriter(os, true); // Auto-flush
        is = socket.getInputStream();
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
    }

    public void send(String message) 
    {
        out.println(message);
    }

    public String receive() throws IOException 
    {
        return br.readLine();
    }
    
    public static void main(String args[]) throws IOException 
    {
        client Client = new client("127.0.0.1", 9090);
        Client.send("Hello from client!");
        String resp = Client.receive();
        System.out.println("Server says: " + resp);
    }
}
