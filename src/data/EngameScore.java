package data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public record EngameScore(String name, double score, int dayCount, int moneyEarned) {
    
    private static final String HIGHSCORE_FILE = "highscores.txt";

    private double countScore() {
        double score = moneyEarned * 0.25 * dayCount;
        return score;
    }

    private boolean isHighScore() {
        
        double highScore = loadHighScore();
        if (score > highScore) {
            saveHighScore();
            return true;
        }
        return false;
    }

    public void displayScore() {
        System.out.println("\n------ " + name + " score and achievements ------");
        System.out.println("Score: " + countScore());
        System.out.println("------------------------------\n");
    }

    private void saveHighScore() {

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(HIGHSCORE_FILE))) {

            writer.write(String.valueOf(score));
        } catch (IOException e) {
            System.err.println("Error saving high score: " + e.getMessage());
        }

    }

    private double loadHighScore() {

        try {
            if (Files.exists(Paths.get(HIGHSCORE_FILE))) {
                String data = Files.readString(Paths.get(HIGHSCORE_FILE));
                return Double.parseDouble(data);
            }
        } catch (IOException e) {
            System.err.println("Error reading high score: " + e.getMessage());
        }
        return 0;
    }

}