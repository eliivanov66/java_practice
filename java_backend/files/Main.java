import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        //task 1
        // MyFileHandler file1 = new MyFileHandler("inFile", "input file");
        // MyFileHandler file2 = new MyFileHandler("encrypted", "encrypted file");
        // MyFileHandler file3 = new MyFileHandler("decrypted", "decrypted file");
        // file2.clear();
        // file3.clear();

        // for (int i = 0; i < file1.size(); i++) {
            
        //     String tempEncrypt = file1.read(i);
        //     tempEncrypt = Cypher.encrypt(tempEncrypt, 3);
        //     file2.write(tempEncrypt);

        //     String tempDecrypt = file2.read(i);
        //     tempDecrypt = Cypher.dencrypt(tempDecrypt, 3);

        //     file3.write(tempDecrypt);

        // }
        
        //task 2
        
        MyFileHandler BD = new MyFileHandler("DB", "Файл типо база данных");
        String login = UI.in("Введите login: \n"); 
        String password = UI.in("Введите password: \n");
        String hashPassword = MyHash.hash(password);
        int lineNumber = BD.find(login);

        if (lineNumber == -1) { 
            BD.write(login + " " + hashPassword);
            UI.out("Login not existed, created new");
        } else {
            String readedHashPassword = BD.read(lineNumber).split(" ") [1];
            if (hashPassword.equals(readedHashPassword)) {
                UI.out("Login found, password accepted");
            } else {
                UI.out("Login found, but password declined");
            }
        }


    }
}