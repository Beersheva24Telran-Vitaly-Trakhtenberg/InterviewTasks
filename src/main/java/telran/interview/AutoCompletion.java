package telran.interview;

import java.util.*;

public class AutoCompletion
{
    private final LinkedHashSet<String> words = new LinkedHashSet<>();

    public boolean addWord(String word)
    {
        return words.add(word);
    }

    public String [] getVariants(String prefix)
    {
        List<String> variants = new ArrayList<>();
        String lower_prefix = prefix.toLowerCase();
        for (String word : words) {
            if (word.toLowerCase().startsWith(lower_prefix)) {
                variants.add(word);
            }
        }
        variants.sort(String.CASE_INSENSITIVE_ORDER);
        return variants.toArray(new String[0]);
    }
}
