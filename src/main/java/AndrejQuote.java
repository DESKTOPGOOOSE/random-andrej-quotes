import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AndrejQuote {
    public static void main(String[] args) throws Exception {
        String cd = System.getProperty("user.dir");
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL("https://raw.githubusercontent.com/DESKTOPGOOOSE/random-andrej-quotes/main/quotes.txt").openStream());
             FileOutputStream fileOS = new FileOutputStream(cd + "/quotes.txt")) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
        } catch (IOException e) {
            System.out.println("Java go boom boom");
        }

        // The main fucking thing of this stupid ass program
        BufferedReader reader = new BufferedReader(new FileReader(cd + "/quotes.txt"));
        List<String> lines = new ArrayList<String>();

        String line = reader.readLine();

        while ( line != null ) {
            lines.add(line);
            line = reader.readLine();
        }

        // Lets choose a random quote now!
        Random r = new Random();
        String randomQuote = lines.get(r.nextInt(lines.size()));
        System.out.println("Your Andrej Akan quote is: " + randomQuote);
    }
}
