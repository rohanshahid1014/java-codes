package Threading;

import java.io.*;
import java.net.*;

// A handler thread for each client
class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            // Read a single message from the client
            String clientMsg = in.readLine();
            System.out.println("Client says: " + clientMsg);

            // Respond to client
            out.println("Hello from server! Received: " + clientMsg);

        } catch (IOException e) {
            System.err.println("Client handler error: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }
}

public class MultiThreadServer {
    public static void main(String[] args) {
        int port = 9090;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port + " and waiting for client connections...");
            while (true) {
                // Accept new client
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected!");

                // Handle client in new thread
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
