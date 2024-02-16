package functional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class PrimitiveFShould {
    @Test
    void get_a_primitive_type_as_entry() {
        IntFunction<String> toString = integer -> String.valueOf(integer);
        int var = 5;
        String result = toString.apply(var);

        Assertions.assertThat(result.equals("5"));
    }

    @Test
    void given_any_type_return_a_primitive_type() {
        int var = 3;
        ToDoubleFunction<Integer> toString = integer -> Double.parseDouble(integer.toString());
        double v = toString.applyAsDouble(var);

        Assertions.assertThat(v).isEqualTo(3.0);
    }

    @Test
    void given_primitive_type_as_input_and_output() {
        IntToLongFunction intToLongFunction = integer -> Long.valueOf(integer);
        int var = 2;
        long applyAsLong = intToLongFunction.applyAsLong(var);

        Assertions.assertThat(applyAsLong).isEqualTo(2L);
    }
}
