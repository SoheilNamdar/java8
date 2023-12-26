package functional.stream;

import football.playes.Player;
import helper.PlayerTestHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

public class TerminalOperatorShould {
    private List<Player> players;
    @BeforeEach
    void setUp() {
        players = PlayerTestHelper.getPlayers();
    }
    @Test
    void collect_data() {   // toList, toMap, toSet, toArray, toCollection
        Function<? super Player, UUID> keys = player -> UUID.randomUUID();
        UnaryOperator<Player> values = player -> player;
        Map<UUID, Player> playersWithId = players.stream().collect(Collectors.toMap(keys, values));
        BiConsumer<? super UUID, ? super Player> printPlayer = (k,v) -> System.out.println("key is : " + k + " value is : " + v) ;
        playersWithId.forEach(printPlayer);

        assertThat(players).hasSameElementsAs(playersWithId.values());
        assertThat(playersWithId.keySet()).hasOnlyElementsOfType(UUID.class);
    }
    @Test
    void calculate_data() {
        Stream<Integer> goals = players.stream().map(Player::getGoal);
        ToIntFunction<? super Integer> intConverter = goal-> Integer.valueOf(goal);

        Integer sum = goals.collect(summingInt(intConverter));
        assertThat(sum).isEqualTo(591);

        Double average = goals.collect(averagingInt(intConverter));
        assertThat(average).isEqualTo(98.5);

        Optional<Integer> maxGoalScorer = goals.max(Comparator.naturalOrder());
        assertThat(maxGoalScorer.get()).isEqualTo(115);

        Long numberOfElement = goals.collect(counting());
        assertThat(numberOfElement).isEqualTo(6);

        IntSummaryStatistics summary = goals.collect(summarizingInt(intConverter));
        assertThat(summary.getSum()).isEqualTo(591);
        assertThat(summary.getAverage()).isEqualTo(98.5);
        assertThat(summary.getMax()).isEqualTo(115);
        assertThat(summary.getMin()).isEqualTo(84);
        assertThat(summary.getCount()).isEqualTo(6);
    }

    @Test
    void group_data() {
        Function<Player, String> playerName = Player::getName;
        final Map<String, Long> groupedPlayers = players.stream().collect(groupingBy(playerName, counting()));
        groupedPlayers.forEach((k,v) -> System.out.println("player is " + k + " , has " + v + " occurencies"));
        assertThat(groupedPlayers)
                .containsEntry("Ali DAEI", 2L)
                .containsEntry("Christian RONALDO", 1L)
                .containsEntry("Ferenc PUSKAS", 1L)
                .containsEntry("Mokhtar DAHARI", 1L)
                .containsEntry("Sunil Chhetri", 1L);
    }
}
