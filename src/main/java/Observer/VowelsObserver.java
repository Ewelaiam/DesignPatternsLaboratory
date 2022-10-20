package Observer;

import java.util.Arrays;
import java.util.List;

public class VowelsObserver extends FileObserver {
    private final List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public VowelsObserver(String fileName) {
        super(fileName);
    }

    @Override
    public void update(String sentence) {
        int vowelsInSentence = 0;

        for (int i = 0 ; i < sentence.length(); i++){
            if(vowels.contains(sentence.charAt(i))){
                vowelsInSentence++;
            }
        }

        writeToFile(vowelsInSentence);
    }
}
