package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

public class UnaryOperatoFunctionShould {
    @Test
    void has_the_same_entry_as_input_and_output() {
        int var = 6;

        UnaryOperator<Integer> unaryOperator = integer -> integer * integer;
        Integer apply = unaryOperator.apply(var);

        Assertions.assertThat(36).isEqualTo(apply);
    }
}
