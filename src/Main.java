import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    private static final String HTML = "<html>\n" +
            "<head>\n" +
            "    <title>Clock</title>\n" +
            "    <meta http-equiv=\"refresh\" content=\"0.9\">\n" +
            "</head>\n" +
            "<body>\n" +
            "    <br><br><br>\n" +
            "    <div align=\"center\"><span style=\"font-size:48\">hh:mm:ss</span></div>\n" +
            "</body>\n" +
            "</html>\n" +
            "</html>\n";

    public static void main(String[] args) throws InterruptedException, IOException {

        LocalTime now = LocalTime.now();
        while (true) {
            //String temp = now.toString();
            Thread.sleep(900);
            now = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String f = formatter.format(now);
            System.out.println(f);
            String temp = HTML.replace("hh:mm:ss", f);

            try (PrintWriter pw = new PrintWriter(new FileWriter("clock.html"))) {
                pw.printf(temp);
                pw.flush();
            }
        }
    }
}
