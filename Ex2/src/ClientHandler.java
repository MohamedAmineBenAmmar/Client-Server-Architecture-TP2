import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    int received;
    String toreturn;
    float salary;

    final DataInputStream in;
    final DataOutputStream out;
    final Socket socket;
    final int number;

    public ClientHandler(Socket socket, DataInputStream in, DataOutputStream out,int number)
    {
        this.socket = socket;
        this.in = in;
        this.out = out;
        this.number = number;
    }

    public void run()
    {
        try {
            out.writeUTF("Please enter your salary : \n");
            out.flush();
            salary = in.readFloat();
            out.writeUTF("Menu :\n1 - Pret Auto \n2 - Pret Immobilier \n");
            out.flush();
            received = in.readInt();

            PretAuto pa = new PretAuto(salary);
            PretImmobilier pi = new PretImmobilier(salary);
            switch (received) {
                case 1 -> out.writeUTF("From Server to Client-" + number + "\n" + pa.MontantMax());
                case 2 -> out.writeUTF("From Server to Client-" + number + pi.MontantMax());
                default -> out.writeUTF("Invalid input");
            }
            in.close();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
