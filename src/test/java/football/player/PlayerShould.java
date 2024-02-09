package football.player;
import football.playes.Player;
import helper.PlayerTestHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
public class PlayerShould {
    @Test
    void give_the_best_score_with_oop() {

        List<Player> scorers = getPlayers();

        Player bestScorer = scorers.get(0);
        for (Player scorer : scorers) {
            if(scorer.getGoal() > bestScorer.getGoal())
                bestScorer = scorer;
        }
        System.out.println(bestScorer.getName());
    }
    @Test
    void give_best_score_fp() {
        List<Player> scorers = getPlayers();

        Player bestScorer = scorers.stream().max(Comparator.comparing(Player::getGoal)).get();

        Assertions.assertThat(bestScorer.getName()).isEqualTo("Christian RONALDO");

    }

    private static List<Player> getPlayers() {
        List<Player> scorers = new ArrayList<>();
        scorers.add(new Player("Ali DAEI", 109));
        scorers.add(new Player("Christian RONALDO", 115));
        scorers.add(new Player("Mokhtar DAHARI", 89));
        return scorers;
    }

}
