import java.io.*;

public class MyDirectoryHandler {
    public static boolean isDirectory(String path){
        File temp = new File(path);
        return temp.isDirectory();

    }

    public static boolean delete(String path){
        File temp = new File(path);
        if (temp.isDirectory()) {
            return temp.delete();
        }
        return false;
    }

    public static boolean copy(String path1, String path2) throws FileNotFoundException, IOException {
        File file1 = new File(path1);
        File file2 = new File(path2);
        if (isDirectory(path1)) {
            if (isDirectory(path2)) {
                file2.delete();
                file2.mkdir();  
            } else {
                file2.mkdir(); 
            }
            for (String string : file1.list()) {
                if ((new File(string)).isDirectory()){ //
                    //копирование директорий
                    if (! path2.contains(string)){
                        copy(path1 + "/" + string, path2 + "/" + string);
                    }
                    
                } else {
                    //копирование файлов
                    FileInputStream in = new FileInputStream(file1.getAbsolutePath() + "/" + string);
                    FileOutputStream out = new FileOutputStream(file2.getAbsolutePath() + "/" + string);
                    in.transferTo(out);
                    in.close();
                    out.close();
                }
            }
            return true;
             
        } else {
            return false;
        }
    }

    public static boolean backup(String path) throws FileNotFoundException, IOException{
        return copy(path, "./backup");
    }
}
