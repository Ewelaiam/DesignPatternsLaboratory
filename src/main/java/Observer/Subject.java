package Observer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<FileObserver> fileObservers;
    private FileReader fileReader;

    public Subject(String fileName) {
        fileObservers = new ArrayList<>();
        try {
            fileReader = new FileReader(fileName);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addObserver(FileObserver fileObserver) {
        if(fileObserver != null)
            this.fileObservers.add(fileObserver);
    }

    public void removeObserver(FileObserver fileObserver){
        if(fileObserver != null){
            this.fileObservers.remove(fileObserver);
        }
    }

    private void updateAll(String scanner) {
        for(FileObserver observer : fileObservers) {
            observer.update(scanner);
        }
    }

    public void readSentencesInGivenFile(){
        String sentence = "";
        while(true) {
            try {
                int ans = fileReader.read();
                if (ans == -1)
                    break;

                char c = (char)ans;
                sentence += c;
                if (c == '.' || c == '!' || c == '?'){
                    updateAll(sentence);
                    sentence = "";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
