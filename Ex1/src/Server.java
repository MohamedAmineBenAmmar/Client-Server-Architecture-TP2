import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        // Declaring the server socket
        ServerSocket serverSocket = null;

        try{
            // Start listening on port 5000
            serverSocket = new ServerSocket(5000);
            // Tracking the number of clients
            int client_number = 0;

            while(true){
                System.out.println("Waiting for client ...");

                // Setting connection with the client
                Socket socket = serverSocket.accept();
                client_number++;

                System.out.println("-New client connected:" + client_number);

                // Initializing input / output buffers
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                Thread thread = new ClientHandler(socket, in, out, client_number);

                thread.start();
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
