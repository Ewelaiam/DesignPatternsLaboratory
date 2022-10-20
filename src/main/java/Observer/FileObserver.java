package Observer;

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

    public void writeToFile(int value){
        try {
            fileWriter.append(String.valueOf(value)).append("\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
