package Threading;

import java.io.*;
import java.net.*;

// Single client handler thread
class ClientWorker extends Thread {
    private String ip;
    private int port;
    private int threadNumber;
    private int amount;

    public ClientWorker(String ip, int port, int threadNumber, int amount) {
        this.ip = ip;
        this.port = port;
        this.threadNumber = threadNumber;
        this.amount = amount;
    }

    @Override
    public void run() {
        try (
            Socket socket = new Socket(ip, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            // Send a message with thread number and amount
            String message = "Thread " + threadNumber + " sending amount: " + amount;
            out.println(message);

            // Read server response
            String resp = br.readLine();
            System.out.println("Thread " + threadNumber + " received: " + resp);

        } catch (IOException e) {
            System.err.println("Thread " + threadNumber + " error: " + e.getMessage());
        }
    }
}

public class MultiThreadedClient {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 9090;

        int numberOfThreads = 5; // how many clients to spawn
        int startAmount = 0;   // starting amount value

        for (int i = 1; i <= numberOfThreads; i++) {
            // Each thread can have its own amount or increment it
            int amount = startAmount++;
            new ClientWorker(ip, port, i, amount).start();
        }
    }
}
