/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypairgeneratorfinal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Class for the generation of the public/private key pair
 * @author nerea
 */
public class KeyPairGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
			
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
			
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
			
            X509EncodedKeySpec pubspec = new X509EncodedKeySpec(publicKey.getEncoded());
            FileOutputStream fos1 = new FileOutputStream("public.key");
            fos1.write(pubspec.getEncoded());
			
            PKCS8EncodedKeySpec prispec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
            FileOutputStream fos2 = new FileOutputStream("private.key");
            fos2.write(prispec.getEncoded());
           
	} catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	}
    }
    
    
    
}
