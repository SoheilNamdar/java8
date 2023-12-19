package football.playes;

public class Player {
    private final String name;
    private final int goal;

    public Player(String name, int goal) {

        this.name = name;
        this.goal = goal;
    }

    public String getName() {
        return name;
    }

    public int getGoal() {
        return goal;
    }
}
