package strategy;

// Context
public class Panel {
    private DrawingStrategy drawingStrategy;

    public DrawingStrategy getDrawingStrategy() {
        return drawingStrategy;
    }

    public void setDrawingStrategy(DrawingStrategy drawingStrategy) {
        this.drawingStrategy = drawingStrategy;
    }

    public void drawBackground(){
        drawingStrategy.drawBackground();
    }
}
