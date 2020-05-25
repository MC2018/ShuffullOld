package shuffull;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MC_2018 <mc2018.git@gmail.com>
 */
public class Utilities {

    public static String read(File file) {
        StringBuilder result = new StringBuilder("");
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String buffer;
            
            while ((buffer = br.readLine()) != null) {
                result.append(buffer);
            }
            
            br.close();
            fr.close();
            return result.toString();
        } catch (IOException e) {
            return result.toString();
            //e.printStackTrace();
            //throw new RuntimeException(e.getLocalizedMessage());
        }
    }
    
    public static List<String> readLines(File file) {
        try {
            return Files.readLines(file, Charsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void write(File file, String info) {
        verifyFilePathExists(file);
        
        try {
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(info);
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
    
    public static void verifyDirectoryExists(File directory) {
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
    
    public static void verifyFilePathExists(File file) {
        File directory;
        String path = file.getAbsolutePath().replaceAll("\\\\", "/");
        String[] folderSeparation = path.split("/");
        StringBuilder directoryBuilder = new StringBuilder("");
        
        for (int i = 0; i < folderSeparation.length - 1; i++) {
            directoryBuilder.append(folderSeparation[i]);
            directoryBuilder.append("/");
        }
        
        directory = new File(directoryBuilder.toString());
        
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
    
    public static String getCSVValueAtIndex(String csv, int index) {
        String[] values = csv.split(",");
        
        if (index < 0 || index >= values.length) {
            return null;
        }
        
        return values[index];
    }
    
    public static String buildCSV(String[] array) {
        String result = "";
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                result += array[i];
            }
            
            if (i + 1 < array.length) {
                result += ",";
            }
        }
        
        return result;
    }
    
}
