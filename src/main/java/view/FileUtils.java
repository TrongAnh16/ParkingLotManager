package view;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static FileUtils instance;
    private FileUtils(){}
    public static FileUtils getInstance(){
        if (instance==null) return new FileUtils();
        return instance;
    }
    public List<String> readData(String path){
        List<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine())!=null){
                lines.add(line);
            }
            br.close();
            fileReader.close();
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeData(String path, List<String> data) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (String line : data) {
                bw.write(line+"\n");
            }
            bw.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
