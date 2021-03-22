package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 *
 * @author Fachri
 */
public class CopyFile {
    public static void main(String[] args)
    {
   
        boolean success = false;
        Scanner scan = new Scanner(System.in);
        String val;
        Scanner isThere = null;
        
        while(!success){
            /* Masukkan nama file, tanpa ekstensi apapun. */
            System.out.print("Enter File Name: ");
            val = scan.next();
            File file = new File(val);
            
            /* Cek apakah ada file yang diinputkan */
            try{
                isThere = new Scanner(file);
            }catch(FileNotFoundException e){
                 System.out.println("File Tidak Ditemukan, Coba lagi.");
            }
            
            /* Jika ada, copy file menjadi file baru dengan format : "'namafile'+2" */
            if(isThere != null){
                try {
                    /* Buat file 2 */
                    File file2 = new File(val+"2");
                    
                    /* Copy file awal ke file2, apabila sudah ada dengan nama sama, di replace. */
                    Files.copy(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    System.out.println("Gagal Copy File.");
                }
                success = true;
            }
        }
        
    }
}
