package service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import service.ISorter;

/**
 * Class responsible for sorting names.
 */
public class PersonNameSorter implements ISorter<List<String>> {

    /**
     * Sorting names in list, giving priority to lastName and then givenNames.
     *
     * @param input
     * @return List of sorted names
     */
    @Override
    public List<String> sort(List<String> input) {
        List<String> sortedList = new ArrayList<>(input);
        sortedList.sort(Comparator.comparing((String name) -> {
            String[] nameSection = name.split(" ");
            String lastName = nameSection[nameSection.length - 1];
            String givenNames = String.join(" ", Arrays.copyOf(nameSection, nameSection.length - 1));
            return lastName + " " + givenNames;
        }));
        return sortedList;
    }
}
