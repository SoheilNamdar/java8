package football.player;

import football.playes.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerShould {
    @Test
    void give_the_best_score_with_oop() {
        final List<Player> scorers = getPlayers();

        Player bestScore = scorers.get(0);
        for (Player scorer : scorers) {
            if(scorer.getGoal() > bestScore.getGoal()){
                bestScore = scorer;
            }
        }
        System.out.println(bestScore.getName());
        assertThat(bestScore.equals("Christian RONALDO"));
    }

    @Test
    void give_best_score_fp() {
        List<Player> playerList = getPlayers();
        playerList.stream().max(Comparator.comparing(player -> player.getGoal())).get();
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
