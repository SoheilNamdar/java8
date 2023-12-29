package helper;

import football.playes.Player;
import football.playes.PlayersWithCup;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.*;
import static java.util.Collections.emptyList;

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
    public static List<PlayersWithCup> getPlayersWithCup(){
        final List<PlayersWithCup> scorers = new LinkedList<>();
        scorers.add(new PlayersWithCup("Ali DAEI", 109, asList("Bundes Liga","Azadegan")));
        scorers.add(new PlayersWithCup("Christian RONALDO", 115,asList("La liga", "European cup")));
        scorers.add(new PlayersWithCup("Mokhtar DAHARI", 89, asList("La liga", "European cup")));
        scorers.add(new PlayersWithCup("Sunil Chhetri", 85, emptyList()));
        scorers.add(new PlayersWithCup("Ferenc PUSKAS", 84, emptyList()));
        return scorers;
    }
}
