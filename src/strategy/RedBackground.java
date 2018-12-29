package strategy;

// Concrete Strategy
public class RedBackground implements DrawingStrategy {
    @Override
    public void drawBackground() {
        System.out.println("drawn with red background");
    }
}
