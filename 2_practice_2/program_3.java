import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class program_3 {
    public static void main(String[] args) throws IOException {
        StringBuilder myBuilder = new StringBuilder();
        File myFile = new File("program_3.txt");
        try (FileWriter myFw = new FileWriter(myFile)) {
            for (int i = 0; i < 100; i++) {
                myBuilder.append("Test");
                myBuilder.append("\n");
            }

            try {
                myFw.append(myBuilder.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
