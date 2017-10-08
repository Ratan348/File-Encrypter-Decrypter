package MinorProjectUI;

import Crypto.EncrypterDecrypter;

import javax.swing.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.border.Border;

import java.security.NoSuchAlgorithmException;
import java.security.Key;
import java.security.InvalidKeyException;
import java.io.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class CloseMe extends WindowAdapter
{
  public void windowClosing(WindowEvent e)
  {
    System.exit(0);
  }
}

public class UIClient implements ActionListener
{
 JFrame frame1 ;
 JButton jb1,jb2;
 String key;
 JLabel l;
 JLabel l2,l3,l4,l5;
 public UIClient()
 {
   frame1 =new JFrame("Encrypter-Decrypter (Minor Project) ");
   frame1.setResizable(false);
   Container c = frame1.getContentPane();
   jb1=new JButton("Encrypt my files");
   jb2=new JButton("Decrypt my files");
   l=new JLabel("Welcome to File Encryption Decryption application... ");
   l2=new JLabel("Files considered are :");
   l3=new JLabel("1. Text Document");
   l4=new JLabel("2. Audio");
   l5=new JLabel("3. Video");
   c.add(l);
   c.add(l2);
   c.add(l3);
   c.add(l4);
   c.add(l5);
   c.add(jb1);
   c.add(jb2);
   frame1.setSize(650,600);
   frame1.setVisible(true);
   frame1.setLayout(null);
   c.setBackground(new Color(112,128,144));

   l.setBounds(10,-220,600,550);
   l2.setBounds(150,80,200,100);
   l3.setBounds(200,110,200,100);
   l4.setBounds(200,130,200,100);
   l5.setBounds(200,150,200,100);
   jb1.setBounds(100,400,150,50);
   jb2.setBounds(350,400,150,50); 
   jb1.setFont(new Font("Arial", Font.BOLD, 15));
   jb2.setFont(new Font("Arial", Font.BOLD, 15));
   l.setFont(new Font("Cooper Black",Font.BOLD , 20));
   
   l2.setFont(new Font("Bank Gothic",Font.PLAIN , 20));
   
   l3.setFont(new Font("Garamond",Font.PLAIN , 20));
   l4.setFont(new Font("Garamond",Font.PLAIN , 20));
   l5.setFont(new Font("Garamond",Font.PLAIN , 20));
   
   
   
   jb1.setBackground(Color.lightGray);
   jb2.setBackground(Color.lightGray);
 
   jb1.addActionListener(this);
   jb2.addActionListener(this);
    
   CloseMe cm = new CloseMe();
   frame1.addWindowListener(cm);
   
   
 }
 public void actionPerformed(ActionEvent ae)
 {
   	 if(ae.getSource()==jb1)         // if block will execute when Encrypt is clicked.
	 {
		 frame1.setVisible(false);
		 
		 JFileChooser fc=new JFileChooser();    
         int i=fc.showOpenDialog(null);    
	
              if(i==JFileChooser.APPROVE_OPTION)
	           {    
                File f=fc.getSelectedFile();    
                String filepath=f.getPath();
                String filename = fc.getSelectedFile().getPath();
                JOptionPane.showMessageDialog(null, "Press OK to Encrypt  \n" + filename);
	//The line Below will invoke Encrypt method 		    
				EncrypterDecrypter EDE = new EncrypterDecrypter(f,Cipher.ENCRYPT_MODE);
			 
				frame1.setVisible(true);
               }		 
	 }                                 // end of Encrypt button function
	 
	 else if(ae.getSource()==jb2)    // This will execute When Decrypt is clicked.
	 {
		 frame1.setVisible(false);
		 
		 JFileChooser fc=new JFileChooser();    
         int i=fc.showOpenDialog(null);    
	
         if(i==JFileChooser.APPROVE_OPTION)
	      {    
          File f=fc.getSelectedFile();    
          String filepath=f.getPath();
          String filename = fc.getSelectedFile().getPath();
          JOptionPane.showMessageDialog(null, "Press OK to Decrypt \n " + filename);			                 
    // The Line Below will invoke Decrypt Method      
		  EncrypterDecrypter EDD = new EncrypterDecrypter(f,Cipher.DECRYPT_MODE);
		  
		  frame1.setVisible(true);
	      }
	 }
	 
	 
	 
 
 }
 
 }

