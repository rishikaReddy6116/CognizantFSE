import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);

            System.out.println("Server started...");
            System.out.println("Waiting for client...");

            Socket socket = server.accept();

            System.out.println("Client connected!");

            BufferedReader br =
                new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter pw =
                new PrintWriter(socket.getOutputStream(), true);

            String message = br.readLine();

            System.out.println("Client: " + message);

            pw.println("Hello Client");

            socket.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}