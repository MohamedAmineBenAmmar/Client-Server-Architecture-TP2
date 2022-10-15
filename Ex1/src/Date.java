import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Date implements DateInterface {
    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
