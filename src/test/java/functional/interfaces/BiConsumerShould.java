package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static java.lang.System.out;

public class BiConsumerShould {
    @Test
    void get_two_entities_and_return_nothing() {
        Map<String, Integer> copyPlayers = new HashMap<>();
        Map<String, Integer> players = new HashMap<>();
        players.put("Diego", 85);
        players.put("Messi",97);
        BiConsumer<? super String, ? super Integer> biConsumer =
            (key,value) -> out.println("Player name is " + key + " and his score is " + value);
        players.forEach(biConsumer);

        BiConsumer<? super String, ? super Integer> copyConsumer =
                copyPlayers::put;
        players.forEach(copyConsumer);

        Assertions.assertThat(players).isEqualTo(copyPlayers);
    }
}
