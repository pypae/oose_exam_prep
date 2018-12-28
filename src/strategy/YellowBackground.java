package strategy;

public class YellowBackground implements DrawingStrategy{

    @Override
    public void drawBackground() {
        System.out.println("drawn with yellow background");
    }
}
