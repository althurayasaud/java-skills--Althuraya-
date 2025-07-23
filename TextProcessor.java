public class TextProcessor {

    // count words
    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // replace all occurrences of a word
    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null || oldWord == null || newWord == null) {
            return text;
        }
        return text.replaceAll("\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {
        String sentence = "The Java is fun and Java is powerful";

        // Count words
        int wordCount = countWords(sentence);
        System.out.println("Word Count: " + wordCount);

        // Replace word
        String replacedText = replaceWord(sentence, "Java", "Programming");
        System.out.println("Replaced the Text: " + replacedText);
    }
}

