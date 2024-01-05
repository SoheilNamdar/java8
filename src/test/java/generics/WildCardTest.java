package generics;

import football.playes.Player;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class WildCardTest {
    @Test
    void sohould_print_names() {
        List<Player> playerList = Arrays
                .asList(new Player("Ali DAEI", 109), new Player("Christian RONALDO", 115));
        printName(playerList);
    }

    private void printName(List<? extends Player> playerList) {
        for (Player player : playerList) {
            System.out.println(player.getName());
        }
    }
}
