package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToDoubleBiFunction;

public class BiFunctionPrimitiveShould {
    @Test
    void return_a_primitive_type() {
        ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction =
            (integer_1, integer_2) -> integer_1 + integer_2;
        Integer int1 = 5;
        Integer int2 = 7;
        final double result = toDoubleBiFunction.applyAsDouble(int1, int2);
        Assertions.assertThat(12d).isEqualTo(result);
    }
}
