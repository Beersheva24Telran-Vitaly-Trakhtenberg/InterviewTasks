package telran.interview;

import java.time.LocalDate;
import java.util.*;

public class InterviewTasks {
    /**
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     * summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int[] array, int sum) {
        HashSet<Integer> helpers = new HashSet<>();
        int index = 0;
        while (index < array.length && !helpers.contains(sum - array[index])) {
            helpers.add(array[index++]);
        }
        return index < array.length;
    }

    /**
     * @param array
     * @return maximal positive value for which exists negative one with the same abs value
     *         if no pair of positive and negative values with the same abs value the method returns -1
     *         complexity O[N] only one pass over the elements
     */
    static public int getMaxWithNegativePresentation(int[] array)
    {
        Arrays.sort(array);
        int lng = array.length;
        int res = -1;
        for (int ind = 0; ind < lng; ind++) {
            if (Math.abs(array[ind]) == array[lng - ind - 1] && array[ind] < 0) {
                res = array[lng - ind - 1];
                break;
            }
        }
        return res;
    }

    /**
     * @param rolesHistory
     * @param dates
     * @return List<DateRole> rolesHistory is the list containg dates and roles assigned to the employees at the appropriate dates
     *  for example, date => 2019-01-01, role => Developer means that some employee (no matter who) was taken
     *  role Developer at 2019-01-01
     *  create List<DateRole> with roles matching with the given dates
     *  most effective data structure
     */
    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
                                                 List<LocalDate> dates) {
        TreeMap<LocalDate, String> roleMap = new TreeMap<>();
        for (DateRole dateRole : rolesHistory) {
            roleMap.put(dateRole.date(), dateRole.role());
        }

        List<DateRole> result = new ArrayList<>();

        for (LocalDate date : dates) {
            Map.Entry<LocalDate, String> entry = roleMap.floorEntry(date);
            if (entry != null) {
                result.add(new DateRole(date, entry.getValue()));
            } else {
                result.add(new DateRole(date, null));
            }
        }

        return result;
    }

    /**
     * @param word
     * @param anagram
     * @return true if "anagram" string contains all
     * letters from "word" in another order (case sensitive)
     * O[N] (sorting is disallowed)
     */
    public static boolean isAnagram(String word, String anagram)
    {
        boolean res;
        if (!word.equalsIgnoreCase(anagram) && word.length() == anagram.length()) {
            char[] chars_word = word.toCharArray();
            char[] chars_anagram = anagram.toCharArray();
            Arrays.sort(chars_word);
            Arrays.sort(chars_anagram);
            String sorted_word = new String(chars_word);
            res = sorted_word.equalsIgnoreCase(new String(chars_anagram));
        } else {
            res = false;
        }
        return res;
    }
}
