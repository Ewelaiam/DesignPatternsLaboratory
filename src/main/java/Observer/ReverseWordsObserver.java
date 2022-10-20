package Observer;

public class ReverseWordsObserver extends FileObserver{
    public ReverseWordsObserver(String fileName) {
        super(fileName);
    }
    @Override
    public void update(String sentence) {
        StringBuilder word = new StringBuilder();
        String newSentence = "";
        boolean isPreviousCharacterALetter = false;
        int eof = sentence.length() - 1;
        char[] characters = sentence.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i]) && i != eof) {
                isPreviousCharacterALetter = true;
                word.append(characters[i]);
            } else if (!Character.isLetter(characters[i]) && isPreviousCharacterALetter) {
                word.reverse();
                newSentence += word + " ";
                word = new StringBuilder();
                isPreviousCharacterALetter = false;
            } else if (Character.isLetter(characters[i]) && i == eof) {
                word.append(characters[i]);
            }
        }

        writeToFile(newSentence);
    }
}
