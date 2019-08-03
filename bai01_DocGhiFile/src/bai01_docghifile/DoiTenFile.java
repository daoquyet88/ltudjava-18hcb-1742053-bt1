/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai01_docghifile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Admin
 */
public class DoiTenFile {
    public static void main(String[] args) {
//      File oldName = new File("D:/xxxx.txt");
//      File newName = new File("D:/yyyy.txt");
//      if(oldName.renameTo(newName)) {
//         System.out.println("renamed");
//      } else {
//         System.out.println("Error");
//      }
                String path="D:\\yyyy.txt";
                 Path source = Paths.get(path);
 
		// Destination file.
                 String fileKt="D:\\zz.txt";
		Path destination = Paths.get(fileKt);
		
		try {
			copyFile(source, destination);
		} catch (IOException e) {
			System.out.println("Lỗi Khi copy File");
			e.printStackTrace();
		}
        
    }
    public static void copyFile(Path source, Path destination) throws IOException {
		Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
	}
    
}
