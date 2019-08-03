/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai01_docghifile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ghieFile {
    public static void main(String[] args) throws IOException {
         File f = new File("d:\\aaa.txt");
          FileWriter fw=new FileWriter(f.getAbsoluteFile(), true);
          BufferedWriter bw=new BufferedWriter(fw);     
            bw.write("aaaa");
           bw.newLine();          
          bw.close();
          fw.close();
         
      }
        
}
    

