import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = UI.in("Введите путь к директории для создания резервной копии");
        MyDirectoryHandler.backup(path);
    }
}