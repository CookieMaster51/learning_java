import java.time.LocalDateTime;

public class DoinStuff {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.out.printf("%tD%n%<ta, %<td %<tb %<tY%n%<tR %<tp", time);
    }
}
