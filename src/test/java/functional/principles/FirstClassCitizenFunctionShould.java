package functional.principles;

import football.playes.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstClassCitizenFunctionShould {
    //Lambda Expression is the name of function in java
    @Test
    void be_passed_as_method_parameter() {
        List<String> players = getStrings();

        Collections.sort(players, (a, b) -> a.compareTo(b));

        extracted(players);
    }

    @Test
    void be_passed_as_method_variable() {
        List<String> players = getStrings();

        Comparator<String> stringComparator = (a, b) -> a.compareTo(b);
        Collections.sort(players, stringComparator);

        extracted(players);
    }

    @Test
    void be_returned_from_a_method() {
        List<String> players = getStrings();

        Comparator<String> stringComparator = getStringComparator();
        Collections.sort(players, stringComparator);

        extracted(players);
    }

    private static Comparator<String> getStringComparator() {
        Comparator<String> stringComparator = (a, b) -> a.compareTo(b);
        return stringComparator;
    }

    private static void extracted(List<String> players) {
        assertThat(players.get(0)).isEqualTo("ABEDZADEH");
        assertThat(players.get(1)).isEqualTo("AliDAEI");
        assertThat(players.get(2)).isEqualTo("MADJIDI");
    }

    private static List<String> getStrings() {
        List<String> players = new LinkedList<>();
        players.add("AliDAEI");
        players.add("MADJIDI");
        players.add("ABEDZADEH");
        return players;
    }
}
