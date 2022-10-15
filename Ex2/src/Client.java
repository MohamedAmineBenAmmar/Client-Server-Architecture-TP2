import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        try{
            while(true) {
                Socket socket = new Socket(InetAddress.getLocalHost(),4000);

                System.out.println("-Connection with the server is done successfully.");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                System.out.println(in.readUTF());
                out.writeFloat(scn.nextFloat());
                out.flush();

                System.out.println(in.readUTF());

                out.writeInt(scn.nextInt());
                out.flush();

                System.out.println(in.readUTF());

                out.close();
                in.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        scn.close();
    }
}
