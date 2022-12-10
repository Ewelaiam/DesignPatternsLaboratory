package pl.edu.agh.dp;

public class WordsObserver extends FileObserver {
    public WordsObserver(String fileName) {
        super(fileName);
    }

    @Override
    public void update(String sentence) {
        int wordsInSentence = 0;
        boolean isPreviousCharacterALetter = false;
        int eof = sentence.length() - 1;
        char[] characters = sentence.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i]) && i != eof) {
                isPreviousCharacterALetter = true;
            } else if (!Character.isLetter(characters[i]) && isPreviousCharacterALetter) {
                wordsInSentence++;
                isPreviousCharacterALetter = false;
            } else if (Character.isLetter(characters[i]) && i == eof) {
                wordsInSentence++;
            }
        }

        writeToFile(String.valueOf(wordsInSentence));


    }
}
