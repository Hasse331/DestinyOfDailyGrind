package data;

public record EngameScore(String name, int dayCount, int moneyEarned) {
    
    public double countScore() {
        double score = moneyEarned * 0.25 * dayCount;
        return score;
    }

    public void displayScore() {
        System.out.println("\n------ " + name + " score and achievements ------");
        System.out.println("Score: " + countScore());
        System.out.println("------------------------------\n");
    }
}