import composite.FinancialInstrument;
import composite.Portfolio;
import composite.PricedComponent;
import strategy.Panel;
import strategy.RedBackground;
import strategy.YellowBackground;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        test_composite();
        test_strategy();
    }

    private static void test_composite(){
        PricedComponent myInstrument = new FinancialInstrument();
        System.out.println(myInstrument.getPrice());

        Portfolio myPortfolio = new Portfolio(new ArrayList<PricedComponent>());

        for (int i=0; i < 10; i++) {
            myPortfolio.addInstrument(new FinancialInstrument());
        }

        System.out.println(myPortfolio.getPrice());
    }

    private static void test_strategy(){
        Panel myPanel = new Panel();

        myPanel.setDrawingStrategy(new RedBackground());
        myPanel.drawBackground();

        myPanel.setDrawingStrategy(new YellowBackground());
        myPanel.drawBackground();
    }


}
