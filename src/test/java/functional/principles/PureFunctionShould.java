package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PureFunctionShould {
    // Pure Function Method characteristics:
    // 1- Depends only on it's parameter
    // 2- Without side-effect

    // Side effect means have effect outside the method
    // - method which save data in data-base
    @Test
    void depends_only_on_its_parameter() {
        // Pure method
        PureMethod pureMethod = new PureMethod();
        int sum = pureMethod.sum(1, 3);
        Assertions.assertThat(sum).isEqualTo(4);

        // Impure method
        ImpureMethod impureMethod = new ImpureMethod();
        int sum1 = impureMethod.sum(1, 3);
        Assertions.assertThat(sum1).isEqualTo(9);
    }

    @Test
    void has_no_side_effect() {
        ImpureMethod imPureMethod = new ImpureMethod();
        int impure = imPureMethod.impure(1, 3);
        Assertions.assertThat(4).isEqualTo(impure);
    }
}
