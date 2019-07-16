/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai01_docghifile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class NewClass {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("C:\\Users\\Admin\\Desktop\\File CSV\\17hcb.csv");
        BufferedReader br = new BufferedReader(fr);
        String [] NameSv;
        //String [][] dataSV;
          String line = br.readLine();
          NameSv=line.split(",");
          for(int a=0;a<NameSv.length;a++){
              System.out.println(NameSv[a]);
          }
          System.out.println(line);
             System.out.println("aaa");
          line = br.readLine();
            while(line != null){
                System.out.println(line);
                line =br.readLine();
            }
        br.close();
        fr.close();

    }
    
}
