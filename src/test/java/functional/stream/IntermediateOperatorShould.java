package functional.stream;
import football.playes.Player;
import football.playes.PlayersWithCup;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class IntermediateOperatorShould {
    private List<Player> players;
    @BeforeEach
    void setUp() {
         players = PlayerTestHelper.getPlayers();
    }
    @Test
    void filter_data() {
        Consumer<? super Player> sideEffect = player -> out.println(player);
        Predicate<? super Player> topScore = player -> player.getGoal() > 100;
        final List<Player> topScorerWhereNameIsAliDaei = players.stream()
                .filter(topScore)
                .peek(sideEffect)
                .filter(player -> player.getName().contains("Ali"))
                .distinct()
                .collect(toList());
        
        final List<Player> aliDaei = new LinkedList<>();
        aliDaei.add(new Player("Ali DAEI", 109));
        assertThat(aliDaei).isEqualTo(topScorerWhereNameIsAliDaei);
    }
    @Test
    void map_data() {
        Function<? super Player, ?> function = Player::getName;
        List<?> playerNames = players.stream()
                .map(function)
                .distinct()
                .skip(2)
                .collect(toList());

        final List<String> ExpectedReselt = new LinkedList<>();
        //ExpectedReselt.add("Ali DAEI");
        //ExpectedReselt.add("Christian RONALDO");
        ExpectedReselt.add("Ferenc PUSKAS");
        ExpectedReselt.add("Mokhtar DAHARI");
        ExpectedReselt.add("Sunil Chhetri");
        assertThat(ExpectedReselt).isEqualTo(playerNames);
    }
    @Test
    void sort_data() {
        List<Integer> sortedScoreGoals = players.stream()
                .map(Player::getGoal)
                //.sorted()
                .sorted(reverseOrder())
                .limit(3)
                .collect(toList());
        List<Integer> expectedResult = new LinkedList<>();
        /*expectedResult.add(84);
        expectedResult.add(85);
        expectedResult.add(89);
        expectedResult.add(109);
        expectedResult.add(109);
        expectedResult.add(115);*/
        expectedResult.add(115);
        expectedResult.add(109);
        expectedResult.add(109);
       // expectedResult.add(89);
        //expectedResult.add(85);
        //expectedResult.add(84);
        assertThat(sortedScoreGoals).isEqualTo(expectedResult);
    }
    @Test
    void be_lazy() {
        final List<Integer> collect = players.stream()
                .map(Player::getGoal)
                .peek(goal -> out.println("Scored goal is : " + goal))
                .filter(goal -> goal < 50)
                .peek(goal -> out.println("Code won't be executed from this line !"))
                .collect(toList());
        assertThat(collect).isEmpty();
    }

    @Test
    void handle_complex_objests() {
        final List<PlayersWithCup> playersWithCup = new PlayerTestHelper().getPlayersWithCup();

        final List<List<String>> byMap = playersWithCup.stream()
                .filter(pwc -> pwc.getName().contains("Ali"))
                .map(p -> p.getCups())
                .collect(toList());
        byMap.forEach(out::println);

        assertThat(byMap).contains(Arrays.asList("Bundes Liga","Azadegan"));

        final List<String> byflatMap = playersWithCup.stream()
                .filter(pwd -> pwd.getName().contains("Ali") )
                .flatMap(p -> p.getCups().stream())
                .collect(toList());
        byflatMap.forEach(out::println);

        assertThat(byflatMap).contains("Bundes Liga","Azadegan");

    }
}
