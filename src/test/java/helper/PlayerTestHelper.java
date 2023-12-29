package helper;

import football.playes.Player;

import java.util.LinkedList;
import java.util.List;

public class PlayerTestHelper {
    public static List<Player> getPlayers() {
        final List<Player> scorers = new LinkedList<>();
        scorers.add(new Player("Ali DAEI", 109));
        scorers.add(new Player("Ali DAEI", 109));
        scorers.add(new Player("Christian RONALDO", 115));
        scorers.add(new Player("Mokhtar DAHARI", 89));
        scorers.add(new Player("Sunil Chhetri", 85));
        scorers.add(new Player("Ferenc PUSKAS", 84));
        return scorers;
    }
}
