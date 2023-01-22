using System.IO;
using System.Text;
public abstract class BaseFileHandler {
    private string info;
    private string filePath;

    private string fileStart;

    private string fileEnd;

    
    public BaseFileHandler(string argFilePath, string argFileStart, string argFileEnd, string argInfo) {  
        this.info = argInfo;
        this.filePath = argFilePath;
        this.fileStart = argFileStart;
        this.fileEnd = argFileEnd;
        if (! File.Exists(argFilePath)) {
            FileStream fileStorage = File.Create(argFilePath);
            fileStorage.Close();
            this.Clear();
        } 
    }

    public string Info(){
        return this.info;
    }

    public string Read(int argLineNumber){       
        string tempLine;
        string[] tempLines = File.ReadAllLines(this.filePath);
        tempLine = tempLines[argLineNumber -1];
        return tempLine;
    }

    public void Edit(int argLineNumber, string argLine){
        string[] tempLines = File.ReadAllLines(this.filePath);
        tempLines[argLineNumber - 1] = argLine;
        StringBuilder builder = new StringBuilder();
        foreach (string tempLine in tempLines) {
            builder.Append(String.Format("{0}\n", tempLine));
        }
        File.WriteAllText(this.filePath, builder.ToString());
    }

    public void Insert(int argLineNumber, string argLine){
        string[] tempLines = File.ReadAllLines(this.filePath);
        List<string> outLines = tempLines.ToList();
        outLines.Insert(argLineNumber - 1, argLine);
        StringBuilder builder = new StringBuilder();
        foreach (string tempLine in outLines) {
            builder.Append(String.Format("{0}\n", tempLine));
        }
        File.WriteAllText(this.filePath, builder.ToString());
    }

    public void Delete(int argLineNumber){
        string[] tempLines = File.ReadAllLines(this.filePath);
        StringBuilder builder = new StringBuilder();
        List<string> outLines = tempLines.ToList();
        outLines.RemoveAt(argLineNumber - 1);
        foreach (string tempLine in outLines) {
            builder.Append(String.Format("{0}\n", tempLine));
        }
        File.WriteAllText(this.filePath, builder.ToString());
    }

    public void Write(string argLine){
        string[] tempLines = File.ReadAllLines(this.filePath);
        string[] outLines = new string[tempLines.Length + 1];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tempLines.Length - 1; i++)
        {
            outLines[i] = tempLines[i];
        }
        outLines[tempLines.Length - 1] = argLine;
        outLines[tempLines.Length] = tempLines[tempLines.Length - 1];
        foreach (string tempLine in outLines) {
            builder.Append(String.Format("{0}\n", tempLine));
        }
        File.WriteAllText(this.filePath, builder.ToString());
    }
    
    public void Clear(){
        StringBuilder builder = new StringBuilder();
        builder.Append(String.Format("{0}\n", this.fileStart));
        builder.Append(String.Format("{0}\n", this.fileEnd));
        File.WriteAllText(this.filePath, builder.ToString());
    }

    public int Find(string argLine){
        int tempFind = -1;
        string[] tempLines = File.ReadAllLines(this.filePath);
        for (int i = 0; i < tempLines.Length; i++)
        {
            if (argLine.Equals(tempLines[i])) {
                tempFind = i + 1;
            }
        }
        return tempFind;
    }

    public int Size(){
        string[] tempLines = File.ReadAllLines(this.filePath);
        return tempLines.Length;
    }

    public void Copy(BaseFileHandler argIn){
        this.Clear();
        for (int i = 2; i < argIn.Size(); i++) {
            this.Insert(this.Size(), this.formData(argIn.extractData(argIn.Read(i))));
         }
    }

    abstract public string formData(Contact argIn);
    
    abstract public Contact extractData(string argIn);
}