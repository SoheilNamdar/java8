package functional.principles;

import football.playes.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstClassCitizenFunctionShould {
    //Lambda Expression is the name of function in java
    @Test
    void be_passed_as_method_parameter() {
        List<String> players = getPlayers();

        Collections.sort(players, (a,b) -> a.compareTo(b));

        assertPlayersSort(players);
    }
    @Test
    void should_be_passed_as_variable() {
        List<String> players = getPlayers();

        Comparator<String> stringComparator = (a, b) -> a.compareTo(b);
        Collections.sort(players, stringComparator);

        assertPlayersSort(players);
    }

    @Test
    void should_return_from_a_method() {
        List<String> players = getPlayers();

        Comparator<String> stringComparator = getStringComparator();
        Collections.sort(players, stringComparator);

        assertPlayersSort(players);
    }

    private static Comparator<String> getStringComparator() {
        return (a, b) -> a.compareTo(b);
    }

    private static void assertPlayersSort(List<String> players) {
        assertThat(players.get(0).equals("ABEDZADEH"));
        assertThat(players.get(1).equals("AliDAEI"));
        assertThat(players.get(2).equals("ABEDZADEH"));
    }

    private static List<String> getPlayers() {
        List<String > players = new LinkedList<>();
        players.add("AliDAEI");
        players.add("Ronaldo");
        players.add("ABEDZADEH");
        return players;
    }
}
