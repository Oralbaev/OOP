import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindText {

    private String fileName = "gettys.html";
    private Pattern pattern;
    private Matcher matcher;

    public static void main(String[] args) {
        FindText find = new FindText();
        find.run();
    }

    public void run() {
        pattern = Pattern.compile("\\B^</");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            int c = 1;
            while ((line = reader.readLine()) != null) {
                matcher = pattern.matcher(line);
                
                if (matcher.find())
                    System.out.println(c + "   " + line);

                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
