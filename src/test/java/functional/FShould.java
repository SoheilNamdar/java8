package functional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FShould {
    @Test
    void get_an_entry_and_produce_an_output() {
        Map<String, Integer> map = new HashMap<>();
        Function<String, Integer> function = key -> key.length();
        final Integer result = map.computeIfAbsent("sepehr", function);

        Assertions.assertThat(result.equals(6));
    }
}
