package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.ToIntFunction;

public class PrimitiveFunctionShould {
    @Test
    void get_an_primitive_entry() {
        int var = 5;
        IntFunction<String> toString = String::valueOf;

        String apply = toString.apply(var);

        Assertions.assertThat(apply).isEqualTo("5");
    }
    @Test
    void return_primitive_type_given_any_type() {
        String var = "3";
        ToIntFunction<String> toIntFunction = String -> Integer.valueOf(String).intValue();

        int stringToInt = toIntFunction.applyAsInt(var);
        Assertions.assertThat(stringToInt).isEqualTo(3);
    }
    @Test
    void give_primitive_as_input_and_output() {
        int var = 3;
        IntToLongFunction intToLongFunction = integer -> (long) integer;
        final long result = intToLongFunction.applyAsLong(var);
        Assertions.assertThat(result).isEqualTo(3L);
    }
}
