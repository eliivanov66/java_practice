import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyHash {
        public static String hash(String password) throws NoSuchAlgorithmException{
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            //md.update(password.getBytes());
            byte[] digest = md.digest(password.getBytes());

            char[] temp = new char[digest.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = (char)(digest[i]);
            }

            String myHash = new String(temp);
            myHash = new String(digest);

            return myHash;
        } 

}
