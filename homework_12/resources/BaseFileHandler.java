package resources;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public abstract class BaseFileHandler {
    private File fileStorage;
    
    public BaseFileHandler(String argFilePath) throws IOException{
        this.fileStorage = new File(argFilePath);
        if (! this.fileStorage.exists()) {
            this.fileStorage.createNewFile();
        }
    }

    public void SetFile(File argIn){
        this.fileStorage = argIn;
    }

    public String Read(int argLineNumber) throws IOException{
        BufferedReader fileStream = new BufferedReader(new FileReader(this.fileStorage));
        String line;
        List<String> lines = (fileStream.lines().toList());
        if (argLineNumber - 1 < lines.size() && argLineNumber - 1 >= 0) {
            line = lines.get(argLineNumber - 1);
        } else {
            line = null;
        }
        fileStream.close();
        return line;
    }

    public void Edit(int argLineNumber, String argLine) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.fileStorage));
        for (int i = 0; i < lines.size(); i++) {
            if (i + 1 == argLineNumber) {
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

    public void Insert(int argLineNumber, String argLine) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.fileStorage));
        for (int i = 0; i < lines.size(); i++) {
            if (i + 1 == argLineNumber) {
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

    public void Delete(int argLineNumber) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.fileStorage));
        for (int i = 0; i < lines.size(); i++) {
            if (i + 1 != argLineNumber) {
                fileStream.append(lines.get(i));
                fileStream.newLine();
            }
        }
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }

    public void Write(String argLine) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.fileStorage));
        for (String line : lines) {
            fileStream.append(line);
            fileStream.newLine();
        }
        fileStream.write(argLine);
        fileStream.newLine();
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }
    
    public void Clear() throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.fileStorage));
        for (int i = 0; i < lines.size(); i++) {
            if (i + 1 == 1 || i + 1 == lines.size()) {
                fileStream.append(lines.get(i));
                fileStream.newLine();
            }
        }
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }

    public int Find(String argLine) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        int tempOut = -1;
        for (String line : lines) {
            if (line.contains(argLine)) tempOut = lines.indexOf(line);
        }
        tempReader.close();
        return tempOut;
    }

    public int Size() throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.fileStorage));
        List<String> lines = (tempReader.lines().toList());
        tempReader.close();
        return lines.size();
    }

    public void Copy(BaseFileHandler argIn) throws IOException{
        this.Clear();
        for (int i = 0; i < argIn.Size(); i++) {
            this.Insert(this.Size() - 1, this.formData(argIn.extractData(argIn.Read(i))));
         }
    }

    abstract public String formData(GameData argIn);
    
    abstract public GameData extractData(String argIn);
}
