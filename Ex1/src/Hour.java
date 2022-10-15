public class Hour implements HourInterface {
    public String getTime() {
        return (" "+java.time.LocalTime.now());
    }
}
