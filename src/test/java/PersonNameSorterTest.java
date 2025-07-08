import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.impl.PersonNameSorter;


/**
 * Test class for PersonNameSorter.
 */
public class PersonNameSorterTest {

    private PersonNameSorter sorter;

    @BeforeEach
    void setUp() {
        sorter = new PersonNameSorter();
    }

    @Test
    void testSort_ReturnsSortedListByLastName() {
        List<String> input = Arrays.asList("Janet Parsons", "Vaughn Lewis", "Marin Alvarez", "London Lindsey");

        List<String> expected = Arrays.asList("Marin Alvarez", "Vaughn Lewis", "London Lindsey", "Janet Parsons");

        List<String> result = sorter.sort(input);
        assertEquals(expected, result);
    }

    @Test
    void testSort_WithSingleName() {
        List<String> input = List.of("Janet Parsons");

        List<String> result = sorter.sort(input);
        assertEquals(input, result);
    }

    @Test
    void testSort_EmptyList_ReturnsEmptyList() {
        List<String> result = sorter.sort(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void testSort_NamesWithSameLastName_SortedByGivenNames() {
        List<String> input = Arrays.asList("Zack Smith", "Anna Smith", "John Smith");

        List<String> expected = Arrays.asList("Anna Smith", "John Smith", "Zack Smith");

        List<String> result = sorter.sort(input);
        assertEquals(expected, result);
    }
}
