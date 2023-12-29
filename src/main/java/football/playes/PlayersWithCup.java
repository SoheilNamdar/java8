package football.playes;

import java.util.List;

public class PlayersWithCup extends Player{
    private final List<String> cups;
    public PlayersWithCup(String name, int goal, List<String> cups) {
        super(name, goal);
        this.cups = cups;
    }
    public List<String> getCups() {
        return cups;
    }


}
