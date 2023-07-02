import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] field = new int[3][3];
        MyFileHandler saveFile = new MyFileHandler("saveFile", "Файл сохранения");
        UI.display(field);
        
        saveFile.clear();
        for (int[] integers : field) {
            saveFile.write(Arrays.toString(integers));
        }
    }
}