package Crypto;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.awt.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFrame;
public class EncrypterDecrypter extends JFrame
{
	File encryptedFile;
	File decryptedFile;
	
	public EncrypterDecrypter(File input,int mode)
	 {
		JFrame frame =new JFrame();
	String fname = input.getName();
	String key = "This is a secret";
	File inputFile = input;
    encryptedFile = new File("E:\\",fname);
	
	System.out.println("File name "+fname);
	try
	{
	 decryptedFile = new File("E:\\",fname+".dec");
	}
	catch(Exception ex)
	{
		System.out.println("File Not Found");
	}
	try 
	 {
		 if(mode==1)
		 {
			 
	     EncrypterDecrypter.fileProcessor(Cipher.ENCRYPT_MODE,key,inputFile,encryptedFile);
		 JOptionPane.showMessageDialog(null,"File Encrypted Sucessfully");
		 //System.out.println("Encrypted Sucessfully");
		 }
		 else if(mode==2)
		 {
	    
	      EncrypterDecrypter.fileProcessor(Cipher.DECRYPT_MODE,key,encryptedFile,decryptedFile);
	      //System.out.println("Decrypted Sucessfully");
		  JOptionPane.showMessageDialog(frame, "File decrypted Sucessfully  \n" );
		 }
	 
	 } 
	 catch (Exception ex)
	 {
	         System.out.println(ex.getMessage());
             ex.printStackTrace();
	 }
    }
	
	
 public static void fileProcessor(int cipherMode,String key,File inputFile,File outputFile)
   {
	   System.out.println("Cipher mode "+cipherMode);
	 try
	 {
	       Key secretKey = new SecretKeySpec(key.getBytes(),"AES");
	       Cipher cipher = Cipher.getInstance("AES");
	       cipher.init(cipherMode, secretKey);

	       FileInputStream inputStream = new FileInputStream(inputFile);
	       byte[] inputBytes = new byte[(int) inputFile.length()];
	       inputStream.read(inputBytes);

	       byte[] outputBytes = cipher.doFinal(inputBytes);

	       FileOutputStream outputStream = new FileOutputStream(outputFile);
	       outputStream.write(outputBytes);

	       inputStream.close();
	       outputStream.close();
           System.out.println("Suceed in Encryption.. ");
	  }
		catch (Exception e)
     		 {
	         	e.printStackTrace();
             }
     }
}