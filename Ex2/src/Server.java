import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){

        ServerSocket serverSocket=null;

        try{
            serverSocket = new ServerSocket(4000);
            int client_number = 0;

            while(true){

                System.out.println("-Waiting for client...");

                Socket socket = serverSocket.accept();
                client_number++;

                System.out.println("-Client No:" + client_number + " started!");

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
