package pl.edu.agh.dp.Observer;

import java.util.Arrays;
import java.util.List;

public class ConsonantsObserver extends FileObserver {

    private final List<Character> consonants = Arrays.asList('B', 'C', 'D', 'F', 'G', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'S', 'T', 'V', 'X', 'Z', 'H', 'R', 'W', 'Y',
            'b', 'c', 'd', 'f', 'g', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 's', 't', 'v', 'x', 'z', 'h', 'r', 'w', 'y');

    public ConsonantsObserver(String fileName) {
        super(fileName);
    }

    @Override
    public void update(String sentence) {

        int consonantsInSentence = 0;

        for (int i = 0 ; i < sentence.length(); i++){
            if(consonants.contains(sentence.charAt(i))){
                consonantsInSentence++;
            }
        }

        writeToFile(String.valueOf(consonantsInSentence));
    }
}
