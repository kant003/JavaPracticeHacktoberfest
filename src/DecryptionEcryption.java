
//We use "generateKey()" method to generate a secret key for AES algorithm with a given key
import java.util.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

 /**In the following example we use an algorithm called AES 128 and the bytes of the word "TheBestSecretKey" 
as the secret key 
* */
class AESencrp {
    
     private static final String ALGO = "AES";
    private static final byte[] keyValue = 
        new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',
'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };

public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
}

}
public class DecryptionEcryption {
    public static void main(String[] args) throws Exception {
        Scanner in=new Scanner(System.in);
        int ch;
        String password;
        while(true)
        {
            System.out.print("\n\nEnter choice:\n1.ENCRYPTION\n2.DECRYPTION\n3.QUIT\n:");
            ch=in.nextInt();
            switch(ch)
            {
                case 1:System.out.println("Enter Plain Text password :");password = in.next();
        String passwordEnc = AESencrp.encrypt(password);
        System.out.println("Encrypted Text : " + passwordEnc);
        break;
                case 2:
        System.out.println("Enter Encrypted password : ");password=in.next();
        String passwordDec = AESencrp.decrypt(password);
        System.out.println("Decrypted Text : " + passwordDec);
        break;
                case 3:return;
                default:System.out.println("Wrong choice!!");
    }
        }
    }
}
