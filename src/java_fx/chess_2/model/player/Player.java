package java_fx.chess_2.model.player;

public class Player implements PlayerImpl {

    private int score;
    private String name;

    public Player(String name) {
        this.name = name;
        resetScore();
    }

    public void addScore() {
        score += 5;
    }

    public void resetScore(){
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
