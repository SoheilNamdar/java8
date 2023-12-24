package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

public class BinaryOperatorFunctionShould {
    @Test
    void should_have_two_entry_and_one_output_with_the_same_type() {
        int var1 = 4;
        int var2 = 4;

        BinaryOperator<Integer> binaryOperator = (int1, int2) -> int1 * int2;
        Integer result = binaryOperator.apply(var1, var2);

        Assertions.assertThat(result).isEqualTo(16);
    }
}
