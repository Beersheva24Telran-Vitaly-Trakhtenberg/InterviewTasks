package telran.interview;

import java.util.TreeSet;
import java.util.Set;

public class AutoCompletion {
    private final Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public boolean addWord(String word) {
        return words.add(word);
    }

    public String[] getVariants(String prefix) {
        return words.stream()
                .filter(word -> word.toLowerCase().startsWith(prefix.toLowerCase()))
                .toArray(String[]::new);
    }
}