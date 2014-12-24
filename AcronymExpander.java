import java.util.Scanner;

public class AcronymExpander {

    static final String[] acronyms = {"lol", "dw", "hf", "gg", "brb", "g2g", "wtf", "wp", "gl", "imo"};
    static final String[] expandedAcronyms = {"laugh out loud", "don't worry", "have fun", "good game", "be right back",
            "got to go", "what the fuck", "well played", "good luck", "in my opinion"};

    public static String expand(String input) {
        String[] splitWords = input.split(" ");
        for (int i = 0; i < splitWords.length; i++) {
            String testWord = splitWords[i];
            String last = " ";
            if(splitWords[i].matches("(.*)[.,:;!]")) {
                testWord = splitWords[i].substring(0, splitWords[i].length() - 1);
                last = splitWords[i].substring(splitWords[i].length() - 1, splitWords[i].length());
            }
            for (int j = 0; j < acronyms.length; j++) {
                if (testWord.equalsIgnoreCase(acronyms[j])) {
                    testWord = expandedAcronyms[j];
                }
            }
            if (last != " ") testWord += last;
            splitWords[i] = testWord;
        }
        StringBuilder builder = new StringBuilder();
        for(String s : splitWords) {
            builder.append(s + " ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a phrase with acronyms: ");
        String input = scanner.nextLine();
        System.out.println(expand(input));
    }
}
