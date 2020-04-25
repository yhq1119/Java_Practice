package java_fx.chess.model;

public class Player {

    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;}

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='\n" + name + '\'' +
                "\n, score=" + score +
                "}\n";
    }
}
