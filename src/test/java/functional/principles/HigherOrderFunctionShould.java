package functional.principles;

import jdk.dynalink.Operation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HigherOrderFunctionShould {
    @Test
    void take_one_or_many_other_function_as_parameter_and_return_a_function() {
        Operation operation = str -> str + "!";
        printFormatted("hello", operation);
    }

    private void printFormatted(String str, Operation operation) {
        String run = operation.run(str);
        System.out.println(run);
    }

    interface Operation{
        String run(String str);
    }
}
