package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HigherOrderFunctionShould {
    @Test
    void take_one_or_many_other_function_as_parameter_and_return_a_function() {
        // a number and an operation return function
        Operation operation = number -> number + 5;
        AddOperationTo addOperationTo = addOperationTo(2, operation);

        assertThat(7).isEqualTo(addOperationTo.apply());

        Operation operationTavan = number -> number * number;
        AddOperationTo addOperationToTavan = addOperationTo(5, operationTavan);
        Assertions.assertThat(addOperationToTavan.equals(25));
    }
    private AddOperationTo addOperationTo(int number, Operation operation) {
        return () -> operation.applyOperation(number);
    }
}
