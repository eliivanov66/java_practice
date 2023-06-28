import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyHash {
        public static String hash(String password) throws NoSuchAlgorithmException{
            MessageDigest md = MessageDigest.getInstance("SHA-256"); //"MD5"
            //md.update(password.getBytes());
            byte[] digest = md.digest(password.getBytes());
            
            BigInteger bigInt = new BigInteger(1, digest);
            String md5Hex = bigInt.toString(16);

            while( md5Hex.length() < 32 ){
                md5Hex = "0" + md5Hex;
            }
            System.out.println(md5Hex);
            return md5Hex;

        } 

}
