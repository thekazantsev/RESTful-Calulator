public class WordsCount {

    public static void main(String[] args) {
        String stringLine = "one two three one five seven two one nine one";

        String[] words = stringLine.split(" ");

        for (int i = 0; i < words.length; i++) {
            int wordAmount = 1;
            for (int j = i+1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    wordAmount ++;
                }
            }
            System.out.println(words[i] + " - " + wordAmount);
            wordAmount = 1;

        }

    }
}
