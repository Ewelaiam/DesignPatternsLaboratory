package Observer;

public class Main {
    public static void main(String[] args) {
        FileObserver fileObserver1 = new WordsObserver(Constants.OUT_PATH_WORDS);
        FileObserver fileObserver2 = new VowelsObserver(Constants.OUT_PATH_VOWELS);
        FileObserver fileObserver3 = new ConsonantsObserver(Constants.OUT_PATH_CONSONANTS);

        Subject subject = new Subject(Constants.DATA_PATH);
        subject.addObserver(fileObserver1);
        subject.addObserver(fileObserver2);
        subject.addObserver(fileObserver3);

        subject.readSentencesInGivenFile();

    }
}
