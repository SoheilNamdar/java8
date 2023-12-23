package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerShould {
    @Test
    void take_entries_and_return_nothing() {
        List<Integer> listNumbers = new LinkedList<>();
        listNumbers.add(1);
        listNumbers.add(2);

        Consumer<? super Integer> consumer = System.out::println;
        listNumbers.forEach(consumer);
    }
}
