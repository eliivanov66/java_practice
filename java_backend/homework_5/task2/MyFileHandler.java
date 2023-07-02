import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class MyFileHandler {
    private File fileStorage;
    private String info;
    public MyFileHandler(String argFilePath, String argInfo) throws IOException{
        this.fileStorage = new File(argFilePath);
        if (! this.fileStorage.exists()) {
            this.fileStorage.createNewFile();
        }
        this.info = argInfo;
    }

    public String info(){
        return this.info;
    }

    public String read(int argLineNumber) throws IOException{
        BufferedReader fileStream = new BufferedReader(new FileReader(this.fileStorage));
        String line;
        List<String> lines = (fileStream.lines().toList());
        if (argLineNumber  < lines.size() && argLineNumber  >= 0) {
            line = lines.get(argLineNumber);
        } else {
            line = null;
        }
        fileStream.close();
        return line;
    }

    public void edit(int argLineNumber, String argLine) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.fileStorage));
        for (int i = 0; i < lines.size(); i++) {
            if (i == argLineNumber) {
                fileStream.append(argLine);
                fileStream.newLine();
            }
            else {
                fileStream.append(lines.get(i));
                fileStream.newLine();
            }
        }
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }

    public void insert(int argLineNumber, String argLine) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.fileStorage));
        for (int i = 0; i < lines.size(); i++) {
            if (i == argLineNumber) {
                fileStream.append(lines.get(i));
                fileStream.newLine();
                fileStream.append(argLine);
                fileStream.newLine();
            }
            else {
                fileStream.append(lines.get(i));
                fileStream.newLine();
            }
        }
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }

    public void delete(int argLineNumber) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.fileStorage));
        for (int i = 0; i < lines.size(); i++) {
            if (i != argLineNumber) {
                fileStream.append(lines.get(i));
                fileStream.newLine();
            }
        }
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }

    public void write(String argLine) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.fileStorage));
        for (String line : lines) {
            fileStream.append(line);
            fileStream.newLine();
        }
        fileStream.write(argLine);
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }
    
    public void clear() throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.fileStorage));
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }

    public int find(String argLine) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        int tempOut = -1;
        for (String line : lines) {
            if (line.contains(argLine)) tempOut = lines.indexOf(line);
        }
        tempReader.close();
        return tempOut;
    }

    public int size() throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        tempReader.close();
        return lines.size();
    }

    public void copy(MyFileHandler argIn) throws IOException{
        
        BufferedReader tempReader = new BufferedReader(new FileReader(argIn.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.fileStorage));
        this.clear();
        for (String line : lines) {
            fileStream.append(line);
            fileStream.newLine();
        }
        fileStream.newLine();
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }

    public static void copy(MyFileHandler argIn1, MyFileHandler argIn2) throws IOException{
        
        BufferedReader tempReader = new BufferedReader(new FileReader(argIn2.fileStorage));
        List<String> lines2 = (tempReader.lines().toList());
        tempReader.close();
        
        tempReader = new BufferedReader(new FileReader(argIn1.fileStorage));
        List<String> lines1 = (tempReader.lines().toList());
        tempReader.close();


        BufferedWriter fileStream = new BufferedWriter(new FileWriter(argIn1.fileStorage));

        for (String line : lines1) {
            fileStream.append(line);
            fileStream.newLine();
        }

        for (String line : lines2) {
            fileStream.append(line);
            fileStream.newLine();
        }

        fileStream.newLine();
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }
}
