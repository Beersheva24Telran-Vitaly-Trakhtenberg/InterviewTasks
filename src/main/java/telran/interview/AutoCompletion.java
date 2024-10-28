package telran.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AutoCompletion
{
    private HashSet<String> words = new HashSet<>();

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
        return variants.reversed().toArray(new String[0]);
    }
}
