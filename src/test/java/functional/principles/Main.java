package functional.principles;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        method(numbers);
    }

    private static void method(List<Object> numbers) {
        numbers.forEach(System.out::println);
    }
}
