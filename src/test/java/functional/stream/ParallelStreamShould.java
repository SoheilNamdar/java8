package functional.stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;

public class ParallelStreamShould {
    @Test
    void be_unpredictable() {
        final List<Integer> integers = asList(1, 2, 3, 4, 5);

        out.println("Sequential result is : ");
        integers.stream().forEach(out::print);

        out.println("\nSequential result is : ");
        integers.parallelStream().forEach(out::print);

        final Integer sequentialSum = integers.stream().reduce(5, Integer::sum);
        Assertions.assertThat(sequentialSum).isEqualTo(20);
    }
}
