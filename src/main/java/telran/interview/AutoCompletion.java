package telran.interview;

import java.util.*;

public class AutoCompletion
{
    private LinkedHashSet<String> words = new LinkedHashSet<>();

    public boolean addWord(String word)
    {
        return words.add(word);
    }

    public String [] getVariants(String prefix)
    {
        List<String> variants = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().startsWith(prefix.toLowerCase())) {
                variants.add(word);
            }
        }
        Collections.sort(variants, String.CASE_INSENSITIVE_ORDER);
        return variants.toArray(new String[0]);
    }
}
