import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

public class Packer{



    public static String pack(Serializable object) throws IOException{
        String fileName = object.getClass() + " " + UUID.randomUUID().toString() + ".packer";
        File dataFile = new File(fileName);
        if (!dataFile.exists()){
            dataFile.createNewFile();
        } else {
            dataFile.delete();
            dataFile.createNewFile();
        }

        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(dataFile));
        stream.writeObject(object);
        stream.close();
        return fileName; 
    }

    public static Serializable unpack(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
        File dataFile = new File(fileName);
        if (!dataFile.exists()){
            return null;
        } else {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(dataFile));
            Serializable object = (Serializable) stream.readObject();
            stream.close();
            dataFile.delete();
            return (object);
        }
        
    }


}