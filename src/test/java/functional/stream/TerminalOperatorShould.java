package functional.stream;

import football.playes.Player;
import helper.PlayerTestHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;
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
        Stream<Integer> goals = playerGoals();
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
    void match_data() {
        Predicate<? super Integer> goalMoreThan50 = goal -> goal >= 50;

        final boolean allPlayersScoreMoreThan50 = playerGoals().allMatch(goalMoreThan50);
        assertThat(allPlayersScoreMoreThan50).isTrue();

        final boolean anyPlayersScoreMoreThan50 = playerGoals().anyMatch(goalMoreThan50);
        assertThat(allPlayersScoreMoreThan50).isTrue();

        boolean nonePlayersScoreMoreThan50 = playerGoals().noneMatch(goalMoreThan50);
        assertThat(nonePlayersScoreMoreThan50).isFalse();

    }

    private Stream<Integer> playerGoals() {
        return players.stream()
                .map(Player::getGoal);
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
    @Test
    void find_data() {
        final Optional<String> firstScorer = players.stream()
                .filter(player -> player.getGoal() < 100)
                .map(Player::getName)
                .findFirst();
        assertThat(firstScorer.get()).isEqualTo("Mokhtar DAHARI");

        Optional<String> findAny = players.stream()
                .filter(player -> player.getGoal() < 100)
                .map(Player::getName)
                .findAny();
        String actual = findAny.get();
        System.out.println(actual);
        assertThat(actual).satisfiesAnyOf(
                p -> p.equals("Sunil Chhetri"),
                p -> p.equals("Mokhtar DAHARI"),
                p -> p.equals("Ferenc PUSKAS")
        );
    }
    @Test
    void reduce_data() {
        BinaryOperator<Integer> sumOfGoals = Integer::sum;
        final Integer totalGoals = players.stream().map(Player::getGoal).reduce(0, sumOfGoals);
        assertThat(totalGoals).isEqualTo(591);

        final String formattedNames = players.stream()
                .map(Player::getName)
                .reduce("", this::format)
                .replaceFirst("\\|"," ")
                .trim();
        //System.out.println(formattedNames);

        assertThat(formattedNames)
                .isEqualTo("Ali DAEI | Ali DAEI | Christian RONALDO | Ferenc PUSKAS | Mokhtar DAHARI | Sunil CHHETRI");
    }

    private String format(String res, String playrName) {
        String seperator = " ";
        String firstName = playrName.split(seperator)[0];
        String lastName = playrName.split(seperator)[1];
        return res + " | " + firstName + seperator + lastName.toUpperCase();
    }
}
