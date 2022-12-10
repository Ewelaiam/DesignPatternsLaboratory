package pl.edu.agh.dp;

import java.io.FileWriter;
import java.io.IOException;

public abstract class FileObserver {

    protected FileWriter fileWriter;

    public FileObserver(String fileName){
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public abstract void update(String sentence);

    public void writeToFile(String value){
        try {
            fileWriter.append(value).append("\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
