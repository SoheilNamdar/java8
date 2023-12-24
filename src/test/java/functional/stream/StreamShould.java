package functional.stream;

import football.playes.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class StreamShould {
    @Test
    void should_be_created() {
        final String hello = "hello";
        final Stream<String> helloStram = Stream.of(hello);

        final Stream<Player> playerStream = getPlayers().stream();
        Integer[] numbers = new Integer[5];
        Stream<Integer> stream = Arrays.stream(numbers);
    }

    private static List<Player> getPlayers() {
        final List<Player> scorers = new LinkedList<>();
        scorers.add(new Player("Ali DAEI", 109));
        scorers.add(new Player("Christian RONALDO", 115));
        scorers.add(new Player("Ferenc PUSKAS", 84));
        scorers.add(new Player("Mokhtar DAHARI", 89));
        scorers.add(new Player("Sunil Chhetri", 85));
        return scorers;
    }
}
