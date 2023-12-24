package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

public class PredicatShould {
    @Test
    void take_a_type_as_entry_and_return_a_boolean() {
        int var = 8;

        Predicate<Integer> oddPredicate = integer -> integer % 2 == 0;
        boolean result = oddPredicate.test(var);

        Assertions.assertThat(result).isTrue();
    }
}
