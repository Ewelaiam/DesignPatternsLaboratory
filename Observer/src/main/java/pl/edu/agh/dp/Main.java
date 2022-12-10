package pl.edu.agh.dp;

import pl.edu.agh.dp.*;

public class Main {
    public static void main(String[] args) {
        FileObserver fileObserver1 = new WordsObserver(Constants.OUT_PATH_WORDS);
        FileObserver fileObserver2 = new VowelsObserver(Constants.OUT_PATH_VOWELS);
        FileObserver fileObserver3 = new ConsonantsObserver(Constants.OUT_PATH_CONSONANTS);
        FileObserver fileObserver4 = new ReverseWordsObserver(Constants.OUT_PATH_REVERSE_WORDS);

        Subject subject = new Subject(Constants.DATA_PATH);
        subject.addObserver(fileObserver1);
        subject.addObserver(fileObserver2);
        subject.addObserver(fileObserver3);
        subject.addObserver(fileObserver4);

        subject.readSentencesInGivenFile();

    }
}
