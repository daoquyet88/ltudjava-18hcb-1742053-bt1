/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai01_docghifile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class xoaNoiDung {

    public static void main(String args[]) throws IOException {
       
         String p="D:\\test1.txt";
         String dataSV[];
        ArrayList<String> ar=new ArrayList<String>();
        FileReader fr = new FileReader(p);
        BufferedReader br = new BufferedReader(fr);
        String  line = br.readLine();
          while(line != null){
              //dataSV=line.split(",");
//               dtm.addRow(new Object[]{dataSV[0],dataSV[1],dataSV[2],dataSV[3],dataSV[4]});
              ar.add(line);
              line =br.readLine();
          }
          
        for(String s : ar){
            System.out.println("kq"+s);
        }
        br.close();
        fr.close();
        
        FileWriter fw = new FileWriter(p);
        BufferedWriter bw = new BufferedWriter(fw);  
        for(String s : ar){
            if(s.equals("222"))
            {
                 System.out.println("kq"+s);
            }
            else{
                bw.write(s);
                bw.newLine();
            }
        }
        bw.close();
        fw.close();
        
    }
}
