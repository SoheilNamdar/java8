package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursivFunction {
    @Test
    void call_itself() {
        int limit = 5;

        assertThat(15).isEqualTo(iterativeSum(limit));
        Assertions.assertThat(15).isEqualTo(recursivSum(limit));
        //Assertions.assertThat(15).isEqualTo(tailRecursivSum(sum, limit));
    }

    private int tailRecursivSum(int sum, int limit) {
        if(limit == 0){
            return limit;
        }
        return tailRecursivSum(sum + limit, limit - 1);
    }

    private int recursivSum(int limit) {
        if(limit == 0){
            return limit;
        }
        return limit + recursivSum(limit - 1);
    }

    private int iterativeSum(int limit) {
        int sum = 0;
        for (int index = 0; index <= limit; index++) {
            sum += index;
        }
        return sum;
    }
}
