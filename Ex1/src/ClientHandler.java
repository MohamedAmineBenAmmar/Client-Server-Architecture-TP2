import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    String received;
    String toreturn;

    final DataInputStream in;
    final DataOutputStream out;
    final Socket socket;
    final int number;

    public ClientHandler(Socket socket, DataInputStream in, DataOutputStream out, int number)
    {
        this.socket = socket;
        this.in = in;
        this.out = out;
        this.number = number;
    }

    public void run()
    {
        try {
            out.writeUTF("Menu :\n1 - Date \n2 - Time \n");
            out.flush();
            received = in.readUTF();

            Date date = new Date();
            Hour hour = new Hour();
            switch (received) {
                case "1" -> out.writeUTF("From Server to Client-" + number + " Date is " + date.getDate());
                case "2" -> out.writeUTF("From Server to Client-" + number + " Time is " + hour.getTime());
                default -> out.writeUTF("Invalid input");
            }
            in.close();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
