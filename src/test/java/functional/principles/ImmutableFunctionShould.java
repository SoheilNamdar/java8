package functional.principles;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ImmutableFunctionShould {
    @Test
    void Should_never_be_changed_after_being_constructed() {
        final int var=5;
        Operation operation = number -> number + var;
        AddOperationTo addOperationTo = addOperationTo(2, operation);

        assertThat(7).isEqualTo(addOperationTo.apply());
    }

    private AddOperationTo addOperationTo(int number, Operation operation) {
        return () -> operation.applyOperation(number);
    }
}
