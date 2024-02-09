package collection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class ArrayListTest {
    @Test
    void should_transform_list_to_arrayList() {
            // When
            int[] arrayNumbers = {1,2,3};

            // Given
            Converter converter = new Converter();
            List<Integer> convert = converter.convertToArrayList(arrayNumbers);

            List<Integer> expectedList = new LinkedList<>();
            expectedList.add(1);
            expectedList.add(2);
            expectedList.add(3);

            // Then
            assertThat(convert).isEqualTo(expectedList);

        }

    @Test
    void should_reverse_a_list() {
        // Given
        List<String> animals = new ArrayList<>();
        animals.add("dog");
        animals.add("cat");
        animals.add("cat");
        animals.add("gees");
        animals.add("cat");

        // When
        Collections.reverse(animals);

        List<String> reversedAnimals = new ArrayList<>();
        reversedAnimals.add("cat");
        reversedAnimals.add("gees");
        reversedAnimals.add("cat");
        reversedAnimals.add("cat");
        reversedAnimals.add("dog");

        // Then
        assertThat(reversedAnimals).isEqualTo(animals);
        //assertThat(reversedAnimals.indexOf("cat")).isEqualTo(1);
        assertThat(reversedAnimals.lastIndexOf("cat")).isEqualTo(3);
    }

    @Test
    void should_be_immutable() {
        List<String> animals = new ArrayList<>();
        animals.add("dog");
        animals.add("cat");
        animals.add("cat");
        animals.add("gees");
        animals.add("cat");

        List<String> strings = Collections.unmodifiableList(animals);


    }

}
