package football.player;
import football.playes.Player;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class PlayerShould {
    @Test
    void give_the_best_score_with_oop() {

        final List<Player> scorers = new PlayerTestHelper().getPlayers();

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
        List<Player> playerList = new PlayerTestHelper().getPlayers();
        playerList.stream().max(Comparator.comparing(player -> player.getGoal())).get();
    }

}
